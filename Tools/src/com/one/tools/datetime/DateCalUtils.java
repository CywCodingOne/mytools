package com.one.tools.datetime;

import java.util.Date;

/**
 * @description 
 * @author one-coder
 * @date 2016年11月21日 下午11:21:30
 */
public class DateCalUtils extends DateUtils{
	
	/**
	 * @description 返回两个时间差（毫秒）
	 * @param 两个时间的大小顺序不作要求
	 * @return 若存在为空的参数，则返回 -1； 否则返回时间差
	 * @throws
	 */
	public static long diffMilliSeconds(Date date1, Date date2){
		long differ = -1;
		
		if (null == date1 || null == date2) {
			return differ;
		}
		long d1 = date1.getTime();
		long d2 = date2.getTime();
		
		differ = (d1 > d2)? (d1 - d2): (d2 - d1);
		
		return differ;
	}
	
	/**
	 * @description 返回相对参考时间的一个时移时间
	 * @param currentDate为当前参考时间，shift为正表示向未来时移，为负表示向过去时移，时移量为 shift的绝对值,shift单位毫秒
	 * @return 若参考时间为空 或者 时移后的时间早于“格林威治时间1970年01月01日00时00分00秒”，则返回 null；否则返回时移后的时间
	 * @throws
	 */
	public static Date shiftDate(Date currentDate, long shift){
		Date afterShift = null;
		
		if (null == currentDate) {
			return afterShift;
		}
		long temp = currentDate.getTime() + shift;
		if (0 > temp) {
			return afterShift;
		}
		afterShift = new Date(temp);
		
		return afterShift;
	}
}
