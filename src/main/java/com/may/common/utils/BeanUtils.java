package com.may.common.utils;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.DateConverter;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by mayxys on 2016/7/10.
 */
public class BeanUtils {
    private static String defaultDateFormate = "yyyy:MM:dd HH:mm:ss";
    public static void copyProperties(Object dest, Object orig) throws InvocationTargetException, IllegalAccessException {
        BeanUtilsBean beanUtilsBean = BeanUtilsBean.getInstance();
        DateConverter dateConverter = new DateConverter();
        dateConverter.setPattern(defaultDateFormate);
       /* ConvertUtils.register(dateConverter
        , java.util.Date.class);*/
        ConvertUtils.register(dateConverter
                , java.lang.String.class);
        org.apache.commons.beanutils.BeanUtils.copyProperties(dest, orig);
        //beanUtilsBean.copyProperties(dest,orig);
    }
}
