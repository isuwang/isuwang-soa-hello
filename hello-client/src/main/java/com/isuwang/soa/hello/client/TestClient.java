package com.isuwang.soa.hello.client;

import com.isuwang.soa.hello.HelloServiceClient;
import org.apache.thrift.TException;

import java.util.concurrent.CountDownLatch;

/**
 * Created by tangliu on 2016/3/3.
 */
public class TestClient {


    public static void main(String[] args) throws InterruptedException {
        int count = 50;

        while (true) {
            final CountDownLatch latch = new CountDownLatch(count);

            newTask(count, latch);

            latch.await();

            Thread.sleep(2000);
        }
    }

    private static void newTask(int count, CountDownLatch latch) {
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < count; i++) {
                    HelloServiceClient client = new HelloServiceClient();
                    try {
                        System.out.println(client.sayHello("LiLei"));

                        latch.countDown();
                    } catch (TException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }


}
