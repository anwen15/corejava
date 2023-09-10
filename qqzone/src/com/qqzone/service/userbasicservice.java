package com.qqzone.service;

import com.qqzone.pojo.userbasic;

import java.util.List;

public interface userbasicservice {
    userbasic login(String loginid, String pwd);

    List<userbasic> getfriendlist(userbasic userbasic);
    userbasic getuserbasicbyid(Integer id);
}
