package com.qqzone.dao.impl;

import com.myssm.basedao.BaseDAO;
import com.qqzone.dao.hostreplydao;
import com.qqzone.pojo.hostreply;

public class hostreplydaoimpl extends BaseDAO<hostreply> implements hostreplydao {
    @Override
    public hostreply gethostreplybyreplyid(Integer replyid) {
        return load("select * from t_host_reply where reply=?", replyid);
    }

    @Override
    public void delhostreply(Integer id) {
        executeUpdate("delete from t_host_reply where id=?",id);
    }
}
