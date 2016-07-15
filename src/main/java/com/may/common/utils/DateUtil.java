package com.may.common.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by mayxys on 2016/7/11.
 */
public class DateUtil {
    public static Date getStartDate(){
       return  getStartDate(0);
    }
    public static Date getStartDate(int i){
        Calendar now = Calendar.getInstance();
        now.add(Calendar.DAY_OF_MONTH,i);
        now.set(Calendar.HOUR, 0);
        now.set(Calendar.MINUTE, 0);
        now.set(Calendar.SECOND, 0);
        now.set(Calendar.HOUR_OF_DAY, 0);
        return now.getTime();
    }
    public static void main(String[] args){
        System.out.println(DateUtil.getStartDate());
    }
}
