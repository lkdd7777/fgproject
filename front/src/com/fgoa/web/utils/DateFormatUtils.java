package com.fgoa.web.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtils {
	public static final String SHORT_FORMAT = "yyyy-MM-dd";
	public static final String LONG_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String CHI_SHORT_FORMAT = "yyyy��MM��dd��";
	public static final String CHI_LONG_FORMAT = "yyyy��MM��dd��  HH:mm:ss";
	public static final String SPLIT_SHORT_FORMAT = "yyyy/MM/dd";
	public static final String SPLIT_LONG_FORMAT = "yyyy/MM/dd HH:mm:ss";

	public static Date convertToDate(DateFormat format, String dateStr)
			throws ParseException {
		return format.parse(dateStr);
	}

	public static Date convertToDate(String formatStr, String dateStr)
			throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		return convertToDate(format, dateStr);
	}

	public static Date convertToDate(String dateStr) throws Exception {
		String[] formats = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss",
				"yyyy��MM��dd��", "yyyy��MM��dd��  HH:mm:ss", "yyyy/MM/dd",
				"yyyy/MM/dd HH:mm:ss" };

		Date returnValue = null;
		for (String format : formats) {
			try {
				returnValue = convertToDate(format, dateStr);
				if (returnValue != null) {
					break;
				}
			} catch (ParseException e) {
			}
		}
		if (returnValue == null) {
			throw new Exception();
		}
		return returnValue;
	}
}
