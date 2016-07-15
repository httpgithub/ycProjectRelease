package com.may.com.may.Exception;

import com.may.common.utils.AjaxUtil;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mayxys on 2016/7/15.
 */
public class ExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv = new ModelAndView();
        if(AjaxUtil.isAjax(request)){
            MappingJackson2JsonView view = new MappingJackson2JsonView();
            Map<String, Object> attributes = new HashMap<String, Object>();
            String code = "";
            if(ex instanceof BaseException){
                BaseException  baseException = (BaseException) ex;
                code = baseException.getExceptionCode();
            }
            attributes.put("code", code);
            attributes.put("msg", ex.getMessage());
            view.setAttributesMap(attributes);
            mv.setView(view);
        }

        //log.debug("异常:" + ex.getMessage(), ex);
        return mv;
    }
}
