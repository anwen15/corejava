package com.atguigu.fruit.dao;

import com.atguigu.fruit.pojo.Fruit;

import java.util.List;

public interface FruitDAO {
    //获取所有库存信息
    //List<Fruit> getFruitList();
    //获取指定页码上的库存信息
    List<Fruit> getFruitList( String keyword ,Integer pageno);
    //根据fid获取信息
    Fruit getfruitbyfid(Integer fid);
    //修改指定的库存信息
    void updatefruit(Fruit fruit);
    //根据fid删除
    void delfruit(Integer fid);
    //添加
    void addFruit(Fruit fruit);
    //查询总库总记录条数
    int getfruitcount(String keyword);
}
