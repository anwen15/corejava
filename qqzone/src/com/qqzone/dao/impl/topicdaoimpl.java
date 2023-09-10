package com.qqzone.dao.impl;

import com.myssm.basedao.BaseDAO;
import com.qqzone.dao.topicdao;
import com.qqzone.pojo.topic;
import com.qqzone.pojo.userbasic;

import java.util.List;

public class topicdaoimpl extends BaseDAO<topic> implements topicdao {
    @Override
    public List<topic> gettopiclist(userbasic userbasic) {
        return super.executeQuery("select * from t_topic where author=?", userbasic.getId());
    }

    @Override
    public void addtopic(topic topic) {

    }

    @Override
    public void deltopic(topic topic) {

    }

    @Override
    public topic gettopic(Integer id) {
        return super.load("select * from t_topic where id=?", id);
    }
}
