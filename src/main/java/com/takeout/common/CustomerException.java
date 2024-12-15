package com.takeout.common;

/**
* 自定义一个运行时异常
*
*/
public class CustomerException extends RuntimeException{

    public CustomerException(String message) {

        super(message);
    }
}
