package com.jeeplus.common.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils {

    /**
     * 获取请求Request
     * @return
     */
    public static HttpServletRequest getRequest() {
        if ( RequestContextHolder.getRequestAttributes ( ) == null ) {
            return null;
        }
        HttpServletRequest request = ((ServletRequestAttributes)  RequestContextHolder.getRequestAttributes ( ) ).getRequest ( );
        return request;
    }

    /**
     * 获取请求header中的值
     *
     * @return
     */
    public static String getHeader(String key) {
        if ( RequestContextHolder.getRequestAttributes ( ) == null ) {
            return null;
        }
        HttpServletRequest request = ((ServletRequestAttributes)  RequestContextHolder.getRequestAttributes ( ) ).getRequest ( );
        if ( request != null ) {
            return request.getHeader ( key);
        }
        return null;
    }
}
