package com.zqc.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextUtils {
	public static boolean isEmpty(String str) {
		if (str == null || str.length() ==0) {
			return true;
		}
		return false;
	}
	
	 public static String replaceBlank(String str) {
	        String dest = "";
	        if (str!=null) {
	            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
	            Matcher m = p.matcher(str);
	            dest = m.replaceAll("");
	        }
	        return dest;
	    }
}
