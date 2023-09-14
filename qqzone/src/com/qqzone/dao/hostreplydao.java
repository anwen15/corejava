package com.qqzone.dao;

import com.qqzone.pojo.hostreply;

public interface hostreplydao {
    hostreply gethostreplybyreplyid(Integer replyid);

    void delhostreply(Integer id);
}
