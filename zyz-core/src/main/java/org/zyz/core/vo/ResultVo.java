package org.zyz.core.vo;

import lombok.Data;
import org.zyz.core.enums.ResultCodeEnum;

/**
 * 返回的数据结构<br/>
 * 返回的Code和描述
 * @see org.zyz.core.enums.ResultCodeEnum
 */
@Data
public class ResultVo<T> {
    private int code;
    private String msg;
    private T data;

    /**
     * 请求成功
     * @param data
     * @return
     * @param <T>
     */
    public static <T> ResultVo<T> OK(T data){
        ResultVo<T> resultVo = new ResultVo<>();
        resultVo.code = ResultCodeEnum.OK.getCode();
        resultVo.msg = ResultCodeEnum.OK.getMsg();
        resultVo.data = data;
        return resultVo;
    }

    /**
     * 请求失败
     * @param msg
     * @return
     */
    public static ResultVo<String> Error(String msg){
        ResultVo<String> resultVo = new ResultVo<>();
        resultVo.code = ResultCodeEnum.COMMON_ERROR.getCode();
        if (msg.isEmpty()){
            resultVo.msg = ResultCodeEnum.COMMON_ERROR.getMsg();
        }else {
            resultVo.msg = msg;
        }
        return resultVo;
    }
}
