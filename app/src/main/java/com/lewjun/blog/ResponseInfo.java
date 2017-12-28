package com.lewjun.blog;

/**
 * 响应信息
 * @author LewJun
 * @version v0.1 2017/12/22 13:55 LewJun Exp $$
 */
public class ResponseInfo<T> {
    private int errcode;

    private String errmsg;

    private T data;

    public boolean isSuccess() {
        return errcode == 0;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
