package com.shouxin.yy.filters;

import com.shouxin.yy.common.AppContext;
import com.shouxin.yy.utils.GenIdUtil;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * ContextFilter
 * 全局上下文过滤器
 *
 * @time 2022/2/11 10:18 上午
 * @Author feikong
 */
@Slf4j
public class ContextFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        AppContext.getContext().setRequestTime(System.currentTimeMillis());

        String traceId = GenIdUtil.genOrderId();
        AppContext.getContext().setRequestId(traceId);

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
