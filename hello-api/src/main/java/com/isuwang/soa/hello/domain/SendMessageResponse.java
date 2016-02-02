package com.isuwang.soa.hello.domain;

/**
 * 发送信息返回包
 **/
public class SendMessageResponse {

    /**
     * 状态
     **/
    public Integer status;

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 信息
     **/
    public String msg;

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");
        stringBuilder.append("\"").append("status").append("\":").append(this.status).append(",");
        stringBuilder.append("\"").append("msg").append("\":\"").append(this.msg).append("\",");

        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
        stringBuilder.append("}");

        return stringBuilder.toString();
    }
}
      