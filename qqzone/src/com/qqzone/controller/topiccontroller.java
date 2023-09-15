package com.qqzone.controller;

import com.qqzone.pojo.topic;
import com.qqzone.pojo.userbasic;
import com.qqzone.service.replyservice;
import com.qqzone.service.topicservice;

import javax.servlet.http.HttpSession;
import java.util.List;

public class topiccontroller {
    private topicservice topicservice;
    private replyservice replyservice;

    public String topicdetail(Integer id, HttpSession session){
        topic topic = topicservice.gettopicbyid(id);
        session.setAttribute("topic",topic);
        return "frames/detail";
    }
    public String deltopic(Integer topicid){
        topicservice.deltopic(topicid);
        return "redirect:topic.do?operate=gettopiclist";
    }
    public String gettopiclist(HttpSession session){
        //重新查询session中的用户列表并覆盖
        userbasic userbasic = (userbasic) session.getAttribute("userbasic");
        List<topic> topicList = topicservice.getyopiclist(userbasic);
        userbasic.setTopicList(topicList);
        session.setAttribute("friend", userbasic);
        return "frames/main";
    }
}
