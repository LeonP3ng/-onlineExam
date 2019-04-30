package com.lp.controller;

import com.lp.entity.User;
import com.lp.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceInterface userServiceInterface;

    @ResponseBody
    @RequestMapping("/login")
    public Map<String,Object> loginUser(HttpServletRequest request, @RequestParam("username") String username, @RequestParam("password") String password){

        Map<String,Object> result = new HashMap<>();

        User user=userServiceInterface.loginUser(username,password);
        if (user == null){
            result.put("status",false);
            result.put("errMsg","账号或者密码错误！");
            return result;
        }
        request.getSession().setAttribute("user",user);

        result.put("status",true);
        result.put("user",user);
        return result;
    }

    @RequestMapping("/login1")
    public void test(){
        System.out.println("hahhah ");
    }

}
