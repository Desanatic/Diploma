package com.khai.training.controller.login;

import com.khai.training.entity.User;
import com.khai.training.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ������� on 01.11.2015.
 */
@Controller
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/sig_in", method = RequestMethod.POST)
    public void getPage(HttpServletRequest request, HttpServletResponse response, @RequestParam String login, String password) {
        if(login.contains("_")){
            User user = userRepository.get(login.split("_")[0],login.split("_")[1],password);
            request.getSession().setAttribute("user", user);
            response.setStatus(HttpServletResponse.SC_OK);
        }else{
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
