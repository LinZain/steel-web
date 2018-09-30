package com.boll6.steel.util;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by wangluyin on 16/9/27.
 */
public class NumberUtils extends org.apache.commons.lang.math.NumberUtils{
    public static boolean isNullOrZero(Long value){
        if(value == null ||value == 0 ){
            return true;
        }
        return false;
    }

    public static boolean isNullOrZero(Integer value){
        if(value == null || value == 0 ){
            return true;
        }
        return false;
    }

    public static boolean isNull(Long value){
        if(value == null){
            return true;
        }
        return false;
    }

    public static boolean isNotNullOrZero(Long value){
        return !isNullOrZero(value);
    }

    public static boolean isNotNullOrZero(Integer value){
        return !isNullOrZero(value);
    }

    public static boolean isNotNull(Long value){
        return !isNull(value);
    }

    /**
     * 升序排列
     * @param value
     * @return
     */
    public static String sortAsc(long[] value){
        String key = "";
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < value.length; i++) {
            list.add(value[i]);
        }
        Collections.sort(list);
        for(long val :list){
            key += val + ",";
        }
        return key.substring(0, key.length()-1);
    }

    public static String sortAsc(Long[] value){
        String key = "";
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < value.length; i++) {
            list.add(value[i]);
        }
        Collections.sort(list);
        for(long val :list){
            key += val + ",";
        }
        return key.substring(0, key.length()-1);
    }

    public static long[] toArray(Long[] values){
        if(values==null|| values.length == 0){
            return new long[]{};
        }
        long[] destArray = new long[values.length];
        for (int i = 0;i<values.length;i++ ) {
            destArray[i] = values[i].longValue();
        }
        return destArray;
    }

    public static long[] toArray(JSONArray values){
        if(values==null|| values.size() == 0){
            return new long[]{};
        }
        long[] destArray = new long[values.size()];
        for (int i = 0;i<values.size();i++ ) {
            destArray[i] = values.getLongValue(i);
        }
        return destArray;
    }

}
