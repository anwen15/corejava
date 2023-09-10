package com.atguigu.myssm.springmvc;

import com.atguigu.myssm.ioc.beanfactory;
import com.atguigu.myssm.ioc.pathxmlapplicationcontext;
import com.atguigu.myssm.unti.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

@WebServlet("*.do")
public class dispatcherservlet extends ViewBaseServlet {
    private beanfactory beanfactory;

    public dispatcherservlet() {
    }

    public void init() throws ServletException {
        super.init();
        beanfactory=new pathxmlapplicationcontext();

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //截取url名称
        String servletPath = req.getServletPath();
        servletPath = servletPath.substring(1);
        int lastIndexOf = servletPath.lastIndexOf(".do");
        String servletpath = servletPath.substring(0, lastIndexOf);
        Object controllerobj = beanfactory.getBean(servletpath);
        String operate = req.getParameter("operate");
        if (StringUtil.isEmpty(operate)) {
            operate = "index";
        }
        try {
            Method[] methods = controllerobj.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (operate.equals(method.getName())) {
                    //统一获取请求
                    //获取参数数组
                    Parameter[] parameters = method.getParameters();
                    //承载参数数组
                    Object[] values = new Object[parameters.length];
                    for (int i = 0; i < parameters.length; i++) {
                        Parameter param = parameters[i];
                        String parameterName = param.getName();
                        if ("request".equals(parameterName)) {
                            values[i] = req;
                        } else if ("response".equals(parameterName)) {
                            values[i] = resp;
                        } else if ("session".equals(parameterName)) {
                            values[i] = req.getSession();
                        } else {
                            String parmvalue = req.getParameter(parameterName);
                            String typename = param.getType().getName();
                            Object parmvalues = parmvalue;
                            if (parmvalues != null) {
                                if ("java.lang.Integer".equals(typename)) {
                                    parmvalues = Integer.parseInt(parmvalue);
                                }
                            }
                            values[i] = parmvalues;
                        }
                    }

                //调用controller组件
                method.setAccessible(true);
                Object methodreturnobj = method.invoke(controllerobj, values);

                //视图处理
                String methodreturn = (String) methodreturnobj;
                if (methodreturn.startsWith("redirect:")) {
                    String redirect = methodreturn.substring("redirect:".length());
                    resp.sendRedirect(redirect);
                } else {
                    super.processTemplate(methodreturn, req, resp);
                }
            }
        }
        //使用功能

        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}