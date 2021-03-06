package pl.edu.agh.tools;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateTimeTools {

	private static SimpleDateFormat fullDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.getDefault());
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
	private static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
	private static final String DATE_SEPARATOR = ".";
	private static final String TIME_SEPARATOR = ":";
	
	/**
	 * Format: yyyy:MM:dd HH:mm:ss
	 * @param fullDate
	 */
	public static Date convertStringToFullDate(String fullDate) {
		String[] date = fullDate.split(" ")[0].split("\\" + DATE_SEPARATOR);
		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.DAY_OF_MONTH, Integer.valueOf(date[0]));
		calendar.set(Calendar.MONTH, Integer.valueOf(date[1]) - 1);
		calendar.set(Calendar.YEAR, Integer.valueOf(date[2]));
		String[] time = fullDate.split(" ")[1].split(TIME_SEPARATOR);
		calendar.set(Calendar.HOUR_OF_DAY, Integer.valueOf(time[0]));
		calendar.set(Calendar.MINUTE, Integer.valueOf(time[1]));
		calendar.set(Calendar.SECOND, Integer.valueOf(time[2]));
		return calendar.getTime();
	}
	
	/**
	 * Format: yyyy:MM:dd + time is 00:00:00
	 * @param date
	 */
	public static Date convertStringToDate(String dateString) {
		String[] date = dateString.split("\\" + DATE_SEPARATOR);
		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.DAY_OF_MONTH, Integer.valueOf(date[0]));
		calendar.set(Calendar.MONTH, Integer.valueOf(date[1]) - 1);
		calendar.set(Calendar.YEAR, Integer.valueOf(date[2]));
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}
	
	/**
	 * Format: HH:mm:ss + date is set on today's date
	 * @param timeOnly
	 * @return
	 */
	public static Date convertStringToTime(String timeOnly) {
		String[] date = timeOnly.split(TIME_SEPARATOR);
		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.HOUR_OF_DAY, Integer.valueOf(date[0]));
		calendar.set(Calendar.MINUTE, Integer.valueOf(date[1]) - 1);
		calendar.set(Calendar.SECOND, Integer.valueOf(date[2]));
		return calendar.getTime();
	}
	
	public static String convertFullDateToString(Calendar calendar) {
		return fullDateFormat.format(calendar.getTime());
	}
	
	public static String convertFullDateToString(Date date) {
		return fullDateFormat.format(date);
	}
	
	public static String convertDateToString(Calendar calendar) {
		return dateFormat.format(calendar.getTime());
	}
	
	public static String convertDateToString(Date date) {
		return dateFormat.format(date);
	}
	
	public static String convertTimeToString(Calendar calendar) {
		return timeFormat.format(calendar.getTime());
	}
	
	public static String convertTimeToString(Date date) {
		return timeFormat.format(date);
	}

	public static Calendar getCalendarInstanceWithDate(int year, int month, int day) {
		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar;
	}
	
	public static Calendar getCalendarInstanceWithTime(int hour, int minute) {
		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, minute);
		calendar.set(Calendar.SECOND, 0);
		return calendar;
	}
	
	public static Calendar getCalendarInstanceWithTime(Date date, int hour, int minute) {
		Calendar calendar = getCalendarFromDate(date);
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, minute);
		calendar.set(Calendar.SECOND, 0);
		return calendar;
	}
	
	public static int getMinuteDifferenceBetweenTwoDates(Date firstDate, Date secondDate) {
		return getCalendarFromDate(secondDate).get(Calendar.HOUR_OF_DAY) * 60 + getCalendarFromDate(secondDate).get(Calendar.MINUTE) - (getCalendarFromDate(firstDate).get(Calendar.HOUR_OF_DAY) * 60 + getCalendarFromDate(firstDate).get(Calendar.MINUTE));
	}

	public static Calendar getCalendarFromDate(Date date) {
		Calendar calendar = Calendar.getInstance();
            		calendar.setTime(date);
		return calendar;
	}
	
	public static Calendar getCalendarFromDates(Date date, Date timeDate) {
		Calendar timeCalendar = getCalendarFromDate(timeDate);
		Calendar calendar = getCalendarInstanceWithTime(date, timeCalendar.get(Calendar.HOUR_OF_DAY), timeCalendar.get(Calendar.MINUTE));
		return calendar;
	}
	
	public static boolean happenedBefore(Date firstDate, Date secondDate){
		return getCalendarFromDate(firstDate).before(secondDate);
	}
	
	public static boolean isBetween(Date date, Date firstDate, Date seccondDate)
	{
		//if(happenedBefore(firstDate, date) && happenedBefore(date, seccondDate)) {
		if(firstDate.getTime() < date.getTime() && date.getTime() < seccondDate.getTime()) {
			return true;
		}
		return false;
	}
	
	public static Date addMinutesToDate(Date date, int amount){
		Calendar calendar = getCalendarFromDate(date);
		calendar.add(Calendar.MINUTE,amount);
		return calendar.getTime();
	}
}
