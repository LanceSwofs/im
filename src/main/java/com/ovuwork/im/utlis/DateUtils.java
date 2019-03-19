package com.ovuwork.im.utlis;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    final static public String CREATE_NO = "yyyyMMddHHmmss";

    final static public String CREATE_NO_17 = "yyyyMMddhhmmssSSS";

    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM", "yyyy-MM-dd HH:mm:ss.SSS",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM", "yyyy/MM/dd HH:mm:ss.SSS",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM", "yyyy.MM.dd HH:mm:ss.SSS",
            CREATE_NO, CREATE_NO_17};

    public static final int SECOND = 1000;
    public static final int MINUTE = SECOND * 60;
    public static final int HOUR = MINUTE * 60;
    public static final long DAY = HOUR * 24;
    public static final long WEEK = DAY * 7;
    public static final long YEAR = DAY * 356;

    final static public String FULL_MS_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
    final static public String FULL_ST_FORMAT = "yyyy-MM-dd HH:mm:ss";
    final static public String FULL_J_FORMAT = "yyyy/MM/dd HH:mm:ss";
    final static public String CURRENCY_ST_FORMAT = "yyyy-MM-dd HH:mm";
    final static public String CURRENCY_J_FORMAT = "yyyy/MM/dd HH:mm";
    final static public String DATA_FORMAT = "yyyyMMddHHmmss";
    final static public String ST_FORMAT = "yyyy-MM-dd HH:mm";
    final static public String ST_CN_FORMAT = "yyyy年MM月dd日 HH:mm";
    final static public String CN_FORMAT = "yy年MM月dd日HH:mm";
    final static public String DAY_FORMAT = "yyyy-MM-dd";
    final static public String SHORT_DATE_FORMAT = "yy-MM-dd";
    final static public String YEAR_FORMAT = "yyyy";
    final static public String YEAR_MONTH = "yyyy-MM";
    final static public String MONTH_FORMAT = "MM";
    final static public String TODAYNO_FORMAT = "dd";

    public static String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DAY_FORMAT);
        return sdf.format(date);
    }

    public static String getDateTimeSequence() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATA_FORMAT);
        return sdf.format(new Date());
    }

    public static String getDate(long second) {
        SimpleDateFormat sdf = new SimpleDateFormat(FULL_ST_FORMAT);
        return sdf.format(new Date(second));
    }


    /**
     * 获取当前时间yyyy-MM-dd HH:mm格式
     *
     * @return
     */
    public static String getDateWidthoutSecs() {
        SimpleDateFormat sdf = new SimpleDateFormat(ST_FORMAT);
        return sdf.format(new Date());
    }

    public static String getToday() {
        SimpleDateFormat sdf = new SimpleDateFormat(DAY_FORMAT);
        return sdf.format(new Date());
    }

    public static String getYesterday() {
        SimpleDateFormat sdf = new SimpleDateFormat(DAY_FORMAT);
        return sdf.format(addDays(new Date(),-1));
    }

    public static String getNow() {
        SimpleDateFormat sdf = new SimpleDateFormat(FULL_ST_FORMAT);
        return sdf.format(new Date());
    }

    public static String getShortDate() {
        SimpleDateFormat sdf = new SimpleDateFormat(SHORT_DATE_FORMAT);
        return sdf.format(new Date());
    }

    public static String getYearMonth() {
        SimpleDateFormat sdf = new SimpleDateFormat(YEAR_MONTH);
        return sdf.format(new Date());
    }

    public static String getTodayNo() {
        SimpleDateFormat sdf = new SimpleDateFormat(TODAYNO_FORMAT);
        String today = sdf.format(new Date());
        if (today.startsWith("0")) {
            today = today.substring(1);
        }
        return today;
    }

    public static String getMillisecond() {
        return "" + new Date().getTime();
    }

    public static long getQuot(String time1, String time2)
            throws ParseException {
        long quot = 0;
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date1 = ft.parse(time1);
            Date date2 = ft.parse(time2);
            quot = date1.getTime() - date2.getTime();
            quot = quot / 1000 / 60 / 60 / 24;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return quot;
    }

    public static String getTimeByMinute(int minute) {

        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.MINUTE, minute);

        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(calendar.getTime());

    }

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd）
     */
    public static String getDate() {
        return getDate("yyyy-MM-dd");
    }

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd）
     */
    public static String getDate(Date date) {
        return getDate(date, "yyyy-MM-dd");
    }

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String getDate(String pattern) {
        return DateFormatUtils.format(new Date(), pattern);
    }

    public static String getDate(Date date, String pattern) {
        return DateFormatUtils.format(date, pattern);
    }

    /**
     * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String formatDate(Date date, Object... pattern) {
        String formatDate = null;
        if (pattern != null && pattern.length > 0) {
            formatDate = DateFormatUtils.format(date, pattern[0].toString());
        } else {
            formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
        }
        return formatDate;
    }

    /**
     * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String formatDateTime(Date date) {
        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss.SSS）
     */
    public static String formatDateTime2MS(Date date) {
        return formatDate(date, FULL_MS_FORMAT);
    }

    /**
     * 得到当前时间字符串 格式（HH:mm:ss）
     */
    public static String getTime() {
        return formatDate(new Date(), "HH:mm:ss");
    }

    /**
     * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String getDateTime() {
        return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 得到当前年份字符串 格式（yyyy）
     */
    public static String getYear() {
        return formatDate(new Date(), "yyyy");
    }

    /**
     * 得到当前月份字符串 格式（MM）
     */
    public static String getMonth() {
        return formatDate(new Date(), "MM");
    }

    /**
     * 得到当天字符串 格式（dd）
     */
    public static String getDay() {
        return formatDate(new Date(), "dd");
    }

    /**
     * 得到当前星期字符串 格式（E）星期几
     */
    public static String getWeek() {
        return formatDate(new Date(), "E");
    }

    /**
     * 日期型字符串转化为日期 格式
     * { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
     * "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm",
     * "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
     */
    public static Date parseDate(Object str) {
        if (str == null) {
            return null;
        }
        try {
            return parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取过去的天数
     *
     * @param date
     * @return
     */
    public static long pastDays(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (24 * 60 * 60 * 1000);
    }

    /**
     * 获取过去的小时
     *
     * @param date
     * @return
     */
    public static long pastHour(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (60 * 60 * 1000);
    }

    /**
     * 获取过去的分钟
     *
     * @param date
     * @return
     */
    public static long pastMinutes(Date date) {
        long t = new Date().getTime() - date.getTime();
//		if(t<=0) t= 1;
        return t / (60 * 1000);
    }

    /**
     * 转换为时间（天,时:分:秒.毫秒）
     *
     * @param timeMillis
     * @return
     */
    public static String formatDateTime(long timeMillis) {
        long day = timeMillis / (24 * 60 * 60 * 1000);
        long hour = (timeMillis / (60 * 60 * 1000) - day * 24);
        long min = ((timeMillis / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (timeMillis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        long sss = (timeMillis - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000);
        return (day > 0 ? day + "," : "") + hour + ":" + min + ":" + s + "." + sss;
    }

    /**
     * 获取两个日期之间的天数
     *
     * @param before
     * @param after
     * @return
     */
    public static double getDistanceOfTwoDate(Date before, Date after) {
        long beforeTime = before.getTime();
        long afterTime = after.getTime();
        return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
    }

    /**
     * 获取两个日期之间的天数+1
     *
     * @author MrZhu 20160524 20:10
     */
    public static double getDistanceOfTwoDate_V101(Date before, Date after) {
        long beforeTime = before.getTime();
        long afterTime = after.getTime();
        return ((afterTime - beforeTime) / (1000 * 60 * 60 * 24)) + 1;
    }


    public static String getDateStr(String dateFormat, Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(date);
    }


    /**
     * 获取当前时间之前多少天或者之后多少天的日期
     *
     * @param days    把日期往后增加一天.整数往后推,负数往前移动
     * @param pattern 时间格式
     * @return
     */
    public static String getAfterOrBeforeToday(String current_date, int days, String pattern) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            Date date = sdf.parse(current_date);
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            calendar.add(calendar.DATE, days);//把日期往后增加一天.整数往后推,负数往前移动
            date = calendar.getTime();   //这个时间就是日期往后推一天的结果
            String ret = new SimpleDateFormat(pattern).format(date);
            return ret;
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("=====获取时间出错========");
            return null;
        }

    }

    public static int comparedTwoDate(String beginTime, String endTime) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt1 = df.parse(beginTime);
            Date dt2 = df.parse(endTime);
            if (dt1.getTime() > dt2.getTime()) {
                System.out.println("dt1 在dt2后");
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                System.out.println("dt1在dt2前");
                return -1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * comparedTwoFullDate类型时间比较
     *
     * @param beginTime
     * @param endTime
     * @return
     * @throws ParseException
     */
    public static int comparedTwoFullDate(String beginTime, String endTime) {
        //DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date dt1 = df.parse(beginTime);
            Date dt2 = df.parse(endTime);
            if (dt1.getTime() > dt2.getTime()) {
                System.out.println("dt1 在dt2后");
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                System.out.println("dt1在dt2前");
                return -1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }


    /**
     * comparedTwoFullDate类型时间比较
     *
     * @param beginTime
     * @param endTime
     * @return
     * @throws ParseException
     */
    public static int comparedTwoShortDateFullDate(String beginTime, String endTime) {
        //DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt1 = df.parse(beginTime);
            Date dt2 = df.parse(endTime);
            if (dt1.getTime() > dt2.getTime()) {
                System.out.println("dt1 在dt2后");
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                System.out.println("dt1在dt2前");
                return -1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    
    /**
     * 判断 时间 串与当前时间 是否在70秒内
     *
     * @param time 6位时间串 111214
     * @return
     */
    public static boolean between(String time) {
        //01095253
        System.out.println(time.substring(0, 2) + ":" + time.substring(2, 4) + ":" + time.substring(4, 6) + ":" + time.substring(6, 8));

			/*  Calendar cal=Calendar.getInstance();
			//Date nowDate=new Date(cal.getTimeInMillis());
			   cal.set(Integer.valueOf(DateUtils.getYear()),
					   Integer.valueOf(DateUtils.getMonth()),
					   cal.get(Integer.parseInt(time.substring(0, 2))),
				//Integer.valueOf(time.substring(0, 2)), 
				Integer.valueOf(time.substring(2, 4)),
				Integer.valueOf(time.substring(4,6)),
			    Integer.valueOf(time.substring(6,8)));*/
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());

        cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(time.substring(0, 2)));
        cal.set(Calendar.HOUR_OF_DAY, Integer.valueOf(time.substring(2, 4)));
        cal.set(Calendar.MINUTE, Integer.valueOf(time.substring(4, 6)));
        cal.set(Calendar.SECOND, Integer.valueOf(time.substring(6, 8)));

        System.out.println(cal.getTime());

        System.out.println((System.currentTimeMillis() - cal.getTimeInMillis()) / 1000);

        long between = (System.currentTimeMillis() - cal.getTimeInMillis()) / 1000;

        System.out.println(between);
			   /*Date last=new Date(cal.getTimeInMillis());
			   double between=(cal.getTime()-last.getTime())/1000;*/
        //System.out.println("间隔时间是："+between);
        return between < 70;
    }

    public static String createOrderNo(int randnum) {
        return createNoByNow() + RandomStringUtils.randomNumeric(randnum);
    }

    public static String createNoByNow() {
        SimpleDateFormat sdf = new SimpleDateFormat(CREATE_NO);
        String No = sdf.format(new Date());
        return No;
    }

    public static String createNoByNow_17() {
        SimpleDateFormat sdf = new SimpleDateFormat(CREATE_NO_17);
        String No = sdf.format(new Date());
        return No;
    }

    public static String createOrderNo1(int randnum) {
        return createNoByNow_17() + RandomStringUtils.randomNumeric(randnum);
    }


    /**
     * 计算两个时间 之间的差值
     * 返回 毫秒数
     *
     * @param start
     * @param end
     * @return
     */
    public static int getMilliSecondsOfTwoDate(Date start, Date end) {

        return (int) (end.getTime() - start.getTime());
    }


    /**
     * 判断时间是否在范围内
     *
     * @param start
     * @param end
     * @param date
     * @return
     */
    public static boolean compareCycleDate(Date start, Date end, Date date) {
        if (date.getTime() >= start.getTime() && date.getTime() <= end.getTime()) {
            return true;
        }
        return false;
    }

    /**
     * 获取某月第一天
     * @return
     */
    public static String getMonthFirstDay(Date date){
        //获取当前月第一天：
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
        String first = formatDate(c.getTime());
        return first;
    }

    public static String getMonthLastDay(Date date){
        //获取当前月最后一天
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        String last = formatDate(c.getTime());
        return last;
    }

    /**
     * 获取某年第一天
     * @return
     */
    public static String getYearFirstDay(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int currentYear = c.get(Calendar.YEAR);
        c.clear();
        c.set(Calendar.YEAR, currentYear);
        String first = formatDate(c.getTime());
        return first;
    }

    /**
     * 获取某年最后一天
     * @return
     */
    public static String getYearLastDay(Date date){
        //获取当前月最后一天
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int currentYear = c.get(Calendar.YEAR);
        c.clear();
        c.set(Calendar.YEAR, currentYear);
        c.roll(Calendar.DAY_OF_YEAR, -1);
        String last = formatDate(c.getTime());
        return last;
    }

    /**
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {
     /*   Date yesterDay = DateUtils.addDays(new Date(),-10);
        System.out.println(getMonthFirstDay(yesterDay));
        System.out.println(getMonthLastDay(yesterDay));*/
    	
    	System.out.println(dayDiff("2019-09-14", "2019-08-15", "yyyy-MM-dd"));
    }


	/**
	 * @descript:计算两个字符串日期相差的天数
	 * @param date1 字符串日期1 end日期
	 * @param date2 字符串日期2  begin 日期
	 * @param format 日期格式化方式  format="yyyy-MM-dd"
	 * @return
	 */
	public static long dayDiff(String date1, String date2,String format) {
		SimpleDateFormat formater = new SimpleDateFormat(format);
		long diff=0l;
		try {
			long d1 = formater.parse(date1).getTime();
			long d2 = formater.parse(date2).getTime();
			//diff=(Math.abs(d1-d2) / (1000 * 60 * 60 * 24));
			diff=(d1-d2)/(1000 * 60 * 60 * 24);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return diff;
	}
    
}
