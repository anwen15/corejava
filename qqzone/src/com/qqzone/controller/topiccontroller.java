package com.qqzone.controller;

import com.qqzone.pojo.topic;
import com.qqzone.service.replyservice;
import com.qqzone.service.topicservice;

import javax.servlet.http.HttpSession;

public class topiccontroller {
    private topicservice topicservice;
    private replyservice replyservice;

    public String topicdetail(Integer id, HttpSession session){
        topic topic = topicservice.gettopicbyid(id);
        session.setAttribute("topic",topic);
        return "frames/detail";
    }

}
