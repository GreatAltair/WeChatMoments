package com.example.liuyuhao.wechatmoments.Data.model;

import java.util.LinkedList;

public class BaseTweetModel extends BaseModel{
    private String likename;//the user's name of this tweet
    private String iconUrl;
    private String content;//tweet's context;
    private LinkedList<String> likeList;//the users' list which contains all friends like this tweet
    private LinkedList<Comment> comments;//the comments of this tweet

    public BaseTweetModel(String likename, String iconUrl, String content, LinkedList<String> likeList, LinkedList<Comment> comments) {
        this.likename = likename;
        this.content = content;
        this.iconUrl = iconUrl;
        this.likeList = likeList;
        this.comments = comments;
    }

    public String getLikename() {
        return likename;
    }

    public void setLikename(String likename) {
        this.likename = likename;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LinkedList<String> getLikeList() {
        return likeList;
    }

    public void setLikeList(LinkedList<String> likeList) {
        this.likeList = likeList;
    }

    public LinkedList<Comment> getComments() {
        return comments;
    }

    public void setComments(LinkedList<Comment> comments) {
        this.comments = comments;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
}
