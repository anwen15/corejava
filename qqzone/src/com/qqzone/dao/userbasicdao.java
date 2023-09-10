package com.qqzone.dao;

import com.qqzone.pojo.userbasic;

import java.util.List;

public interface userbasicdao {
    //根据账号和密码获取用户信息
    userbasic getuserbasic(String loginid, String pwd);

    //获取指定用户的所有好友列表
    List<userbasic> getuserbasiclist(userbasic userbasic);

    //根据id查询userbasic信息
    userbasic getuserbasicbyid(Integer id);

}
