package com.qqzone.dao;

import com.qqzone.pojo.topic;
import com.qqzone.pojo.userbasic;

import java.util.List;

public interface topicdao {
    //获取指定用户的所有日志列表
    List<topic> gettopiclist(userbasic userbasic);

    //添加日志
    void addtopic(topic topic);

    //删除日志
    void deltopic(topic topic);

    //获取特定日志信息
    topic gettopic(Integer id);
}
