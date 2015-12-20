package com.khai.training.controller.get.old;

import com.khai.training.bean.HomeworkBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by ������� on 01.11.2015.
 */
@Controller
public class HomeWorkController {
    @RequestMapping(value = "home_work", method = RequestMethod.GET)
    public String getPage(HttpServletRequest request) {
        return "home_work";
    }
}
