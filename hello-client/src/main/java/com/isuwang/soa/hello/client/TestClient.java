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

    public static void main(String[] args) throws InterruptedException {

        ServiceInfoWatcher siw = new ServiceInfoWatcher();
        siw.init();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }


        final int nThreads = 10;

        final ExecutorService threadPool = Executors.newFixedThreadPool(nThreads);

        int size = 100;

        final CountDownLatch latch = new CountDownLatch(size * 1);

        final long startTime = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            threadPool.submit(() -> {
                try {
                    System.out.println((new HelloServiceClient().sayHello("Xiaoming", "nice to meet you")));
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            });
        }

        threadPool.shutdown();

        latch.await();

        long totalTime = System.currentTimeMillis() - startTime;

        System.out.println("请求总数:" + size);
        System.out.println("并发数:" + nThreads);
        System.out.println("总耗时时间:" + totalTime + "ms");
        System.out.println("平均响应时间:" + totalTime / (size * 0.1) + "ms");
        //QPS（TPS）= 并发数 / 平均响应时间 或者 并发数 = QPS * 平均响应时间
        System.out.println("QPS（TPS）:" + nThreads * size / (totalTime * 0.1));

        Thread.sleep(30 * 1000L);

        try {
            System.out.println((new HelloServiceClient().sayHello("Xiaoming", "nice to meet you")));
        } catch (TException e) {
            e.printStackTrace();
        }

        Thread.sleep(3000 * 1000L);
        System.exit(0);

    }
}
