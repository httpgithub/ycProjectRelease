package com.may.common.utils;

import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by mayxys on 2016/7/15.
 */
public class AjaxUtil {

    //判断是否是ajax请求
    public static boolean isAjax(HttpServletRequest request){
        return  (request.getHeader("X-Requested-With") != null
                && "XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString())) ;
    }
    // org.springframework.web.context.request.WebRequest;
    public static boolean isAjaxRequest(WebRequest webRequest) {
        String requestedWith = webRequest.getHeader("X-Requested-With");
        return requestedWith != null ? "XMLHttpRequest".equals(requestedWith) : false;
    }
}
