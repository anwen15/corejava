package com.myssm.filter;

import com.myssm.trans.transmanager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.sql.SQLException;
@WebFilter("*.do")
public class opensessionfilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            //开启事物
            transmanager.begintrans();
            System.out.println("开启");
            filterChain.doFilter(servletRequest, servletResponse);
            //提交事物
            transmanager.commit();
            System.out.println("提交");
        } catch (Exception e) {
            e.printStackTrace();
            try {
                //回滚
                System.out.println("回滚");
                transmanager.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void destroy() {

    }
}
