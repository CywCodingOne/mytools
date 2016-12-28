package com.one.tools.str;

public class ELResolver {
	public static final String OPEN = "&{";
	public static final String CLOSE = "}";
	
	public static String resolve(String initialString){
		String resolvedString = "";
		
		String tempString = initialString.trim();
		return resolvedString;
	}
	
	public static String onceResolve(String initialString){
		String resolvedString = "";
		
		String tempString = initialString.trim();
		
		return resolvedString;
	}
	
	public static int[] findPairIndex(String findString){
		int start = -1;
		int end = -1;
		
		int first = findString.indexOf(ELResolver.OPEN);
		int last = findString.indexOf(ELResolver.CLOSE);
		
		if (first >= 0 && end > first) {
			
		}
		return new int[]{start, end};
	}
}
