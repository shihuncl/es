package com.chenlei.elasticsearch.common.exception;


import com.chenlei.elasticsearch.common.enums.EnumResult;

/**
 * 业务自定义异常
 * 
 * @author ZY
 * @date 2018/10/18
 */
public class BizException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = -4372754315437274125L;

    /**
     * 结果码
     */
    private Integer code;

    /**
     * 结果消息
     */
    private String msg;

    public BizException(EnumResult resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }

    public BizException(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
