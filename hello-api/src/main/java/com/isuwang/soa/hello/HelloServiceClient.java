package com.isuwang.soa.hello;

import com.isuwang.dapeng.core.SoaException;
import com.isuwang.dapeng.remoting.BaseServiceClient;
import com.isuwang.org.apache.thrift.TException;
import com.isuwang.soa.hello.HelloServiceCodec.*;

public class HelloServiceClient extends BaseServiceClient {

    public HelloServiceClient() {
        super("com.isuwang.soa.hello.service.HelloService", "1.0.0");
    }

    @Override
    protected boolean isSoaTransactionalProcess() {
        return false;
    }


    /**
     * say hello
     **/

    public String sayHello(String name) throws SoaException {
        initContext("sayHello");

        try {
            sayHello_args sayHello_args = new sayHello_args();
            sayHello_args.setName(name);


            sayHello_result response = sendBase(sayHello_args, new sayHello_result(), new SayHello_argsSerializer(), new SayHello_resultSerializer());


            return response.getSuccess();


        } catch (SoaException e) {
            throw e;
        } catch (TException e) {
            throw new SoaException(e);
        } finally {
            destoryContext();
        }
    }


    /**
     *
     **/

    public String sayHello2(com.isuwang.soa.hello.domain.Hello hello) throws SoaException {
        initContext("sayHello2");

        try {
            sayHello2_args sayHello2_args = new sayHello2_args();
            sayHello2_args.setHello(hello);


            sayHello2_result response = sendBase(sayHello2_args, new sayHello2_result(), new SayHello2_argsSerializer(), new SayHello2_resultSerializer());


            return response.getSuccess();


        } catch (SoaException e) {
            throw e;
        } catch (TException e) {
            throw new SoaException(e);
        } finally {
            destoryContext();
        }
    }


    /**
     * getServiceMetadata
     **/
    public String getServiceMetadata() throws SoaException {
        initContext("getServiceMetadata");
        try {
            getServiceMetadata_args getServiceMetadata_args = new getServiceMetadata_args();
            getServiceMetadata_result response = sendBase(getServiceMetadata_args, new getServiceMetadata_result(), new GetServiceMetadata_argsSerializer(), new GetServiceMetadata_resultSerializer());
            return response.getSuccess();
        } catch (SoaException e) {
            throw e;
        } catch (TException e) {
            throw new SoaException(e);
        } finally {
            destoryContext();
        }
    }

}
      