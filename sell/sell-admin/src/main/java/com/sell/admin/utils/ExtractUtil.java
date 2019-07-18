package com.sell.admin.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractUtil {
	public static String extractNumber(String str){
		String regEx="[^0-9]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		String trim = m.replaceAll("").trim();
		return trim;
	}
	
	public static Integer[] getArray(String str, String separator){
		String[] split = str.split(separator);
		Integer[] array = new Integer[split.length];
		for (int i = 0; i < split.length; i++) {
			array[i] = Integer.parseInt(split[i]);
		}
		return array;
	}
	
}
