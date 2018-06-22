package com.example.liuyuhao.wechatmoments.Domain;

import android.util.Log;

import com.example.liuyuhao.wechatmoments.Data.TweetModelStorage;
import com.example.liuyuhao.wechatmoments.Data.model.BaseModel;
import com.example.liuyuhao.wechatmoments.Data.model.BaseTweetModel;
import com.example.liuyuhao.wechatmoments.Data.model.Comment;
import com.example.liuyuhao.wechatmoments.Data.model.ImgListTweetModel;
import com.example.liuyuhao.wechatmoments.Data.model.TopModel;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class TweetDataLoader {
    LinkedList<BaseModel> tweets;
    TweetModelStorage storage = TweetModelStorage.getInstance();
    //    String[] uris = {"http://www.gamersky.com/showimage/id_gamersky.shtml?http://img1.gamersky.com/image2018/06/20180621_ls_141_2/gamersky_026origin_051_2018621181319E.jpg",
//    "http://www.gamersky.com/showimage/id_gamersky.shtml?http://img1.gamersky.com/image2018/06/20180621_ls_141_2/gamersky_136origin_271_20186211813DFB.jpg",
//    "http://www.gamersky.com/showimage/id_gamersky.shtml?http://img1.gamersky.com/image2018/06/20180621_ls_141_2/gamersky_040origin_079_201862118136CA.jpg",
//    "http://www.gamersky.com/showimage/id_gamersky.shtml?http://img1.gamersky.com/image2018/06/20180621_ls_141_2/gamersky_148origin_295_2018621181325B.jpg"};
    String[] uris = {"https://upload-images.jianshu.io/upload_images/1019822-b2acfd9ed6182541.png","http://mmbiz.qpic.cn/mmbiz/PwIlO51l7wuFyoFwAXfqPNETWCibjNACIt6ydN7vw8LeIwT7IjyG3eeribmK4rhibecvNKiaT2qeJRIWXLuKYPiaqtQ/0"};

    public LinkedList<BaseModel> getTweets() {
        return storage.getTweets();
    }
}
