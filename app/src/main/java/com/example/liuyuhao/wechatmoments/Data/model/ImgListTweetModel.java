package com.example.liuyuhao.wechatmoments.Data.model;

import com.example.liuyuhao.wechatmoments.Presentation.Views.TweetCell.ImgListCell;

import java.util.ArrayList;
import java.util.LinkedList;

public class ImgListTweetModel extends BaseTweetModel{
    private ArrayList<String> imgUrls;//the images' urls
    public static final Class cellClass = ImgListCell.class;//correspond the cell's class with the model

    public ImgListTweetModel(String likename, String url, String content, LinkedList<String> likeList, LinkedList<Comment> comments, ArrayList<String>imgUrls){
        super(likename, url, content, likeList, comments);
        this.imgUrls = imgUrls;
    }

    public ArrayList<String> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(ArrayList<String> imgUrls) {
        this.imgUrls = imgUrls;
    }
}
