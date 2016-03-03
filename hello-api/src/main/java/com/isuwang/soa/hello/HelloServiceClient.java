package com.isuwang.soa.hello;

import com.isuwang.soa.core.*;
import org.apache.thrift.*;
import com.isuwang.soa.remoting.BaseServiceClient;
import com.isuwang.soa.hello.HelloServiceCodec.*;

public class HelloServiceClient extends BaseServiceClient {

    public HelloServiceClient() {
        super("com.isuwang.soa.hello.service.HelloService", "1.0.0");
    }


    /**
     * say hello
     **/
    public String sayHello(String name) throws TException {
        initContext("sayHello");

        try {
            sayHello_args sayHello_args = new sayHello_args();
            sayHello_args.setName(name);


            sayHello_result response = sendBase(sayHello_args, new sayHello_result(), new SayHello_argsSerializer(), new SayHello_resultSerializer());

               
                    
                          /*
                          if(response.getSuccess() == null){
                            if(response.getSoaException() == null)
                            throw new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.MISSING_RESULT, "sayHello failed: unknown result");
                            else
                            throw response.getSoaException();
                          }
                          */
            return response.getSuccess();


        } finally {
            destoryContext();
        }
    }


    /**
     * getServiceMetadata
     **/
    public String getServiceMetadata() throws TException {
        initContext("getServiceMetadata");
        try {
            getServiceMetadata_args getServiceMetadata_args = new getServiceMetadata_args();
            getServiceMetadata_result response = sendBase(getServiceMetadata_args, new getServiceMetadata_result(), new GetServiceMetadata_argsSerializer(), new GetServiceMetadata_resultSerializer());
            return response.getSuccess();
        } finally {
            destoryContext();
        }
    }

}
      