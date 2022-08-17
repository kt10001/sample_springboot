package com.shouxin.yy.common.exception;

import com.shouxin.yy.common.ApiResponse;
import com.shouxin.yy.common.RespEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.HttpResponseException;
import org.apache.shiro.authz.UnauthorizedException;
import org.crazycake.shiro.exception.PrincipalIdNullException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartException;

import java.util.List;

/**
 * @time 2022/2/9 1:35 下午
 * @Author feikong
 */
@RestControllerAdvice(annotations = RestController.class)
@Slf4j
public class ExceptionInterceptor {

    @ExceptionHandler(value = DuplicateKeyException.class)
    @ResponseBody
    public ApiResponse<?> duplicateKeyExceptionHandle(DuplicateKeyException e){
        log.info(e.getMessage(), e);
        return ApiResponse.error(RespEnum.CODE_ENTITY_EXIST.getCode(), "信息已被使用");
    }

    @ExceptionHandler(value = UnauthorizedException.class)
    @ResponseBody
    public ApiResponse<?> unauthorizedExceptionHandle(UnauthorizedException e){
        log.info(e.getMessage(), e);
        return ApiResponse.error(RespEnum.CODE_NO_AUTH.getCode(), RespEnum.CODE_NO_AUTH.getMessage());
    }

    @ExceptionHandler(value = PrincipalIdNullException.class)
    @ResponseBody
    public ApiResponse<?> unLoginExceptionHandle(PrincipalIdNullException e){
        log.info(e.getMessage(), e);
        return ApiResponse.error(RespEnum.CODE_TOKEN_ERROR.getCode(), RespEnum.CODE_TOKEN_ERROR.getMessage());
    }

    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public ApiResponse<?> nullPointerExceptionHandle(NullPointerException e){
        log.error(e.getMessage(), e);
        return ApiResponse.paramError("参数错误");
    }

    @ExceptionHandler(value = HttpResponseException.class)
    public HttpResponseException httpResponseExceptionHandler(HttpResponseException e){
        log.error("运行时异常: ", e);
        e.setStackTrace(new StackTraceElement[]{});
        return e;
    }

    /**
     * 处理实体字段校验不通过异常
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ApiResponse<?> validationError(MethodArgumentNotValidException e) {
        log.info(e.getMessage(), e);
        BindingResult result = e.getBindingResult();
        final List<FieldError> fieldErrors = result.getFieldErrors();
        StringBuilder builder = new StringBuilder();
        for (FieldError error : fieldErrors) {
            builder.append( error.getDefaultMessage()+" ");
        }
        return ApiResponse.paramError(builder.toString());
    }

    /**
     * 处理RequestParam实体字段校验不通过异常
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ApiResponse<?> validationError(BindException e) {
        log.info(e.getMessage(), e);
        BindingResult result = e.getBindingResult();
        final List<FieldError> fieldErrors = result.getFieldErrors();
        FieldError fieldError = fieldErrors.get(fieldErrors.size() - 1);
        return ApiResponse.paramError(fieldError.getDefaultMessage());
    }

    /**
     * url请求参数验证错误
     *
     * @param e e
     * @return {@code ApiResponse<?>}
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public ApiResponse<?> requestParamValidationError(MissingServletRequestParameterException e) {
        log.error(e.getMessage(), e);
        return ApiResponse.paramError("参数" + e.getParameterName() + "错误.");
    }

    /**
     * 缺少文件类型参数错误
     *
     * @param e e
     * @return {@code ApiResponse<?>}
     */
    @ExceptionHandler(MultipartException.class)
    @ResponseBody
    public ApiResponse<?> missMultipartFileError(MultipartException e) {
        log.error(e.getMessage(), e);
        return ApiResponse.paramError("缺少文件类型参数.");
    }

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
     * 预料之中的异常
     *
     * @param e e
     * @return {@code ApiResponse<?>}
     */
    @ExceptionHandler(value =WorkingException.class)
    public ApiResponse<?> workingExceptionHandler(WorkingException e){
        log.info("运行时异常: ", e);
        return ApiResponse.error(e.getCode(), e.getMessage());
    }

    /**
     * 通过抛异常的方式 返回正常返回
     *
     * @param e e
     * @return {@code ApiResponse<?>}
     */
    @ExceptionHandler(value =SuccessedException.class)
    public ApiResponse<?> workingExceptionHandler(SuccessedException e){
        return ApiResponse.success(e.getData());
    }
}
