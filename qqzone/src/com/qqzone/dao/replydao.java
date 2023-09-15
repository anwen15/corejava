package com.qqzone.dao;

import com.qqzone.pojo.reply;
import com.qqzone.pojo.topic;

import java.util.List;

public interface replydao {
    //获取指定日志的回复列表
    List<reply> getreplylist(topic topic);

    //添加回复
    void addreply(reply reply);

    //删除回复
    void delreply(Integer id);

    //获取reply
    reply getreply(Integer id);

    reply getreplybytopicid(Integer id);
}