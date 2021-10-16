package com.ddf.utils;

import java.util.Date;

import org.testng.annotations.Test;

public class DateUtils {
	
	public static String getTimeStamp(){
		Date date = new Date();
		return date.toString().replaceAll(":", "_").replaceAll(" ", "_");
	}
	
	
}
