package com.headstrong.npi.raas;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateConversion {


	private static final Logger LOGGER = LoggerFactory.getLogger(DateConversion.class);

	public final static long SECOND_MILLIS = 1000;
	public final static long MINUTE_MILLIS = SECOND_MILLIS * 60;
	public final static long HOUR_MILLIS = MINUTE_MILLIS * 60;
	public final static long DAY_MILLIS = HOUR_MILLIS * 24;
	public final static long YEAR_MILLIS = DAY_MILLIS * 365;
	
	// Date Format Strings
	public static final String DATE_FORMAT_STR_YYYY_MM_DD = "yyyy/MM/dd";
	public static final String DATE_FORMAT_STR_YYYYMMDD_FORMAT = "yyyy-MM-dd";
	public static final String DATE_FORMAT_STR_YYYY_MM_DD_2 = "yyyy-MM-dd";
	public static final String DATE_FORMAT_STR_YYYY_MM_DD_3 = "YYYY-MM-DD";
	public static final String DATE_FORMAT_STR_DD_MM_YYYY = "dd/MM/yyyy";
	public static final String DATE_FORMAT_STR_US = "MM/dd/yyyy";
	public static final String DATE_FORMAT_STR_US_2 = "MM-dd-yyyy";
	public static final String DATE_FORMAT_STR_MM_D = "MM/dd";
	public static final String DATE_FORMAT_STR_MMM_D = "MMM dd";
	public static final String DATE_FORMAT_STR_MMMM_D = "MMMM dd";
	public static final String DATE_FORMAT_SPREADSHEET = "dd-mmm-yy";
	public static final String TIME_FORMAT_STR_H_MM_SS = "H:mm:ss";
	public static final String TIME_FORMAT_STR_HH_MM_SS = "HH:mm:ss";
	public static final String DATE_TIME_FORMAT_STR_YYYY_MM_DD_H_MM_SS = "yyyy-MM-dd H:mm:ss";
	public static final String DATE_TIME_FORMAT_STR_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd hh:mm:ss";
	public static final String DATE_TIME_FORMAT_STR_YYYY_MM_DD_HH_MM_SS_2 = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_TIME_FORMAT_STR_MM_DD_YYYY_HH_MM_US = "MM/dd/yyyy HH:mm:ss";
	public static final String DATE_TIME_FORMAT_STR_YYYY_MM_DD_HH_MM_SS_3 = "yyyyMMdd_HHmmss";
	public static final String DATE_TIME_FORMAT_STR_YYYY_MM_DD_HH_MM_SS_4 = "yyyy-MM-dd:HH:mm:ss";
	public static final String DATE_TIME_FORMAT_STR_YYYY_MM_DD_HH_MM_SS_5 = "yyyy/MM/dd HH:mm:ss";
	public static final String DATE_TIME_FORMAT_STR_YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss:SSS";
	public static final String DATE_TIME_FORMAT_STR_YYYY_MM_DD_HH_MM_SS_SSS_Z = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
	public static final String DATE_TIME_FORMAT_STR_YYYY_MM_DD_KK_MM_SS = "yyyyMMddkkmmss";
	public static final String DATE_TIME_FORMAT_STR_D_MM_YY_H_MM_SS = "d/M/yy H:mm:ss";
	public static final String DATE_TIME_FORMAT_STR_US = "MM/dd/yyyy H:mm:ss";
	public static final String DATE_TIME_FORMAT_STR_US_2 = "MMddyyyyhhmmss";
	public static final String DATE_TIME_FORMAT_STR_US_3 = "MM/dd/yyyy hh:mm:ss a";
	public static final String DATE_TIME_FORMAT_STR_US_4 = "MM/dd/yyyy HH:mm:ss";
	public static final String DATE_TIME_FORMAT_STR_US_5 = "MMddyyyyHHmmss";
	public static final String DATE_TIME_FORMAT_SPREADSHEET = "dd-mmm-yy h:mm AM/PM";
	
	// Date formats. FIXME: Use thread locals.
	private static final ThreadLocalDF OUT_DATE_FORMAT = new ThreadLocalDF(DATE_FORMAT_STR_DD_MM_YYYY);
	private static final ThreadLocalDF OUT_TIME_FORMAT = new ThreadLocalDF(TIME_FORMAT_STR_H_MM_SS);
	private static final ThreadLocalDF OUT_DATETIME_FORMAT = new ThreadLocalDF(DATE_TIME_FORMAT_STR_US);
	private static final ThreadLocalDF OUT_TIMESTAMP_FORMAT = new ThreadLocalDF(DATE_TIME_FORMAT_STR_D_MM_YY_H_MM_SS);
	private static final ThreadLocalDF NEW_OUT_DATETIME_FORMAT = new ThreadLocalDF(DATE_TIME_FORMAT_STR_US);
	private static final ThreadLocalDF IN_DATE_FORMAT = new ThreadLocalDF(DATE_FORMAT_STR_YYYY_MM_DD);
	private static final ThreadLocalDF DATE_FORMAT_YYYY_MM_DD_2 = new ThreadLocalDF(DATE_FORMAT_STR_YYYY_MM_DD_2);
	private static final ThreadLocalDF DATE_FORMAT_YYYY_MM_DD_3 = new ThreadLocalDF(DATE_FORMAT_STR_YYYY_MM_DD_3);
	private static final ThreadLocalDF IN_TIME_FORMAT = new ThreadLocalDF(TIME_FORMAT_STR_H_MM_SS);
	private static final ThreadLocalDF TIME_FORMAT_HH_MM_SS = new ThreadLocalDF(TIME_FORMAT_STR_HH_MM_SS);
	private static final ThreadLocalDF IN_DATETIME_FORMAT = new ThreadLocalDF(DATE_TIME_FORMAT_STR_YYYY_MM_DD_H_MM_SS);
	private static final ThreadLocalDF DATE_TIME_FORMAT_YYYY_MM_DD_HH_MM_SS_2 = new ThreadLocalDF(DATE_TIME_FORMAT_STR_YYYY_MM_DD_HH_MM_SS_2);
	private static final ThreadLocalDF DATE_TIME_FORMAT_MM_DD_YYYY_HH_MM_US = new ThreadLocalDF(DATE_TIME_FORMAT_STR_MM_DD_YYYY_HH_MM_US);
	private static final ThreadLocalDF DATE_TIME_FORMAT_YYYY_MM_DD_HH_MM_SS_3 = new ThreadLocalDF(DATE_TIME_FORMAT_STR_YYYY_MM_DD_HH_MM_SS_3);
	private static final ThreadLocalDF DATE_TIME_FORMAT_YYYY_MM_DD_HH_MM_SS_4 = new ThreadLocalDF(DATE_TIME_FORMAT_STR_YYYY_MM_DD_HH_MM_SS_4);
	private static final ThreadLocalDF DATE_TIME_FORMAT_YYYY_MM_DD_HH_MM_SS_5 = new ThreadLocalDF(DATE_TIME_FORMAT_STR_YYYY_MM_DD_HH_MM_SS_5);
	private static final ThreadLocalDF DATE_TIME_FORMAT_YYYY_MM_DD_HH_MM_SS_SSS = new ThreadLocalDF(DATE_TIME_FORMAT_STR_YYYY_MM_DD_HH_MM_SS_SSS);
	private static final ThreadLocalDF DATE_TIME_FORMAT_YYYY_MM_DD_HH_MM_SS_SSS_Z = new ThreadLocalDF(DATE_TIME_FORMAT_STR_YYYY_MM_DD_HH_MM_SS_SSS_Z);
	private static final ThreadLocalDF IN_TIMESTAMP_FORMAT = new ThreadLocalDF(DATE_TIME_FORMAT_STR_D_MM_YY_H_MM_SS);

	private static final ThreadLocalDF DATE_TIME_FORMAT = new ThreadLocalDF(DATE_TIME_FORMAT_STR_YYYY_MM_DD_KK_MM_SS);
	private static final ThreadLocalDF OUT_DATE_FORMAT_US = new ThreadLocalDF(DATE_FORMAT_STR_US);
	private static final ThreadLocalDF DATE_FORMAT_US_2 = new ThreadLocalDF(DATE_FORMAT_STR_US_2);
	private static final ThreadLocalDF DATE_TIME_FORMAT_US_3 = new ThreadLocalDF(DATE_TIME_FORMAT_STR_US_3);
	private static final ThreadLocalDF DATE_TIME_FORMAT_US_4 = new ThreadLocalDF(DATE_TIME_FORMAT_STR_US_4);
	private static final ThreadLocalDF DATE_TIME_FORMAT_US_5 = new ThreadLocalDF(DATE_TIME_FORMAT_STR_US_5);
	private static final ThreadLocalDF DATE_FORMAT_MM_D = new ThreadLocalDF(DATE_FORMAT_STR_MM_D);
	private static final ThreadLocalDF DATE_FORMAT_MMM_D = new ThreadLocalDF(DATE_FORMAT_STR_MMM_D);
	private static final ThreadLocalDF DATE_FORMAT_MMMM_D = new ThreadLocalDF(DATE_FORMAT_STR_MMMM_D);
	
	public static final DateFormat getOutDateFormat() {
		return OUT_DATE_FORMAT.get();
	}

	public static final DateFormat getOutTimeFormat() {
		return OUT_TIME_FORMAT.get();
	}

	public static final DateFormat getOutDatetimeFormat() {
		return OUT_DATETIME_FORMAT.get();
	}

	public static final DateFormat getOutTimestampFormat() {
		return OUT_TIMESTAMP_FORMAT.get();
	}

	public static final DateFormat getNewOutDatetimeFormat() {
		return NEW_OUT_DATETIME_FORMAT.get();
	}

	public static final DateFormat getInDateFormat() {
		return IN_DATE_FORMAT.get();
	}

	public static final DateFormat getDateFormatYyyyMmDd2() {
		return DATE_FORMAT_YYYY_MM_DD_2.get();
	}

	public static final DateFormat getDateFormatYyyyMmDd3() {
		return DATE_FORMAT_YYYY_MM_DD_3.get();
	}

	public static final DateFormat getInTimeFormat() {
		return IN_TIME_FORMAT.get();
	}
	
	public static final DateFormat getTimeFormatHhMmSs() {
		return TIME_FORMAT_HH_MM_SS.get();
	}

	public static final DateFormat getInDatetimeFormat() {
		return IN_DATETIME_FORMAT.get();
	}

	public static final DateFormat getDateTimeFormatYyyyMmDdHhMmSs2() {
		return DATE_TIME_FORMAT_YYYY_MM_DD_HH_MM_SS_2.get();
	}
	
	public static final DateFormat getDateTimeFormatMmDdYyyyHhMmSs2() {
		return DATE_TIME_FORMAT_MM_DD_YYYY_HH_MM_US.get();
	}

	public static final DateFormat getDateTimeFormatYyyyMmDdHhMmSs3() {
		return DATE_TIME_FORMAT_YYYY_MM_DD_HH_MM_SS_3.get();
	}

	public static final DateFormat getDateTimeFormatYyyyMmDdHhMmSs4() {
		return DATE_TIME_FORMAT_YYYY_MM_DD_HH_MM_SS_4.get();
	}

	public static final DateFormat getDateTimeFormatYyyyMmDdHhMmSs5() {
		return DATE_TIME_FORMAT_YYYY_MM_DD_HH_MM_SS_5.get();
	}

	public static final DateFormat getDateTimeFormatYyyyMmDdHhMmSsSss() {
		return DATE_TIME_FORMAT_YYYY_MM_DD_HH_MM_SS_SSS.get();
	}

	public static final DateFormat getDateTimeFormatYyyyMmDdHhMmSsSssZ() {
		return DATE_TIME_FORMAT_YYYY_MM_DD_HH_MM_SS_SSS_Z.get();
	}

	public static final DateFormat getInTimestampFormat() {
		return IN_TIMESTAMP_FORMAT.get();
	}

	public static final DateFormat getDateTimeFormat() {
		return DATE_TIME_FORMAT.get();
	}

	public static final DateFormat getOutDateFormatUs() {
		return OUT_DATE_FORMAT_US.get();
	}

	public static final DateFormat getDateFormatUs2() {
		return DATE_FORMAT_US_2.get();
	}

	public static final DateFormat getDateTimeFormatUs3() {
		return DATE_TIME_FORMAT_US_3.get();
	}

	public static final DateFormat getDateTimeFormatUs4() {
		return DATE_TIME_FORMAT_US_4.get();
	}

	public static final DateFormat getDateTimeFormatUs5() {
		return DATE_TIME_FORMAT_US_5.get();
	}

	public static final DateFormat getDateFormatMmD() {
		return DATE_FORMAT_MM_D.get();
	}

	public static final DateFormat getDateFormatMmmD() {
		return DATE_FORMAT_MMM_D.get();
	}

	public static final DateFormat getDateFormatMmmmD() {
		return DATE_FORMAT_MMMM_D.get();
	}

	private static DatatypeFactory df = null;

	static {
		try {
			df = DatatypeFactory.newInstance();
		} catch (DatatypeConfigurationException e) {
			throw new IllegalStateException("Error while trying to obtain a new instance of DatatypeFactory", e);
		}
	}

	/**
	 * Convert date from XML GregorianCalendar to String in 'MM/dd/yyyy hh:mm:ss'
	 * 
	 * @param xmlCalendar XMLGregorianCalendar INSTANCE
	 * @return String
	 */
	public static String XMLGregorianCalendartoString(XMLGregorianCalendar xmlCalendar, DateFormat format) {
		if(xmlCalendar == null) {
			return null;
		}
		GregorianCalendar calendar = xmlCalendar.toGregorianCalendar();
		if(format == null) {
			format = new SimpleDateFormat(DATE_TIME_FORMAT_STR_US_4);
		}
		return format.format(calendar.getTime());
	}
	
	/**
     * Convert String with various formats into java.util.Date
     * 
     * @param input
     *            Date as a string
     * @return java.util.Date object if input string is parsed 
     *          successfully else returns null
     */
    public static Date convertStringToDate(String input , DateFormat format) {
        Date date = null;
        if(input == null || input.trim().length()<1) {
            return null;
        }
        
        try {
        	if(format == null) {
    			format = new SimpleDateFormat(DATE_TIME_FORMAT_STR_US_4);
    		}
	        format.setLenient(false);
	        date = format.parse(input);
        } catch (ParseException e) {
            
        }
        return date;
    }

	
	public static XMLGregorianCalendar asXMLGregorianCalendar(java.util.Date date) {
		if (date == null) {
			return null;
		} else {
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTimeInMillis(date.getTime());
			return df.newXMLGregorianCalendar(gc);
		}
	}

	public static java.util.Date asDate(XMLGregorianCalendar xmlGC) {
		if (xmlGC == null) {
			return null;
		} else {
			return xmlGC.toGregorianCalendar().getTime();
		}
	}

	public static XMLGregorianCalendar getCurrentDateInXMLGregorianCalendar() {

		Date currentDate = new Date(); // Current date
		DateFormat dateFormat = getDateFormatYyyyMmDd2();
		String temp = dateFormat.format(currentDate);
		String[] strArr = temp.split("-");
		String year = strArr[0];
		String month = strArr[1];
		String date = strArr[2];

		XMLGregorianCalendar xmlGC = df.newXMLGregorianCalendar();

		xmlGC.setDay(Integer.parseInt(date));
		xmlGC.setMonth(Integer.parseInt(month));
		xmlGC.setYear(Integer.parseInt(year));

		return xmlGC;
	}

	public static XMLGregorianCalendar getCurrentDateInXMLGregorianCalendar(String date) {

		String[] strArr = date.split("-");
		String year = strArr[0];
		String month = strArr[1];
		String datedd = strArr[2];

		XMLGregorianCalendar xmlGC = df.newXMLGregorianCalendar();

		xmlGC.setDay(Integer.parseInt(datedd));
		xmlGC.setMonth(Integer.parseInt(month));
		xmlGC.setYear(Integer.parseInt(year));

		return xmlGC;
	}

	public static Timestamp getCurrentDateTimeTimestamp() {
		return new Timestamp(new java.util.Date().getTime());
	}

	public static String getCurrentDate() {
		Date currentDate = new Date();
		Format formatter = getOutDateFormatUs();
		String currentDateString = formatter.format(currentDate);
		return currentDateString;

	}

	/**
	 * return current date in string Date format yyyy/MM/dd H:mm:ss
	 * 
	 * **/
	public static String getCurrentDateTime() {
		return getOutDatetimeFormat().format(new java.util.Date());
	}

	public static String getCurrentDateAndTime() {
		return getNewOutDatetimeFormat().format(new java.util.Date());
	}

	public static String getCurrentDateAndTime(Date date) {
		return getNewOutDatetimeFormat().format(date);
	}

	public static Calendar convertStringToCalenderObj(String dateToBeConverted,
			String pattern) throws ParseException {
		Date date = new SimpleDateFormat(pattern).parse(dateToBeConverted);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}

	/**
	 * Argument in the NEW_OUT_DATETIME_FORMAT
	 * 
	 * @throws ParseException
	 * */
	public static Timestamp convertStringDateTimeToTimestamp(String DateTime) throws ParseException {
		Timestamp ts = new Timestamp(getNewOutDatetimeFormat().parse(DateTime).getTime());
		return ts;
	}

	/**
	 * Argument in the OUT_DATETIME_FORMAT
	 * 
	 * @throws ParseException
	 * */
	public static Timestamp convertStringDateTimeOldFormatToTimestamp(String DateTime) throws ParseException {
		Timestamp ts = new Timestamp(getOutDatetimeFormat().parse(DateTime).getTime());
		return ts;
	}

	public static long getCurrentTimeInMilliSec() throws ParseException {

		Calendar currentDate = Calendar.getInstance();
		return currentDate.getTimeInMillis();
	}

	/**
	 * This Method will return the string represent the difference between the current date and the old entered date.
	 * 
	 * @param currentDate
	 * @param oldDate
	 * @return
	 */
	public static String getTimeDiff(Calendar currentDate, Calendar oldDate) {
		long timeDiffInMilliSec = (currentDate.getTimeInMillis()) - (oldDate.getTimeInMillis());
		StringBuffer timeDuration = new StringBuffer();
		long millSecRemaining = 0;
		if (timeDiffInMilliSec > Constants.MILLISECINADAY) {
			long noOfDays = timeDiffInMilliSec / Constants.MILLISECINADAY;
			millSecRemaining = timeDiffInMilliSec % Constants.MILLISECINADAY;
			timeDuration.append(noOfDays + "d");
		}
		if (timeDiffInMilliSec > Constants.MILLISECINAHOUR) {
			if (millSecRemaining == 0) {
				long noOfHours = timeDiffInMilliSec / Constants.MILLISECINAHOUR;
				millSecRemaining = timeDiffInMilliSec % Constants.MILLISECINAHOUR;
				timeDuration.append(noOfHours + "h");
			} else if (millSecRemaining > Constants.MILLISECINAHOUR) {
				long noOfHours = millSecRemaining / Constants.MILLISECINAHOUR;
				millSecRemaining = millSecRemaining % Constants.MILLISECINAHOUR;
				timeDuration.append(" " + noOfHours + "h");
			}
		}
		if (timeDiffInMilliSec > Constants.MILLISECINAMINUTE) {
			if (millSecRemaining == 0) {
				long noOfMinutes = timeDiffInMilliSec / Constants.MILLISECINAMINUTE;
				timeDuration.append(noOfMinutes + "m");
			} else if (millSecRemaining > Constants.MILLISECINAMINUTE) {
				long noOfMinutes = millSecRemaining / Constants.MILLISECINAMINUTE;
				timeDuration.append(" " + noOfMinutes + "m");
			}
		}
		if (null == timeDuration || ("").equalsIgnoreCase(timeDuration.toString())) {
			timeDuration.append("Few Seconds Ago");
		}

		return timeDuration.toString();
	}

	public static long daysBetween(Calendar currentDate, Calendar oldDate) {
		long timeDiffInMilliSec = (currentDate.getTimeInMillis())
				- (oldDate.getTimeInMillis());
		long milliSecInADay = 24 * 60 * 60 * 1000L;
		/* findbugfix
		 * long milliSecInAHour = 60 * 60 * 1000;
		long milliSecInAMin = 60 * 1000;
		StringBuffer timeDuration = new StringBuffer();
		long millSecRemaining = 0;*/
		long noOfDays = 0;
		if (timeDiffInMilliSec > milliSecInADay) {
			noOfDays = timeDiffInMilliSec / milliSecInADay;
		} else {
			noOfDays = 1;
		}
		return noOfDays;
	}

	/**
	 * This method will return the time in milli seconds.
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static long getTimeInMilliSec(Date date) throws ParseException {
		return date.getTime();
	}

	/**
	 * This method will return the time difference between dates in milli seconds.
	 * 
	 * @param currentDate
	 * @param oldDate
	 * @return
	 */
	public static long returnTimeDifferenceInMilliseconds(Calendar currentDate, Calendar oldDate) {
		return (currentDate.getTimeInMillis()) - (oldDate.getTimeInMillis());
	}

	/**
	 * Get number of days hours and minutes for the given time in millisecs.
	 * 
	 * @param timeDiffInMilliSec
	 */
	public static String calculateDaysHoursMinutesforTimeInMillis(long timeDiffInMilliSec) {
		StringBuffer timeDuration = new StringBuffer();
		long millSecRemaining = 0;
		if (timeDiffInMilliSec > Constants.MILLISECINADAY) {
			long noOfDays = timeDiffInMilliSec / Constants.MILLISECINADAY;
			millSecRemaining = timeDiffInMilliSec % Constants.MILLISECINADAY;
			timeDuration.append(noOfDays + "d");
		}
		if (timeDiffInMilliSec > Constants.MILLISECINAHOUR) {
			if (millSecRemaining == 0) {
				long noOfHours = timeDiffInMilliSec / Constants.MILLISECINAHOUR;
				millSecRemaining = timeDiffInMilliSec % Constants.MILLISECINAHOUR;
				timeDuration.append(noOfHours + "h");
			} else if (millSecRemaining > Constants.MILLISECINAHOUR) {
				long noOfHours = millSecRemaining / Constants.MILLISECINAHOUR;
				millSecRemaining = millSecRemaining % Constants.MILLISECINAHOUR;
				timeDuration.append(" " + noOfHours + "h");
			}
		}
		if (timeDiffInMilliSec > Constants.MILLISECINAMINUTE) {
			if (millSecRemaining == 0) {
				long noOfMinutes = timeDiffInMilliSec / Constants.MILLISECINAMINUTE;
				timeDuration.append(noOfMinutes + "m");
			} else if (millSecRemaining > Constants.MILLISECINAMINUTE) {
				long noOfMinutes = millSecRemaining / Constants.MILLISECINAMINUTE;
				timeDuration.append(" " + noOfMinutes + "m");
			}
		}
		if (timeDuration == null || timeDuration.length() == 0) {
			timeDuration.append("0m");
		}
		return timeDuration.toString();
	}

	/**
	 * Get number of days hours and minutes for the given time in sec.
	 * 
	 * @param timeDiffInMilliSec
	 */
	public static String calculateDaysHoursMinutesforTimeInSec(long timeDiffInSec) {
		StringBuffer timeDuration = new StringBuffer();
		long timeDiffInMilliSec = timeDiffInSec * 1000;
		long millSecRemaining = 0;
		if (timeDiffInMilliSec > Constants.MILLISECINADAY) {
			long noOfDays = timeDiffInMilliSec / Constants.MILLISECINADAY;
			millSecRemaining = timeDiffInMilliSec % Constants.MILLISECINADAY;
			timeDuration.append(noOfDays + "d");
		}
		if (timeDiffInMilliSec > Constants.MILLISECINAHOUR) {
			if (millSecRemaining == 0) {
				long noOfHours = timeDiffInMilliSec / Constants.MILLISECINAHOUR;
				millSecRemaining = timeDiffInMilliSec % Constants.MILLISECINAHOUR;
				timeDuration.append(noOfHours + "h");
			} else if (millSecRemaining > Constants.MILLISECINAHOUR) {
				long noOfHours = millSecRemaining / Constants.MILLISECINAHOUR;
				millSecRemaining = millSecRemaining % Constants.MILLISECINAHOUR;
				timeDuration.append(" " + noOfHours + "h");
			}
		}
		if (timeDiffInMilliSec > Constants.MILLISECINAMINUTE) {
			if (millSecRemaining == 0) {
				long noOfMinutes = timeDiffInMilliSec / Constants.MILLISECINAMINUTE;
				timeDuration.append(noOfMinutes + "m");
			} else if (millSecRemaining > Constants.MILLISECINAMINUTE) {
				long noOfMinutes = millSecRemaining / Constants.MILLISECINAMINUTE;
				timeDuration.append(" " + noOfMinutes + "m");
			}
		}
		if (timeDuration == null || timeDuration.length() == 0) {
			timeDuration.append("0m");
		}
		return timeDuration.toString();
	}

	/**
	 * This Method will return the Hours, Minutes, Days difference between the current date and the old entered date.
	 * 
	 * @param currentDate
	 * @param oldDate
	 * @return
	 */
	public static String getTimeDifferenceBetweenDates(Calendar currentDate, Calendar oldDate) {

		long timeDiffInMilliSec = (currentDate.getTimeInMillis()) - (oldDate.getTimeInMillis());
		String timeDuration = calculateDaysHoursMinutesforTimeInMillis(timeDiffInMilliSec);
		return timeDuration;
	}

	/**
	 * Create a new DateTime. To the last second. This will not create any extra-millis-seconds, which may cause bugs when writing to stores such as databases that round milli-seconds up and down.
	 */
	public static java.util.Date newDateTime() {
		return new java.util.Date((System.currentTimeMillis() / SECOND_MILLIS) * SECOND_MILLIS);
	}

	/**
	 * Create a new Date. To the last day.
	 */
	public static java.sql.Date newDate() {
		return new java.sql.Date((System.currentTimeMillis() / DAY_MILLIS) * DAY_MILLIS);
	}

	/**
	 * Create a new Time, with no date component.
	 */
	public static java.sql.Time newTime() {
		return new java.sql.Time(System.currentTimeMillis() % DAY_MILLIS);
	}

	/**
	 * Create a new Timestamp.
	 */
	public static java.sql.Timestamp newTimestamp() {
		return new java.sql.Timestamp(System.currentTimeMillis());
	}

	/**
	 * Get the seconds difference
	 */
	public static int secondsDiff(Date earlierDate, Date laterDate) {
		if (earlierDate == null || laterDate == null)
			return 0;

		return (int) ((laterDate.getTime() / SECOND_MILLIS) - (earlierDate.getTime() / SECOND_MILLIS));
	}

	/**
	 * Get the minutes difference
	 */
	public static int minutesDiff(Date earlierDate, Date laterDate) {
		if (earlierDate == null || laterDate == null)
			return 0;

		return (int) ((laterDate.getTime() / MINUTE_MILLIS) - (earlierDate.getTime() / MINUTE_MILLIS));
	}

	/**
	 * Get the hours difference
	 */
	public static int hoursDiff(Date earlierDate, Date laterDate) {
		if (earlierDate == null || laterDate == null)
			return 0;

		return (int) ((laterDate.getTime() / HOUR_MILLIS) - (earlierDate.getTime() / HOUR_MILLIS));
	}

	/**
	 * Get the days difference
	 */
	public static int daysDiff(Date earlierDate, Date laterDate) {
		if (earlierDate == null || laterDate == null)
			return 0;

		return (int) ((laterDate.getTime() / DAY_MILLIS) - (earlierDate.getTime() / DAY_MILLIS));
	}

	/**
	 * Roll the java.util.Time forward or backward.
	 * 
	 * @param startDate
	 *            - The start date
	 * @period Calendar.YEAR etc
	 * @param amount
	 *            - Negative to rollbackwards.
	 */
	public static java.sql.Time rollTime(java.util.Date startDate, int period, int amount) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(startDate);
		gc.add(period, amount);
		return new java.sql.Time(gc.getTime().getTime());
	}

	/**
	 * Roll the java.util.Date forward or backward.
	 * 
	 * @param startDate
	 *            - The start date
	 * @period Calendar.YEAR etc
	 * @param amount
	 *            - Negative to rollbackwards.
	 */
	public static java.util.Date rollDateTime(java.util.Date startDate, int period, int amount) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(startDate);
		gc.add(period, amount);
		return new java.util.Date(gc.getTime().getTime());
	}

	/**
	 * Roll the java.sql.Date forward or backward.
	 * 
	 * @param startDate
	 *            - The start date
	 * @period Calendar.YEAR etc
	 * @param amount
	 *            - Negative to rollbackwards.
	 */
	public static java.sql.Date rollDate(java.util.Date startDate, int period, int amount) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(startDate);
		gc.add(period, amount);
		return new java.sql.Date(gc.getTime().getTime());
	}

	/**
	 * Roll the years forward or backward.
	 * 
	 * @param startDate
	 *            - The start date
	 * @param years
	 *            - Negative to rollbackwards.
	 */
	public static java.sql.Date rollYears(java.util.Date startDate, int years) {
		return rollDate(startDate, Calendar.YEAR, years);
	}

	/**
	 * Roll the days forward or backward.
	 * 
	 * @param startDate
	 *            - The start date
	 * @param months
	 *            - Negative to rollbackwards.
	 */
	public static java.sql.Date rollMonths(java.util.Date startDate, int months) {
		return rollDate(startDate, Calendar.MONTH, months);
	}

	/**
	 * Roll the days forward or backward.
	 * 
	 * @param startDate
	 *            - The start date
	 * @param days
	 *            - Negative to rollbackwards.
	 */
	public static java.sql.Date rollDays(java.util.Date startDate, int days) {
		return rollDate(startDate, Calendar.DATE, days);
	}

	/**
	 * Convert an Object of type Classs to an Object.
	 */
	@SuppressWarnings("rawtypes")
	public static Object toObject(Class clazz, Object value) throws ParseException {
		if (value == null)
			return null;
		if (clazz == null)
			return value;

		if (java.sql.Date.class.isAssignableFrom(clazz))
			return toDate(value);
		if (java.sql.Time.class.isAssignableFrom(clazz))
			return toTime(value);
		if (java.sql.Timestamp.class.isAssignableFrom(clazz))
			return toTimestamp(value);
		if (java.util.Date.class.isAssignableFrom(clazz))
			return toDateTime(value);

		return value;
	}

	/**
	 * Convert an Object to a DateTime, without an Exception
	 */
	public static java.util.Date getDateTime(Object value) {
		try {
			return toDateTime(value);
		} catch (ParseException pe) {
			LOGGER.error("Could not parse date", pe);
			return null;
		}
	}

	/**
	 * Convert an Object to a DateTime.
	 */
	public static java.util.Date toDateTime(Object value) throws ParseException {
		if (value == null)
			return null;
		if (value instanceof java.util.Date)
			return (java.util.Date) value;
		if (value instanceof String) {
			if ("".equals((String) value))
				return null;
			return getOutDatetimeFormat().parse((String) value);
		}

		return getOutDatetimeFormat().parse(value.toString());
	}

	/**
	 * Convert an Object to a Date, without an Exception
	 */
	public static java.sql.Date getDate(Object value) {
		try {
			return toDate(value);
		} catch (ParseException pe) {
			LOGGER.error("Could not parse date", pe);
			return null;
		}
	}

	/**
	 * Convert an Object to a Date.
	 */
	public static java.sql.Date toDate(Object value) throws ParseException {
		if (value == null)
			return null;
		if (value instanceof java.sql.Date)
			return (java.sql.Date) value;
		if (value instanceof String) {
			if ("".equals((String) value))
				return null;
			return new java.sql.Date(getInDateFormat().parse((String) value).getTime());
		}

		return new java.sql.Date(getInDateFormat().parse(value.toString()).getTime());
	}

	/**
	 * Convert an Object to a Time, without an Exception
	 */
	public static java.sql.Time getTime(Object value) {
		try {
			return toTime(value);
		} catch (ParseException pe) {
			LOGGER.error("Could not parse date", pe);
			return null;
		}
	}

	/**
	 * Convert an Object to a Time.
	 */
	public static java.sql.Time toTime(Object value) throws ParseException {
		if (value == null)
			return null;
		if (value instanceof java.sql.Time)
			return (java.sql.Time) value;
		if (value instanceof String) {
			if ("".equals((String) value))
				return null;
			return new java.sql.Time(getInTimeFormat().parse((String) value).getTime());
		}

		return new java.sql.Time(getInTimeFormat().parse(value.toString()).getTime());
	}

	/**
	 * Convert an Object to a Timestamp, without an Exception
	 */
	public static java.sql.Timestamp getTimestamp(Object value) {
		try {
			return toTimestamp(value);
		} catch (ParseException pe) {
			LOGGER.error("Could not parse date", pe);
			return null;
		}
	}

	/**
	 * Convert an Object to a Timestamp.
	 */
	public static java.sql.Timestamp toTimestamp(Object value) throws ParseException {
		if (value == null)
			return null;
		if (value instanceof java.sql.Timestamp)
			return (java.sql.Timestamp) value;
		if (value instanceof String) {
			if ("".equals((String) value))
				return null;
			return new java.sql.Timestamp(getInTimestampFormat().parse((String) value).getTime());
		}

		return new java.sql.Timestamp(getInTimestampFormat().parse(value.toString()).getTime());
	}

	public static int getYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}

	public static int getMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH);
	}

	public static int getDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DATE);
	}

	public static int getHour(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.HOUR);
	}

	public static int getMinute(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MINUTE);
	}

	public static int getSeconds(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.SECOND);
	}

	public static int getMillisecond(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MILLISECOND);
	}

	/**
	 * Convert an Object to a String using Dates
	 */
	public static String toString(Object date) {
		if (date == null)
			return null;

		if (java.sql.Timestamp.class.isAssignableFrom(date.getClass())) {
			return getOutTimestampFormat().format(date);
		}
		if (java.sql.Time.class.isAssignableFrom(date.getClass())) {
			return getOutTimeFormat().format(date);
		}
		if (java.sql.Date.class.isAssignableFrom(date.getClass())) {
			return getOutDateFormat().format(date);
		}
		if (java.util.Date.class.isAssignableFrom(date.getClass())) {
			return getOutDatetimeFormat().format(date);
		}

		throw new IllegalArgumentException("Unsupported type " + date.getClass());
	}

	public static String getFutureDate(int daysFromNow) {

		long milli = (24 * 3600 * 1000) * daysFromNow + new Date().getTime();
		Date date = new Date(milli);
		// change format
		DateFormat format = getDateFormatUs2();

		return format.format(date);
	}

	public static String setDate(int daysFromNow) {

		DateFormat format = getOutDateFormatUs();
		Calendar c1 = Calendar.getInstance();
		c1.add(Calendar.DATE, daysFromNow);
		return format.format(c1.getTime());
	}

	public static String setYear(int YearsFromNow) {

		DateFormat format = getOutDateFormatUs();
		Calendar c1 = Calendar.getInstance();
		c1.add(Calendar.YEAR, YearsFromNow);
		return format.format(c1.getTime());
	}

	public static String getORADateToStr(Date theDate) {
		if (theDate == null) {
			return "";
		}
		return getOutDateFormatUs().format(theDate);
	}

	public static String convertTimestampToString(Timestamp timestamp) {
		if (timestamp == null) {

			return "";
		}

		DateFormat format = getDateTimeFormatYyyyMmDdHhMmSs2();
		Date date = (Date) timestamp;
		return format.format(date);

	}

	public static String convertTimestampToStringWithTimeZone(Timestamp timestamp, String timeZoneFormat) {
		if (timestamp == null) {

			return "";
		}

		DateFormat format = getDateTimeFormatYyyyMmDdHhMmSs2();
		Date date = (Date) timestamp;
		TimeZone tz = TimeZone.getTimeZone(timeZoneFormat);
		format.setTimeZone(tz);

		return format.format(date);

	}

	public static String convertTimestampToStringWithFormat(Timestamp timestamp, String Format) {
		if (timestamp == null) {

			return "";
		}

		DateFormat format = new SimpleDateFormat(Format);
		Date date = (Date) timestamp;
		return format.format(date);

	}

	public static String displayTimestampAsString(Timestamp timestamp) {

		DateFormat format = getDateTimeFormatUs4();
		Date date = (Date) timestamp;
		return format.format(date);

	}

	public static Timestamp convertStringToTimestamp(String dateTime) {

		String MM = dateTime.substring(0, 2);
		String dd = dateTime.substring(3, 5);
		String yyyy = dateTime.substring(6, 10);
		String hh = dateTime.substring(11, 13);
		String mm = dateTime.substring(14, 16);
		String ss = dateTime.substring(17, 19);
		String finalString = yyyy + "-" + MM + "-" + dd + " " + hh + ":" + mm + ":" + ss;
		return Timestamp.valueOf(finalString);

	}

	public static Timestamp convertStringToTimestamp2(String dateTime) {
		String yyyy = dateTime.substring(0, 4);
		String MM = dateTime.substring(5, 7);
		String dd = dateTime.substring(8, 10);
		String hh = dateTime.substring(11, 13);
		String mm = dateTime.substring(14, 16);
		String ss = dateTime.substring(17, 19);
		String finalString = yyyy + "-" + MM + "-" + dd + " " + hh + ":" + mm + ":" + ss;
		return Timestamp.valueOf(finalString);

	}

	public static boolean compareDates(String startDate, String endDate) {

		boolean afterDt = false;
		try {
			DateFormat df = getOutDateFormatUs();
			Date startDt = df.parse(startDate);
			Date endDt = df.parse(endDate);

			if (startDt.after(endDt)) {
				afterDt = true;
			}
		} catch (Exception ex) {

		}
		return afterDt;
	}

	public static boolean checkDateEquality(String date1, String date2) {
		boolean res = false;

		try {
			DateFormat df = getOutDateFormatUs();
			Date date_1 = df.parse(date1);
			Date date_2 = df.parse(date2);

			if (date_1.equals(date_2))
				res = true;

		} catch (Exception ex) {

		}

		return res;
	}

	public static String convertXMLGregorianDateToString(String xmlDate) {
		XMLGregorianCalendar gc;
		try {
			DateFormat dateFormat = getDateTimeFormatUs4();
			gc = DatatypeFactory.newInstance().newXMLGregorianCalendar(xmlDate);

			GregorianCalendar gCalender = gc.toGregorianCalendar();

			if (gCalender != null) {
				return dateFormat.format(gCalender.getTime()).toString();
			}

		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static boolean futureDate(String strDate) {
		boolean futureDate = false;
		try {

			DateFormat df = getOutDateFormatUs();
			Date enteredDate = df.parse(strDate);
			Date currDate = new Date();

			if (enteredDate.after(currDate)) {
				futureDate = true;
			}

		} catch (Exception ex) {
		}

		return futureDate;

	}

	public static java.sql.Date convertStringTimestampToDate(String passedDate) throws ParseException {
		DateFormat formater = getDateTimeFormatYyyyMmDdHhMmSs2();
		java.util.Date parsedUtilDate = formater.parse(passedDate);
		return new java.sql.Date(parsedUtilDate.getTime());

	}

	public static String getORADateToStrwithFormat(Date theDate) {
		if (theDate == null) {
			return "";
		}
		return getDateFormatYyyyMmDd3().format(theDate);
	}

	public String getsqlTimestampToString(Timestamp sqlDate) {
		DateFormat sdfFormat = getDateTimeFormatUs3();
		sdfFormat.setLenient(false);
		Calendar cal = Calendar.getInstance();
		cal.setTime(sqlDate);
		String finalDate = sdfFormat.format(cal.getTime());
		return finalDate;
	}

	public static String getCurrentTimeStamp() {
		final Calendar cal = Calendar.getInstance();
		final DateFormat sdf = getDateTimeFormatUs5();
		return sdf.format(cal.getTime());
	}

	public static String extendDateFromGivenDate(Date startDate, int numberOfDays) throws ParseException {
		DateFormat format = getOutDateFormatUs();
		Calendar c1 = Calendar.getInstance();
		c1.setTime(startDate);
		c1.add(Calendar.DATE, numberOfDays);
		return format.format(c1.getTime());
	}

	public static Timestamp extendDateinTimeStamp(Date startDate, int numberOfDays) throws ParseException {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(startDate);
		c1.add(Calendar.DATE, numberOfDays);
		Timestamp tstamp = new Timestamp(c1.getTimeInMillis());
		return tstamp;

	}

	public static void calculateNextWorkingDate(Calendar cal, List<String> holidays, int days) {

		Calendar startDate = cal;
		List<String> holidaysDays = new ArrayList<String>();
		DateFormat sdf = getOutDateFormatUs();
		String currDate = sdf.format(startDate.getTime());
		int totHolidays = holidays.size();
		if (holidays != null) {
			for (int j = 0; j < totHolidays; j++) {
				holidaysDays.add(sdf.format(holidays.get(j)));
			}

		}
		if (startDate.get(Calendar.DAY_OF_WEEK) == 1 || (holidays != null && holidaysDays.contains(currDate))) {
			startDate.add(Calendar.DATE, 1);
		} else if (startDate.get(Calendar.DAY_OF_WEEK) == 7) {
			startDate.add(Calendar.DATE, 2);
		}

		for (int i = days; i > 0;) {
			if (!(startDate.get(Calendar.DAY_OF_WEEK) == 1 || startDate.get(Calendar.DAY_OF_WEEK) == 7)) {
				currDate = sdf.format(startDate.getTime());
				if (!(holidays != null && holidaysDays.contains(currDate))) {
					i--;
				}
			}
			if (i > 0) {
				startDate.add(Calendar.DATE, 1);
			}
		}
	}

	/**
	 * <p>
	 * String representation of a calendar. Format: MM/DD/YYYY
	 * </p>
	 * 
	 * @param pCalendar
	 *            Calendar
	 * 
	 * @return String
	 */
	public static String getDisplayDate(Calendar pCalendar) {
		DateFormat format = getOutDateFormatUs();
		if (pCalendar != null) {
			return format.format(pCalendar.getTime());
		} else {
			return "";
		}
	}

	/**
	 * <p>
	 * Convert string representation of a date to calendar.
	 * </p>
	 * 
	 * @param str
	 *            String
	 * 
	 * @return Calendar
	 */
	public static Calendar str2Calendar(String str) {
		Calendar cal = null;
		if (!Utils.isEmpty(str)) {
			try {
				DateFormat sdf = getOutDateFormatUs();
				java.util.Date d = sdf.parse(str);
				cal = Calendar.getInstance();
				cal.setTime(d);
			} catch (ParseException e) {
			}
		}
		return cal;
	}
	
	// From Utils
	
	// D A T E M A N I P U L A T I O N

	public static java.sql.Date toSQLDate(java.util.Date inDate) {
		java.sql.Date outDate = null;
		if (inDate != null) {
			outDate = new java.sql.Date(inDate.getTime());
		}
		return outDate;
	}
	
	public static Date getDateFromMmDString(String dateStr) {
		DateFormat format = getDateFormatMmD();

		try {
			return format.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public static Date getDateFromLastUpdatedDate(String dateStr) {
		DateFormat format = getDateTimeFormatUs4();

		try {
			return format.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public static Date getDateFromString(String dateStr) {
		DateFormat format = getOutDateFormatUs();

		try {
			return format.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * <p>
	 * String representation of a date. Format: MM/DD/YYYY
	 * </p>
	 * 
	 * @param date
	 *            Date
	 * 
	 * @return String
	 */
	public static String getDisplayDate(Date date) {
		DateFormat format = getOutDateFormatUs();
		if (date != null) {
			return format.format(date.getTime());
		} else {
			return "";
		}
	}

	public static String getDateTimeWithTZone(Date dt) {
		DateFormat format = getDateTimeFormatYyyyMmDdHhMmSsSssZ();
		return format.format(dt);
	}

	public static String getCurrentDateAndTimeFormat() {
		Date dt = new Date();
		DateFormat format = getDateTimeFormatYyyyMmDdHhMmSs2();
		return format.format(dt);
	}

	public static String getCurrentDateAndTimeFormat1() {
		Date dt = Calendar.getInstance().getTime();
		DateFormat format = getDateTimeFormatYyyyMmDdHhMmSsSss();
		return format.format(dt);
	}

	public static String getCurrentTimeInMmmD() {
		Date dt = Calendar.getInstance().getTime();
		DateFormat format = getDateFormatMmmD();
		return format.format(dt);
	}

	public static String getMmD(Date dt) {
		DateFormat format = getDateFormatMmD();
		return format.format(dt);
	}

	public static String getColorCode(Timestamp time) {
		String colorCode = "<img src='./images/bar_red.gif' border='0' />";

		if (time == null) {
			return colorCode;
		}
		try {
			long currentTimeInLong = System.currentTimeMillis();
			long timeInLong = time.getTime();
			if (timeInLong < (currentTimeInLong - 2 * 24 * 60 * 60 * 1000)) {
				// colorCode = "#FFFF00";
				colorCode = "<img src='./images/bar_yellow.gif' border='0' />";
			} else {
				// colorCode = "#00FF00";
				colorCode = "<img src='./images/bar_green.gif' border='0' />";
			}

		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
		}
		return colorCode;
	}
	
	private static final class ThreadLocalDF extends ThreadLocal<DateFormat> {
		
		private String dateFormatStr;
		
		private ThreadLocalDF(String dateFormatStr) {
			this.dateFormatStr = dateFormatStr;
		}
		
		@Override
		protected DateFormat initialValue() {
			return new SimpleDateFormat(dateFormatStr);
		}
		
	}
	
	public static boolean checkDateExpiry(String dueDate) {
		boolean dateExpired = false;
    	try{
    
    		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        	Date date1 = sdf.parse(dueDate);
        	Date date = new Date();
        	System.out.println(sdf.format(date));
        	Date date2 = sdf.parse(sdf.format(date));
 
        	if(date1.compareTo(date2)>0){
        		return dateExpired;
        	}else if(date1.compareTo(date2)<0){
        		dateExpired = true;
        		return dateExpired;
        	}else if(date1.compareTo(date2)==0){
        		return dateExpired;
        	}
 
    	}catch(ParseException ex){
    		ex.printStackTrace();
    		return dateExpired;
    	}
    	
    	return dateExpired;
	}
	
	public static String dateFormatter(String oldDate, String OLD_FORMAT) throws ParseException {
		
		final String NEW_FORMAT = "MM/dd/yyyy";
		String newDateString;

		SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
		Date d = sdf.parse(oldDate);
		sdf.applyPattern(NEW_FORMAT);
		newDateString = sdf.format(d);
		
		return newDateString;
	}
	
	public static String convertDateToUSFormat(String dateStr){
		
		SimpleDateFormat formatter = new SimpleDateFormat(DATE_TIME_FORMAT_STR_YYYY_MM_DD_HH_MM_SS_2);
		String commentDateStr = "";
		try {
			Date date = formatter.parse(dateStr);
			DateFormat uSDateFormat = DateConversion.getDateTimeFormatMmDdYyyyHhMmSs2();
			commentDateStr = uSDateFormat.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return commentDateStr;
	}

}
