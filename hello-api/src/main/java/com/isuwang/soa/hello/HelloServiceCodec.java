package com.isuwang.soa.hello;

import com.isuwang.soa.core.*;
import org.apache.thrift.*;
import org.apache.thrift.protocol.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Optional;

public class HelloServiceCodec {
    public static class SendMessageRequestSerializer implements TBeanSerializer<com.isuwang.soa.hello.domain.SendMessageRequest> {

        @Override
        public void read(com.isuwang.soa.hello.domain.SendMessageRequest bean, TProtocol iprot) throws TException {

            TField schemeField;
            iprot.readStructBegin();

            while (true) {
                schemeField = iprot.readFieldBegin();
                if (schemeField.type == TType.STOP) {
                    break;
                }

                switch (schemeField.id) {

                    case 1:
                        if (schemeField.type == TType.I32) {
                            bean.setMsgId(iprot.readI32());
                        } else {
                            TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;

                    case 2:
                        if (schemeField.type == TType.I32) {
                            bean.setSmsType(com.isuwang.soa.hello.enums.SmsType.findByValue(iprot.readI32()));
                        } else {
                            TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;

                    case 3:
                        if (schemeField.type == TType.LIST) {
                            {
                                TList _list0 = iprot.readListBegin();
                                bean.setMobileNos(new java.util.ArrayList<>(_list0.size));
                                for (int _i2 = 0; _i2 < _list0.size; ++_i2) {
                                    String _elem1 = iprot.readString();
                                    bean.getMobileNos().add(_elem1);
                                }
                                iprot.readListEnd();
                            }

                        } else {
                            TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;

                    case 4:
                        if (schemeField.type == TType.STRING) {
                            bean.setMsgTemplate(iprot.readString());
                        } else {
                            TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;

                    case 5:
                        if (schemeField.type == TType.MAP) {

                            TMap _map3 = iprot.readMapBegin();
                            bean.setParameters(new java.util.HashMap<>(2 * _map3.size));
                            for (int _i6 = 0; _i6 < _map3.size; ++_i6) {
                                String _key4 = iprot.readString();
                                String _val5 = iprot.readString();
                                bean.getParameters().put(_key4, _val5);
                            }
                            iprot.readMapEnd();

                        } else {
                            TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;


                    default:
                        TProtocolUtil.skip(iprot, schemeField.type);

                }
                iprot.readFieldEnd();
            }
            iprot.readStructEnd();

            validate(bean);
        }

        @Override
        public void write(com.isuwang.soa.hello.domain.SendMessageRequest bean, TProtocol oprot) throws TException {

            validate(bean);
            oprot.writeStructBegin(new TStruct("SendMessageRequest"));


            oprot.writeFieldBegin(new TField("msgId", TType.I32, (short) 1));
            oprot.writeI32(bean.getMsgId());
            oprot.writeFieldEnd();

            oprot.writeFieldBegin(new TField("smsType", TType.I32, (short) 2));
            oprot.writeI32(bean.getSmsType().getValue());
            oprot.writeFieldEnd();

            oprot.writeFieldBegin(new TField("mobileNos", TType.LIST, (short) 3));
            oprot.writeListBegin(new TList(TType.STRING, bean.getMobileNos().size()));
            for (String item : bean.getMobileNos()) {
                oprot.writeString(item);
            }
            oprot.writeListEnd();

            oprot.writeFieldEnd();

            oprot.writeFieldBegin(new TField("msgTemplate", TType.STRING, (short) 4));
            oprot.writeString(bean.getMsgTemplate());
            oprot.writeFieldEnd();

            oprot.writeFieldBegin(new TField("parameters", TType.MAP, (short) 5));
            oprot.writeMapBegin(new TMap(TType.STRING, TType.STRING, bean.getParameters().size()));
            for (java.util.Map.Entry<String, String> item : bean.getParameters().entrySet()) {
                oprot.writeString(item.getKey());
                oprot.writeString(item.getValue());
            }
            oprot.writeMapEnd();

            oprot.writeFieldEnd();

            oprot.writeFieldStop();
            oprot.writeStructEnd();
        }

        public void validate(com.isuwang.soa.hello.domain.SendMessageRequest bean) throws TException {

            if (bean.getMsgId() == null)
                throw new SoaException(SoaBaseCode.NotNull, "msgId字段不允许为空");

            if (bean.getSmsType() == null)
                throw new SoaException(SoaBaseCode.NotNull, "smsType字段不允许为空");

            if (bean.getMobileNos() == null)
                throw new SoaException(SoaBaseCode.NotNull, "mobileNos字段不允许为空");

            if (bean.getMsgTemplate() == null)
                throw new SoaException(SoaBaseCode.NotNull, "msgTemplate字段不允许为空");

            if (bean.getParameters() == null)
                throw new SoaException(SoaBaseCode.NotNull, "parameters字段不允许为空");

        }

        @Override
        public String toString(com.isuwang.soa.hello.domain.SendMessageRequest bean) {
            return bean == null ? "null" : bean.toString();
        }
    }

    public static class SendMessageResponseSerializer implements TBeanSerializer<com.isuwang.soa.hello.domain.SendMessageResponse> {

        @Override
        public void read(com.isuwang.soa.hello.domain.SendMessageResponse bean, TProtocol iprot) throws TException {

            TField schemeField;
            iprot.readStructBegin();

            while (true) {
                schemeField = iprot.readFieldBegin();
                if (schemeField.type == TType.STOP) {
                    break;
                }

                switch (schemeField.id) {

                    case 1:
                        if (schemeField.type == TType.I32) {
                            bean.setStatus(iprot.readI32());
                        } else {
                            TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;

                    case 2:
                        if (schemeField.type == TType.STRING) {
                            bean.setMsg(iprot.readString());
                        } else {
                            TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;


                    default:
                        TProtocolUtil.skip(iprot, schemeField.type);

                }
                iprot.readFieldEnd();
            }
            iprot.readStructEnd();

            validate(bean);
        }

        @Override
        public void write(com.isuwang.soa.hello.domain.SendMessageResponse bean, TProtocol oprot) throws TException {

            validate(bean);
            oprot.writeStructBegin(new TStruct("SendMessageResponse"));


            oprot.writeFieldBegin(new TField("status", TType.I32, (short) 1));
            oprot.writeI32(bean.getStatus());
            oprot.writeFieldEnd();

            oprot.writeFieldBegin(new TField("msg", TType.STRING, (short) 2));
            oprot.writeString(bean.getMsg());
            oprot.writeFieldEnd();

            oprot.writeFieldStop();
            oprot.writeStructEnd();
        }

        public void validate(com.isuwang.soa.hello.domain.SendMessageResponse bean) throws TException {

            if (bean.getStatus() == null)
                throw new SoaException(SoaBaseCode.NotNull, "status字段不允许为空");

            if (bean.getMsg() == null)
                throw new SoaException(SoaBaseCode.NotNull, "msg字段不允许为空");

        }

        @Override
        public String toString(com.isuwang.soa.hello.domain.SendMessageResponse bean) {
            return bean == null ? "null" : bean.toString();
        }
    }


    public static class sayHello_args {

        private String name;

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private String msg;

        public String getMsg() {
            return this.msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }


        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{");

            stringBuilder.append("\"").append("name").append("\":\"").append(this.name).append("\",");

            stringBuilder.append("\"").append("msg").append("\":\"").append(this.msg).append("\",");

            if (stringBuilder.lastIndexOf(",") > 0)
                stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
            stringBuilder.append("}");

            return stringBuilder.toString();
        }

    }


    public static class sayHello_result {

              /*
              private SoaException soaException;

              public SoaException getSoaException(){
                return soaException;
              }

              public void setSoaException(SoaException soaException){
                this.soaException = soaException;
              }
              */


        private String success;

        public String getSuccess() {
            return success;
        }

        public void setSuccess(String success) {
            this.success = success;
        }


        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{");

            stringBuilder.append("\"").append("success").append("\":\"").append(this.success).append("\",");

            stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
            stringBuilder.append("}");

            return stringBuilder.toString();
        }

    }

    public static class SayHello_argsSerializer implements TBeanSerializer<sayHello_args> {

        @Override
        public void read(sayHello_args bean, TProtocol iprot) throws TException {

            TField schemeField;
            iprot.readStructBegin();

            while (true) {
                schemeField = iprot.readFieldBegin();
                if (schemeField.type == TType.STOP) {
                    break;
                }

                switch (schemeField.id) {

                    case 1:
                        if (schemeField.type == TType.STRING) {
                            bean.setName(iprot.readString());
                        } else {
                            TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;

                    case 2:
                        if (schemeField.type == TType.STRING) {
                            bean.setMsg(iprot.readString());
                        } else {
                            TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;


                    default:
                        TProtocolUtil.skip(iprot, schemeField.type);

                }
                iprot.readFieldEnd();
            }
            iprot.readStructEnd();

            validate(bean);
        }


        @Override
        public void write(sayHello_args bean, TProtocol oprot) throws TException {

            validate(bean);
            oprot.writeStructBegin(new TStruct("sayHello_args"));


            oprot.writeFieldBegin(new TField("name", TType.STRING, (short) 1));
            oprot.writeString(bean.getName());
            oprot.writeFieldEnd();

            oprot.writeFieldBegin(new TField("msg", TType.STRING, (short) 2));
            oprot.writeString(bean.getMsg());
            oprot.writeFieldEnd();

            oprot.writeFieldStop();
            oprot.writeStructEnd();
        }


        public void validate(sayHello_args bean) throws TException {

            if (bean.getName() == null)
                throw new SoaException(SoaBaseCode.NotNull, "name字段不允许为空");

            if (bean.getMsg() == null)
                throw new SoaException(SoaBaseCode.NotNull, "msg字段不允许为空");

        }


        @Override
        public String toString(sayHello_args bean) {
            return bean == null ? "null" : bean.toString();
        }

    }

    public static class SayHello_resultSerializer implements TBeanSerializer<sayHello_result> {
        @Override
        public void read(sayHello_result bean, TProtocol iprot) throws TException {

            TField schemeField;
            iprot.readStructBegin();

            while (true) {
                schemeField = iprot.readFieldBegin();
                if (schemeField.type == TType.STOP) {
                    break;
                }

                switch (schemeField.id) {
                    case 0:  //SUCCESS
                        if (schemeField.type == TType.STRING) {
                            bean.setSuccess(iprot.readString());
                        } else {
                            TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;
                    /*
                    case 1: //ERROR
                        bean.setSoaException(new SoaException());
                        new SoaExceptionSerializer().read(bean.getSoaException(), iprot);
                        break A;
                    */
                    default:
                        TProtocolUtil.skip(iprot, schemeField.type);
                }
                iprot.readFieldEnd();
            }
            iprot.readStructEnd();

            validate(bean);
        }

        @Override
        public void write(sayHello_result bean, TProtocol oprot) throws TException {

            validate(bean);
            oprot.writeStructBegin(new TStruct("sayHello_result"));


            oprot.writeFieldBegin(new TField("success", TType.STRING, (short) 0));
            oprot.writeString(bean.getSuccess());
            oprot.writeFieldEnd();

            oprot.writeFieldStop();
            oprot.writeStructEnd();
        }


        public void validate(sayHello_result bean) throws TException {

            if (bean.getSuccess() == null)
                throw new SoaException(SoaBaseCode.NotNull, "success字段不允许为空");

        }


        @Override
        public String toString(sayHello_result bean) {
            return bean == null ? "null" : bean.toString();
        }
    }

    public static class sayHello<I extends com.isuwang.soa.hello.service.HelloService> extends SoaProcessFunction<I, sayHello_args, sayHello_result, SayHello_argsSerializer, SayHello_resultSerializer> {
        public sayHello() {
            super("sayHello", new SayHello_argsSerializer(), new SayHello_resultSerializer());
        }

        @Override
        public sayHello_result getResult(I iface, sayHello_args args) throws TException {
            sayHello_result result = new sayHello_result();

            result.success = iface.sayHello(args.name, args.msg);

            return result;
        }

        @Override
        public sayHello_args getEmptyArgsInstance() {
            return new sayHello_args();
        }

        @Override
        protected boolean isOneway() {
            return false;
        }
    }

    public static class sendMessage_args {

        private com.isuwang.soa.hello.domain.SendMessageRequest request;

        public com.isuwang.soa.hello.domain.SendMessageRequest getRequest() {
            return this.request;
        }

        public void setRequest(com.isuwang.soa.hello.domain.SendMessageRequest request) {
            this.request = request;
        }


        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{");

            stringBuilder.append("\"").append("request").append("\":").append(this.request.toString()).append(",");

            if (stringBuilder.lastIndexOf(",") > 0)
                stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
            stringBuilder.append("}");

            return stringBuilder.toString();
        }

    }


    public static class sendMessage_result {

              /*
              private SoaException soaException;

              public SoaException getSoaException(){
                return soaException;
              }

              public void setSoaException(SoaException soaException){
                this.soaException = soaException;
              }
              */


        private com.isuwang.soa.hello.domain.SendMessageResponse success;

        public com.isuwang.soa.hello.domain.SendMessageResponse getSuccess() {
            return success;
        }

        public void setSuccess(com.isuwang.soa.hello.domain.SendMessageResponse success) {
            this.success = success;
        }


        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{");

            stringBuilder.append("\"").append("success").append("\":").append(this.success.toString()).append(",");

            stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
            stringBuilder.append("}");

            return stringBuilder.toString();
        }

    }

    public static class SendMessage_argsSerializer implements TBeanSerializer<sendMessage_args> {

        @Override
        public void read(sendMessage_args bean, TProtocol iprot) throws TException {

            TField schemeField;
            iprot.readStructBegin();

            while (true) {
                schemeField = iprot.readFieldBegin();
                if (schemeField.type == TType.STOP) {
                    break;
                }

                switch (schemeField.id) {

                    case 1:
                        if (schemeField.type == TType.STRUCT) {

                            bean.setRequest(new com.isuwang.soa.hello.domain.SendMessageRequest());
                            new SendMessageRequestSerializer().read(bean.getRequest(), iprot);

                        } else {
                            TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;


                    default:
                        TProtocolUtil.skip(iprot, schemeField.type);

                }
                iprot.readFieldEnd();
            }
            iprot.readStructEnd();

            validate(bean);
        }


        @Override
        public void write(sendMessage_args bean, TProtocol oprot) throws TException {

            validate(bean);
            oprot.writeStructBegin(new TStruct("sendMessage_args"));


            oprot.writeFieldBegin(new TField("request", TType.STRUCT, (short) 1));
            new SendMessageRequestSerializer().write(bean.getRequest(), oprot);
            oprot.writeFieldEnd();

            oprot.writeFieldStop();
            oprot.writeStructEnd();
        }


        public void validate(sendMessage_args bean) throws TException {

            if (bean.getRequest() == null)
                throw new SoaException(SoaBaseCode.NotNull, "request字段不允许为空");

            if (bean.getRequest() != null)
                new SendMessageRequestSerializer().validate(bean.getRequest());

        }


        @Override
        public String toString(sendMessage_args bean) {
            return bean == null ? "null" : bean.toString();
        }

    }

    public static class SendMessage_resultSerializer implements TBeanSerializer<sendMessage_result> {
        @Override
        public void read(sendMessage_result bean, TProtocol iprot) throws TException {

            TField schemeField;
            iprot.readStructBegin();

            while (true) {
                schemeField = iprot.readFieldBegin();
                if (schemeField.type == TType.STOP) {
                    break;
                }

                switch (schemeField.id) {
                    case 0:  //SUCCESS
                        if (schemeField.type == TType.STRUCT) {

                            bean.setSuccess(new com.isuwang.soa.hello.domain.SendMessageResponse());
                            new SendMessageResponseSerializer().read(bean.getSuccess(), iprot);

                        } else {
                            TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;
                    /*
                    case 1: //ERROR
                        bean.setSoaException(new SoaException());
                        new SoaExceptionSerializer().read(bean.getSoaException(), iprot);
                        break A;
                    */
                    default:
                        TProtocolUtil.skip(iprot, schemeField.type);
                }
                iprot.readFieldEnd();
            }
            iprot.readStructEnd();

            validate(bean);
        }

        @Override
        public void write(sendMessage_result bean, TProtocol oprot) throws TException {

            validate(bean);
            oprot.writeStructBegin(new TStruct("sendMessage_result"));


            oprot.writeFieldBegin(new TField("success", TType.STRUCT, (short) 0));
            new SendMessageResponseSerializer().write(bean.getSuccess(), oprot);
            oprot.writeFieldEnd();

            oprot.writeFieldStop();
            oprot.writeStructEnd();
        }


        public void validate(sendMessage_result bean) throws TException {

            if (bean.getSuccess() == null)
                throw new SoaException(SoaBaseCode.NotNull, "success字段不允许为空");

            if (bean.getSuccess() != null)
                new SendMessageResponseSerializer().validate(bean.getSuccess());

        }


        @Override
        public String toString(sendMessage_result bean) {
            return bean == null ? "null" : bean.toString();
        }
    }

    public static class sendMessage<I extends com.isuwang.soa.hello.service.HelloService> extends SoaProcessFunction<I, sendMessage_args, sendMessage_result, SendMessage_argsSerializer, SendMessage_resultSerializer> {
        public sendMessage() {
            super("sendMessage", new SendMessage_argsSerializer(), new SendMessage_resultSerializer());
        }

        @Override
        public sendMessage_result getResult(I iface, sendMessage_args args) throws TException {
            sendMessage_result result = new sendMessage_result();

            result.success = iface.sendMessage(args.request);

            return result;
        }

        @Override
        public sendMessage_args getEmptyArgsInstance() {
            return new sendMessage_args();
        }

        @Override
        protected boolean isOneway() {
            return false;
        }
    }


    public static class getServiceMetadata_args {

        @Override
        public String toString() {
            return "{}";
        }
    }


    public static class getServiceMetadata_result {

        private String success;

        public String getSuccess() {
            return success;
        }

        public void setSuccess(String success) {
            this.success = success;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{");
            stringBuilder.append("\"").append("success").append("\":\"").append(this.success).append("\",");
            stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
            stringBuilder.append("}");

            return stringBuilder.toString();
        }
    }

    public static class GetServiceMetadata_argsSerializer implements TBeanSerializer<getServiceMetadata_args> {

        @Override
        public void read(getServiceMetadata_args bean, TProtocol iprot) throws TException {

            TField schemeField;
            iprot.readStructBegin();

            while (true) {
                schemeField = iprot.readFieldBegin();
                if (schemeField.type == TType.STOP) {
                    break;
                }
                switch (schemeField.id) {
                    default:
                        TProtocolUtil.skip(iprot, schemeField.type);

                }
                iprot.readFieldEnd();
            }
            iprot.readStructEnd();

            validate(bean);
        }


        @Override
        public void write(getServiceMetadata_args bean, TProtocol oprot) throws TException {

            validate(bean);
            oprot.writeStructBegin(new TStruct("getServiceMetadata_args"));
            oprot.writeFieldStop();
            oprot.writeStructEnd();
        }

        public void validate(getServiceMetadata_args bean) throws TException {
        }

        @Override
        public String toString(getServiceMetadata_args bean) {
            return bean == null ? "null" : bean.toString();
        }

    }

    public static class GetServiceMetadata_resultSerializer implements TBeanSerializer<getServiceMetadata_result> {
        @Override
        public void read(getServiceMetadata_result bean, TProtocol iprot) throws TException {

            TField schemeField;
            iprot.readStructBegin();

            while (true) {
                schemeField = iprot.readFieldBegin();
                if (schemeField.type == TType.STOP) {
                    break;
                }

                switch (schemeField.id) {
                    case 0:  //SUCCESS
                        if (schemeField.type == TType.STRING) {
                            bean.setSuccess(iprot.readString());
                        } else {
                            TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;
                    default:
                        TProtocolUtil.skip(iprot, schemeField.type);
                }
                iprot.readFieldEnd();
            }
            iprot.readStructEnd();

            validate(bean);
        }

        @Override
        public void write(getServiceMetadata_result bean, TProtocol oprot) throws TException {

            validate(bean);
            oprot.writeStructBegin(new TStruct("getServiceMetadata_result"));

            oprot.writeFieldBegin(new TField("success", TType.STRING, (short) 0));
            oprot.writeString(bean.getSuccess());
            oprot.writeFieldEnd();

            oprot.writeFieldStop();
            oprot.writeStructEnd();
        }

        public void validate(getServiceMetadata_result bean) throws TException {

            if (bean.getSuccess() == null)
                throw new SoaException(SoaBaseCode.NotNull, "success字段不允许为空");
        }

        @Override
        public String toString(getServiceMetadata_result bean) {
            return bean == null ? "null" : bean.toString();
        }
    }

    public static class getServiceMetadata<I extends com.isuwang.soa.hello.service.HelloService> extends SoaProcessFunction<I, getServiceMetadata_args, getServiceMetadata_result, GetServiceMetadata_argsSerializer, GetServiceMetadata_resultSerializer> {
        public getServiceMetadata() {
            super("getServiceMetadata", new GetServiceMetadata_argsSerializer(), new GetServiceMetadata_resultSerializer());
        }

        @Override
        public getServiceMetadata_result getResult(I iface, getServiceMetadata_args args) throws TException {
            getServiceMetadata_result result = new getServiceMetadata_result();

            try (InputStreamReader isr = new InputStreamReader(HelloServiceCodec.class.getClassLoader().getResourceAsStream("com.isuwang.soa.hello.service.HelloService.xml"));
                 BufferedReader in = new BufferedReader(isr)) {
                int len = 0;
                StringBuffer str = new StringBuffer("");
                String line;
                while ((line = in.readLine()) != null) {

                    if (len != 0) {
                        str.append("\r\n" + line);
                    } else {
                        str.append(line);
                    }
                    len++;
                }
                result.success = str.toString();

            } catch (Exception e) {
                e.printStackTrace();
                result.success = "";
            }

            return result;
        }

        @Override
        public getServiceMetadata_args getEmptyArgsInstance() {
            return new getServiceMetadata_args();
        }

        @Override
        protected boolean isOneway() {
            return false;
        }
    }


    public static class SoaExceptionSerializer implements TBeanSerializer<SoaException> {

        @Override
        public void read(SoaException bean, TProtocol iprot) throws TException {
            TField schemeField;
            iprot.readStructBegin();

            while (true) {
                schemeField = iprot.readFieldBegin();
                if (schemeField.type == TType.STOP) {
                    break;
                }
                switch (schemeField.id) {
                    case 1: // code
                        if (schemeField.type == TType.STRING) {
                            bean.setCode(iprot.readString());
                        } else {
                            TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;
                    case 2: // msg
                        if (schemeField.type == TType.STRING) {
                            bean.setMsg(iprot.readString());
                        } else {
                            TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;
                    default:
                        TProtocolUtil.skip(iprot, schemeField.type);
                }
                iprot.readFieldEnd();
            }
            iprot.readStructEnd();

            // check for required fields of primitive type, which can't be checked in the validate method
            validate(bean);
        }


        @Override
        public void write(SoaException bean, TProtocol oprot) throws TException {
            validate(bean);

            oprot.writeStructBegin(new TStruct("SoaException"));
            oprot.writeFieldBegin(new TField("code", TType.STRING, (short) 1));
            oprot.writeString(bean.getCode());
            oprot.writeFieldEnd();

            oprot.writeFieldBegin(new TField("msg", TType.STRING, (short) 2));
            oprot.writeString(bean.getMsg());
            oprot.writeFieldEnd();

            oprot.writeFieldStop();
            oprot.writeStructEnd();
        }

        @Override
        public void validate(SoaException bean) throws TException {
            if (bean.getCode() == null)
                throw new SoaException(SoaBaseCode.NotNull, "code字段不允许为空");

            if (bean.getMsg() == null)
                throw new SoaException(SoaBaseCode.NotNull, "msg字段不允许为空");
        }

        @Override
        public String toString(SoaException bean) {
            return bean == null ? "null" : bean.toString();
        }

    }

    public static class Processor<I extends com.isuwang.soa.hello.service.HelloService> extends SoaBaseProcessor {
        public Processor(I iface) {
            super(iface, getProcessMap(new java.util.HashMap<>()));
        }

        private static <I extends com.isuwang.soa.hello.service.HelloService> java.util.Map<String, SoaProcessFunction<I, ?, ?, ? extends TBeanSerializer<?>, ? extends TBeanSerializer<?>>> getProcessMap(java.util.Map<String, SoaProcessFunction<I, ?, ?, ? extends TBeanSerializer<?>, ? extends TBeanSerializer<?>>> processMap) {

            processMap.put("sayHello", new sayHello());

            processMap.put("sendMessage", new sendMessage());

            processMap.put("getServiceMetadata", new getServiceMetadata());

            return processMap;
        }
    }

}
      