include "hello_enums.thrift"

namespace java com.isuwang.soa.hello.domain

/**
* 发送信息请求包
**/
struct SendMessageRequest {

    /**
    * 短信编号
    **/
    1:i32 msgId,

    /**
    * 短信类型
    **/
    2:hello_enums.SmsType smsType,

    /**
    * 手机号码
    **/
    3:list<string> mobileNos,

    /**
    * 信息模板
    **/
    4:string msgTemplate,

    /**
    * 模板参数值
    **/
    5:map<string, string> parameters

}

/**
* 发送信息返回包
**/
struct SendMessageResponse {

    /**
    * 状态
    **/
    1:i32 status,

    /**
    * 信息
    **/
    2:string msg

}