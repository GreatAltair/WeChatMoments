package com.example.liuyuhao.wechatmoments.Data;

import com.example.liuyuhao.wechatmoments.Data.model.BaseModel;
import com.example.liuyuhao.wechatmoments.DataTest;

import java.util.LinkedList;

public class TweetModelStorage {
    private static TweetModelStorage storage;
    LinkedList<BaseModel> tweets = new LinkedList<>();//all the tweets including all kinds of tweets

    public static TweetModelStorage getInstance(){
        if (storage == null) storage = new TweetModelStorage();
        return storage;
    }

    private TweetModelStorage(){
        requestData();
    }

    //get data from SDCard storage or internet
    private void requestData(){
        DataTest test = new DataTest();
//        Gson g = new Gson();
//        JsonArray array = test.getJson();
//        for (JsonElement json : array){
//            JsonObject jsonObject = json.getAsJsonObject();
//        }
        tweets = test.getJson();
    }

    public LinkedList<BaseModel> getTweets() {
        requestData();
        return tweets;
    }
}
