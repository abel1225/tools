package me.abel.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @program: automobile_dev
 * @description: 日期时间处理工具包
 * @author: able.li
 * @create: 2018-07-10 11:48
 */
public class DateUtil {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss", Locale.CHINA);

    public static String getTimestamp(Date date){
        sdf.applyPattern("yyyyMMdd HH:mm:ss");
        return sdf.format(date);
    }

    public static String getTimestamp(long date){
        sdf.applyPattern("yyyyMMdd HH:mm:ss");
        return sdf.format(date);
    }

    public static String getDate(Date date){
        sdf.applyPattern("yyyyMMdd");
        return sdf.format(date);
    }

    public static String getDate(long date){
        sdf.applyPattern("yyyyMMdd");
        return sdf.format(date);
    }

    public static String getDate(Date date, String pattern){
        sdf.applyPattern(pattern);
        return sdf.format(date);
    }

    public static String getDate(long date, String pattern){
        sdf.applyPattern(pattern);
        return sdf.format(date);
    }

    public static Date parseDate(String date, String pattern) throws ParseException {
        sdf.applyPattern(pattern);
        return sdf.parse(date);
    }

}
