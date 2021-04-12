package com.vsr.trade.store.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	private final static String PATTERN = "dd/MM/yyyy";
	
	public static Date formatDate(String date) {
		
		DateFormat format = new SimpleDateFormat(PATTERN);
		Date dateObj=null;
		try {
			dateObj = format.parse(date);
		} catch (ParseException e) {
		}
		return dateObj;
	}

	public static java.sql.Date convertToSQLDate(Date date) {
		if(date==null) {
			return null;
		}
		return new java.sql.Date(date.getTime());
	}
	
	public static Date convertToUtilDate(java.sql.Date date) {
		if(date==null) {
			return null;
		}
		return new Date(date.getTime());
	}
	
	public static String convertToUtilDateStr(java.sql.Date date) {
		if(date==null) {
			return null;
		}
		DateFormat format = new SimpleDateFormat(PATTERN);
		return format.format(new Date(date.getTime()));		
	}
	
	public static String convertToUtilDateStr(Date date) {
		if(date==null) {
			return null;
		}
		DateFormat format = new SimpleDateFormat(PATTERN);
		return format.format(new Date(date.getTime()));		
	}
	
	public static Date today() {
		return new Date();
	}
	
	public static Date tomorrow() {
		return new Date(new Date().getTime() + (1000 * 60 * 60 * 24));
	}
	private Utils() {}
}
