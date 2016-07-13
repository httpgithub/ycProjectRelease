package com.may.common.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by mayxys on 2016/7/11.
 */
public class DateUtil {
    public static Date getStartDate(){
        Calendar now = Calendar.getInstance();
        now.set(Calendar.HOUR, 0);
        now.set(Calendar.MINUTE, 0);
        now.set(Calendar.SECOND, 0);
        now.set(Calendar.HOUR_OF_DAY, 0);
        return now.getTime();
    }

}
