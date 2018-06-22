package com.example.liuyuhao.wechatmoments.Domain;

import com.example.liuyuhao.wechatmoments.Data.model.BaseModel;
import com.example.liuyuhao.wechatmoments.Data.model.BaseTweetModel;
import com.example.liuyuhao.wechatmoments.Data.model.Comment;
import com.example.liuyuhao.wechatmoments.Data.model.ImgListTweetModel;
import com.example.liuyuhao.wechatmoments.Data.model.TopModel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class TweetDataHelper {
    LinkedList<BaseModel> tweets;
//    String[] uris = {"http://www.gamersky.com/showimage/id_gamersky.shtml?http://img1.gamersky.com/image2018/06/20180621_ls_141_2/gamersky_026origin_051_2018621181319E.jpg",
//    "http://www.gamersky.com/showimage/id_gamersky.shtml?http://img1.gamersky.com/image2018/06/20180621_ls_141_2/gamersky_136origin_271_20186211813DFB.jpg",
//    "http://www.gamersky.com/showimage/id_gamersky.shtml?http://img1.gamersky.com/image2018/06/20180621_ls_141_2/gamersky_040origin_079_201862118136CA.jpg",
//    "http://www.gamersky.com/showimage/id_gamersky.shtml?http://img1.gamersky.com/image2018/06/20180621_ls_141_2/gamersky_148origin_295_2018621181325B.jpg"};
    String[] uris = {"https://upload-images.jianshu.io/upload_images/1019822-b2acfd9ed6182541.png","http://mmbiz.qpic.cn/mmbiz/PwIlO51l7wuFyoFwAXfqPNETWCibjNACIt6ydN7vw8LeIwT7IjyG3eeribmK4rhibecvNKiaT2qeJRIWXLuKYPiaqtQ/0"};
    String[] uris1 = {
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
    public LinkedList<BaseModel> getTweets() {
        tweets = new LinkedList<>();
        TopModel top = new TopModel();
        tweets.add(top);
        for(int i = 0; i < 10; i++){
            LinkedList<String> likeList = new LinkedList<>();
            likeList.add("田甜");

            LinkedList<Comment> comments = new LinkedList<>();
            Comment comment = new Comment("田甜","","我同意");
            Comment comment2 = new Comment("刘宇豪","田甜","我也同意");
            comments.add(comment);
            comments.add(comment2);

            ArrayList<String> urls = new ArrayList<>();
            Random r = new Random();
            int k = r.nextInt(9);
            for(int j = 0; j < k+1; j++){
//                urls.add(uris[r.nextInt(15)]);
                urls.add(uris[0]);
            }
            ImgListTweetModel model = new ImgListTweetModel("刘宇豪", "","田甜是个小可爱",likeList,comments,urls);
            if((model.getContent() == null || model.getContent() == "")&&(model.getImgUrls().size()==0)) continue;
            tweets.add(model);
        }
        return tweets;
    }
}
