package com.isuwang.soa.hello.domain;

import java.util.Optional;

/**
 *
 **/
public class Hello {

    /**
     *
     **/
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    /**
     *
     **/
    private Optional<String> message = Optional.empty();

    public Optional<String> getMessage() {
        return this.message;
    }

    public void setMessage(Optional<String> message) {
        this.message = message;
    }


    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");
        stringBuilder.append("\"").append("name").append("\":\"").append(this.name).append("\",");
        stringBuilder.append("\"").append("message").append("\":\"").append(this.message.isPresent() ? this.message.get() : null).append("\",");

        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
        stringBuilder.append("}");

        return stringBuilder.toString();
    }
}
      