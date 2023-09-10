package com.atguigu.fruit.service;

import com.atguigu.fruit.pojo.Fruit;

import java.util.List;

public interface fruitservice {
    //获取库存信息
    List<Fruit> getfruitlist(String keyword,Integer pageno);
    //添加库存信息
    void addfruit(Fruit fruit);

    //根据id查找指定信息
    Fruit getfruitbyfid(Integer fid);

    //删除特定库存信息
    void delfruit(Integer fid);

    //获取总页数
    int getpagecount(String keyword);

    //修改指定库存
    void updatefruit(Fruit fruit);

}
