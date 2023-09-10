package com.qqzone.service.impl;

import com.qqzone.dao.hostreplydao;
import com.qqzone.pojo.hostreply;
import com.qqzone.service.hostreplyservice;

public class hostreplyserviceimpl implements hostreplyservice {
    private hostreplydao hostreplydao;
    @Override
    public hostreply gethostreplbyreplyid(Integer replyid) {
        return hostreplydao.gethostreplybyreplyid(replyid);
    }

}
