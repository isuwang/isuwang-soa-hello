package com.isuwang.soa.hello.domain;

/**
 * 发送信息请求包
 **/
public class SendMessageRequest {

    /**
     * 短信编号
     **/
    public Integer msgId;

    public Integer getMsgId() {
        return this.msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    /**
     * 短信类型
     **/
    public com.isuwang.soa.hello.enums.SmsType smsType;

    public com.isuwang.soa.hello.enums.SmsType getSmsType() {
        return this.smsType;
    }

    public void setSmsType(com.isuwang.soa.hello.enums.SmsType smsType) {
        this.smsType = smsType;
    }

    /**
     * 手机号码
     **/
    public java.util.List<String> mobileNos;

    public java.util.List<String> getMobileNos() {
        return this.mobileNos;
    }

    public void setMobileNos(java.util.List<String> mobileNos) {
        this.mobileNos = mobileNos;
    }

    /**
     * 信息模板
     **/
    public String msgTemplate;

    public String getMsgTemplate() {
        return this.msgTemplate;
    }

    public void setMsgTemplate(String msgTemplate) {
        this.msgTemplate = msgTemplate;
    }

    /**
     * 模板参数值
     **/
    public java.util.Map<String, String> parameters;

    public java.util.Map<String, String> getParameters() {
        return this.parameters;
    }

    public void setParameters(java.util.Map<String, String> parameters) {
        this.parameters = parameters;
    }


    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");
        stringBuilder.append("\"").append("msgId").append("\":").append(this.msgId).append(",");
        stringBuilder.append("\"").append("smsType").append("\":").append(this.smsType).append(",");
        stringBuilder.append("\"").append("mobileNos").append("\":").append(this.mobileNos).append(",");
        stringBuilder.append("\"").append("msgTemplate").append("\":\"").append(this.msgTemplate).append("\",");
        stringBuilder.append("\"").append("parameters").append("\":").append(this.parameters).append(",");

        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
        stringBuilder.append("}");

        return stringBuilder.toString();
    }
}
      