package com.one.tools.datetime;

import java.util.Date;

import com.one.tools.exception.ParamNullException;

public class TestDateUtils {
	public static void main (String[] args){
		Date now = new Date();
		Date nullDate = null;
		TestDateUtils test = new TestDateUtils();
		
//		test.testsimpleDate(now);
//		test.testsimpleDate(nullDate);
		
		
		/*test.testpureNumDate(now);
		test.testpureNumDate(nullDate);
		*/
		
		/*test.testsimpleWithWeekDate(now);
		test.testsimpleWithWeekDate(nullDate);
		*/
//		
//		test.testsimple12Date(now);
//		test.testsimple12Date(nullDate);
//		
//		test.testdotDate(now);
//		test.testdotDate(nullDate);
//		
//		test.testdot12Date(now);
//		test.testdot12Date(nullDate);
//		
//		test.testchznDate(now);
//		test.testchznDate(nullDate);
//		
		System.out.println("" + new Date().getTime());
	}
	
	public void testsimpleDate(Date date){
		System.out.println("\n测试 testsimpleDate ：");
		String resultString = "";
		try {
			resultString = DateUtils.simpleDate(date);
		} catch (ParamNullException e) {
			// TODO Auto-generated catch block
			System.out.println("format 测试不通过！！！");
			e.printStackTrace();
			return;
		}
		System.out.println(""+resultString);
		
		try {
			DateUtils.simpleDate(resultString);
		} catch (ParamNullException e) {
			// TODO Auto-generated catch block
			System.out.println("parse 测试不通过！！！");
			e.printStackTrace();
			return;
		}
		System.out.println("parse 测试通过！！！");
	}
	
	public void testpureNumDate(Date date){
		System.out.println("\n测试 testpureNumDate ：");
		String resultString = "";
		try {
			resultString = DateUtils.pureNumDate(date);
		} catch (ParamNullException e) {
			// TODO Auto-generated catch block
			System.out.println("format 测试不通过！！！");
			e.printStackTrace();
			return;
		}
		System.out.println(""+resultString);
		
		try {
			DateUtils.pureNumDate(resultString);
		} catch (ParamNullException e) {
			// TODO Auto-generated catch block
			System.out.println("parse 测试不通过！！！");
			e.printStackTrace();
			return;
		}
		System.out.println("parse 测试通过！！！");
	}
	
	public void testsimpleWithWeekDate(Date date){
		System.out.println("\n测试 testsimpleWithWeekDate ：");
		String resultString = "";
		try {
			resultString = DateUtils.simpleWithWeekDate(date);
		} catch (ParamNullException e) {
			// TODO Auto-generated catch block
			System.out.println("format 测试不通过！！！");
			e.printStackTrace();
			return;
		}
		System.out.println(""+resultString);
		
		try {
			DateUtils.simpleWithWeekDate(resultString);
		} catch (ParamNullException e) {
			// TODO Auto-generated catch block
			System.out.println("parse 测试不通过！！！");
			e.printStackTrace();
			return;
		}
		System.out.println("parse 测试通过！！！");
	}
	
	public void testsimple12Date(Date date){
		System.out.println("\n测试 testsimple12Date ：");
		String resultString = "";
		try {
			resultString = DateUtils.simple12Date(date);
		} catch (ParamNullException e) {
			// TODO Auto-generated catch block
			System.out.println("format 测试不通过！！！");
			e.printStackTrace();
			return;
		}
		System.out.println(""+resultString);
		
		try {
			DateUtils.simple12Date(resultString);
		} catch (ParamNullException e) {
			// TODO Auto-generated catch block
			System.out.println("parse 测试不通过！！！");
			e.printStackTrace();
			return;
		}
		System.out.println("parse 测试通过！！！");
	}
	
	public void testdotDate(Date date){
		System.out.println("\n测试 testdotDate ：");
		String resultString = "";
		try {
			resultString = DateUtils.dotDate(date);
		} catch (ParamNullException e) {
			// TODO Auto-generated catch block
			System.out.println("format 测试不通过！！！");
			e.printStackTrace();
			return;
		}
		System.out.println(""+resultString);
		
		try {
			DateUtils.dotDate(resultString);
		} catch (ParamNullException e) {
			// TODO Auto-generated catch block
			System.out.println("parse 测试不通过！！！");
			e.printStackTrace();
			return;
		}
		System.out.println("parse 测试通过！！！");
	}
	
	public void testdot12Date(Date date){
		System.out.println("\n测试 testdot12Date ：");
		String resultString = "";
		try {
			resultString = DateUtils.dot12Date(date);
		} catch (ParamNullException e) {
			// TODO Auto-generated catch block
			System.out.println("format 测试不通过！！！");
			e.printStackTrace();
			return;
		}
		System.out.println(""+resultString);
		
		try {
			DateUtils.dot12Date(resultString);
		} catch (ParamNullException e) {
			// TODO Auto-generated catch block
			System.out.println("parse 测试不通过！！！");
			e.printStackTrace();
			return;
		}
		System.out.println("parse 测试通过！！！");
	}
	
	public void testchznDate(Date date){
		System.out.println("\n测试 testchznDate ：");
		String resultString = "";
		try {
			resultString = DateUtils.chznDate(date);
		} catch (ParamNullException e) {
			// TODO Auto-generated catch block
			System.out.println("format 测试不通过！！！");
			e.printStackTrace();
			return;
		}
		System.out.println(""+resultString);
		
		try {
			DateUtils.chznDate(resultString);
		} catch (ParamNullException e) {
			// TODO Auto-generated catch block
			System.out.println("parse 测试不通过！！！");
			e.printStackTrace();
			return;
		}
		System.out.println("parse 测试通过！！！");
	}
}
