package com.atguigu.fruit.service.impl;

import com.atguigu.fruit.service.fruitservice;
import com.atguigu.fruit.dao.FruitDAO;
import com.atguigu.fruit.pojo.Fruit;

import java.util.List;

public class fruitserviceimpl implements fruitservice {
    private FruitDAO fruitdao =null;

    @Override
    public List<Fruit> getfruitlist(String keyword, Integer pageno) {
        return fruitdao.getFruitList(keyword,pageno);
    }

    @Override
    public void addfruit(Fruit fruit) {
        fruitdao.addFruit(fruit);

    }

    @Override
    public Fruit getfruitbyfid(Integer fid) {
        return fruitdao.getfruitbyfid(fid);
    }

    @Override
    public void delfruit(Integer fid) {
        fruitdao.delfruit(fid);
    }

    @Override
    public int getpagecount(String keyword) {
    int count= fruitdao.getfruitcount(keyword);
        int pageCount = (count+5-1)/5 ;
        return pageCount;
    }

    @Override
    public void updatefruit(Fruit fruit) {
        fruitdao.updatefruit(fruit);
    }
}
