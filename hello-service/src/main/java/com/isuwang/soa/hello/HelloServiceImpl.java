package com.isuwang.soa.hello;

import com.isuwang.soa.core.SoaException;
import com.isuwang.soa.hello.service.HelloService;

/**
 * Created by tangliu on 2016/1/12.
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) throws SoaException {
        return "hello, " + name;
    }
}
