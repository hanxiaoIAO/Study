package com.proinnova.util;

public class StringUtils {

    public static String captureName(String str) {
        // 进行字母的ascii编码前移，效率要高于截取字符串进行转换的操作
        char[] cs=str.toCharArray();
        if(cs[0] < 123 && cs[0] > 96) {
        	cs[0]-=32;
        }
        
        return String.valueOf(cs);
    }
}
