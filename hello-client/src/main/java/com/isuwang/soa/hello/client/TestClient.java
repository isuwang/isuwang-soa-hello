package com.isuwang.soa.hello.client;

import com.isuwang.soa.hello.HelloServiceClient;
import org.apache.thrift.TException;

/**
 * Created by tangliu on 2016/3/3.
 */
public class TestClient {


    public static void main(String[] args) {

        HelloServiceClient client = new HelloServiceClient();
        try {
            System.out.println(client.sayHello("LiLei"));
        } catch (TException e) {
            e.printStackTrace();
        }
    }
}
