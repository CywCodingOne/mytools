package com.one.tools.validate;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.one.tools.common.EmptyUtils;
import com.one.tools.constants.ExpConstants;
import com.one.tools.entity.ReturnMessage;
import com.one.tools.exception.paraValidateException;

public class Validator implements IValidator{

	private static Logger logger = Logger.getLogger(Validator.class);
	
	private static Map<String, Field[]> requestBeanFiledMap = null;
    
    private static Map<String, Method[]> requestBeanMethoddMap = null;
    
    public Validator(){
    	
    }
    
	public static ReturnMessage check(String alias, Object object) {
		// TODO Auto-generated method stub
		ReturnMessage message = check(alias, object, false);
		
		return message;
	}

	public static ReturnMessage check(String alias, Object object, boolean uperFlag){
		// successful validation default
		ReturnMessage message = new ReturnMessage(ExpConstants.PARAM_CHECK_SUCCESS_CODE, ExpConstants.PARAM_CHECK_SUCCESS_MSG);
		logger.debug("Validator.check: check with alias '" + alias + "' start !" );
		
		//如果参数为空，则校验不通过，日志提示参数为空，并返回错误提示信息
		if (null == object) {
			logger.error("Validator.check: check with alias " + alias + "' failed, caused by a null param object !" );
			message.setReturnCode(ExpConstants.CLASS_CHECK_ERROR);
			message.setErrorMessage(ExpConstants.CLASS_CHECK_MSG);
			return message;
		}
		
        /** 获取传入类以及其父类的属性列表 **/
        List<String> fieldList = getFields(object, uperFlag);
        try
        {
            /** 循环每一个属性 **/
            for (String field : fieldList)
            {
                checkField(alias + "." + field, getProperty(object, field));
            }
        }catch (paraValidateException pve){
        	logger.error("field illegal: " + pve.getMessage());
        	message.setReturnCode(pve.getCode());
        	message.setErrorMessage(pve.getMessage());
        }catch (Exception e)
        {
            logger.error("error accoured when check param with alias '" + alias + "': ", e);
            message.setReturnCode(ExpConstants.CLASS_CHECK_ERROR);
            message.setErrorMessage(ExpConstants.CLASS_CHECK_MSG);
        }
		return message;
	}
	
	public static ReturnMessage checkField(String alias, Object object) throws paraValidateException{
		// TODO Auto-generated method stub
		logger.debug("Validator.checkField: check with alias '" + alias + "' start !");
		if (ValiData.valiMap == null || ValiData.valiMap.isEmpty())
        {
            ValiData.init();
        }

        CheckObj obj = ValiData.valiMap.get(alias);
        if (obj == null)
        {
        	logger.warn("checkField alias '" + alias + "' not found, that mean it is no need to validate !");
            return null;
        }
        logger.debug("checkField alias '" + alias + " = " + obj.toString());

        // 校验项目
        checkRequired(alias, object, obj);		//不为空校验
        
        //若指定了 '引用型校验'，则不再做其它类型的校验
        String refAlias = obj.getRefAlias();
		if (null != refAlias && !"".equals(refAlias)) {
			checkReference(alias, object, obj);
		}else {
			checkDataType(alias, object, obj);		//数据类型校验
	        checkLength(alias, object, obj);		//长度校验（目前只校验最大长度，不校验最小）
	        checkExpression(alias, object, obj);	//正则表达式校验
		}
        return null;
	}
	
	private static void checkReference(String alias, Object object, CheckObj checkObj) throws paraValidateException{
		if (null == object) {
			return;
		}
		
		String refAlias = checkObj.getRefAlias();
		
		ReturnMessage message = check(refAlias, object, checkObj.getAbLetterUpcase());
		
		if (null != message && !ExpConstants.PARAM_CHECK_SUCCESS_CODE.equals(message.getReturnCode())) {
			logger.error("Validator.checkReference: returnCode=" + message.getReturnCode() + "; errorMessage=" + message.getErrorMessage());
			throw new paraValidateException(message.getReturnCode(), message.getErrorMessage());
		}
		
	}
	
	private static void checkRequired(String alias, Object object, CheckObj checkObj) throws paraValidateException{
		String isRequired = checkObj.getIsRequired();
		// 是否为必填字段
        if ("true".equalsIgnoreCase(isRequired) && isEmpty(object))
        {
            logger.error("必填字段: '" + alias + "' 为空!");
            if (null != checkObj.getRequiredMsg() && !"".equals(checkObj.getRequiredMsg()))
            {
                throw new paraValidateException(ExpConstants.NONE_REQUIRED_FIELD_ERROR, checkObj.getRequiredMsg());
            }
            else
            {
            	throw new paraValidateException(ExpConstants.NONE_REQUIRED_FIELD_ERROR, ExpConstants.NONE_REQURED_FIELD_MSG + ": '" + alias +"'");
            }
        }
	}
	
	private static void checkLength(String alias, Object object, CheckObj checkObj) throws paraValidateException{
		String maxLength = checkObj.getMaxlength();
		// 长度校验
        if (null != maxLength && !"".equals(maxLength))
        {
        	Long length;
        	try {
        		length = Long.valueOf(maxLength);
			} catch (Exception e) {
				// TODO: handle exception
				length = new Long(-1);
				logger.error("the 'maxLength' declaration of " + alias + "is illegal, please check it !");
				throw new paraValidateException(ExpConstants.FIELD_CHECK_ERROR, e);
			}
        	if (0 < length.longValue() && null != object && !"".equals(object) && length.longValue() < String.valueOf(object).length()) {
        		if (null != checkObj.getMaxlengthMsg() && !"".equals(checkObj.getMaxlengthMsg()))
                {
                    throw new paraValidateException(ExpConstants.OVER_LENGTH_FIELD_ERROR, checkObj.getMaxlengthMsg());
                }
                else
                {
                	throw new paraValidateException(ExpConstants.OVER_LENGTH_FIELD_ERROR, ExpConstants.OVER_LENGTH_FIELD_MSG + ": '" + alias +"'");
                }
			}
        }
	}
	
	private static void checkDataType(String alias, Object object, CheckObj checkObj) throws paraValidateException{
		if (null == object) {
			return;
		}
		
		String datatype = checkObj.getDatatype();
		if ("String".equalsIgnoreCase(datatype) && !(object instanceof String)) {
			if (null != checkObj.getDatatypeMsg() && !"".equals(checkObj.getDatatypeMsg())) {
				throw new paraValidateException(ExpConstants.DATATYPE_MATCH_ERROR, checkObj.getDatatypeMsg());
			}else {
				throw new paraValidateException(ExpConstants.DATATYPE_MATCH_ERROR, ExpConstants.DATATYPE_MATCH_MSG + ": '" + alias +"'");
			}
		}else if (("Date".equalsIgnoreCase(datatype)) && !(object instanceof Date)) {
			if (null != checkObj.getDatatypeMsg() && !"".equals(checkObj.getDatatypeMsg())) {
				throw new paraValidateException(ExpConstants.DATATYPE_MATCH_ERROR, checkObj.getDatatypeMsg());
			}else {
				throw new paraValidateException(ExpConstants.DATATYPE_MATCH_ERROR, ExpConstants.DATATYPE_MATCH_MSG + ": '" + alias +"'");
			}
		}else if (("int".equalsIgnoreCase(datatype) || "Integer".equalsIgnoreCase(datatype)) && !(object instanceof Integer)) {
			if (null != checkObj.getDatatypeMsg() && !"".equals(checkObj.getDatatypeMsg())) {
				throw new paraValidateException(ExpConstants.DATATYPE_MATCH_ERROR, checkObj.getDatatypeMsg());
			}else {
				throw new paraValidateException(ExpConstants.DATATYPE_MATCH_ERROR, ExpConstants.DATATYPE_MATCH_MSG + ": '" + alias +"'");
			}
		}else if (("long".equalsIgnoreCase(datatype)) && !(object instanceof Long)) {
			if (null != checkObj.getDatatypeMsg() && !"".equals(checkObj.getDatatypeMsg())) {
				throw new paraValidateException(ExpConstants.DATATYPE_MATCH_ERROR, checkObj.getDatatypeMsg());
			}else {
				throw new paraValidateException(ExpConstants.DATATYPE_MATCH_ERROR, ExpConstants.DATATYPE_MATCH_MSG + ": '" + alias +"'");
			}
		}else if (("float".equalsIgnoreCase(datatype)) && !(object instanceof Float)) {
			if (null != checkObj.getDatatypeMsg() && !"".equals(checkObj.getDatatypeMsg())) {
				throw new paraValidateException(ExpConstants.DATATYPE_MATCH_ERROR, checkObj.getDatatypeMsg());
			}else {
				throw new paraValidateException(ExpConstants.DATATYPE_MATCH_ERROR, ExpConstants.DATATYPE_MATCH_MSG + ": '" + alias +"'");
			}
		}else if (("double".equalsIgnoreCase(datatype)) && !(object instanceof Double)) {
			if (null != checkObj.getDatatypeMsg() && !"".equals(checkObj.getDatatypeMsg())) {
				throw new paraValidateException(ExpConstants.DATATYPE_MATCH_ERROR, checkObj.getDatatypeMsg());
			}else {
				throw new paraValidateException(ExpConstants.DATATYPE_MATCH_ERROR, ExpConstants.DATATYPE_MATCH_MSG + ": '" + alias +"'");
			}
		}else if (("boolean".equalsIgnoreCase(datatype)) && !(object instanceof Boolean)) {
			if (null != checkObj.getDatatypeMsg() && !"".equals(checkObj.getDatatypeMsg())) {
				throw new paraValidateException(ExpConstants.DATATYPE_MATCH_ERROR, checkObj.getDatatypeMsg());
			}else {
				throw new paraValidateException(ExpConstants.DATATYPE_MATCH_ERROR, ExpConstants.DATATYPE_MATCH_MSG + ": '" + alias +"'");
			}
		}else if (("char".equalsIgnoreCase(datatype) || "Character".equalsIgnoreCase(datatype)) && !(object instanceof Character)) {
			if (null != checkObj.getDatatypeMsg() && !"".equals(checkObj.getDatatypeMsg())) {
				throw new paraValidateException(ExpConstants.DATATYPE_MATCH_ERROR, checkObj.getDatatypeMsg());
			}else {
				throw new paraValidateException(ExpConstants.DATATYPE_MATCH_ERROR, ExpConstants.DATATYPE_MATCH_MSG + ": '" + alias +"'");
			}
		}else if (("List".equalsIgnoreCase(datatype) || "ArrayList".equalsIgnoreCase(datatype) || "LinkedList".equalsIgnoreCase(datatype)) && !(object instanceof List)) {
			if (null != checkObj.getDatatypeMsg() && !"".equals(checkObj.getDatatypeMsg())) {
				throw new paraValidateException(ExpConstants.DATATYPE_MATCH_ERROR, checkObj.getDatatypeMsg());
			}else {
				throw new paraValidateException(ExpConstants.DATATYPE_MATCH_ERROR, ExpConstants.DATATYPE_MATCH_MSG + ": '" + alias +"'");
			}
		}else if (("Map".equalsIgnoreCase(datatype) || "HashMap".equalsIgnoreCase(datatype) || "TreeMap".equalsIgnoreCase(datatype)) && !(object instanceof Map)) {
			if (null != checkObj.getDatatypeMsg() && !"".equals(checkObj.getDatatypeMsg())) {
				throw new paraValidateException(ExpConstants.DATATYPE_MATCH_ERROR, checkObj.getDatatypeMsg());
			}else {
				throw new paraValidateException(ExpConstants.DATATYPE_MATCH_ERROR, ExpConstants.DATATYPE_MATCH_MSG + ": '" + alias +"'");
			}
		}else if (("array".equalsIgnoreCase(datatype) || (null != datatype && datatype.endsWith("[]"))) && !(object instanceof Object[])) {
			if (null != checkObj.getDatatypeMsg() && !"".equals(checkObj.getDatatypeMsg())) {
				throw new paraValidateException(ExpConstants.DATATYPE_MATCH_ERROR, checkObj.getDatatypeMsg());
			}else {
				throw new paraValidateException(ExpConstants.DATATYPE_MATCH_ERROR, ExpConstants.DATATYPE_MATCH_MSG + ": '" + alias +"'");
			}
		}
		
	}
	
	private static void checkExpression(String alias, Object object, CheckObj checkObj) throws paraValidateException{
		String expression = checkObj.getExpression();
		// 正则表达式验证
        if (null != expression && !"".equals(expression) && null != object && !"".equals(object))
        {
            boolean isNotMatch = !Pattern.matches(expression, String.valueOf(object));
            if (isNotMatch) {
				if (null != checkObj.getExpressionMsg() && !"".equals(checkObj.getExpressionMsg())) {
					throw new paraValidateException(ExpConstants.EXPRESSION_MATCH_ERROR, checkObj.getExpressionMsg());
				}else {
					throw new paraValidateException(ExpConstants.EXPRESSION_MATCH_ERROR, ExpConstants.EXPRESSION_MATCH_MSG + ": '" + alias +"'");
				}
			}
        }
    }
	
	private static Object getProperty(Object bean, String propertyName) throws Exception{
		Class clazz = bean.getClass();
        Class superclazz = bean.getClass().getSuperclass();
        Method method = null;
        try
        {
            if (isPorpertyInClass(propertyName, clazz))
            {
                Field field = clazz.getDeclaredField(propertyName);
                method = clazz.getDeclaredMethod(getGetterName(field.getName()), new Class[] {});
            }
            else
            {
                Field field = superclazz.getDeclaredField(propertyName);
                method = superclazz.getDeclaredMethod(getGetterName(field.getName()), new Class[] {});
            }
            return method.invoke(bean, new Object[] {});
        }
        catch (Exception e)
        {
            throw e;
        }
	}
	
	private static boolean isPorpertyInClass(String propertyName, Class clazz)
    {
        boolean flag = false;
        
        if (null == requestBeanFiledMap)
        {
            requestBeanFiledMap = new HashMap<String, Field[]>();
        }
        
        Field[] fields = requestBeanFiledMap.get(clazz.getName());
        
        if (null == fields)
        {
            fields = clazz.getDeclaredFields();
            requestBeanFiledMap.put(clazz.getName(), fields);
        }
        
        for (Field field : fields)
        {
            if (propertyName.equalsIgnoreCase(field.getName()))
            {
                flag = true;
                break;
            }
        }
        return flag;
    }
	
	private static String getGetterName(String propertyName)
    {
        String method = "get" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
        return method;
    }
	
	private static List<String> getFields(Object object, boolean uperFlag){
		if (null == requestBeanMethoddMap)
        {
            requestBeanMethoddMap = new HashMap<String, Method[]>();
        }
        
        List<String> fieldList = new ArrayList<String>();
        Class clazz = object.getClass();
        Class clazz1 = object.getClass().getSuperclass();
        
        /** 获取父类的方法 **/
        Method[] methods1 = requestBeanMethoddMap.get(clazz1.getName());
        if (null == methods1)
        {
            methods1 = clazz1.getDeclaredMethods();
            requestBeanMethoddMap.put(clazz1.getName(), methods1);
        }
        
        for (Method method : methods1)
        {
            String methodName = method.getName();
            /** 获取拥有set方法的属性 **/
            if (null != methodName && methodName.startsWith("set"))
            {
                String field = null;
                if (uperFlag)
                {
                    field = methodName.substring(3);
                }
                else
                {
                    field = methodName.substring(3, 4).toLowerCase() + methodName.substring(4);
                }
                fieldList.add(field);
            }
        }
        
        /** 获取子类的方法 **/
        Method[] methods = requestBeanMethoddMap.get(clazz.getName());
        if (null == methods)
        {
            methods = clazz.getDeclaredMethods();
            requestBeanMethoddMap.put(clazz.getName(), methods);
        }
        
        for (Method method : methods)
        {
            String methodName = method.getName();
            if (null != methodName && methodName.startsWith("set"))
            {
                String field = null;
                if (uperFlag)
                {
                    field = methodName.substring(3);
                }
                else
                {
                    field = methodName.substring(3, 4).toLowerCase() + methodName.substring(4);
                }
                fieldList.add(field);
            }
        }
        return fieldList;
	}
	
	public static boolean isEmpty(Object object){
		if (null == object) {
			return true;
		}
		
		if (object instanceof String) {
			return "".equals(object);
		}else if (object instanceof ArrayList) {
			return ((ArrayList)object).size()==0;
		}else if (object instanceof LinkedList) {
			return ((LinkedList)object).size()==0;
		}else if (object instanceof HashMap) {
			return ((HashMap)object).size()==0;
		}else if (object instanceof TreeMap) {
			return ((TreeMap)object).size()==0;
		}else if (object instanceof Object[]) {
			return ((Object[])object).length==0;
		}
		
		return false;
	}
}
