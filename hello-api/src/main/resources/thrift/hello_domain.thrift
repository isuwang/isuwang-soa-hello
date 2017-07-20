namespace java com.isuwang.soa.hello.domain

include "hello_enum.thrift"

struct Hello {

    1: string  name,

    2: optional string message,

    3: hello_enum.HelloEnum type

}