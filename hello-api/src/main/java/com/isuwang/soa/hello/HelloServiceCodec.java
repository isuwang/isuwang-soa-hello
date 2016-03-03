package com.isuwang.soa.hello;

import com.isuwang.soa.core.*;
import org.apache.thrift.*;
import org.apache.thrift.protocol.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Optional;

public class HelloServiceCodec {


    public static class sayHello_args {

        private String name;

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }


        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{");

            stringBuilder.append("\"").append("name").append("\":\"").append(this.name).append("\",");

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

            oprot.writeFieldStop();
            oprot.writeStructEnd();
        }


        public void validate(sayHello_args bean) throws TException {

            if (bean.getName() == null)
                throw new SoaException(SoaBaseCode.NotNull, "name字段不允许为空");

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

            result.success = iface.sayHello(args.name);

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

            processMap.put("getServiceMetadata", new getServiceMetadata());

            return processMap;
        }
    }

}
      