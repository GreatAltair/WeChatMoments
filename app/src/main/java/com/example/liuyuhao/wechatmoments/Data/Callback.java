package com.example.liuyuhao.wechatmoments.Data;

public interface Callback <T>{
    void onSuccess(T data);
    void onError(String error);
}
