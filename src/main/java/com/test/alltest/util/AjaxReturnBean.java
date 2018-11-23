package com.test.alltest.util;

public class AjaxReturnBean<T> {

    public enum Code{
        SUCCESS(0),ERROR(1);
        private int value;
        Code(int value){this.value = value;}
        int valueOf(){return this.value;}
    }

    private int code;
    private String msg;
    private T data;

    public AjaxReturnBean(){}

    public AjaxReturnBean(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public AjaxReturnBean(int code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> AjaxReturnBean createSuccess(String msg, T data){
        return new AjaxReturnBean(Code.SUCCESS.valueOf(),msg,data);
    }
    public static <T> AjaxReturnBean createError(String msg,T data){
        return new AjaxReturnBean(Code.ERROR.valueOf(),msg,data);
    }
    public static <T> AjaxReturnBean createSuccess(String msg){
        return new AjaxReturnBean(Code.SUCCESS.valueOf(),msg);
    }
    public static <T> AjaxReturnBean createError(String msg){
        return new AjaxReturnBean(Code.ERROR.valueOf(),msg);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
