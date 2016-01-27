package com.isuwang.soa.hello.service;

import com.isuwang.soa.core.Processor;
import com.isuwang.soa.core.Service;
import com.isuwang.soa.hello.domain.SendMessageRequest;
import com.isuwang.soa.hello.domain.SendMessageResponse;

/**
 * Created by tangliu on 2016/1/11.
 */
@Service(version = "1.0.0")
@Processor(className = "com.isuwang.soa.hello.HelloServiceCodec$Processor")
public interface HelloService {

    /**
     * sayHello
     *
     * @param name
     * @param msg
     * @return
     */
    String sayHello(String name, String msg) throws com.isuwang.soa.core.SoaException;


    /**
     * sendMessage
     *
     * @param request
     * @return
     */
    SendMessageResponse sendMessage(SendMessageRequest request) throws com.isuwang.soa.core.SoaException;

}
