package com.sys8.sqjzapp.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    // formatType格式为yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
    public static String dateToString(Date data, String formatType) {
        return new SimpleDateFormat(formatType).format(data);
    }

    // formatType格式为yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
    public static Date stringToDate(String data, String formatType) {
        try {
            java.text.SimpleDateFormat formatter = new SimpleDateFormat(formatType);
            Date date = formatter.parse(data);
            return date;
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    public static String calculateDaysFromTwoDateString(String string1,String string2){
        Date date1 = stringToDate(string1,"yyyy年MM月dd日");
        Date date2 = stringToDate(string2,"yyyy年MM月dd日");

        Calendar fromCalendar = Calendar.getInstance();
        fromCalendar.setTime(date1);
        fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
        fromCalendar.set(Calendar.MINUTE, 0);
        fromCalendar.set(Calendar.SECOND, 0);
        fromCalendar.set(Calendar.MILLISECOND, 0);

        Calendar toCalendar = Calendar.getInstance();
        toCalendar.setTime(date2);
        toCalendar.set(Calendar.HOUR_OF_DAY, 0);
        toCalendar.set(Calendar.MINUTE, 0);
        toCalendar.set(Calendar.SECOND, 0);
        toCalendar.set(Calendar.MILLISECOND, 0);

        return ((int) ((toCalendar.getTime().getTime() - fromCalendar.getTime().getTime()) / (1000 * 60 * 60 * 24)))+"天";

    }
}
