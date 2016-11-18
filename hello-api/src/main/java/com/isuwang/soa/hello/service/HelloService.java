package com.isuwang.soa.hello.service;

import com.isuwang.dapeng.core.Processor;
import com.isuwang.dapeng.core.Service;

/**
 * Hello Service
 **/
@Service(version = "1.0.0")
@Processor(className = "com.isuwang.soa.hello.HelloServiceCodec$Processor")
public interface HelloService {

    /**
     * say hello
     **/


    String sayHello(String name) throws com.isuwang.dapeng.core.SoaException;


    /**
     *
     **/


    String sayHello2(com.isuwang.soa.hello.domain.Hello hello) throws com.isuwang.dapeng.core.SoaException;


}
        