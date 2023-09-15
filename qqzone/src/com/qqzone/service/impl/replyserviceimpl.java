package com.qqzone.service.impl;

import com.qqzone.dao.replydao;
import com.qqzone.pojo.hostreply;
import com.qqzone.pojo.reply;
import com.qqzone.pojo.topic;
import com.qqzone.pojo.userbasic;
import com.qqzone.service.hostreplyservice;
import com.qqzone.service.replyservice;
import com.qqzone.service.userbasicservice;

import java.util.List;

public class replyserviceimpl implements replyservice {
    private replydao replydao;
    private hostreplyservice hostreplyservice;
    private userbasicservice userbasicservice;
    @Override
    public List<reply> getreplybytopicid(Integer topicid) {
        List<reply> replyList = replydao.getreplylist(new topic(topicid));
        for (int i = 0; i < replyList.size(); i++) {
            reply reply = replyList.get(i);
            userbasic userbasic = userbasicservice.getuserbasicbyid(reply.getAuthor().getId());
            reply.setAuthor(userbasic);
            hostreply hostreply = hostreplyservice.gethostreplbyreplyid(reply.getId());
            reply.setHostreply(hostreply);
        }
        return replyList;
    }

    @Override
    public void addreply(reply reply) {
        replydao.addreply(reply);
    }

    @Override
    public void delreply(Integer replyid) {
        reply reply = replydao.getreply(replyid);
        if(reply!=null){
            hostreply hostreply = hostreplyservice.gethostreplbyreplyid(reply.getId());
            if (hostreply!=null){
                hostreplyservice.delhostreply(hostreply.getId());
            }
        }
        replydao.delreply(replyid);
    }

    @Override
    public void getreplybytopic(Integer topicid) {
        replydao.getreplybytopicid(topicid);
    }
}
