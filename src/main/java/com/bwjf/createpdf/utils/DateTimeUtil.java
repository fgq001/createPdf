package com.bwjf.createpdf.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil {

	private static String PATTERN = "yyyy-MM-dd HH:mm:ss";

	// 获取有效期
	public static String getYxq(String kprq) {
		String enddate = "";
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			Date currdate = format.parse(kprq);
			Calendar ca = Calendar.getInstance();
			ca.add(Calendar.DATE, 180);// num为增加的天数，可以改变的
			currdate = ca.getTime();
			String enddate1 = format.format(currdate);

			Date date = (Date) format.parse(enddate1);
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			enddate = sdf2.format(date);
			System.out.print("有效期：" + enddate);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return enddate;
	}

	/**
	 * String 当前时间
	 * 
	 * @return
	 */
	public static String getStrDate() {
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN);
		return sdf.format(new Date());
	}

	/**
	 * Date 当前时间
	 * 
	 * @return
	 */
	public static Date getDate() {
		String d = getStrDate();
		SimpleDateFormat fmt = new SimpleDateFormat(PATTERN);
		try {
			Date today = fmt.parse(d);
			return today;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * yyyyMMddHHmmss 时间转 1 yyyy-MM-dd 2 yyyy-MM-dd HH:mm:ss
	 */
	public static String ParseDate(String date, Integer type) {
		String pasDate = "";
		try {
			Date orderDateStart = new SimpleDateFormat("yyyyMMddHHmmss").parse(date);
			if (type == 1) {
				pasDate = new SimpleDateFormat("yyyy-MM-dd").format(orderDateStart);
			} else if (type == 2) {
				pasDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(orderDateStart);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return pasDate;
	}

	/**
	 * Data 时间格式化
	 * 
	 * @param d
	 *            时间
	 * @param pattern
	 *            转换格式
	 * @return
	 */
	public static Date parseDate(Date d, String pattern) {
		SimpleDateFormat fmt = new SimpleDateFormat(pattern);
		try {
			return fmt.parse(fmt.format(d));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 时间格式转换 返回 String类型
	 * 
	 * @param d
	 *            时间
	 * @param pattern
	 *            转换格式
	 * @return
	 */
	public static String formatDate(Date d, String pattern) {
		SimpleDateFormat fmt = new SimpleDateFormat(pattern);
		return fmt.format(d);
	}

	/**
	 * 字符串日期转Date
	 */
	public static Date parseDate(String d, String pattern) {
		SimpleDateFormat fmt = new SimpleDateFormat(pattern);
		try {
			return fmt.parse(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 判断是否为当天
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isToday(Date date) {
		if (date == null) {
			return false;
		}
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		if (fmt.format(date).toString().equals(fmt.format(new Date()).toString())) {
			return true;
		}
		return false;
	}

	/**
	 * 判断是否为当月
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isCurrentMonth(Date date) {
		if (date == null) {
			return false;
		}
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM");
		if (fmt.format(date).toString().equals(fmt.format(new Date()).toString())) {
			return true;
		}
		return false;
	}

	/**
	 * 判断是否为当年
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isCurrentYear(Date date) {
		if (date == null) {
			return false;
		}
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy");
		if (fmt.format(date).toString().equals(fmt.format(new Date()).toString())) {
			return true;
		}
		return false;
	}

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static double daystimeBetween(Date smdate, Date bdate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			smdate = sdf.parse(sdf.format(smdate));
			bdate = sdf.parse(sdf.format(bdate));
		} catch (ParseException e) {

		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		double between_days = (double) (time2 - time1) / (1000 * 3600 * 24);
		return between_days;
	}

	public static String getYear() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		return sdf.format(new Date());
	}

	public static String getYear(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		return sdf.format(date);
	}

	public static String getYear2() {
		SimpleDateFormat sdf = new SimpleDateFormat("yy");
		return sdf.format(new Date());
	}

	public static String getMonth() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		return sdf.format(new Date());
	}

	public static String getMonth(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		return sdf.format(date);
	}

	public static String getDay() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		return sdf.format(new Date());
	}

	public static String getDay(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		return sdf.format(date);
	}

}
