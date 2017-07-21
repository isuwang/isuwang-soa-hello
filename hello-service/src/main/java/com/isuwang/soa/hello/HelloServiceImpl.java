package com.isuwang.soa.hello;

import com.isuwang.dapeng.core.SoaException;
import com.isuwang.dapeng.core.helper.MasterHelper;
import com.isuwang.soa.hello.domain.Hello;
import com.isuwang.soa.hello.service.HelloService;

/**
 * Created by tangliu on 2016/1/12.
 */
public class HelloServiceImpl implements HelloService {


    public void init() {

        new Thread(() -> {

            while (true) {
                System.out.println(MasterHelper.isMaster("com.isuwang.soa.hello.service.HelloService", "1.0.0"));

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    @Override
    public String sayHello(Hello hello) throws SoaException {
        System.out.println(hello.toString());
        return hello.getName();
    }
}
