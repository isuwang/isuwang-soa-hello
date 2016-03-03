
package com.isuwang.soa.hello.service;

import com.isuwang.soa.core.Processor;
import com.isuwang.soa.core.Service;

/**
 * Hello Service
 **/
@Service(version = "1.0.0")
@Processor(className = "com.isuwang.soa.hello.HelloServiceCodec$Processor")
public interface HelloService {

    /**
     * say hello
     **/
    String sayHello(String name) throws com.isuwang.soa.core.SoaException;

}
        