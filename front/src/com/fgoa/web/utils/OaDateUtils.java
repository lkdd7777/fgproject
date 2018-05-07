package com.fgoa.web.utils;

import com.fgoa.web.vo.CommonDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class OaDateUtils {
	public static CommonDate getCommonDate(Date date)                                                                 
  {                                                                                                                 
    CommonDate returnValue = new CommonDate();                                                                      
    Calendar c = Calendar.getInstance();                                                                            
    c.setTime(date);                                                                                                
                                                                                                                    
    returnValue.setWeek(getWeekOfDate(c));                                                                          
    returnValue.setNoon(getNoon(c));                                                                                
    returnValue.setDate(c.get(2) + 1 + "月" + c.get(5) + "日");                                                     
                                                                                                                    
    returnValue.setTime(String.format("%02d", new Object[] { Integer.valueOf(c.get(11)) }) + ":" + String.format("%02d", new Object[] { Integer.valueOf(c.get(12)) }));
                                                                                                                    
                                                                                                                    
    return returnValue;                                                                                             
  }
	public static String getWeekOfDate(Calendar c) {
		String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		int w = c.get(7) - 1;
		if (w < 0)
			w = 0;
		return weekDays[w];
	}

	public static String getNoon(Calendar c) {
		String[] noons = { "上午", "下午" };
		int n = c.get(9) - 1;
		if (n < 0) {
			n = 0;
		} else {
			n = 1;
		}
		return noons[n];
	}

	public static Date getCurrentDay() {
		Date current = new Date();
		Calendar c = Calendar.getInstance(Locale.CHINA);
		c.setTime(current);
		c.set(5, c.getActualMaximum(5));
		return c.getTime();
	}

	public static int getDayInMonth(Date date) {
		Calendar c = Calendar.getInstance(Locale.CHINA);
		c.setTime(date);
		return c.get(5);
	}

	public static Date getMinTimeInDay(Date date) {
		Calendar c = Calendar.getInstance(Locale.CHINA);
		c.setTime(date);

		c.set(11, 0);
		c.set(12, 0);
		c.set(13, 0);

		return c.getTime();
	}

	public static Date getMaxTimeInDay(Date date) {
		Calendar c = Calendar.getInstance(Locale.CHINA);
		c.setTime(date);

		c.set(11, 23);
		c.set(12, 59);
		c.set(13, 59);

		return c.getTime();
	}

	public static Date getMaxTimeInMonth(Date date) {
		Calendar c = Calendar.getInstance(Locale.CHINA);
		c.setTime(date);

		c.set(11, 23);
		c.set(12, 59);
		c.set(13, 59);
		c.set(5, c.getActualMaximum(5));

		return c.getTime();
	}

	public static Date getMinTimeInMonth(Date date) {
		Calendar c = Calendar.getInstance(Locale.CHINA);
		c.setTime(date);

		c.set(11, 0);
		c.set(12, 0);
		c.set(13, 0);
		c.set(5, 1);

		return c.getTime();
	}

	public static int getDayByDate(Date date) {
		Calendar c = Calendar.getInstance(Locale.CHINA);
		c.setTime(date);
		return c.get(5);
	}

	public static boolean isNight() {
		Date date = new Date();
		Calendar c = Calendar.getInstance(Locale.CHINA);
		c.setTime(date);
		int h = c.get(11);

		if ((h > 18) || (h < 6)) {
			return true;
		}
		return false;
	}

	public static Date getLastMonday(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(7, 1);
		return c.getTime();
	}

	public static Date getNextSunday(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(7, 7);
		return c.getTime();
	}

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(11, 1);
		System.out.println(c.get(9));
	}
}
