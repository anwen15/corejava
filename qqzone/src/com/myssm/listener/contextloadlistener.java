package com.myssm.listener;

import com.myssm.ioc.beanfactory;
import com.myssm.ioc.pathxmlapplicationcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class contextloadlistener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext applicationconext = servletContextEvent.getServletContext();
        String path = applicationconext.getInitParameter("configlocation");
        //创建ioc容器
        beanfactory beanfactory=new pathxmlapplicationcontext(path);
        applicationconext.setAttribute("beanfactory", beanfactory);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
