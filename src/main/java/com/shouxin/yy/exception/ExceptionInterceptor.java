package com.shouxin.yy.exception;

import com.shouxin.yy.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

/**
 * @time 2022/2/9 1:35 下午
 * @Author feikong
 */
@RestControllerAdvice(annotations = RestController.class)
@Slf4j
public class ExceptionInterceptor {

    /**
     * 处理未知异常
     *
     * @param e e
     * @return {@code ApiResponse<?>}
     */
    @ExceptionHandler(value =Exception.class)
    public ApiResponse<?> exceptionHandler(Exception e, WebRequest webRequest){
        log.error("未知异常！原因是: ", e);
        return ApiResponse.error();
    }

    /**
     * 工作异常处理程序
     *
     * @param e e
     * @return {@code ApiResponse<?>}
     */
    @ExceptionHandler(value =WorkingException.class)
    public ApiResponse<?> workingExceptionHandler(WorkingException e){
        log.error("运行时异常: ", e);
        return ApiResponse.error(e.getCode(), e.getMessage());
    }

    /**
     * 已知工作异常处理程序
     *
     * @param e e
     * @return {@code ApiResponse<?>}
     */
    @ExceptionHandler(value = KnownException.class)
    public ApiResponse<?> knownExceptionHandler(KnownException e){
        return ApiResponse.error(e.getCode(), e.getMessage());
    }
}
