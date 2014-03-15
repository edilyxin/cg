package com.rc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author <a href="mailto:roy.wei@m-time.com">Roy Wei</a>
 *
 */
public class DateUtils {

	//~ Static fields/initializers
	// =============================================

	private static Log log = LogFactory.getLog(DateUtils.class);

	private static String defaultDatePattern = "yyyy-MM-dd";

	private static String timePattern = "yyyy-MM-dd HH:mm";

	//~ Methods
	// ================================================================

	public static String getDatePattern() {
		//        if (defaultDatePattern == null) {
		//            Locale locale = LocaleContextHolder.getLocale();
		//            defaultDatePattern = ResourceBundle.getBundle("ApplicationResources")
		//                                               .getString("date.format");
		//        }
		return defaultDatePattern;
	}

	public static String getTimePattern() {
		return timePattern;
	}

	/**
	 *
	 * 转换为yyyy-MM-dd格式的字符串输出
	 *
	 * @param aDate
	 *            date from database as a string
	 * @return formatted string for the ui
	 */
	public static final String getDate(Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate != null) {
			df = new SimpleDateFormat(getDatePattern());
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}

	/**
	 *
	 * 转换为固定格式的字符串输出
	 *
	 * @param aDate
	 *            date from database as a string
	 * @return formatted string for the ui
	 */
	public static final String getDate(Date aDate,String format) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate != null) {
			df = new SimpleDateFormat(format);
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}

	/**
	 * This method generates a string representation of a date/time in the
	 * format you specify on input
	 *
	 * @param aMask
	 *            the date pattern the string is in
	 * @param strDate
	 *            a string representation of a date
	 * @return a converted Date object
	 * @see java.text.SimpleDateFormat
	 * @throws ParseException
	 */
	public static final Date convertStringToDate(String aMask, String strDate) throws ParseException {
		SimpleDateFormat df = null;
		Date date = null;
		df = new SimpleDateFormat(aMask);

//		if (log.isDebugEnabled()) {
//			log.debug("converting '" + strDate + "' to date with mask '" + aMask + "'");
//		}

		try {
			date = df.parse(strDate);
		} catch (ParseException pe) {
			//log.error("ParseException: " + pe);
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());
		}

		return (date);
	}

	/**
	 * This method returns the current date time in the format: MM/dd/yyyy HH:MM
	 * a
	 *
	 * @param theTime
	 *            the current time
	 * @return the current date/time
	 */
	public static String getTimeNow(Date theTime) {
		return getDateTime(timePattern, theTime);
	}

	/**
	 * This method returns the current date in the format: MM/dd/yyyy
	 *
	 * @return the current date
	 * @throws ParseException
	 */
	public static Calendar getToday() throws ParseException {
		Date today = new Date();
		SimpleDateFormat df = new SimpleDateFormat(getDatePattern());

		// This seems like quite a hack (date -> string -> date),
		// but it works ;-)
		String todayAsString = df.format(today);
		Calendar cal = new GregorianCalendar();
		cal.setTime(convertStringToDate(todayAsString));

		return cal;
	}

	/**
	 * This method generates a string representation of a date's date/time in
	 * the format you specify on input
	 *
	 * @param aMask
	 *            the date pattern the string is in
	 * @param aDate
	 *            a date object
	 * @return a formatted string representation of the date
	 *
	 * @see java.text.SimpleDateFormat
	 */
	public static final String getDateTime(String aMask, Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate == null) {
			if (log.isErrorEnabled()) {
				log.error("aDate is null!");
			}
		} else {
			df = new SimpleDateFormat(aMask);
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}

	/**
	 * This method generates a string representation of a date based on the
	 * System Property 'dateFormat' in the format you specify on input
	 *
	 * @param aDate
	 *            A date to convert
	 * @return a string representation of the date
	 */
	public static final String convertDateToString(Date aDate) {
		return getDateTime(getDatePattern(), aDate);
	}

	/**
	 * This method converts a String to a date using the datePattern
	 *
	 * @param strDate
	 *            the date to convert (in format MM/dd/yyyy)
	 * @return a date object
	 *
	 * @throws ParseException
	 */
	public static Date convertStringToDate(String strDate) throws ParseException {
		Date aDate = null;

		try {
//			if (log.isDebugEnabled()) {
//				log.debug("converting date with pattern: " + getDatePattern());
//			}

			aDate = convertStringToDate(getDatePattern(), strDate);
		} catch (ParseException pe) {
			if (log.isErrorEnabled()) {
				log.error("Could not convert '" + strDate + "' to a date, throwing exception");
			}
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());

		}

		return aDate;
	}

	/**
	 * 返回开始日期格式,为 yyyy-MM-dd 00:00:00
	 *
	 * @param date
	 *            如果输入null,则取当天日期
	 * @return yyyy-MM-dd 00:00:00格式的日期
	 */

	public static Date getStartDate(Date date) {
		if (date == null) {
			date = new Date(System.currentTimeMillis());
		}
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(date);
		rightNow.set(Calendar.HOUR_OF_DAY, 0);
		rightNow.set(Calendar.MINUTE, 0);
		rightNow.set(Calendar.SECOND, 0);

		return rightNow.getTime();
	}

	/**
	 * 返回开始日期格式,为 yyyy-MM-dd 23:59:59
	 *
	 * @param date
	 *            如果输入null,则取当天日期
	 * @return yyyy-MM-dd 23:59:59格式的日期
	 */

	public static Date getEndDate(Date date) {
		if (date == null) {
			date = new Date(System.currentTimeMillis());
		}
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(date);
		rightNow.set(Calendar.HOUR_OF_DAY, 23);
		rightNow.set(Calendar.MINUTE, 59);
		rightNow.set(Calendar.SECOND, 59);

		return rightNow.getTime();
	}

	/**
	 * 返回开始日期格式,为 yyyy-MM-dd 00:00:00
	 *
	 * @param date
	 *            如果输入null,则取当天日期
	 * @return yyyy-MM-dd 00:00:00格式的日期
	 */

	public static Calendar getStartCalendar(Date date) {
		if (date == null) {
			date = new Date(System.currentTimeMillis());
		}
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(date);
		rightNow.set(Calendar.HOUR_OF_DAY, 0);
		rightNow.set(Calendar.MINUTE, 0);
		rightNow.set(Calendar.SECOND, 0);

		return rightNow;
	}

	/**
	 * 返回开始日期格式,为 yyyy-MM-dd 23:59:59
	 *
	 * @param date
	 *            如果输入null,则取当天日期
	 * @return yyyy-MM-dd 23:59:59格式的日期
	 */

	public static Calendar getEndCalendar(Date date) {
		if (date == null) {
			date = new Date(System.currentTimeMillis());
		}
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(date);
		rightNow.set(Calendar.HOUR_OF_DAY, 23);
		rightNow.set(Calendar.MINUTE, 59);
		rightNow.set(Calendar.SECOND, 59);

		return rightNow;
	}

	/**
	 * 返回开始日期格式,为 yyyy-MM-dd 00:00:00
	 *
	 * @param sdate
	 *            如果输入null,则取当天日期
	 * @return yyyy-MM-dd 00:00:00格式的日期
	 */

	public static Date getStartStringToDate(String sdate) {
		Date date = null;
		if (sdate != null && !sdate.equals("")) {
			try {
				date = convertStringToDate("yyyy-MM-dd", sdate);
			} catch (ParseException e) {
				if (log.isWarnEnabled()) {
					log.warn("字符串转换为日期类型出错:" + sdate, e);
				}
				return date;
			}
		} else
			return null;
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(date);
		rightNow.set(Calendar.HOUR_OF_DAY, 0);
		rightNow.set(Calendar.MINUTE, 0);
		rightNow.set(Calendar.SECOND, 0);

		return rightNow.getTime();
	}

	/**
	 * 返回开始日期格式,为 yyyy-MM-dd 23:59:59
	 *
	 * @param sdate
	 *            如果输入null,则取当天日期
	 * @return yyyy-MM-dd 23:59:59格式的日期
	 */

	public static Date getEndStringToDate(String sdate) {
		Date date = null;
		if (sdate != null && !sdate.equals("")) {
			try {
				date = convertStringToDate("yyyy-MM-dd", sdate);
			} catch (ParseException e) {
				if (log.isWarnEnabled()) {
					log.warn("字符串转换为日期类型出错:" + sdate, e);
				}
				return date;
			}
		} else
			return null;
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(date);
		rightNow.set(Calendar.HOUR_OF_DAY, 23);
		rightNow.set(Calendar.MINUTE, 59);
		rightNow.set(Calendar.SECOND, 59);

		return rightNow.getTime();
	}

	/**
	 * 取得输入日期字符串的正负N天对应的日期,如果输入的日期为null或者""则取当前日期
	 * @author Nigel
	 * Create Time: 2005-12-15
	 * @param dateStr 日期字符串
	 * @param before
	 * @return
	 */
	public static String getDateBefore(String dateStr, int before) {
		Date date = null;
		if (dateStr != null && !dateStr.equals("")) {
			try {
				date = convertStringToDate("yyyy-MM-dd", dateStr);
			} catch (ParseException e) {
				if (log.isWarnEnabled()) {
					log.warn("字符串转换为日期类型出错:" + dateStr, e);
				}
				return "";
			}
		}
		Calendar rightNow = Calendar.getInstance();
		if (date != null)
			rightNow.setTime(date);
		rightNow.set(Calendar.DATE, rightNow.get(Calendar.DATE) + before);
		return getDate(rightNow.getTime());
	}

	/**
	 * 日期比较
	 * Create Time: 2005-12-15
	 * @param date1 (格式：yyyy-mm-dd)
	 * @param date2 (格式：yyyy-mm-dd)
	 * @return 相差天数
	 */
	public static long getDateCompare(String date1, String date2) {

		String[] strDate = { date1, date2 };
		int iLen = strDate.length;

		int[] slashMarkIndex1 = new int[iLen];
		int[] slashMarkIndex2 = new int[iLen];

		String[] year = new String[iLen];
		String[] month = new String[iLen];
		String[] day = new String[iLen];
		int[] iYear = new int[iLen];
		int[] iMonth = new int[iLen];
		int[] iDay = new int[iLen];

		Calendar[] calen = new Calendar[iLen];
		Date[] dTime = new Date[iLen];

		for (int i = 0; i < strDate.length; i++) {

			slashMarkIndex1[i] = strDate[i].indexOf("-");
			slashMarkIndex2[i] = strDate[i].indexOf("-", slashMarkIndex1[i] + 1);

			year[i] = strDate[i].substring(0, slashMarkIndex1[i]);
			month[i] = strDate[i].substring(slashMarkIndex1[i] + 1, slashMarkIndex2[i]);
			day[i] = strDate[i].substring(slashMarkIndex2[i] + 1);

			iYear[i] = Integer.parseInt(year[i]);
			iMonth[i] = Integer.parseInt(month[i]) - 1;
			iDay[i] = Integer.parseInt(day[i]);

			calen[i] = Calendar.getInstance();

			calen[i].clear();

			calen[i].set(iYear[i], iMonth[i], iDay[i]);
			dTime[i] = calen[i].getTime();
		}

		long diff = dTime[0].getTime() - dTime[1].getTime();

		return (diff / 1000 / 60 / 60 / 24);
	}


    /**
	 * 时间转换，把long型毫秒数据转换成时分秒的字符串
	 * Create Time: 2005-12-15
	 * @param lngTimes (long型时间，毫秒级)
	 * @return 转换成时分秒的字符串
	 */
    public static String formatLongToTimeString(Long lngTimes) {
        String str = "";
        int hour = 0;
        int minute = 0;
        int second = 0;

        second = lngTimes.intValue() / 1000;

        if (second > 60) {
            minute = second / 60;
            second = second % 60;
        }
        if (minute > 60) {
            hour = minute / 60;
            minute = minute % 60;
        }
        return (String.valueOf(hour) + "小时" + String.valueOf(minute)  + "分钟"
                + String.valueOf(second)  + "秒");
    }




}//end of class DateUtils
