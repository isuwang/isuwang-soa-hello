include "hello_enums.thrift"
include "hello_domain.thrift"
namespace java com.isuwang.soa.hello.service

/**
* Hello Service
**/
service HelloService {

    /**
    * say hello
    **/
    string sayHello(1:string name, 2:string msg),

    /**
    * send message
    **/
    hello_domain.SendMessageResponse sendMessage(1: hello_domain.SendMessageRequest request);

}