package com.sys8.sqjzapp.utils;
/**
 *date:2020/7/29
 *author:wy
 *description:时间日期String分割，转int
*/
public class DateToYMDHM {
    private static int year;
    private static int month;
    private static int day;
    private static int hour;
    private static int minute;
    private static String s_date;
    private static String s_time;

    /**
     *description:日期
    */
    public static String getDateString(String date){
        String[] result = date.split(" ");
        s_date = result[0];
        return s_date;
    }

    /**
     *description:时间
     */
    public static String getTimeString(String date){
        String[] result = date.split(" ");
        s_time= result[1];
        return s_time;
    }

    /**
     *description:年（int）
    */
    public static int getYear(String dates){
        String date = getDateString(dates);
        String[] result = date.split("-");
        year =Integer.parseInt(result[0]);
        //System.out.println(year);
        return year;
    }
    /**
     *description:月（int）
    */
    public static int getMonth(String dates){
        String date = getDateString(dates);
        String[] result = date.split("-");
        month =Integer.parseInt(result[1]);
        //System.out.println(month);
        return month;
    }
    /**
     *description:日（int）
    */
    public static int getDay(String dates){
        String date = getDateString(dates);
        String[] result = date.split("-");
        day =Integer.parseInt(result[2]);
        //System.out.println(day);
        return day;
    }
    /**
     *description:小时（int）
     */
    public static int getHour(String times){
        String time = getTimeString(times);
        String[] result = time.split(":");
        hour =Integer.parseInt(result[0]);
        //System.out.println(hour);
        return hour;
    }
    /**
     *description:分钟（int）
     */
    public static int getMinute(String times){
        String time = getTimeString(times);
        String[] result = time.split(":");
        minute =Integer.parseInt(result[1]);
        //System.out.println(minute);
        return minute;
    }

}
