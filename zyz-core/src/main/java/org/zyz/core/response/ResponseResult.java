package org.zyz.core.response;

import lombok.Data;

/**
 * 统一 API 响应结果类，封装响应数据、状态码、错误信息。
 *
 * @param <T> 返回数据类型
 */
@Data
public class ResponseResult<T> {
    private int code;       // 状态码
    private String message; // 描述信息
    private T data;         // 返回的数据

    /**
     * 成功响应，包含数据。
     */
    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 业务逻辑层面的失败响应，可以自定义状态码和错误信息。
     */
    public static <T> ResponseResult<T> failure(int code, String message) {
        return new ResponseResult<>(code, message, null);
    }

    /**
     * 系统层面的失败响应，使用枚举的默认状态码和错误信息。
     */
    public static <T> ResponseResult<T> failure(ResultCode resultCode) {
        return new ResponseResult<>(resultCode.getCode(), resultCode.getMessage(), null);
    }

    /**
     * 构造方法，用于创建 ResponseResult 对象。
     */
    public ResponseResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
