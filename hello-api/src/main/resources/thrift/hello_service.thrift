include "hello_domain.thrift"

namespace java com.isuwang.soa.hello.service

/**
* Hello Service
**/
service HelloService {

    /**
    * say hello
    **/
    string sayHello(1:string name),

    string sayHello2(1:hello_domain.Hello hello)

}