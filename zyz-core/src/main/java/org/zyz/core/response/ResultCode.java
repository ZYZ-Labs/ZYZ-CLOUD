package org.zyz.core.response;

/**
 * 枚举类，用于管理常见的状态码。
 */
public enum ResultCode {

    SUCCESS(200, "操作成功"),
    FAILURE(500, "服务器内部错误"),
    NOT_FOUND(404, "资源未找到"),
    UNAUTHORIZED(401, "未授权"),
    FORBIDDEN(403, "禁止访问");

    private final int code;      // 状态码
    private final String message; // 描述信息

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
