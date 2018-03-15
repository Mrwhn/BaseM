package com.hnwu.blog.test;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 吴会楠 on 2018/1/8.
 */
@WebServlet(urlPatterns = "/MyServlet",name = "MyServlet" )
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        try{
            out.println("<html><head></head><body><div>sss！</div></body></html>");
            out.flush();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            out.close();
        }
    }
}
