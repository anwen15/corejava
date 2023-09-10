package com.qqzone.pojo;

import java.util.Date;
import java.util.List;

public class topic {
    private Integer id ;
    private String title ;
    private String content ;
    private Date topicDate ;
    private userbasic author ;
    private List<reply> replyList;
    public topic(){}
    public topic(Integer id){
        this.id=id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTopicDate() {
        return topicDate;
    }

    public void setTopicDate(Date topicDate) {
        this.topicDate = topicDate;
    }

    public userbasic getAuthor() {
        return author;
    }

    public void setAuthor(userbasic author) {
        this.author = author;
    }

    public List<reply> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<reply> replyList) {
        this.replyList = replyList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
