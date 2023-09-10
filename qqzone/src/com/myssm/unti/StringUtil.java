package com.myssm.unti;

public class StringUtil {
    public static boolean isEmpty(String str){
        return str == null || "".equals(str);
    }
    public static boolean isnotEmpty(String str){
        return !isEmpty(str);
    }
}
