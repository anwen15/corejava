package com.qqzone.service.impl;

import com.qqzone.dao.topicdao;
import com.qqzone.pojo.reply;
import com.qqzone.pojo.topic;
import com.qqzone.pojo.userbasic;
import com.qqzone.service.replyservice;
import com.qqzone.service.topicservice;

import java.util.List;

public class topicserviceimpl implements topicservice {
    private topicdao topicdao=null;
    private replyservice replyservice;
    @Override
    public List<topic> getyopiclist(userbasic userbasic) {
        //
        return topicdao.gettopiclist(userbasic);
    }

    @Override
    public topic gettopicbyid(Integer id) {
        topic topic = topicdao.gettopic(id);
        List<reply> replyList = replyservice.getreplybytopicid(topic.getId());
        topic.setReplyList(replyList);
        return topic;
    }

}