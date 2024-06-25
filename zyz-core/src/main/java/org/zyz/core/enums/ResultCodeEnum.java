package org.zyz.core.enums;


/**
 * 错误代码
 */
public enum ResultCodeEnum {
    OK(0,"请求成功"),
    COMMON_ERROR(199,"请求失败");
    private int code;
    private String msg;

    ResultCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
