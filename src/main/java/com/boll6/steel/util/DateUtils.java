package com.boll6.steel.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private static SimpleDateFormat YYYYMMDD = new SimpleDateFormat("yyyyMMdd");
    private static SimpleDateFormat YYYY_MM_DD = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat HHMM = new SimpleDateFormat("HH:mm");
    private static SimpleDateFormat HHMMSS = new SimpleDateFormat("HH:mm:ss");
    private static SimpleDateFormat HHMMSS_SSS = new SimpleDateFormat("HH:mm:ss.SSS");
    private static SimpleDateFormat YYYYMMDDHHMMSS = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
    private static SimpleDateFormat YYYYMMDDHHMMSS_SSS = new SimpleDateFormat("yyyyMMdd HH:mm:ss.SSS");
    private static SimpleDateFormat YYYY_MM_DD_HHMMSS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static SimpleDateFormat YYYY_MM_DD_HHMMSS_SSS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    public static String YYYYMMDD(Date date) {
        synchronized (YYYYMMDD) {
            return YYYYMMDD.format(date);
        }
    }

    public static String YYYY_MM_DD(Date date) {
        synchronized (YYYY_MM_DD) {
            return YYYY_MM_DD.format(date);
        }
    }

    public static Date YYYY_MM_DD(String yyyy_mm_dd) throws ParseException {
        synchronized (YYYY_MM_DD) {
            return YYYY_MM_DD.parse(yyyy_mm_dd);
        }
    }

    public static Date YYYY_MM_DD_HH_MM_SS_SSS(String yyyy_mm_dd) throws ParseException {
        synchronized (YYYYMMDDHHMMSS_SSS) {
            return YYYYMMDDHHMMSS_SSS.parse(yyyy_mm_dd);
        }
    }

    public static Date YYYY_MM_DD_HH_MM_SS(String yyyy_mm_dd) throws ParseException {
        synchronized (YYYY_MM_DD_HHMMSS) {
            return YYYY_MM_DD_HHMMSS.parse(yyyy_mm_dd);
        }
    }

    public static String HHMM(Date date) {
        synchronized (HHMM) {
            return HHMM.format(date);
        }
    }

    public static String HHMMSS(Date date) {
        synchronized (HHMMSS) {
            return HHMMSS.format(date);
        }
    }

    public static String HHMMSS_SSS(Date date) {
        synchronized (HHMMSS_SSS) {
            return HHMMSS_SSS.format(date);
        }
    }

    public static String YYYYMMDDHHMMSS(Date date) {
        synchronized (YYYYMMDDHHMMSS) {
            return YYYYMMDDHHMMSS.format(date);
        }
    }

    public static String YYYYMMDDHHMMSS_SSS(Date date) {
        synchronized (YYYYMMDDHHMMSS_SSS) {
            return YYYYMMDDHHMMSS_SSS.format(date);
        }
    }

    public static String YYYY_MM_DD_HHMMSS(Date date) {
        synchronized (YYYY_MM_DD_HHMMSS) {
            return YYYY_MM_DD_HHMMSS.format(date);
        }
    }

    public static String YYYY_MM_DD_HHMMSS_SSS(Date date) {
        synchronized (YYYY_MM_DD_HHMMSS_SSS) {
            return YYYY_MM_DD_HHMMSS_SSS.format(date);
        }
    }
    
    public static Date getCurrDate_YYYY_MM_DD() throws ParseException{
    	synchronized (YYYY_MM_DD) {
            return YYYY_MM_DD.parse(YYYY_MM_DD.format(new Date()));
        }
    }
}
