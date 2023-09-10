package com.qqzone.pojo;

import java.util.List;

public class userbasic {
    private Integer id ;
    private String loginId ;
    private String nickName ;
    private String pwd ;
    private String headImg ;
    private userdetail userdetail;//1:1
    private List<topic> topicList;//1:N
    private List<userbasic> friendlist;//m:n

    public userbasic(){}

    public userbasic(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public com.qqzone.pojo.userdetail getUserdetail() {
        return userdetail;
    }

    public void setUserdetail(com.qqzone.pojo.userdetail userdetail) {
        this.userdetail = userdetail;
    }

    public List<topic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<topic> topicList) {
        this.topicList = topicList;
    }

    public List<userbasic> getFriendlist() {
        return friendlist;
    }

    public void setFriendlist(List<userbasic> friendlist) {
        this.friendlist = friendlist;
    }
}
