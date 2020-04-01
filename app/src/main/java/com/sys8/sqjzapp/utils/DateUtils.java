package com.sys8.sqjzapp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    // formatType格式为yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
    // data Date类型的时间
    public static String dateToString(Date data, String formatType) {
        return new SimpleDateFormat(formatType).format(data);
    }
}
