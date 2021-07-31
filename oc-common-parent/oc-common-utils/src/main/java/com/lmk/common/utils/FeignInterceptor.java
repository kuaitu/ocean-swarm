package com.lmk.common.utils;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class FeignInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        /*final String TOKEN_NAME = "token";
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Cookie cookie = CookieUtil.getCookieByName(attributes.getRequest(), TOKEN_NAME);
        if (null != cookie) {
            template.header("Cookie", TOKEN_NAME + "=" + cookie.getValue());
        }*/
    }
}
