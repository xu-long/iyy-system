package com.iyy.utils.exception;

/**
 * @author MuShan
 * @version 1.0
 * @date 2022/3/28 9:46
 * BussinessException业务逻辑异常
 */

public class BussinessException extends RuntimeException {
    private static String code = Thread.currentThread().getStackTrace()[2].getMethodName();
    private String msg;
    public BussinessException(String msg) {
        super(code + "-" +msg);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
