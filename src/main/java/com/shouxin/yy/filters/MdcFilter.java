package com.shouxin.yy.filters;

import com.shouxin.yy.common.AppContext;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import javax.servlet.*;
import java.io.IOException;

/**
 * ContextFilter
 * 全局上下文过滤器
 *
 * @time 2022/2/11 10:18 上午
 * @Author feikong
 */
@Slf4j
public class MdcFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        MDC.put(AppContext.KEY_REQUEST_ID, AppContext.getContext().getRequestId());

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
