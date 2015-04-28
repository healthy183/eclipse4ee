package com.healthy.commons.lang;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.FastDateFormat;

public class DateUtilsUsage {

	public void isSameDay(){
		
		Date date = new Date();
		Date date2 = new Date();
	
		System.out.println(DateUtils.isSameDay(date, date2));
		
		System.out.println(DateUtils.isSameInstant(date, date2 ));

		//System.out.println(DateUtils.isSameLocalTime(date, date2 ));
	}
	
	public void add(){
		
		Date date = new Date();
		String dateString = DateFormatUtils.format(DateUtils.addYears(date, 1),"yyyy-MM-dd");
		System.out.println(dateString);
		
	    dateString = DateFormatUtils.format(DateUtils.addMonths(date, 1),"yyyy-MM-dd");
		System.out.println(dateString);
		
		dateString = DateFormatUtils.format(DateUtils.addWeeks(date, 1),"yyyy-MM-dd");
		System.out.println(dateString);
		
		dateString = DateFormatUtils.format(DateUtils.addDays(date, 1),"yyyy-MM-dd");
		System.out.println(dateString);
		
		dateString = DateFormatUtils.format(DateUtils.addHours(date, 1),"yyyy-MM-dd hh:mm:ss");
		System.out.println(dateString);
		
		dateString = DateFormatUtils.ISO_DATE_FORMAT.format(date);
		System.out.println(dateString);
		
		
		 FastDateFormat fdf = FastDateFormat.getInstance("yyyy-MM");
		 String customDateTime = fdf.format(date);
		 System.out.println(customDateTime);
	}
	
	
	public static void main(String[] args) {
		DateUtilsUsage dateUtilsUsage = new DateUtilsUsage();
		dateUtilsUsage.add();
		//dateUtilsUsage.isSameDay();
	}

}
