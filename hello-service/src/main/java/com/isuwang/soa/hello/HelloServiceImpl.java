package com.isuwang.soa.hello;

import com.isuwang.soa.core.SoaException;
import com.isuwang.soa.hello.domain.Hello;
import com.isuwang.soa.hello.service.HelloService;

/**
 * Created by tangliu on 2016/1/12.
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) throws SoaException {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "hello, " + name;
    }

    @Override
    public String sayHello2(Hello hello) throws SoaException {
        if (hello.getName().equals("bad")) {
            throw new SoaException("hello-001", "so bad");
        } else {
            String message;
            if (!hello.getMessage().isPresent())
                message = "you message is emtpy";
            else
                message = "you message is '" + hello.getMessage().get() + "'";

            return "hello, " + hello.getName() + ", " + message;
        }
    }
}
