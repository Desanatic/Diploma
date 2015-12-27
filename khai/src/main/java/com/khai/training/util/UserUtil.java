package com.khai.training.util;

import com.khai.training.entity.User;
import com.khai.training.entity.util.UserRole;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by PC on 26.12.2015.
 */
@Component
public class UserUtil {
    private HttpServletRequest request;

    public UserUtil setRequest(HttpServletRequest request){
        this.request = request;
        return this;
    }

    public UserRole getRole(){
        Object user = request.getSession().getAttribute("user");
        if(user != null){
            return ((User)user).getRole();
        }
        return null;
    }

    public User getUser(){
        Object user = request.getSession().getAttribute("user");
        if(user != null){
            return (User)user;
        }
        return null;
    }

    public boolean isStudent(){
        Object user = request.getSession().getAttribute("user");
        if(user != null){
            return ((User)user).getRole().equals(UserRole.STUDENT);
        }
        return false;
    }

    public boolean isTeacher(){
        Object user = request.getSession().getAttribute("user");
        if(user != null){
            return ((User)user).getRole().equals(UserRole.TEACHER);
        }
        return false;
    }

    public void logIn(User user){
        request.getSession().setAttribute("user", user);
    }

    public void logOut(){
        request.getSession().setAttribute("user", null);
    }

}
