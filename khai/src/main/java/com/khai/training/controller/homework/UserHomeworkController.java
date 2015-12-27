package com.khai.training.controller.homework;

import com.khai.training.bean.SolutionBean;
import com.khai.training.bean.TaskBean;
import com.khai.training.entity.User;
import com.khai.training.repository.manager.RepositoryReadManager;
import com.khai.training.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ������� on 01.11.2015.
 */
@Controller
public class UserHomeworkController {
    //ToDo Смерть приложухи при обновлении страницы
    @Autowired
    private RepositoryReadManager repositoryReadManager;
    @Autowired
    private UserUtil userUtil;

    @RequestMapping(value = "home_work", method = RequestMethod.GET)
    public String getPage() {
        return "home_work";
    }

    @RequestMapping(value = "/initial/user.task", method = RequestMethod.POST)
    public
    @ResponseBody
    TaskBean initialTask(HttpServletResponse response, HttpServletRequest request, @RequestParam int id) {
        User user = userUtil.setRequest(request).getUser();
        TaskBean taskBean = repositoryReadManager.getTaskBeanById(user.getId(), id);
        response.addHeader("contentType", "application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        return taskBean;
    }

    @RequestMapping(value = "/initial/user.solution", method = RequestMethod.POST)
    public
    @ResponseBody
    SolutionBean initialSolution(HttpServletResponse response, HttpServletRequest request, @RequestParam int id) {
        User user = userUtil.setRequest(request).getUser();
        SolutionBean solutionBean = repositoryReadManager.getSolutionBeanById(user.getId(), id);
        response.addHeader("contentType", "application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        return solutionBean;
    }
}
