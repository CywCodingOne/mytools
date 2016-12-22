package com.one.tools.validate;

import java.io.File;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.springframework.util.StringUtils;

public class ValiData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5505422250957185593L;

	private static final Logger logger = Logger.getLogger(ValiData.class);
	
	public static Map<String, CheckObj> valiMap = null;
	
	private static String xmlFilePath = ValiData.class.getClassLoader().getResource("validate").getFile();
	
	public static void init(){
		// 初始化DHM校验文件
        logger.info("validate xmlFilePath:" + xmlFilePath);
        
        String filePath = null;
        
        try
        {
            //将路径解码  防止路径中有空格等特殊符号时找不到校验配置文件
            filePath = URLDecoder.decode(xmlFilePath, "utf-8");
        }
        catch (UnsupportedEncodingException e)
        {
            logger.error("解码校验配置文件路径出错。", e);
        }
        
        logger.info("decode validate filePath:" + filePath);
        
        File dir = new File(filePath);
        if (dir.exists() && dir.isDirectory())
        {
            File[] xmlFiles = dir.listFiles();
            if ((null != xmlFiles) && (xmlFiles.length > 0))
            {
                for (File file : xmlFiles)
                {
                    initMap(file.getPath());
                }
            }
        }
	}
	
	public synchronized static void initMap(String xmlFile){
		
		if (valiMap == null)
        {
			valiMap = new HashMap<String, CheckObj>();
        }

        try
        {
            SAXReader reader = new SAXReader();
            // String filePath = SyncDataCheck.class.getResource("").getFile() +
            // xmlFile/* CHECK_XML_NAME */;
            String filePath = xmlFile;
            
            logger.info("paraValidateXML=" + filePath);
            filePath = URLDecoder.decode(filePath, "utf-8");
            Document document = reader.read(new File(filePath));
            Element ele = document.getRootElement();
            List<?> fieldList = ele.selectNodes("/Validation/className/field");
            for (Iterator<?> iterator = fieldList.iterator(); iterator.hasNext();)
            {
                Element fieldEle = (Element) iterator.next();
                String clazzName = fieldEle.getParent().attributeValue("name");
                String fieldName = fieldEle.attributeValue("name");
                /** obj 包括xml中的字段约束条件和对应提示信息 **/
                CheckObj obj = initXmlData(fieldEle);

                if (obj != null && StringUtils.hasLength(obj.toString())
                        && !valiMap.containsKey(clazzName + "." + fieldName))
                {
                	valiMap.put(clazzName + "." + fieldName, obj);
                }
            }
        }
        catch (Exception e)
        {
            logger.error("配置文件的值取得出错, ", e);
        }
	}
	
	private static CheckObj initXmlData(Element fieldEle)
    {
		//校验项
        Node isRequired = fieldEle.selectSingleNode("required");
        Node dataType = fieldEle.selectSingleNode("dataType");
        Node maxLength = fieldEle.selectSingleNode("maxLength");
        Node expression = fieldEle.selectSingleNode("expression");

        // 校验出错返回消息
        Node isRequiredMsg = fieldEle.selectSingleNode("required-msg");
        Node dataTypeMsg = fieldEle.selectSingleNode("dataType-msg");
        Node maxLengthMsg = fieldEle.selectSingleNode("maxLength-msg");
        Node expressionMsg = fieldEle.selectSingleNode("expression-msg");
        
        String abLetterUpcase = fieldEle.attributeValue("abLetterUpcase");
        String reference = fieldEle.attributeValue("ref");
        
        CheckObj obj = new CheckObj();
        
        if (expression != null)
        {
            obj.setExpression(expression.getStringValue());
        }
        if (dataType != null) {
			obj.setDatatype(dataType.getStringValue());
		}
        if (isRequired != null)
        {
            obj.setIsRequired(isRequired.getStringValue());
        }
        if (maxLength != null)
        {
            obj.setMaxlength(maxLength.getStringValue());
        }

        // 返回 code
        if (isRequiredMsg != null)
        {
            obj.setRequiredMsg(isRequiredMsg.getStringValue());
        }
        if (dataTypeMsg != null)
        {
            obj.setDatatypeMsg(dataTypeMsg.getStringValue());
        }
        if (expressionMsg != null)
        {
            obj.setExpressionMsg(expressionMsg.getStringValue());
        }
        if (maxLengthMsg != null)
        {
            obj.setMaxlengthMsg(maxLengthMsg.getStringValue());
        }
        
        //引用型校验项
        obj.setRefAlias(reference);
        
        //校验字段首字母是否大写
        if (null != abLetterUpcase && "true".equalsIgnoreCase(abLetterUpcase)) {
			obj.setAbLetterUpcase(true);
		}
        return obj;
    }
	
	public static void flushMap()
    {
        if (valiMap != null && !valiMap.isEmpty())
        {
        	valiMap.clear();
        }
        
        init();
    }
	
}
