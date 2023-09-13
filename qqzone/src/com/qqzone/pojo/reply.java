package com.qqzone.pojo;

import java.util.Date;

public class reply {
    private Integer id ;
    private String content ;
    private Date replyDate ;
    private userbasic author ;
    private topic topic ; //M:1
    private hostreply hostreply;

    public reply(){}
    public reply(Integer id){
        this.id=id;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public reply(String content, Date replyDate, userbasic author, topic topic) {
        this.content = content;
        this.replyDate = replyDate;
        this.author = author;
        this.topic = topic;
    }

    public Date getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(Date replyDate) {
        this.replyDate = replyDate;
    }

    public userbasic getAuthor() {
        return author;
    }

    public void setAuthor(userbasic author) {
        this.author = author;
    }

    public com.qqzone.pojo.topic getTopic() {
        return topic;
    }

    public void setTopic(com.qqzone.pojo.topic topic) {
        this.topic = topic;
    }

    public com.qqzone.pojo.hostreply getHostreply() {
        return hostreply;
    }

    public void setHostreply(com.qqzone.pojo.hostreply hostreply) {
        this.hostreply = hostreply;
    }
}
