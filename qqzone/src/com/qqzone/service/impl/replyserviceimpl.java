package com.qqzone.service.impl;

import com.qqzone.dao.replydao;
import com.qqzone.pojo.hostreply;
import com.qqzone.pojo.reply;
import com.qqzone.pojo.topic;
import com.qqzone.service.hostreplyservice;
import com.qqzone.service.replyservice;

import java.util.List;

public class replyserviceimpl implements replyservice {
    private replydao replydao;
    private hostreplyservice hostreplyservice;
    @Override
    public List<reply> getreplybytopicid(Integer topicid) {
        List<reply> replyList = replydao.getreplylist(new topic(topicid));
        for (int i = 0; i < replyList.size(); i++) {
            reply reply = replyList.get(i);
            hostreply hostreply = hostreplyservice.gethostreplbyreplyid(reply.getId());
            reply.setHostreply(hostreply);
        }
        return replyList;
    }
}
