package com.example.player.a1610aplayerdemo.net;

//自定义一个exception，来处理token失效问题.
public class TokenException extends RuntimeException {

    public TokenException(String message) {
        super(message);
    }
}
