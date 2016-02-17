package com.isuwang.soa.hello;

import com.isuwang.soa.core.*;
import org.apache.thrift.*;
import com.isuwang.soa.rpc.BaseServiceClient;
import com.isuwang.soa.hello.HelloServiceCodec.*;

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


    public String getServiceMetadata() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><service namespace=\"com.isuwang.soa.hello.service\" name=\"HelloService\">    <doc> Hello Service</doc>    <meta>        <version>1.0.0</version>        <timeout>30000</timeout>    </meta>    <methods>        <method name=\"sayHello\">            <doc> say hello</doc>            <request name=\"sayHello_args\">                <fields>                    <field tag=\"1\" name=\"name\" optional=\"false\" privacy=\"false\">                        <dataType>                            <kind>STRING</kind>                        </dataType>                        <doc></doc>                    </field>                    <field tag=\"2\" name=\"msg\" optional=\"false\" privacy=\"false\">                        <dataType>                            <kind>STRING</kind>                        </dataType>                        <doc></doc>                    </field>                </fields>            </request>            <response name=\"sayHello_result\">                <fields>                    <field tag=\"0\" name=\"success\" optional=\"true\" privacy=\"false\">                        <dataType>                            <kind>STRING</kind>                        </dataType>                        <doc></doc>                    </field>                </fields>            </response>        </method>        <method name=\"sendMessage\">            <doc> send message</doc>            <request name=\"sendMessage_args\">                <fields>                    <field tag=\"1\" name=\"request\" optional=\"false\" privacy=\"false\">                        <dataType>                            <kind>STRUCT</kind>                            <ref>com.isuwang.soa.hello.domain.SendMessageRequest</ref>                        </dataType>                        <doc></doc>                    </field>                </fields>            </request>            <response name=\"sendMessage_result\">                <fields>                    <field tag=\"0\" name=\"success\" optional=\"true\" privacy=\"false\">                        <dataType>                            <kind>STRUCT</kind>                            <ref>com.isuwang.soa.hello.domain.SendMessageResponse</ref>                        </dataType>                        <doc></doc>                    </field>                </fields>            </response>        </method>    </methods>    <structs>        <struct namespace=\"com.isuwang.soa.hello.domain\" name=\"SendMessageRequest\">            <doc> 发送信息请求包</doc>            <fields>                <field tag=\"1\" name=\"msgId\" optional=\"false\" privacy=\"false\">                    <dataType>                        <kind>INTEGER</kind>                    </dataType>                    <doc> 短信编号</doc>                </field>                <field tag=\"2\" name=\"smsType\" optional=\"false\" privacy=\"false\">                    <dataType>                        <kind>ENUM</kind>                        <ref>com.isuwang.soa.hello.enums.SmsType</ref>                    </dataType>                    <doc> 短信类型</doc>                </field>                <field tag=\"3\" name=\"mobileNos\" optional=\"false\" privacy=\"false\">                    <dataType>                        <kind>LIST</kind>                        <valueType>                            <kind>STRING</kind>                        </valueType>                    </dataType>                    <doc> 手机号码</doc>                </field>                <field tag=\"4\" name=\"msgTemplate\" optional=\"false\" privacy=\"false\">                    <dataType>                        <kind>STRING</kind>                    </dataType>                    <doc> 信息模板</doc>                </field>                <field tag=\"5\" name=\"parameters\" optional=\"false\" privacy=\"false\">                    <dataType>                        <kind>MAP</kind>                        <keyType>                            <kind>STRING</kind>                        </keyType>                        <valueType>                            <kind>STRING</kind>                        </valueType>                    </dataType>                    <doc> 模板参数值</doc>                </field>            </fields>        </struct>        <struct namespace=\"com.isuwang.soa.hello.domain\" name=\"SendMessageResponse\">            <doc> 发送信息返回包</doc>            <fields>                <field tag=\"1\" name=\"status\" optional=\"false\" privacy=\"false\">                    <dataType>                        <kind>INTEGER</kind>                    </dataType>                    <doc> 状态</doc>                </field>                <field tag=\"2\" name=\"msg\" optional=\"false\" privacy=\"false\">                    <dataType>                        <kind>STRING</kind>                    </dataType>                    <doc> 信息</doc>                </field>            </fields>        </struct>    </structs>    <enums>        <tenum namespace=\"com.isuwang.soa.hello.enums\" name=\"SmsType\">            <items>                <item>                    <label>test</label>                    <value>0</value>                </item>                <item>                    <label>production</label>                    <value>1</value>                </item>            </items>        </tenum>    </enums></service>";
    }

}
      