package com.shouxin.yy.common.aspectj;

import cn.hutool.json.JSONUtil;
import com.shouxin.yy.common.AppContext;
import com.shouxin.yy.utils.IpUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.util.Objects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.multipart.MultipartFile;

/**
 * 使用aop记录controller请求日志
 * @time 2022/4/25 2:15 下午
 * @Author feikong
 */
@Aspect
@Component
//@Order(Ordered.LOWEST_PRECEDENCE - 2)
@Slf4j
public class LogAspectj {

    /**
     * 切入点
     */
    @Pointcut("execution(public * com.shouxin.yy.controller.*.*Controller.*(..))")
    public void logAspect() {

    }

    /**
     * 前置操作
     */
    @Before("logAspect()")
    public void beforeLog(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
        log.info("【请求 URL】：{},【请求 IP】：{},【请求参数】：{}", request.getRequestURL(), IpUtil.getIpAddress(request), JSONUtil.toJsonStr(getRequestParam(joinPoint)));
    }

    /**
     * 环绕操作
     *
     * @param point 切入点
     * @return 原方法返回值
     * @throws Throwable 异常信息
     */
    @Around("logAspect()")
    public Object aroundLog(@NotNull ProceedingJoinPoint point) throws Throwable {
        Object result = point.proceed();
        log.info("【请求类】：{}【返回值】：{}", String.format("%s.%s", point.getSignature().getDeclaringTypeName(), point.getSignature().getName()), JSONUtil.toJsonStr(result));
        return result;
    }

    /**
     * 后置操作
     */
    @AfterReturning("logAspect()")
    public void afterReturning() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();

        Long end = System.currentTimeMillis();
        log.info("【请求耗时】：{}毫秒", end - AppContext.getContext().getRequestTime());
    }

    /**
     * 获取请求参数
     */
    private Object[] getRequestParam(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Object[] arguments = new Object[args.length];
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof ServletRequest || args[i] instanceof ServletResponse || args[i] instanceof MultipartFile) {
                //ServletRequest，ServletResponse,MultipartFile不能序列化
                continue;
            }
            arguments[i] = args[i];
        }
        return arguments;
    }
}
