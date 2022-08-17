package com.shouxin.yy.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @time 2021/8/10 1:50 下午
 * @Author feikong
 */
@Slf4j
public class TimerUtil {
    public static final String pattern = "yyyy-MM-dd";
    public static final String yyyyMMddHHmmss = "yyyyMMddHHmmss";
    public static final String patternAll = "yyyy-MM-dd HH:mm:ss";
    public static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(pattern);

    /**
     * 时间增加小时
     * @param date
     * @param hour
     * @return
     */
    public static Date addDateHours(Date date, int hour) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, hour);
        return cal.getTime();
    }

    /**
     * 时间增加天
     *
     * @param date 日期
     * @param day  一天
     * @return {@code Date}
     */
    public static Date addDateDays(Date date, int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, day);
        return cal.getTime();
    }

    /**
     * 时间增加年
     *
     * @param date 日期
     * @param year  一年
     * @return {@code Date}
     */
    public static Date addDateYears(Date date, int year) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, year);
        return cal.getTime();
    }

    /**
     * 时间增加月
     *
     * @param date 日期
     * @param month  月
     * @return {@code Date}
     */
    public static Date addDateMonths(Date date, int month) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, month);
        return cal.getTime();
    }

    /**
     * 获取指定时间范围的全部日期
     * @param cntDateBeg 开始时间
     * @param cntDateEnd 结束时间
     * @return
     */
    public static List<String> getRangeDays(String cntDateBeg, String cntDateEnd) {
        List<String> list = new ArrayList<>();
        //拆分成数组
        String[] dateBegs = cntDateBeg.split("-");
        String[] dateEnds = cntDateEnd.split("-");
        //开始时间转换成时间戳
        Calendar start = Calendar.getInstance();
        start.set(Integer.parseInt(dateBegs[0]), Integer.parseInt(dateBegs[1]) - 1, Integer.parseInt(dateBegs[2]));
        long startTime = start.getTimeInMillis();
        //结束时间转换成时间戳
        Calendar end = Calendar.getInstance();
        end.set(Integer.parseInt(dateEnds[0]), Integer.parseInt(dateEnds[1]) - 1, Integer.parseInt(dateEnds[2]));
        long endTime = end.getTimeInMillis();
        //定义一个一天的时间戳时长
        long oneDay = 1000 * 60 * 60 * 24L;
        long time = startTime;
        //循环得出
        while (time <= endTime) {
            list.add(new SimpleDateFormat("yyyy-MM-dd").format(new Date(time)));
            time += oneDay;
        }
        return list;
    }

    /**
     * 计算两个字符串时间差
     * @param time1
     * @param time2
     * @return
     */
    public static Long calcStringTimeDiff(String time1, String time2){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        long result = 0;
        try {
            Date date1, date2;
            date1 = simpleDateFormat.parse(time1);
            date2 = simpleDateFormat.parse(time2);
            result = date1.getTime() - date2.getTime();
        } catch (ParseException e) {
            log.error("calc time error: " + e.toString());
        }
        return result;
    }

    /**
     * 获取当前时间的近12个月
     * @return ["2021-07", "2021-06", ...]
     */
    public static String[] rent12Month(long start, long end){
        LocalDate today = LocalDate.now();
        String[] month = new String[12];
        int n = 0;
        for(long i = start; i <= end; i++){
            LocalDate localDate = today.minusMonths(i);
            String ss = localDate.toString().substring(0,7);
            month[n++] = ss;
        }
        return month;
    }

    /**
     * 获取指定时间的近12个月
     * @return ["2021-07", "2021-06", ...]
     */
    public static String[] rent12Month(long start, long end, String time){
        LocalDate today = LocalDate.parse(time);
        String[] month = new String[12];
        int n = 0;
        for(long i = start; i <= end; i++){
            LocalDate localDate = today.minusMonths(i);
            String ss = localDate.toString().substring(0,7);
            month[n++] = ss;
        }
        return month;
    }

    /**
     * 获取指定天数的日期数组
     * @param gap
     * @param endDate
     * @return
     */
    public static String[] getDayList(int gap, String endDate) {
        // 生成年月日的日期序列
        String[] res = new String[gap];
        for (int i = gap - 1; i >= 0; i--) {
            LocalDate newDate = LocalDate.parse(endDate, dateFormat).minusDays(i);
            String dateString = dateFormat.format(newDate);
            res[i] = dateString;
        }
        return res;
    }

    /**
     * 判断平闰年
     * @param year
     * @return
     */
    public static boolean checkRunYear(int year){
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    /**
     * 获取n天前的时间
     * @param date 指定时间
     * @param gap n天
     * @return
     */
    public String getDayTime(String date, int gap){
        LocalDate newDate = LocalDate.parse(date, dateFormat).minusDays(gap);
        return dateFormat.format(newDate);
    }

    /**
     * 获取一年日期列表
     * @param time 2021-09
     * @return
     */
    public static String[] getOneYearAgo(String time){
        String[] times = time.split("-");
        String year = times[0], month = times[1];
        List<String> month31Day = Arrays.asList("01", "03", "05", "07", "08", "10", "12");
        List<String> month30Day = Arrays.asList("04", "06", "09", "11");

        String endDate;
        if(month31Day.contains(month)){
            endDate = time + "-" + "31";
        }else if(month30Day.contains(month)){
            endDate = time + "-" + "30";
        }else{
            String addDay = checkRunYear(Integer.parseInt(year))? "29": "28";
            endDate = time + "-" + addDay;
        }
        return getDayList(365, endDate);
    }

    /**
     * 当前时间yyyy-MM-dd
     * @return
     */
    public static String nowTimeYMD() {
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }

    public static void main(String[] args) {
        String[] months = rent12Month(1L, 12L, "2021-08-12");
        for(int i=0; i<months.length; i++){
            System.out.println(months[i]);
        }

    }

    /**
     * 获取当前时间 格式 yyyy-MM-dd HH:mm:ss
     */
    public static String now(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar startTime = Calendar.getInstance();
        startTime.setTime(new Date());
        return format.format(startTime.getTime());
    }

    /***
     * 日期转corn表达式
     * @param time 日期
     * @return
     */
    public static String getCron(String time){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        Date date;
        String corn = null;
        try {
            date = simpleDateFormat.parse(time);
            String dateFormat="ss mm HH dd MM ? yyyy";
            SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
            if (date != null) {
                corn = sdf.format(date);
            }
            return corn;
        } catch (ParseException e) {
            log.error("calc time error: " + e.toString());
        }
        return null;
    }

    /**
     * 日期转字符串
     */
    public static String dateToString(Date date, String pattern){
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Calendar startTime = Calendar.getInstance();
        startTime.setTime(date);
        return format.format(startTime.getTime());
    }

    /**
     * 指定时间格式转换 oldFormat -> newFormat
     * date 要转换的字符串
     */
    public static String dateFormart(String oldFormat,String newFormat,String date) throws ParseException {
        // string 转 calender
        SimpleDateFormat sdf = new SimpleDateFormat(oldFormat);
        Date changeDate = sdf.parse(date);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(changeDate);

        // calender转string
        SimpleDateFormat sdf2 = new SimpleDateFormat(newFormat);
        return sdf2.format(calendar.getTime());
    }

    /**
     * 字符串转换成日期
     * @param time
     * @return date
     */
    public static Date stringToDate(String time, String pattern) {

        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            log.error("calc time error: " + e.toString());
        }
        return date;
    }

    /**
     * 根据自己需要获取时间具体点的字符串
     *
     * @param date 0当天,-1昨天 1明天
     * @param  hour  指定小时
     * @param  minute  指定分钟
     * @param  second 指定秒
     * @return String
     */
    public static String dateTime(int date, int hour, int minute, int second){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar startTime = Calendar.getInstance();
        startTime.add(Calendar.DATE, date);
        startTime.set(Calendar.HOUR_OF_DAY, hour);
        startTime.set(Calendar.MINUTE, minute);
        startTime.set(Calendar.SECOND, second);
        startTime.set(Calendar.MILLISECOND, 0);
        return format.format(startTime.getTime());
    }

    /**
     * date2比date1多的天数
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDays(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        //同一年
        if(year1 != year2) {
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++)
            {
                //闰年
                if(i%4==0 && i%100!=0 || i%400==0)
                {
                    timeDistance += 366;
                }
                else    //不是闰年
                {
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2-day1) ;
            // 不同年
        } else {
            return day2-day1;
        }
    }
}
