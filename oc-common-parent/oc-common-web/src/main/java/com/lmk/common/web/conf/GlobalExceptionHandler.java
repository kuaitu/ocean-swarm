package com.lmk.common.web.conf;

import com.lmk.common.exception.LogicException;
import com.lmk.common.rdbms.vo.Ret;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(LogicException.class)
    @ResponseBody
    Ret<Void> handleLogicException(LogicException ex) {
        log.error("业务异常", ex);
        return Ret.err(ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    Ret<Void> handleAssertException(IllegalArgumentException ex) {
        log.error("参数校验异常！", ex);
        return Ret.err(ex.getMessage());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    Ret<Void> handleMissingServletRequestParameterException(MissingServletRequestParameterException ex) {
        log.error("缺少参数异常！", ex);
        return Ret.err("缺少参数异常！");
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    Ret<Void> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
        log.error("请求方法不支持异常！", ex);
        return Ret.err("请求方法不支持异常！");
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    Ret<Void> handleAssertException(Exception ex) {
        log.error("发生异常！", ex);
        return Ret.err("服务器内部错误，请联系管理员！");
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    @ResponseBody
    public Ret<Void> handleMaxUploadSizeExceededException(MaxUploadSizeExceededException ex) {
        log.error("文件大小超出限制，请压缩或降低文件质量！", ex);
        return Ret.err("文件大小超出限制，请压缩或降低文件质量！");
    }
}
