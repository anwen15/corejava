package com.atguigu.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Service;
import java.io.IOException;

@WebServlet("/demo01")
public class servletdemo01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("uname", "lili");
        //客户端重定向(外部)
        //resp.sendRedirect("demo02");
        //服务器端转发（内部）
        req.getRequestDispatcher("demo02").forward(req,resp);
    }
}
