package com.atguigu.fruit.dao.impl;

import com.atguigu.fruit.dao.FruitDAO;
import com.atguigu.fruit.pojo.Fruit;
import com.atguigu.myssm.basedao.BaseDAO;
import com.sun.org.apache.bcel.internal.generic.Select;

import java.util.List;

public
class fruitdaoimpl extends BaseDAO<Fruit> implements FruitDAO {

    @Override
    public List<Fruit> getFruitList(String keyword ,Integer pageno) {
        return super.executeQuery("select * from t_fruit where fname like ? or remark like ? limit ?,5","%"+keyword+"%","%"+keyword+"%",(pageno-1)*5);
    }

    @Override
    public Fruit getfruitbyfid(Integer fid) {
        return super.load("select * from t_fruit where fid=?",fid);
    }

    @Override
    public void updatefruit(Fruit fruit) {
        String sql = "update t_fruit set fname=?,price=?,fcount=?,remark=? where fid=?";
        super.executeUpdate(sql,fruit.getFname(),fruit.getPrice(),fruit.getFcount(),fruit.getRemark(),fruit.getFid());

    }

    @Override
    public void delfruit(Integer fid) {
        super.executeUpdate("delete from t_fruit where fid=?", fid );
    }

    @Override
    public void addFruit(Fruit fruit) {
        String sql = "insert into t_fruit values(0,?,?,?,?)";
        super.executeUpdate(sql, fruit.getFname(), fruit.getPrice(), fruit.getFcount(), fruit.getRemark());
    }


    @Override
    public int getfruitcount(String keyword) {
        return ((Long)super.executeComplexQuery("select count(*) from t_fruit where fname like ? or remark like ?","%"+keyword+"%","%"+keyword+"%")[0]).intValue();
    }
}
