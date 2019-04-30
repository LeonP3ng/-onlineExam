package com.lp.service.serviceImple;

import com.lp.dao.UserDaoInterface;
import com.lp.entity.User;
import com.lp.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSreviceImple implements UserServiceInterface {
    @Autowired
    UserDaoInterface userDaoInterface;

    @Override
    public User loginUser(String username, String password) {
        return userDaoInterface.loginUser(username,password);
    }
}
