package com.healthy.commons.lang;

import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.time.DateFormatUtils;

public class DateFormatUtilsUsage {

	
	public void formatUTC(){
		Date d = new Date();
		long dateTime = d.getTime();
		System.out.println(DateFormatUtils.formatUTC(dateTime, "yyyy-MM-dd"));
		System.out.println(DateFormatUtils.formatUTC(d, "yyyy-MM-dd"));
		System.out.println(DateFormatUtils.formatUTC(dateTime, "yyyy-MM-dd",Locale.CHINESE));
		System.out.println(DateFormatUtils.formatUTC(d, "yyyy-MM-dd",Locale.CHINESE));
	}
	
	public void format(){
		
		Date d = new Date();
		long dateTime = d.getTime();
		System.out.println(DateFormatUtils.format(dateTime, "yyyy-MM-dd"));
		System.out.println(DateFormatUtils.format(d, "yyyy-MM-dd"));
		System.out.println(DateFormatUtils.format(dateTime, "yyyy-MM-dd",Locale.CHINESE));
		System.out.println(DateFormatUtils.format(d, "yyyy-MM-dd",Locale.CHINESE));
	
	}
	
	public static void main(String[] args) {

		DateFormatUtilsUsage dateFormatUtilsUsage = new DateFormatUtilsUsage();
		dateFormatUtilsUsage.format();
		dateFormatUtilsUsage.formatUTC();
	}

}
