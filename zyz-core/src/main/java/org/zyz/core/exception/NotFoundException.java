package org.zyz.core.exception;

/**
 * 自定义的 "资源未找到" 异常类。
 * 当请求的资源在系统中不存在时，抛出该异常。
 */
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);  // 传入异常信息
    }
}
