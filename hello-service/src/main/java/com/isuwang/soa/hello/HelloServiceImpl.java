package com.isuwang.soa.hello;

import com.isuwang.soa.core.SoaException;
import com.isuwang.soa.hello.domain.SendMessageRequest;
import com.isuwang.soa.hello.domain.SendMessageResponse;
import com.isuwang.soa.hello.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

/**
 * Created by tangliu on 2016/1/12.
 */
public class HelloServiceImpl implements HelloService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public String sayHello(String name, String msg) throws SoaException {
        LOGGER.info(name + "," + msg);

        return "nice to meet you too, " + name;
    }

    @Override
    public SendMessageResponse sendMessage(SendMessageRequest request) throws SoaException {
        Set<String> keys = request.getParameters().keySet();
        for (String key : keys) {
            request.setMsgTemplate(request.getMsgTemplate().replace(key, request.getParameters().get(key)));
        }

        request.getMobileNos().stream()
                .map(mobileNo -> (mobileNo + ":(" + request.getSmsType().name() + ")" + request.getMsgTemplate()))
                .forEach(msg -> LOGGER.info(msg));

        SendMessageResponse response = new SendMessageResponse();
        response.setStatus(1);
        response.setMsg("message received");

        return response;
    }
}
