package com.lp.service;

import com.lp.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;


public interface UserServiceInterface {
    User loginUser(@Param("username") String username, @Param("password") String password);
}
