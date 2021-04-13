package com.proinnova.util;

import java.util.Calendar;
import java.util.Date;

/**
 * java.util.Date 就是在除了SQL语句的情况下面使用
 * java.sql.Date 是针对SQL语句使用的，它只包含日期而没有时间部分
 * */
public class DateUtil {
	
    /** 
     * 获取某日期的月份 
     * @param date 
     * @return 
     */  
    public static Integer getMonth(Date date) {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);  
        return cal.get(Calendar.MONTH) + 1;  
    }  

}
