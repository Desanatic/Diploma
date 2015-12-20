package com.khai.training.controller.post.old;

import com.khai.training.bean.SolutionBean;
import com.khai.training.bean.TaskBean;
import com.khai.training.bean.constructor.SolutionBeanConstructor;
import com.khai.training.bean.constructor.TaskBeanConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by ������� on 11.11.2015.
 */
@Controller
public class InitialUserTaskController {
    private SolutionBeanConstructor solutionBeanConstructor;
    private TaskBeanConstructor taskBeanConstructor;

    @Autowired
    public InitialUserTaskController(SolutionBeanConstructor solutionBeanConstructor, TaskBeanConstructor taskBeanConstructor) {
        this.solutionBeanConstructor = solutionBeanConstructor;
        this.taskBeanConstructor = taskBeanConstructor;
    }

    //ToDo
    //@RequestMapping(value = "/initial/user.task", method = RequestMethod.POST)
    public @ResponseBody TaskBean initialTask(HttpServletResponse response, @RequestParam int id) {
        TaskBean taskBean = taskBeanConstructor.get(id);
        System.out.println(taskBean);
        response.addHeader("contentType", "application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        return taskBean;
    }

    //@RequestMapping(value = "/initial/user.solution", method = RequestMethod.POST)
    public @ResponseBody SolutionBean initialSolution(HttpServletResponse response, @RequestParam int id) {
        SolutionBean solutionBean = solutionBeanConstructor.get(id);
        System.out.println(solutionBean);
        response.addHeader("contentType", "application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        return solutionBean;
    }

}