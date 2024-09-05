package org.zyz.core.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.zyz.core.util.LogUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 请求拦截器，用于记录请求的详细信息。
 */
@Component
public class RequestLogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String requestUri = request.getRequestURI();
        String queryString = request.getQueryString();
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        LogUtil.info("Request Start: " + requestUri + (queryString != null ? "?" + queryString : ""));
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        long startTime = (Long) request.getAttribute("startTime");
        long duration = System.currentTimeMillis() - startTime;
        LogUtil.info("Request End: " + request.getRequestURI() + " Duration: " + duration + "ms");
        if (ex != null) {
            LogUtil.error("Request Error: ", ex);
        }
    }
}
