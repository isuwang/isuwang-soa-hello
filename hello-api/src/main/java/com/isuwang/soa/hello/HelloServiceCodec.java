package com.isuwang.soa.hello;

import com.isuwang.soa.core.*;
import com.isuwang.soa.hello.domain.SendMessageRequest;
import com.isuwang.soa.hello.domain.SendMessageResponse;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;

public class HelloServiceCodec {

    public static class SendMessageRequestSerializer implements TBeanSerializer<SendMessageRequest> {

        @Override
        public void read(com.isuwang.soa.hello.domain.SendMessageRequest bean, TProtocol iprot) throws TException {

            org.apache.thrift.protocol.TField schemeField;
            iprot.readStructBegin();

            while (true) {
                schemeField = iprot.readFieldBegin();
                if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                    break;
                }

                switch (schemeField.id) {

                    case 1:
                        if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
                            bean.setMsgId(iprot.readI32());
                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;

                    case 2:
                        if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
                            bean.setSmsType(com.isuwang.soa.hello.enums.SmsType.findByValue(iprot.readI32()));
                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;

                    case 3:
                        if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
                            {
                                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                                bean.setMobileNos(new java.util.ArrayList<>(_list0.size));
                                for (int _i2 = 0; _i2 < _list0.size; ++_i2) {
                                    String _elem1 = iprot.readString();
                                    bean.getMobileNos().add(_elem1);
                                }
                                iprot.readListEnd();
                            }

                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;

                    case 4:
                        if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                            bean.setMsgTemplate(iprot.readString());
                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;

                    case 5:
                        if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {

                            org.apache.thrift.protocol.TMap _map3 = iprot.readMapBegin();
                            bean.setParameters(new java.util.HashMap<>(2 * _map3.size));
                            for (int _i6 = 0; _i6 < _map3.size; ++_i6) {
                                String _key4 = iprot.readString();
                                String _val5 = iprot.readString();
                                bean.getParameters().put(_key4, _val5);
                            }
                            iprot.readMapEnd();

                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;


                    default:
                        org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);

                }
                iprot.readFieldEnd();
            }
            iprot.readStructEnd();

            validate(bean);
        }

        @Override
        public void write(com.isuwang.soa.hello.domain.SendMessageRequest bean, TProtocol oprot) throws TException {

            validate(bean);
            oprot.writeStructBegin(new org.apache.thrift.protocol.TStruct("SendMessageRequest"));


            oprot.writeFieldBegin(new org.apache.thrift.protocol.TField("msgId", org.apache.thrift.protocol.TType.I32, (short) 1));
            oprot.writeI32(bean.getMsgId());
            oprot.writeFieldEnd();

            oprot.writeFieldBegin(new org.apache.thrift.protocol.TField("smsType", org.apache.thrift.protocol.TType.I32, (short) 2));
            oprot.writeI32(bean.getSmsType().getValue());
            oprot.writeFieldEnd();

            oprot.writeFieldBegin(new org.apache.thrift.protocol.TField("mobileNos", org.apache.thrift.protocol.TType.LIST, (short) 3));
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, bean.getMobileNos().size()));
            for (String item : bean.getMobileNos()) {
                oprot.writeString(item);
            }
            oprot.writeListEnd();

            oprot.writeFieldEnd();

            oprot.writeFieldBegin(new org.apache.thrift.protocol.TField("msgTemplate", org.apache.thrift.protocol.TType.STRING, (short) 4));
            oprot.writeString(bean.getMsgTemplate());
            oprot.writeFieldEnd();

            oprot.writeFieldBegin(new org.apache.thrift.protocol.TField("parameters", org.apache.thrift.protocol.TType.MAP, (short) 5));
            oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, bean.getParameters().size()));
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

    }

    public static class SendMessageResponseSerializer implements TBeanSerializer<SendMessageResponse> {

        @Override
        public void read(com.isuwang.soa.hello.domain.SendMessageResponse bean, TProtocol iprot) throws TException {

            org.apache.thrift.protocol.TField schemeField;
            iprot.readStructBegin();

            while (true) {
                schemeField = iprot.readFieldBegin();
                if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                    break;
                }

                switch (schemeField.id) {

                    case 1:
                        if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
                            bean.setStatus(iprot.readI32());
                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;

                    case 2:
                        if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                            bean.setMsg(iprot.readString());
                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;


                    default:
                        org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);

                }
                iprot.readFieldEnd();
            }
            iprot.readStructEnd();

            validate(bean);
        }

        @Override
        public void write(com.isuwang.soa.hello.domain.SendMessageResponse bean, TProtocol oprot) throws TException {

            validate(bean);
            oprot.writeStructBegin(new org.apache.thrift.protocol.TStruct("SendMessageResponse"));


            oprot.writeFieldBegin(new org.apache.thrift.protocol.TField("status", org.apache.thrift.protocol.TType.I32, (short) 1));
            oprot.writeI32(bean.getStatus());
            oprot.writeFieldEnd();

            oprot.writeFieldBegin(new org.apache.thrift.protocol.TField("msg", org.apache.thrift.protocol.TType.STRING, (short) 2));
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


    }

    public static class SayHello_argsSerializer implements TBeanSerializer<sayHello_args> {

        @Override
        public void read(sayHello_args bean, TProtocol iprot) throws TException {

            org.apache.thrift.protocol.TField schemeField;
            iprot.readStructBegin();

            while (true) {
                schemeField = iprot.readFieldBegin();
                if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                    break;
                }

                switch (schemeField.id) {

                    case 1:
                        if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                            bean.setName(iprot.readString());
                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;

                    case 2:
                        if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                            bean.setMsg(iprot.readString());
                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;


                    default:
                        org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);

                }
                iprot.readFieldEnd();
            }
            iprot.readStructEnd();

            validate(bean);
        }


        @Override
        public void write(sayHello_args bean, TProtocol oprot) throws TException {

            validate(bean);
            oprot.writeStructBegin(new org.apache.thrift.protocol.TStruct("sayHello_args"));


            oprot.writeFieldBegin(new org.apache.thrift.protocol.TField("name", org.apache.thrift.protocol.TType.STRING, (short) 1));
            oprot.writeString(bean.getName());
            oprot.writeFieldEnd();

            oprot.writeFieldBegin(new org.apache.thrift.protocol.TField("msg", org.apache.thrift.protocol.TType.STRING, (short) 2));
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

    }

    public static class SayHello_resultSerializer implements TBeanSerializer<sayHello_result> {
        @Override
        public void read(sayHello_result bean, TProtocol iprot) throws TException {

            org.apache.thrift.protocol.TField schemeField;
            iprot.readStructBegin();

            A:
            while (true) {
                schemeField = iprot.readFieldBegin();
                if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                    break;
                }

                switch (schemeField.id) {
                    case 0:  //SUCCESS
                        if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                            bean.setSuccess(iprot.readString());
                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;
                    /*
                    case 1: //ERROR
                        bean.setSoaException(new SoaException());
                        new SoaExceptionSerializer().read(bean.getSoaException(), iprot);
                        break A;
                    */
                    default:
                        org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                }
                iprot.readFieldEnd();
            }
            iprot.readStructEnd();

            validate(bean);
        }

        @Override
        public void write(sayHello_result bean, TProtocol oprot) throws TException {

            validate(bean);
            oprot.writeStructBegin(new org.apache.thrift.protocol.TStruct("sayHello_result"));

            if (bean.getSuccess() != null) {
                oprot.writeFieldBegin(new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.STRING, (short) 0));
                oprot.writeString(bean.getSuccess());
                oprot.writeFieldEnd();
            }

            oprot.writeFieldStop();
            oprot.writeStructEnd();
        }


        public void validate(sayHello_result bean) throws TException {

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
    }

    public static class SendMessage_argsSerializer implements TBeanSerializer<sendMessage_args> {

        @Override
        public void read(sendMessage_args bean, TProtocol iprot) throws TException {

            org.apache.thrift.protocol.TField schemeField;
            iprot.readStructBegin();

            while (true) {
                schemeField = iprot.readFieldBegin();
                if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                    break;
                }

                switch (schemeField.id) {

                    case 1:
                        if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {

                            bean.setRequest(new com.isuwang.soa.hello.domain.SendMessageRequest());
                            new SendMessageRequestSerializer().read(bean.getRequest(), iprot);

                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;


                    default:
                        org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);

                }
                iprot.readFieldEnd();
            }
            iprot.readStructEnd();

            validate(bean);
        }


        @Override
        public void write(sendMessage_args bean, TProtocol oprot) throws TException {

            validate(bean);
            oprot.writeStructBegin(new org.apache.thrift.protocol.TStruct("sendMessage_args"));


            oprot.writeFieldBegin(new org.apache.thrift.protocol.TField("request", org.apache.thrift.protocol.TType.STRUCT, (short) 1));
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

    }

    public static class SendMessage_resultSerializer implements TBeanSerializer<sendMessage_result> {
        @Override
        public void read(sendMessage_result bean, TProtocol iprot) throws TException {

            org.apache.thrift.protocol.TField schemeField;
            iprot.readStructBegin();

            A:
            while (true) {
                schemeField = iprot.readFieldBegin();
                if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                    break;
                }

                switch (schemeField.id) {
                    case 0:  //SUCCESS
                        if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {

                            bean.setSuccess(new com.isuwang.soa.hello.domain.SendMessageResponse());
                            new SendMessageResponseSerializer().read(bean.getSuccess(), iprot);

                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;
                    /*
                    case 1: //ERROR
                        bean.setSoaException(new SoaException());
                        new SoaExceptionSerializer().read(bean.getSoaException(), iprot);
                        break A;
                    */
                    default:
                        org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                }
                iprot.readFieldEnd();
            }
            iprot.readStructEnd();

            validate(bean);
        }

        @Override
        public void write(sendMessage_result bean, TProtocol oprot) throws TException {

            validate(bean);
            oprot.writeStructBegin(new org.apache.thrift.protocol.TStruct("sendMessage_result"));

            if (bean.getSuccess() != null) {
                oprot.writeFieldBegin(new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.STRUCT, (short) 0));
                new SendMessageResponseSerializer().write(bean.getSuccess(), oprot);
                oprot.writeFieldEnd();
            }

            oprot.writeFieldStop();
            oprot.writeStructEnd();
        }


        public void validate(sendMessage_result bean) throws TException {

            if (bean.getSuccess() != null)
                new SendMessageResponseSerializer().validate(bean.getSuccess());

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


    public static class SoaExceptionSerializer implements TBeanSerializer<SoaException> {

        @Override
        public void read(SoaException bean, TProtocol iprot) throws TException {
            org.apache.thrift.protocol.TField schemeField;
            iprot.readStructBegin();

            while (true) {
                schemeField = iprot.readFieldBegin();
                if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                    break;
                }
                switch (schemeField.id) {
                    case 1: // code
                        if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                            bean.setCode(iprot.readString());
                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;
                    case 2: // msg
                        if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                            bean.setMsg(iprot.readString());
                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;
                    default:
                        org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
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

            oprot.writeStructBegin(new org.apache.thrift.protocol.TStruct("SoaException"));
            oprot.writeFieldBegin(new org.apache.thrift.protocol.TField("code", org.apache.thrift.protocol.TType.STRING, (short) 1));
            oprot.writeString(bean.getCode());
            oprot.writeFieldEnd();

            oprot.writeFieldBegin(new org.apache.thrift.protocol.TField("msg", org.apache.thrift.protocol.TType.STRING, (short) 2));
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
    }

    public static class Processor<I extends com.isuwang.soa.hello.service.HelloService> extends SoaBaseProcessor {
        public Processor(I iface) {
            super(iface, getProcessMap(new java.util.HashMap<>()));
        }

        private static <I extends com.isuwang.soa.hello.service.HelloService> java.util.Map<String, SoaProcessFunction<I, ?, ?, ? extends TBeanSerializer<?>, ? extends TBeanSerializer<?>>> getProcessMap(java.util.Map<String, SoaProcessFunction<I, ?, ?, ? extends TBeanSerializer<?>, ? extends TBeanSerializer<?>>> processMap) {

            processMap.put("sayHello", new sayHello());

            processMap.put("sendMessage", new sendMessage());

            return processMap;
        }
    }

}
      