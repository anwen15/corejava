package com.atguigu.fruit.controller;

import com.atguigu.fruit.service.fruitservice;
import com.atguigu.fruit.pojo.Fruit;
import com.atguigu.myssm.unti.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


public class fruitcontroller {
    private fruitservice fruitservice=null;

    private String update(Integer fid , String fname , Integer price , Integer fcount , String remark ){
        //3.执行更新
        fruitservice.updatefruit(new Fruit(fid,fname, price ,fcount ,remark ));
        //4.资源跳转
        return "redirect:fruit.do";
    }

    private String edit(Integer fid , HttpServletRequest request){
        if(fid!=null){
            Fruit fruit = fruitservice.getfruitbyfid(fid);
            request.setAttribute("fruit",fruit);
            //super.processTemplate("edit",request,response);
            return "edit";
        }
        return "error" ;
    }

    private String del(Integer fid  ){
        if(fid!=null){
            fruitservice.delfruit(fid);
            return "redirect:fruit.do";
        }
        return "error";
    }

    private String add(String fname , Integer price , Integer fcount , String remark ) {
        Fruit fruit = new Fruit(0,fname , price , fcount , remark ) ;
        fruitservice.addfruit(fruit);
        return "redirect:fruit.do";
    }

    private String index(String oper , String keyword , Integer pageNo , HttpServletRequest request ) {
        HttpSession sessions = request.getSession() ;

        if(pageNo==null){
            pageNo = 1;
        }
        if(StringUtil.isnotEmpty(oper) && "search".equals(oper)){
            pageNo = 1 ;
            if(StringUtil.isEmpty(keyword)){
                keyword = "" ;
            }
            sessions.setAttribute("keyword",keyword);
        }else{
            Object keywordObj = sessions.getAttribute("keyword");
            if(keywordObj!=null){
                keyword = (String)keywordObj ;
            }else{
                keyword = "" ;
            }
        }

        // 重新更新当前页的值
        sessions.setAttribute("pageNo",pageNo);

        List<Fruit> fruitList = fruitservice.getfruitlist(keyword , pageNo);
        sessions.setAttribute("fruitList",fruitList);

        //总记录条数
        int pagecount = fruitservice.getpagecount(keyword);
        sessions.setAttribute("pageCount",pagecount);

        return "index" ;
    }
}