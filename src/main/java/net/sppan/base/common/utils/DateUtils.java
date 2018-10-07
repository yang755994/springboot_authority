package net.sppan.base.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {

    private static Logger logger = LoggerFactory.getLogger(DateUtils.class);

    public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";

    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    public static final String DEFAULT_DATE_FORMAT_HHMMSS = "yyyy-MM-dd HH:mm:ss";


    /**
     * 获取当前时间日历对象
     *
     * @return 返回java.util.Calendar日期对象
     */
    public static Calendar getCurCalendar() {
        return Calendar.getInstance();
    }

    /**
     * 获取此时当天所剩余的时间
     *
     * @return
     */
    public static int getRemainTime() {
        Calendar calendar = getCurCalendar();
        Calendar nextDayTime = new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE) + 1, 0, 0, 0);
        return (int) (nextDayTime.getTimeInMillis() - calendar.getTimeInMillis()) / 1000;
    }

    public static Integer getTimestamp(Date date) {
        Long currentTimeMillis = date.getTime();
        Long times = (currentTimeMillis / 1000);
        return times.intValue();
    }

    public static long parseDateHourMinuteByTimestamp(Date date) {
        return getTimestamp(date);
    }

    /**
     * 将时间戳转换为datetime yyyy-MM-dd HH:mm:ss
     *
     * @param timestamp
     * @return
     * @datetime 2016年6月17日下午4:41:57
     */
    public static String parseTimestampByDatetime(Integer timestamp) {
        if (timestamp <= 0) {
            return "";
        }
        DateFormat sf = new SimpleDateFormat(DEFAULT_DATE_FORMAT_HHMMSS);
        return sf.format(Long.parseLong(timestamp + "000"));
    }

    /**
     * 获取当前时间戳
     *
     * @return 10位时间戳
     */
    public static Integer getCurrentTimestamp() {
        Long times = (System.currentTimeMillis() / 1000);
        return times.intValue();
    }

    /**
     * 获取当前时间减去几分钟后的时间戳
     *
     * @param minutes
     * @return
     * @datetime 2016年7月4日上午9:34:50
     */
    public static Integer getCurrentTimestampMinusMinutes(int minutes) {
        Date date = new Date();
        date = new Date(date.getTime() - minutes * 60 * 1000);
        return getTimestamp(date);
    }

    /**
     * 得到几天后的时间
     *
     * @param d
     * @param day
     * @return
     */
    public static long getDateAfter(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
        return Long.parseLong(String.valueOf(now.getTime().getTime()).substring(0, 10));
    }

    /**
     * 将时间戳转换为date yyyy-MM-dd
     *
     * @param timestamp
     * @return
     * @throws ParseException
     * @datetime 2016年8月11日下午4:41:57
     */
    public static Date parseTimestampByDate2(long timestamp) {
        if (timestamp <= 0) {
            return null;
        }
        DateFormat sf = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        try {
            return sf.parse(sf.format(Long.parseLong(timestamp + "000")));
        } catch (ParseException e) {
            logger.error("格式化时间异常:" + e.getMessage());
        }
        return new Date();
    }

    public static Integer getSystemCouponEndTime(Date currentTime, long startTime, long endTime) {
        Date date1 = parseTimestampByDate2(endTime);
        Date date2 = parseTimestampByDate2(startTime);
        Long l = date1.getTime() - date2.getTime();
        long day = l / (24 * 60 * 60 * 1000);
        Long endTim = getDateAfter(currentTime, (int) day);
        return endTim.intValue();
    }

    /**
     * 获取当前时间戳
     *
     * @return
     * @datetime
     */
    public static Long getCurrentTimestamp(Date d) {
        String timeStr = String.valueOf(d.getTime());
        return Long.parseLong(timeStr.substring(0, 10));
    }

    /**
     * 获取当前yyyyMMdd时间
     *
     * @return
     */
    public static String getCurrentDateString() {
        Date now = new Date();
        DateFormat sf = new SimpleDateFormat(DATE_FORMAT_YYYYMMDD);
        return sf.format(now);
    }

    /**
     * 获取当天0点的时刻的时间戳: 即每天开始的时间戳
     *
     * @return
     */
    public static Long getStartTimeStamp() {
        Calendar calendar = getCurCalendar();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date start = calendar.getTime();
        return start.getTime() / 1000;
    }

    /**
     * 获取当天23点59分59秒的时刻的时间戳: 即每天结束的时间戳
     *
     * @return
     */
    public static Long getEndTimeStamp() {
        Calendar calendar = getCurCalendar();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.SECOND, -1);
        Date end = calendar.getTime();
        return end.getTime() / 1000;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getCurrentTimestamp());
        System.out.println(parseTimestampByDatetime(getCurrentTimestampMinusMinutes(2)));
        System.out.println(getRemainTime());
        System.out.println(getStartTimeStamp());  // 1496851200  -- 20170608 0点0分0秒
        System.out.println(getEndTimeStamp());    // 1496937599  -- 20170608 23点59分59秒
    }
}
