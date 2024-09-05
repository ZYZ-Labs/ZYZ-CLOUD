package org.zyz.core.exception;

import org.zyz.core.response.ResponseResult;
import org.zyz.core.response.ResultCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器，用于捕获项目中的异常并统一返回格式化的错误信息。
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 捕获所有未处理的异常。
     *
     * @param e 捕获到的异常对象
     * @return 统一封装的错误信息
     */
    @ExceptionHandler(Exception.class)
    public ResponseResult<Object> handleException(Exception e) {
        // 这里可以记录日志或进一步处理异常
        return ResponseResult.failure(ResultCode.FAILURE);
    }

    /**
     * 自定义业务异常的处理器（例如未找到资源）。
     *
     * @param e 业务异常对象
     * @return 统一封装的错误信息
     */
    @ExceptionHandler(NotFoundException.class)
    public ResponseResult<Object> handleNotFoundException(NotFoundException e) {
        return ResponseResult.failure(ResultCode.NOT_FOUND);
    }
}
