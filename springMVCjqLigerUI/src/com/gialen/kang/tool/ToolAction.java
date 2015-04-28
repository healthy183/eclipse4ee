package com.gialen.kang.tool;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.directwebremoting.io.FileTransfer;

public class ToolAction {

	
	public static String getThisYear(){
		SimpleDateFormat smdt = new SimpleDateFormat("yyyy");
		return smdt.format(new Date());
	}
	
	public static String getThisMonth() {
		SimpleDateFormat smdt = new SimpleDateFormat("yyyyMM");
		return smdt.format(new Date());
	}
	
	public static String getThisDate() {
		SimpleDateFormat smdt = new SimpleDateFormat("yyyy.MM.dd");
		return smdt.format(new Date());
	}
	
	public static String setYearList(HttpServletRequest request){
	

		String prevYear = null;
		String thisYear = null;
		String nextYear = null;
		String toYear = null;
		Integer formatThisyear = null;
		Integer formatToyear = null;
		
		thisYear =  request.getParameter("thisYear");
		

		List<String> yearList = new ArrayList<String>();
		
		
		if(thisYear == null){
			thisYear = ToolAction.getThisYear();// 从工具类中获得当前年份，
			formatThisyear = Integer.valueOf(thisYear);
			prevYear = (formatThisyear-1)+"";
			nextYear = (formatThisyear+1)+"";
			yearList.add(prevYear);
			yearList.add(thisYear);
			yearList.add(nextYear);
			//yearList.add(thisYear);
		}else{
			//yearList.add(thisYear);
			toYear = ToolAction.getThisYear();// 从工具类中获得当前年份，
			formatToyear = Integer.valueOf(toYear);
			
			formatThisyear = Integer.valueOf(thisYear);//转参数过来的年份
			
			if(formatToyear > formatToyear){
				
				yearList.add((formatToyear-2)+"");
				yearList.add((formatToyear-1)+"");
				yearList.add(formatToyear+"");
				
			}else if(formatToyear == formatToyear){
				
				yearList.add((formatToyear-1)+"");
				yearList.add(formatToyear+"");
				yearList.add((formatToyear+1)+"");
				
			}else{
				
				yearList.add(formatToyear+"");
				yearList.add((formatToyear+1)+"");
				yearList.add((formatToyear+2)+"");
				
			}
			
			
		}/**/
		request.setAttribute("yearList",yearList);
		request.setAttribute("thisYear",thisYear);
		
		return thisYear;
		
		/*
		toYear = ToolAction.getThisYear();// 从工具类中获得当前年份，
		if(toYear.equals(thisYear)){
			thisYear = ToolAction.getThisYear();// 从工具类中获得当前年份，
			nextYear = (Integer.valueOf(thisYear)+1)+"";
		}else{
			nextYear = (Integer.valueOf(thisYear)-1)+"";
		}
	*/
		
		
	}
	
	
	
	//File upfiles
	//File upfiles
		public static String upload(InputStream upfiles,String address){
			//good系文件路劲
			 //= new File(good);
			String fileName = null;
			BufferedInputStream bin;
			java.io.BufferedOutputStream bout;
			//upfiles;
			try {
				//bin =  new BufferedInputStream(new java.io.FileInputStream(upfiles));
				bin =  new BufferedInputStream(upfiles);
				//FileTransfer f = upfiles;
				if(address.equalsIgnoreCase("Area")){
				fileName = "d:/uploadFile/"+address+new Random().nextInt(10000)+".xls";
					}
				else if(address.equalsIgnoreCase("Store")){
					 fileName = "d:/uploadFile/"+address+new Random().nextInt(10000)+".xls";
					
				}else if(address.equalsIgnoreCase("Total")){
					fileName = "d:/uploadFile/"+address+new Random().nextInt(10000)+".xls";
				}else {
					fileName = "d:/uploadFile/"+new Random().nextInt(10000)+".xls";
					
				}
				bout = new BufferedOutputStream(new java.io.FileOutputStream(fileName));
			
				int tmp=0;
				while(tmp!=-1){
					tmp = bin.read();
					bout.write(tmp);
				}
				bout.flush();
				bout.close();
				bin.close();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return fileName; 
		}

	public static String upload(InputStream upfiles){
		//good系文件路劲
		 //= new File(good);
		String fileName = null;
		BufferedInputStream bin;
		java.io.BufferedOutputStream bout;
		//upfiles;
		try {
			//bin =  new BufferedInputStream(new java.io.FileInputStream(upfiles));
			bin =  new BufferedInputStream(upfiles);
			//FileTransfer f = upfiles;
			fileName = "d:/uploadFile/"+new Random().nextInt(10000)+".xls";
			bout = new BufferedOutputStream(new java.io.FileOutputStream(fileName));
		
			int tmp=0;
			while(tmp!=-1){
				tmp = bin.read();
				bout.write(tmp);
			}
			bout.flush();
			bout.close();
			bin.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileName; 
	}

	public static List<Date> getMyFormatDate(String operatingStartDate,
			String operatingEndDate) {
		
		SimpleDateFormat smdt  = new SimpleDateFormat("yyyy.MM.dd");
		
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = smdt.parse(operatingStartDate);
			endDate = smdt.parse(operatingEndDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		List<Date> dateList = new ArrayList<Date>();
		dateList.add(startDate);
		dateList.add(endDate);
		return dateList;
	}
	
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip = request.getRemoteAddr();
		}
		return ip;
		}
	
	public static Map<Integer, String> getErrormMap(){
		Map<Integer, String> errorMap=new HashMap<Integer, String>();
		for (int i = 0; i < 26; i++) {
			char abc=(char)(i+65);
			errorMap.put(i, abc+"");
		}
		return errorMap;
	}
	
}
