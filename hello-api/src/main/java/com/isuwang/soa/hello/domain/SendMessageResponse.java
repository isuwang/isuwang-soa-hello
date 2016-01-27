package com.isuwang.soa.hello.domain;

/**
 * Created by tangliu on 2016/1/11.
 */
public class SendMessageResponse {

    /**
     * 状态
     **/
    public Integer status;

    /**
     * 信息
     **/
    public String msg;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
