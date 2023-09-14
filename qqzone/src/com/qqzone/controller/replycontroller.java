package com.qqzone.controller;

import com.qqzone.pojo.reply;
import com.qqzone.pojo.topic;
import com.qqzone.pojo.userbasic;
import com.qqzone.service.replyservice;

import javax.servlet.http.HttpSession;
import java.util.Date;
public class replycontroller {

    private replyservice replyservice;

    public String addreply(String content,Integer topicid,HttpSession session){
        userbasic userbasic = (userbasic) session.getAttribute("friend");
        reply reply=new reply(content,new Date(), userbasic,new topic(topicid));
        replyservice.addreply(reply);
        return "redirect:topic.do?operate=topicdetail&id="+topicid;
    }
    public String delreply(Integer replyId , Integer topicId){
        replyservice.delreply(replyId);
        return "redirect:topic.do?operate=topicdetail&id="+topicId;
    }
}
