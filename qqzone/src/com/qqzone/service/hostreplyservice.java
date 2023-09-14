package com.qqzone.service;

import com.qqzone.pojo.hostreply;

public interface hostreplyservice {
    hostreply gethostreplbyreplyid(Integer replyid);
    void delhostreply(Integer hostreplyid);
}
