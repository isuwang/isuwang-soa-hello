package com.isuwang.soa.hello.client;

import com.isuwang.soa.hello.HelloServiceClient;
import com.isuwang.soa.registry.ServiceInfoWatcher;
import org.apache.thrift.TException;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tangliu on 2016/2/16.
 */
public class TestClient {

    public static void main(String[] args) throws InterruptedException, TException {

        ServiceInfoWatcher siw = new ServiceInfoWatcher();
        siw.init();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        int size = 100;


        final long startTime = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {

            System.out.println((new HelloServiceClient().sayHello("Xiaoming", "nice to meet you")));

        }

        long totalTime = System.currentTimeMillis() - startTime;

        System.out.println("请求总数:" + size);
        System.out.println("总耗时时间:" + totalTime + "ms");

//        Thread.sleep(30 * 1000L);
//
//        try {
//            System.out.println((new HelloServiceClient().sayHello("Xiaoming", "nice to meet you")));
//        } catch (TException e) {
//            e.printStackTrace();
//        }
//
//        Thread.sleep(3000 * 1000L);
//        System.exit(0);

    }
}
