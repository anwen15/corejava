package com.qqzone.service;

import com.qqzone.pojo.topic;
import com.qqzone.pojo.userbasic;

import java.util.List;

public interface topicservice {
    //查询特定用户的日志列表
    List<topic> getyopiclist(userbasic userbasic);

    topic gettopicbyid(Integer id );

    topic gettopic(Integer id);
}
