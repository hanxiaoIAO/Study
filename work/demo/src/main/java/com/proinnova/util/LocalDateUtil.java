package com.proinnova.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class LocalDateUtil {
	
	public static LocalDate getNow() {
		return LocalDate.now();
	}

	public static void main(String[] args) {
		System.out.println("当前日期:"+LocalDate.now());// 2021-02-04
		System.out.println("2021 年 3 月 4 号:"+LocalDate.of(2021, 3, 4));// 2021-03-04
		System.out.println("2021-01-02:"+LocalDate.parse("2021-01-02", DateTimeFormatter.ofPattern("yyyy-MM-dd")));// 2021-01-02
		System.out.println("20210102:"+LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));// 2021-01-02
		System.out.println("当前日期加一天:"+LocalDate.now().plusDays(1));
		System.out.println("当前日期加一周:"+LocalDate.now().plusWeeks(1));
		System.out.println("当前日期加一月:"+LocalDate.now().plusMonths(1));
		System.out.println("当前日期减一天:"+LocalDate.now().minusDays(1));
		System.out.println("当前日期减一天:"+LocalDate.now().minusDays(1));
		System.out.println("是否为闰年:"+LocalDate.now().isLeapYear());
		System.out.println("当前月的第一天:"+LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()));
		System.out.println("当前月的最后一天:"+LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()));
		System.out.println("当前年:"+LocalDate.now().getYear());//2021
		System.out.println("当前月:"+LocalDate.now().getMonth());//FEBRUARY
		System.out.println("当前星期:"+LocalDate.now().getDayOfWeek());//FRIDAY
		System.out.println("当前天数（年）:"+LocalDate.now().getDayOfYear());//36
		System.out.println("当前日期:"+LocalDate.now().getDayOfMonth());//5
		
		System.out.println(LocalDateTime.now());// 2021-02-04T14:59:54.580082300
		System.out.println(LocalTime.now());// 2021-02-04T14:59:54.580082300
	}
}
