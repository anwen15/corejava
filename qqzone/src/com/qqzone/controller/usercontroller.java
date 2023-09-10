package com.qqzone.controller;

import com.qqzone.pojo.topic;
import com.qqzone.pojo.userbasic;
import com.qqzone.service.topicservice;
import com.qqzone.service.userbasicservice;

import javax.servlet.http.HttpSession;
import java.util.List;

public class usercontroller  {
    private userbasicservice userbasicservice=null;
    private topicservice topicservice=null;

    public String login(String loginid, String pwd,  HttpSession session){
        userbasic userbasic = userbasicservice.login(loginid, pwd);
        if(userbasic!=null){
        List<userbasic> friendlist = userbasicservice.getfriendlist(userbasic);
        List<topic> topiclist = topicservice.getyopiclist(userbasic);

        userbasic.setFriendlist(friendlist);
        userbasic.setTopicList(topiclist);
        //userbasic保存的是登录者的信息,friend保存的是当前进入的是谁的空间
        session.setAttribute("userbasic", userbasic);
        session.setAttribute("friend",userbasic);
            return "index";
        }
        return  "login";
    }
    public String friend(Integer id,HttpSession session){
        //根据id获取指定的用户信息
        //userbasic friend = (userbasic) session.getAttribute("friend");
        userbasic currfiend = userbasicservice.getuserbasicbyid(id);
        List<topic> topicList = topicservice.getyopiclist(currfiend);
        currfiend.setTopicList(topicList);
        session.setAttribute("friend",currfiend);
        return "index";
    }
}
