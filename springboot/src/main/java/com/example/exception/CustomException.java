package com.example.exception;

public class CustomException extends RuntimeException {

    private static String msg;

    public CustomException(String msg) {
        this.msg =msg;
    }

    public static String getMsg() {
        return msg;
    }

    public static void setMsg(String msg) {
        CustomException.msg = msg;
    }
}