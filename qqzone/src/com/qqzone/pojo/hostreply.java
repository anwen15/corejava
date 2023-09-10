package com.qqzone.pojo;

import java.util.Date;

public class hostreply {
    private Integer id ;
    private String content ;
    private Date hostReplyDate ;
    private userbasic author ; //M:1
    private reply reply ;

    public hostreply(Integer id) {
        this.id = id;
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

    public Date getHostReplyDate() {
        return hostReplyDate;
    }

    public void setHostReplyDate(Date hostReplyDate) {
        this.hostReplyDate = hostReplyDate;
    }

    public userbasic getAuthor() {
        return author;
    }

    public void setAuthor(userbasic author) {
        this.author = author;
    }

    public com.qqzone.pojo.reply getReply() {
        return reply;
    }

    public void setReply(com.qqzone.pojo.reply reply) {
        this.reply = reply;
    }

    public hostreply(){}
}
