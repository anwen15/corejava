package com.qqzone.dao.impl;

import com.myssm.basedao.BaseDAO;
import com.qqzone.dao.replydao;
import com.qqzone.pojo.reply;
import com.qqzone.pojo.topic;

import java.util.List;

public class replydaoimpl extends BaseDAO<reply> implements replydao {
    @Override
    public List<reply> getreplylist(topic topic) {
        return super.executeQuery("select * from t_reply where topic=?",topic.getId());
    }

    @Override
    public void addreply(reply reply) {

    }

    @Override
    public void delreply(Integer id) {

    }
}
