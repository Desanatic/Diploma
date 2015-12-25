package com.khai.training.controller.post.old;

import com.khai.training.bean.HomeworkBean;
import com.khai.training.entity.util.HomeworkState;
import com.khai.training.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by ������� on 11.11.2015.
 */
@Controller
public class InitialUserTasksController {
   /* @Autowired
    private HomeWorkBeanConstructor homeWorkConstructorBean;

    //ToDo
    //@RequestMapping(value = "/initial/user.tasks", method = RequestMethod.POST)
    public @ResponseBody List<HomeworkBean> initial(HttpServletRequest request, HttpServletResponse response, @RequestParam String state) {

        User user = (User) request.getSession().getAttribute("user");
        List<HomeworkBean> homeworkBeans = null;

        if(state.equalsIgnoreCase(HomeworkState.NEW.name())){
            homeworkBeans = homeWorkConstructorBean.get(user.getId(), HomeworkState.NEW);
        }else if(state.equalsIgnoreCase(HomeworkState.IN_PROGRESS.name())){
            homeworkBeans = homeWorkConstructorBean.get(user.getId(), HomeworkState.IN_PROGRESS);
        }else if(state.equalsIgnoreCase(HomeworkState.OVERDUE.name())) {
            homeworkBeans = homeWorkConstructorBean.get(user.getId(), HomeworkState.OVERDUE);
        }else if(state.equalsIgnoreCase(HomeworkState.DONE.name())) {
            homeworkBeans = homeWorkConstructorBean.get(user.getId(), HomeworkState.DONE);
        } else if(state.equalsIgnoreCase(HomeworkState.CLOSE.name())) {
            homeworkBeans = homeWorkConstructorBean.get(user.getId(), HomeworkState.CLOSE);
        }

        request.getSession().setAttribute("taskList", homeworkBeans);
        response.addHeader("contentType", "application/json");
        response.setStatus(HttpServletResponse.SC_OK);

        return homeworkBeans;
    }*/
}