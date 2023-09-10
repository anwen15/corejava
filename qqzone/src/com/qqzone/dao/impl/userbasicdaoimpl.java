package com.qqzone.dao.impl;

import com.myssm.basedao.BaseDAO;
import com.qqzone.dao.userbasicdao;
import com.qqzone.pojo.userbasic;

import java.util.List;

public class userbasicdaoimpl extends BaseDAO<userbasic> implements userbasicdao{
    @Override
    public userbasic getuserbasic(String loginid, String pwd) {
        return super.load("select * from t_user_basic where loginid=? and pwd=?", loginid, pwd);
    }

    @Override
    public List<userbasic> getuserbasiclist(userbasic userbasic) {
        String sql="select fid as id from t_friend where uid=?";
        return super.executeQuery(sql, userbasic.getId());
    }

    @Override
    public userbasic getuserbasicbyid(Integer id) {
        return super.load("select * from t_user_basic where id=?", id);
    }

}
