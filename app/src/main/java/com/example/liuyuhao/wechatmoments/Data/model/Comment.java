package com.example.liuyuhao.wechatmoments.Data.model;

public class Comment {
    //as a signal to record from whom this comment was sent
    private String from;
    //if this comment is a reply, this property will not be empty, otherwise it is null
    private String to;
    private String commentBody;

    public Comment(String from, String to, String commentBody) {
        this.from = from;
        this.to = to;
        this.commentBody = commentBody;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }
}
