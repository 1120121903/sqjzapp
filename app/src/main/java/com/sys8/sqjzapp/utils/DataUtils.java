package com.sys8.sqjzapp.utils;

import java.security.PublicKey;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.sys8.sqjzapp.utils.Constant.USER_NAME;

public class DataUtils {

    public static List getRevertTimeLineData(List mdata){
        List mRevertData = new ArrayList<>();
        for(int i=mdata.size()-1;i>=0;i--){
            mRevertData.add(mdata.get(i));
        }
        return mRevertData;
    }

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

    /**
     * 比较两个时间的先后
     */
    public static boolean compareTwoDate(String firstDate, String secondDate, String formatType) {
        SimpleDateFormat df = new SimpleDateFormat(formatType);
        try {
            Date firstDateD = df.parse(firstDate);
            Date secondDateD = df.parse(secondDate);
            if (firstDateD.before(secondDateD)) {
                return true;
            } else {
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     *description:获取用户名
     */
    public static String getUserName() {
        return USER_NAME;
    }

    /**
     *description:获取当前日期
     */
    public static String getDate( String formatType) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatType);
        //获取当前时间
        Date date = new Date(System.currentTimeMillis());
        return simpleDateFormat.format(date);
    }

    /**
     *description:获取当前时间
     */
    public static String getTime( String formatType) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatType);
        //获取当前时间
        Date date = new Date(System.currentTimeMillis());
        return simpleDateFormat.format(date);
    }

    //计算两个日期之间的天数
    public static String calculateDaysFromTwoDateString(String string1,String string2,String formatType){
        Date date1 = stringToDate(string1,formatType);
        Date date2 = stringToDate(string2,formatType);

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
