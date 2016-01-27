package com.isuwang.soa.hello.enums;

/**
 * Created by tangliu on 2016/1/11.
 */
public enum SmsType {

    test(0),

    production(1);

    private final int value;

    private SmsType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static SmsType findByValue(int value) {
        switch (value) {
            case 0:
                return test;
            case 1:
                return production;
            default:
                return null;
        }
    }
}
