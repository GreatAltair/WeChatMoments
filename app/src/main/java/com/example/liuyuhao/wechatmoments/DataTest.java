package com.example.liuyuhao.wechatmoments;

import com.example.liuyuhao.wechatmoments.Data.model.BaseModel;
import com.example.liuyuhao.wechatmoments.Data.model.Comment;
import com.example.liuyuhao.wechatmoments.Data.model.ImgListTweetModel;
import com.example.liuyuhao.wechatmoments.Data.model.TopModel;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class DataTest {
    String[] uris = {
            "http://img.my.csdn.net/uploads/201508/05/1438760758_3497.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760758_6667.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760757_3588.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760756_3304.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760755_6715.jpeg",
            "http://img.my.csdn.net/uploads/201508/05/1438760726_5120.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760726_8364.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760725_4031.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760724_9463.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760724_2371.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760707_4653.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760706_6864.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760706_9279.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760704_2341.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760704_5707.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760685_5091.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760685_4444.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760684_8827.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760683_3691.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760683_7315.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760663_7318.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760662_3454.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760662_5113.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760661_3305.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760661_7416.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760589_2946.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760589_1100.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760588_8297.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760587_2575.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760587_8906.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760550_2875.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760550_9517.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760549_7093.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760549_1352.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760548_2780.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760531_1776.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760531_1380.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760530_4944.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760530_5750.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760529_3289.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760500_7871.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760500_6063.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760499_6304.jpeg",
            "http://img.my.csdn.net/uploads/201508/05/1438760499_5081.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760498_7007.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760478_3128.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760478_6766.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760477_1358.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760477_3540.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760476_1240.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760446_7993.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760446_3641.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760445_3283.jpg"
    };

    String[] froms = {"张三","李文礼","秦宁","唐波","田甜","付荣亮","武星宇","陈天城","王伟","张浩洋"};
    String[] tos = {"田甜","付荣亮","","陈天城","王伟","张浩洋","张三","李文礼","秦宁","唐波"};
    String[] bodys = {"我同意","哈哈哈哈哈嗝","666","测试数据","也是测试数据","这还是测试数据"};
    public LinkedList<BaseModel> getJson(){
        LinkedList<BaseModel> tweets = new LinkedList<>();
        //必须在第一项放置topCell
        TopModel top = new TopModel();
        tweets.add(top);

        Gson gson = new Gson();
        Random r = new Random();
        for (int i = 0; i < 10; i++){
            LinkedList<String> likeList = new LinkedList<>();
            int likeCount = r.nextInt(10);
            for (int j = 0; j < likeCount; j++){
                likeList.add(froms[j]);
            }

            int commentCount = r.nextInt(5);
            LinkedList<Comment> comments = new LinkedList<>();
            for(int j = 0; j < commentCount; j++){
                Comment comment = new Comment(froms[r.nextInt(10)],tos[r.nextInt(10)],bodys[r.nextInt(6)]);
                comments.add(comment);
            }

            ArrayList<String> urls = new ArrayList<>();
            int k = r.nextInt(9);
            for(int j = 0; j < k+1; j++){
                urls.add(uris[r.nextInt(9)+1]);
            }
            ImgListTweetModel model = new ImgListTweetModel(froms[r.nextInt(10)], "","HelloWorld",likeList,comments,urls);
            tweets.add(model);
        }

        return tweets;
    }
}
