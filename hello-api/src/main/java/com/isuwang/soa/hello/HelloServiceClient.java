package com.isuwang.soa.hello;

import com.isuwang.soa.hello.HelloServiceCodec.*;
import com.isuwang.soa.rpc.BaseServiceClient;
import org.apache.thrift.TException;

public class HelloServiceClient extends BaseServiceClient {

    public HelloServiceClient() {
        super("com.isuwang.soa.hello.service.HelloService", "1.0.0");
    }


    /**
     * say hello
     **/
    public String sayHello(String name, String msg) throws TException {
        initContext("sayHello");

        try {
            sayHello_args sayHello_args = new sayHello_args();
            sayHello_args.setName(name);
            sayHello_args.setMsg(msg);


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
     * send message
     **/
    public com.isuwang.soa.hello.domain.SendMessageResponse sendMessage(com.isuwang.soa.hello.domain.SendMessageRequest request) throws TException {
        initContext("sendMessage");

        try {
            sendMessage_args sendMessage_args = new sendMessage_args();
            sendMessage_args.setRequest(request);


            sendMessage_result response = sendBase(sendMessage_args, new sendMessage_result(), new SendMessage_argsSerializer(), new SendMessage_resultSerializer());

               
                    
                          /*
                          if(response.getSuccess() == null){
                            if(response.getSoaException() == null)
                            throw new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.MISSING_RESULT, "sendMessage failed: unknown result");
                            else
                            throw response.getSoaException();
                          }
                          */
            return response.getSuccess();


        } finally {
            destoryContext();
        }
    }

}
      