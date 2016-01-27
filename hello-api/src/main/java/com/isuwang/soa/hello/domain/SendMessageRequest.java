package com.isuwang.soa.hello.domain;

import com.isuwang.soa.hello.enums.SmsType;

import java.util.List;
import java.util.Map;

/**
 * Created by tangliu on 2016/1/11.
 */
public class SendMessageRequest {

    /**
     * 短信编号
     **/
    public Integer msgId;

    /**
     * 短信类型
     **/
    public SmsType smsType;

    /**
     * 手机号码
     **/
    public List<String> mobileNos;

    /**
     * 信息模板
     **/
    public String msgTemplate;

    /**
     * 模板参数值
     **/
    public Map<String, String> parameters;

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public SmsType getSmsType() {
        return smsType;
    }

    public void setSmsType(SmsType smsType) {
        this.smsType = smsType;
    }

    public List<String> getMobileNos() {
        return mobileNos;
    }

    public void setMobileNos(List<String> mobileNos) {
        this.mobileNos = mobileNos;
    }

    public String getMsgTemplate() {
        return msgTemplate;
    }

    public void setMsgTemplate(String msgTemplate) {
        this.msgTemplate = msgTemplate;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }
}
