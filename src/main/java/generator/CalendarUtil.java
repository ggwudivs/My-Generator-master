package generator;


import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by hou on 23/01/2016.
 */
public final class CalendarUtil {

    // 一天的时间
    public static final Integer ONE_DAY_TIME = 86400;
    // 一小时的时间
    public static final Integer ONE_HOUR_TIME = 3600;

    /**
     * 获取 当前日期"年月日"的秒数
     *
     * @return
     */
    public static Long getCurrYMDSeconds() {
        String currTime = dateToStr(new Date(), TimeFormat.yyyy_MM_dd);
        Date currDate = strToDate(currTime, TimeFormat.yyyy_MM_dd);
        return currDate.getTime() / 1000;
    }

    /**
     * 获取 当前日期"年月日时分秒"的秒数
     *
     * @return
     */
    public static Long getCurrSeconds() {
        return System.currentTimeMillis() / 1000;
    }

    /**
     * 获取当前日期毫秒数
     *
     * @return
     */
    public static Long getCurrMillis() {
        return System.currentTimeMillis();
    }

    /**
     * 计算两个日期之间相差的天数(如果两个日期是一天则返回0)
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static int getDaysBetween(Date startDate, Date endDate) {
        if (startDate == null || endDate == null) {
            return -1;
        } else if (startDate.equals(endDate)) {
            return 0;
        }
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();

        start.setTime(startDate);
        end.setTime(endDate);

        //设置时间为0时
        start.set(Calendar.HOUR_OF_DAY, 0);
        start.set(Calendar.MINUTE, 0);
        start.set(Calendar.SECOND, 0);
        end.set(Calendar.HOUR_OF_DAY, 0);
        end.set(Calendar.MINUTE, 0);
        end.set(Calendar.SECOND, 0);
        //得到两个日期相差的天数

        int days = ((int) (end.getTime().getTime() / 1000) - (int) (start.getTime().getTime() / 1000)) / 3600 / 24;
        return days;
    }

    /**
     * 获取两个日期之间相差的秒数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static int getSecondsBetween(Date startDate, Date endDate) {
        if (startDate == null || endDate == null) {
            return -1;
        } else if (startDate.equals(endDate)) {
            return 0;
        }
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();

        start.setTime(startDate);
        end.setTime(endDate);

        //设置时间为0时
        start.set(Calendar.HOUR_OF_DAY, 0);
        start.set(Calendar.MINUTE, 0);
        start.set(Calendar.SECOND, 0);
        end.set(Calendar.HOUR_OF_DAY, 0);
        end.set(Calendar.MINUTE, 0);
        end.set(Calendar.SECOND, 0);
        //得到两个日期相差的秒数

        int seconds = ((int) (end.getTime().getTime() / 1000) - (int) (start.getTime().getTime() / 1000) / 3600);
        return seconds;
    }

    /**
     * 获取两个日期之间相差的分数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static int getMinuteBetween(Date startDate, Date endDate) {
        if (startDate == null || endDate == null) {
            return -1;
        } else if (startDate.equals(endDate)) {
            return 0;
        }
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();

        start.setTime(startDate);
        end.setTime(endDate);

        //设置时间为0时
        start.set(Calendar.HOUR_OF_DAY, 0);
        start.set(Calendar.MINUTE, 0);
        start.set(Calendar.SECOND, 0);
        end.set(Calendar.HOUR_OF_DAY, 0);
        end.set(Calendar.MINUTE, 0);
        end.set(Calendar.SECOND, 0);
        //得到两个日期相差的分数

        int minute = ((int) (endDate.getTime() / 1000) - (int) (startDate.getTime() / 1000)) / 60;
        return minute;
    }

    /**
     * 返回某个日期属于一个星期的周几(起始天是周日)
     * 1-周一
     * 2-周二
     * 3-周三
     * 4-周四
     * 5-周五
     * 6-周六
     * 7-周日
     *
     * @param date
     * @return
     */
    public static int getDayOfWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setFirstDayOfWeek(Calendar.SUNDAY);
        c.setTime(date);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        return dayOfWeek == 0 ? 7 : dayOfWeek;
    }

    /**
     * @return 周一、周二、周三、周四、周五、周六、周日
     */
    public static String getDayOfCHINESEWeek(Date date) {
        int week = getDayOfWeek(date);

        switch (week) {
            case 1:
                return "周一";
            case 2:
                return "周二";
            case 3:
                return "周三";
            case 4:
                return "周四";
            case 5:
                return "周五";
            case 6:
                return "周六";
            case 7:
                return "周日";
        }

        throw new RuntimeException("参数错误");
    }

    /**
     * 把一个字符串转换为日期,字符串的格式规定为:年-月-日
     *
     * @param dateStr
     * @return
     */
    public static Date fromSimpleDateStr(String dateStr) {
        Date d = null;
        try {
            d = getSimpleFormat().parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;
    }

    /**
     * 获取简单时间格式(年-月-日)
     *
     * @return
     */
    private static DateFormat getSimpleFormat() {
        return getFormat(TimeFormat.yyyy_MM_dd.getTimeFormat());
    }

    private static DateFormat getFormat(String format) {
        return new SimpleDateFormat(format);
    }

    /**
     * 获取当前时间的mysql标准datetime格式字符串
     *
     * @return
     */
    public static String toMySqlDateStrOfNow() {
        return toMySqlDateStr(new Date());
    }

    /**
     * 把一个日期格式化成mysql日期,格式为: yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static String toMySqlDateStr(Date date) {
        return getMySqlDateFormat().format(date);
    }

    /**
     * 获取标准日期格式(年-月-日 时:分:秒): yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    private static DateFormat getMySqlDateFormat() {
        return getFormat(TimeFormat.yyyy_MM_dd__HH_mm_ss.getTimeFormat());
    }

    /**
     * 把一个日期转换成字符串,格式为: yyyy-MM-dd
     *
     * @param date
     * @return
     */
    public static String toSimpleDateStr(Date date) {
        return getSimpleFormat().format(date);
    }

    /**
     * 根据给定格式,把日期转换成字符串
     *
     * @param date
     * @param format
     * @return
     */
    public static String dateToStr(Date date, TimeFormat format) {
        return getFormat(format.toString()).format(date);
    }

    /**
     * 根据给定格式,把时间戳转换成字符串
     *
     * @param time
     * @param format
     * @return
     */
    public static String timeToStr(Long time, TimeFormat format) {
        return getFormat(format.toString()).format(timeToDate(time));
    }

    /**
     * 把时间戳转换成字符串（2019年09月26日 18:01:36）
     *
     * @param time
     * @return
     */
    public static String timeToStrWithTemplate(Long time) {
        return time == null ? "-" : getFormat(TimeFormat.yyyy_year_MM_month_dd_day_HH_hour_mm_min_ss_sec.toString()).format(timeToDate(time));
    }

    /**
     * 时间戳转换成日期
     *
     * @param time
     * @return
     */
    public static Date timeToDate(Long time) {
        return new Date(time * 1000);
    }

    /**
     * 根据给定格式,把字符串转换为日期
     *
     * @param dateStr
     * @param format
     * @return
     */
    public static Date strToDate(String dateStr, TimeFormat format) {
        Date d = null;
        try {
            d = getFormat(format.toString()).parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;
    }

    /**
     * @param dataStr
     * @return
     */
    public static String getTimeDesc(String dataStr) {
        Date tobeTran = CalendarUtil.strToDate(dataStr, TimeFormat.yyyy_MM_dd__HH_mm_ss);

        //得到两个日期相差的秒数

        int seconds = ((int) (new Date().getTime() / 1000) - (int) (tobeTran.getTime() / 1000));
        String timeStr = "";
        if (seconds < 60) {
            timeStr = "just now";
        } else if (seconds < 60 * 60) {
            int min = seconds / 60;
            timeStr = min + "minute(s) ago";
        } else if (seconds < 60 * 60 * 24) {
            int hour = seconds / (60 * 60);
            timeStr = hour + "hour(s) ago";
        } else if (seconds < 60 * 60 * 24 * 7) {
            int day = seconds / (60 * 60 * 24);
            if (day <= 1) {
                timeStr = "yesterday";
            } else {
                timeStr = day + "days ago";
            }
        } else if (seconds < 60 * 60 * 24 * 31) {
            int weekend = seconds / (60 * 60 * 24 * 7);
            timeStr = weekend + "week(s) ago";
        } else {
            timeStr = CalendarUtil.toSimpleDateStr(tobeTran);
        }
        return timeStr;
    }

    /**
     * 调整时间,返回调整结果
     *
     * @param time
     * @param field
     * @param offset
     * @return
     */
    public static String getTimeOffset(String time, Field field, int offset) {
        if (StringUtils.isEmpty(time)) {
            return null;
        } else if (time.matches("^\\d{4}-\\d{2}-\\d{2}\\s{1}\\d{2}:\\d{2}:\\d{2}$") == false) {
            return null;
        } else {
            Date d = null;
            try {
                d = fromMySqlFormat(time);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            d = getTimeOffset(d, field, offset);
            return toMySqlDateStr(d);
        }
    }

    /**
     * 调整时间,返回调整结果
     *
     * @param field
     * @param offset
     * @return
     */
    public static String getTimeStr(Field field, int offset) {
        Date d = getTimeOffset(new Date(), field, offset);
        return toMySqlDateStr(d);
    }

    public static Date getTimeOffset(Date d, Field field, int offset) {
        if (Field.valueOf(field.getValue()) == null) {
            return d;// 为空,不操作
        }
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(field.getValue(), offset);
        return c.getTime();
    }

    public static Date getTimeOffset(Field field, int offset) {
        return getTimeOffset(new Date(), field, offset);
    }

    /**
     * 从一个mysql字符串格式化成日期
     *
     * @param dateStr
     * @return
     */
    public static Date fromMySqlFormat(String dateStr) {
        Date d = null;
        try {
            d = getMySqlDateFormat().parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;
    }

    public static int getYear(Date d) {
        if (d == null) {
            return -1;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        return c.get(Calendar.YEAR);
    }

    public static int getMonth(Date d) {
        if (d == null) {
            return -1;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        return c.get(Calendar.MONTH) + 1;
    }

    public static int getDayOfMonth(Date d) {
        if (d == null) {
            return -1;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        return c.get(Calendar.DAY_OF_MONTH);
    }

    public static int getHourOfDay(Date d) {
        if (d == null) {
            return -1;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        return c.get(Calendar.HOUR_OF_DAY);
    }

    public static int getMinute(Date d) {
        if (d == null) {
            return -1;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        return c.get(Calendar.MINUTE);
    }

    public static int getSecond(Date d) {
        if (d == null) {
            return -1;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        return c.get(Calendar.SECOND);
    }

    public static int getMilliSecond(Date d) {
        if (d == null) {
            return -1;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        return c.get(Calendar.MILLISECOND);
    }


    public static String simplified(String dateStr) {
        if (StringUtils.isEmpty(dateStr)) return "";
        return dateStr.trim().replaceAll("-", "").replaceAll(" ", "").replaceAll(":", "");
    }

    /**
     * 将一个字符串
     *
     * @param dateStr
     * @param fromFormat
     * @param toFormat
     * @return
     */
    public static String formatDateStr(String dateStr, TimeFormat fromFormat, TimeFormat toFormat) {
        Date d = strToDate(dateStr, fromFormat);
        return dateToStr(d, toFormat);
    }

    public enum TimeFormat {
        HH_mm_ss("HH:mm:ss"),
        HH_mm("HH:mm"),
        mm_ss("mm:ss"),
        HHmmss("HHmmss"),
        HHmm("HHmm"),
        HH("HH"),
        mmss("mmss"),
        mm("mm"),
        ss("ss"),
        yyyy_year_MM_month_dd_day_HH_hour_mm_min_ss_sec("yyyy年MM月dd日 HH:mm:ss"),
        yyyy_MM_dd__HH_mm_ss("yyyy-MM-dd HH:mm:ss"),
        yyyy_MM_dd__HH_mm("yyyy-MM-dd HH:mm"),
        yyyy_MM_dd__HH("yyyy-MM-dd HH"),
        yyyyMMddHHmmss("yyyyMMddHHmmss"),
        yyyyMMddHHmm("yyyyMMddHHmm"),
        yyyyMMddHH("yyyyMMddHH"),
        yyyyMMdd("yyyyMMdd"),
        yyyy_MM_dd("yyyy-MM-dd"),
        yyyy_MM("yyyy-MM"),
        yyyy_M_d("yyyy-M-d"),
        yyyyMM("yyyyMM"),
        yyyy_slash_MM_slash_dd("yyyy/MM/dd"),
        yyyy_slash_MM("yyyy/MM"),
        yyyy("yyyy"),
        MM("MM"),
        dd("dd");

        private String format;

        TimeFormat(String format) {
            this.format = format;
        }

        public static TimeFormat forFormat(String format) {
            for (TimeFormat c : values()) {
                if (c.toString().equals(format)) {
                    return c;
                }
            }
            return null;
        }

        public String toString() {
            return this.format;
        }

        public String getTimeFormat() {
            return this.format;
        }
    }

    /**
     * 内部的枚举类型
     */
    public enum Field {
        SECONDS(Calendar.SECOND, "seconds"),// 秒
        MINUTE(Calendar.MINUTE, "minute"),// 分
        HOUR(Calendar.HOUR_OF_DAY, "hour"),// 时
        DAY(Calendar.DAY_OF_MONTH, "day"),// 天
        WEEK(Calendar.WEEK_OF_YEAR, "week_of_year"),// 周
        MONTH(Calendar.MONTH, "month"),// 月
        YEAR(Calendar.YEAR, "year");// 年

        private int value;
        private String description;

        Field(int value, String content) {
            this.value = value;
            this.description = content;
        }

        public static Field valueOf(int field) {
            for (Field f : Field.values()) {
                if (f.getValue() == field) {
                    return f;
                }
            }
            return null;
        }

        public int getValue() {
            return this.value;
        }

        public String getDescription() {
            return this.description;
        }

        public Field setType(int value) {
            this.value = value;
            return this;
        }
    }

    /**
     * 获取当前时间的整点小时时间
     *
     * @return
     */
    public static Long getCurrHourTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime().getTime() / 1000;
    }

    /**
     * 获取精确到秒的时间戳
     *
     * @return
     */
    public static long getSecondTimestamp(Date date) {
        if (null == date) {
            return 0;
        }
        String timestamp = String.valueOf(date.getTime());
        int length = timestamp.length();
        if (length > 3) {
            return Long.valueOf(timestamp.substring(0, length - 3));
        } else {
            return 0;
        }
    }

    /**
     * 获取某个时间戳下的起始时间
     *
     * @param time
     * @return
     */
    public static long getStartOfTime(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(time * 1000));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime().getTime() / 1000;
    }

    /**
     * 获取某个时间戳下的结束时间
     *
     * @param time
     * @return
     */
    public static long getEndOfTime(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(time * 1000));
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, -1);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime().getTime() / 1000;
    }

    /**
     * 获取今天第一秒
     */
    public static long getDayStartTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime().getTime() / 1000;
    }

    /**
     * 获取*天的第一秒
     * -1 昨天 0 今天 1 明天
     */
    public static long getDayStartTime(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DATE, day);
        return calendar.getTime().getTime() / 1000;
    }


    /**
     * 获取今天最后一秒
     */
    public static long getDayEndTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.SECOND, -1);
        return calendar.getTime().getTime() / 1000;
    }

    // 获取某个日期的开始时间
    public static Timestamp getDayStartTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if (null != d)
            calendar.setTime(d);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }

    // 获取某个日期的结束时间
    public static Timestamp getDayEndTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if (null != d)
            calendar.setTime(d);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return new Timestamp(calendar.getTimeInMillis());
    }

    // 获取本周的开始日期
    public static Date getBeginDayOfWeek() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayofweek == 1) {
            dayofweek += 7;
        }
        cal.add(Calendar.DATE, 2 - dayofweek);
        return getDayStartTime(cal.getTime());
    }

    // 获取本周的结束日期
    public static Date getEndDayOfWeek() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getBeginDayOfWeek());
        cal.add(Calendar.DAY_OF_WEEK, 6);
        Date weekEndSta = cal.getTime();
        return getDayEndTime(weekEndSta);
    }

    // 获取本周的开始时间戳
    public static long getBeginTimeOfWeek() {
        return getSecondTimestamp(getBeginDayOfWeek());
    }

    /**
     * 获取本周第一天
     */
    public static long getBeginTimeOfWeek_New() {
        Calendar cal = Calendar.getInstance();

        if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
            //周日需要扣除一天
            cal.add(Calendar.DATE, -1);
        }
        cal.set(Calendar.DAY_OF_WEEK, 2);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);

        return cal.getTimeInMillis() / 1000;
    }


    /**
     * 获取本周最后一天
     */
    public static long getEndTimeOfWeek_New() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(getBeginTimeOfWeek_New() * 1000);
        //周日需要扣除一天
        cal.add(Calendar.DATE, 7);
        cal.add(Calendar.SECOND, -1);

        return cal.getTimeInMillis() / 1000;
    }


    // 获取本周的结束时间戳
    public static long getEndTimeOfWeek() {
        return getSecondTimestamp(getEndDayOfWeek());
    }

    /**
     * 获取本月第一秒
     */
    public static long getMonthStartTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime().getTime() / 1000;
    }

    /**
     * 获取本月最后一秒
     */
    public static long getMonthEndTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, -1);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime().getTime() / 1000;
    }

    /**
     * 获取上个月的第一秒
     */
    public static long getFrontMonthStartTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime().getTime() / 1000;
    }

    /**
     * 获取上个月的最后一秒
     */
    public static long getFrontMonthEndTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, -1);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime().getTime() / 1000;
    }

    /**
     * 获取某个月份的起始时间戳
     */
    public static long getStartOfMonth(int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime().getTime() / 1000;
    }


    /**
     * 获取某个月份的结束时间戳
     *
     * @param month
     * @return
     */
    public static long getEndOfMonth(int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, -1);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime().getTime() / 1000;
    }

    /**
     * 获取当前时间的前x 天
     */
    public static long getBeforeDay(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, -day);
        return calendar.getTimeInMillis() / 1000;
    }

    /**
     * 获取当前时间的前x 周
     */
    public static long getBeforeWeek(int week) {
        return getBeforeDay(week * 7);
    }

    /**
     * 获取当前时间的前x 月
     */
    public static long getBeforeMonth(int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -month);
        return calendar.getTimeInMillis() / 1000;
    }

    /**
     * 获取X个月前的时间戳
     *
     * @param x 0.本月，1.去月，2.前月，...
     * @return
     */
    public static long getXMonthAgoTime(int x) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -x);
        return calendar.getTime().getTime() / 1000;
    }

    /**
     * 时间戳转日期字符串
     */
    public static String timeToStr(long time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date(time * 1000);
        return simpleDateFormat.format(date);
    }

    /**
     * 获取时间段内的每一天
     */
    public static List<String> findDaysStr(String beginTime, String endTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date dBegin = null;
        Date dEnd = null;

        try {
            dBegin = sdf.parse(beginTime);
            dEnd = sdf.parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<String> daysStrList = new ArrayList<String>();
        daysStrList.add(sdf.format(dBegin));

        Calendar calBegin = Calendar.getInstance();
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(dEnd);

        while (dEnd.after(calBegin.getTime())) {
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            String dayStr = sdf.format(calBegin.getTime());
            daysStrList.add(dayStr);
        }

        return daysStrList;
    }

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        calendar.set(2019, 11-1, 25, 16, 45, 0);
        System.out.println(calendar.getTimeInMillis() / 1000);
    }

}
