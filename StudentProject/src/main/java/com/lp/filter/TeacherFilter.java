package com.lp.filter;

import com.lp.entity.Student;
import com.lp.entity.Teacher;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class TeacherFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest)req;
        HttpServletResponse response=(HttpServletResponse)resp;
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession();
        Teacher teacher=(Teacher)session.getAttribute("teacher");
        if(teacher ==null){
            try{
                String message="您无权操作,请登录";
                String jsonMessage="";
                jsonMessage = "{\"status\": false ,\"errMsg\":\"" + message + "\"}";
                resp.getWriter().write(jsonMessage.toString());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
             return;
        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
