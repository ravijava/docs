package com.sorc.datamigration.articles.core.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

public class DateUtil {

	private static Logger logger = Logger.getLogger(DateUtil.class);

	public static final String DEFALUT_DATEFORMAT = "yyyy-MM-dd'T'HH:mm:ss";

	private static List<String> dateFormats = new ArrayList<String>();  
		
	static{		
		dateFormats.add("yyyy-MM-dd'T'HH:mm:ss");
		dateFormats.add("yyyy.MM.dd'T'HH:mm:ss");
		dateFormats.add("yyyy/MM/dd'T'HH:mm:ss");
		dateFormats.add("yyyy MM dd'T'HH:mm:ss");	
		
		dateFormats.add("yyyy-MMM-dd'T'HH:mm:ss");
		dateFormats.add("yyyy.MMM.dd'T'HH:mm:ss");
		dateFormats.add("yyyy/MMM/dd'T'HH:mm:ss");
		dateFormats.add("yyyy MMM dd'T'HH:mm:ss");	
		
		dateFormats.add("M/dd/yyyy hh:mm:ss a");
		dateFormats.add("M.dd.yyyy hh:mm:ss a");
		dateFormats.add("M-dd-yyyy hh:mm:ss a");
		dateFormats.add("M dd yyyy hh:mm:ss a");
		
		dateFormats.add("yyyy-MM-dd HH:mm:ss");
		dateFormats.add("yyyy.MM.dd HH:mm:ss");
		dateFormats.add("yyyy/MM/dd HH:mm:ss");
		dateFormats.add("yyyy MM dd HH:mm:ss");	
		
		dateFormats.add("MMM dd yyyyHH:mma");
		dateFormats.add("MMM/dd/yyyyHH:mma");
		dateFormats.add("MMM.dd.yyyyHH:mma");
		dateFormats.add("MMM-dd-yyyyHH:mma");
		
		dateFormats.add("MMM.dd.yyyy");
		dateFormats.add("MMM-dd-yyyy");
		dateFormats.add("MMM/dd/yyyy");
		dateFormats.add("MMM dd yyyy");
		
		dateFormats.add("M.d.yyyy");
		dateFormats.add("M-d-yyyy");		
		dateFormats.add("M/d/yyyy");
		dateFormats.add("M d yyyy");
	}

	public static Date getDateFromString(String dateStr) {		
		
		Date date = null;
				
		if(GenericUtil.isObjectNull(dateStr))
			return null;		
		
		for(int i=0; i<dateFormats.size(); i++)
		{
			try {
				date = new SimpleDateFormat(dateFormats.get(i)).parse(dateStr);				
			} catch (ParseException e) {				
				//try other date format
				if(i == dateFormats.size()-1)
					logger.error(e);
			}
			
			if (date != null) {
                break;
            }
		}
		
		return date;
	}		
	
	public static String getJsonDateFromString(Date date) {		
		String dateStr = null;		
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
			dateStr = dateFormat.format(date);				
		} catch (Exception e) {								
				logger.error(e);
		}
		return dateStr;
	}
	
	public static long convertDateToMilliSeconds(String dateStr) {
		    Date date = getDateFromString(dateStr);
		    long dateInLong = date.getTime();

		    System.out.println("date = " + date);
		    System.out.println("dateInLong = " + dateInLong);
			return dateInLong;
	}
}
