package com.qqzone.service.impl;

import com.qqzone.dao.userbasicdao;
import com.qqzone.pojo.userbasic;
import com.qqzone.service.userbasicservice;

import java.util.ArrayList;
import java.util.List;

public class userbasicserviceImpl implements userbasicservice {
    private userbasicdao userbasicdao=null;
    @Override
    public userbasic login(String loginid, String pwd) {
        userbasic userbasic = userbasicdao.getuserbasic(loginid, pwd);
        return userbasic;
    }

    @Override
    public List<userbasic> getfriendlist(userbasic userbasic) {
        List<userbasic> userbasicList = userbasicdao.getuserbasiclist(userbasic);
        List<userbasic> friendlist=new ArrayList<>(userbasicList.size());
        for (int i = 0; i < userbasicList.size(); i++) {
            userbasic userbasic1 = userbasicList.get(i);
            userbasic getuserbasicbyid = userbasicdao.getuserbasicbyid(userbasic1.getId());
            friendlist.add(getuserbasicbyid);
        }
        return friendlist;
    }
    public userbasic getuserbasicbyid(Integer id){
        return userbasicdao.getuserbasicbyid(id);
    }
}
