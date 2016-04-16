package com.isuwang.soa.hello.client;

import com.isuwang.soa.hello.HelloServiceClient;
import com.isuwang.soa.hello.domain.Hello;

import java.util.concurrent.CountDownLatch;

/**
 * Created by tangliu on 2016/3/3.
 */
public class TestClient {

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            final int count = 10;

            final CountDownLatch latch = new CountDownLatch(count);

            newTask(count, latch);

            latch.await();
        }
    }

    private static void newTask(int count, CountDownLatch latch) {
        for (int i = 0; i < count; i++) {
            new Thread() {
                @Override
                public void run() {
                    HelloServiceClient client = new HelloServiceClient();
                    try {
                        Hello hello = new Hello();
                        hello.setName("ddd");
                        System.out.println(client.sayHello2(hello));

                        //System.out.println(client.sayHello("hello"));

                        Thread.sleep(100);

                        latch.countDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }


}
