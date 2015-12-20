package com.khai.training.controller.get.old;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ������� on 01.11.2015.
 */
@Controller
public class HomeWorkListController {

    //ToDo
    //@RequestMapping(value = "home_work_list", method = RequestMethod.GET)
    public String getPage() {
        return "home_work_list";
    }

}
