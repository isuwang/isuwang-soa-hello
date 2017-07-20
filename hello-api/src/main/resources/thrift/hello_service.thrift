include "hello_domain.thrift"

namespace java com.isuwang.soa.hello.service

/**
* Hello Service
**/
service HelloService {

    string sayHello(1:hello_domain.Hello hello)

}