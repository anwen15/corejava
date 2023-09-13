package com.qqzone.service;

import com.qqzone.pojo.reply;

import java.util.List;

public interface replyservice {
    //根据topicid获取关联的索引回复
    List<reply> getreplybytopicid(Integer topicid);

    void addreply(reply reply);
    void delreply(Integer replyid);

}
