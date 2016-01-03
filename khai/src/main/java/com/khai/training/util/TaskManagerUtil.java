package com.khai.training.util;

import com.khai.training.entity.Homework;
import com.khai.training.entity.HomeworkTask;
import com.khai.training.entity.Training;
import com.khai.training.entity.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 03.01.2016.
 */
@Component
public class TaskManagerUtil {
    private HttpServletRequest request;
    private TaskManager taskManager;

    public TaskManagerUtil init(HttpServletRequest request){
        this.request = request;
        Object tm = request.getSession().getAttribute("taskManager");

        if(tm == null){
            taskManager = new TaskManager();
            request.getSession().setAttribute("taskManager",taskManager);
        }else{
            taskManager = (TaskManager) request.getSession().getAttribute("taskManager");
        }
        return this;
    }

    public TaskManagerUtil addTraining(Training training){
        taskManager = (TaskManager) request.getSession().getAttribute("taskManager");
        taskManager.setTraining(training);
        request.getSession().setAttribute("taskManager",taskManager);
        return this;
    }

    public TaskManagerUtil addUser(User user){
        taskManager = (TaskManager) request.getSession().getAttribute("taskManager");
        taskManager.setUser(user);
        request.getSession().setAttribute("taskManager",taskManager);
        return this;
    }

    public TaskManagerUtil addHomework(Homework homework){
        taskManager = (TaskManager) request.getSession().getAttribute("taskManager");
        taskManager.setHomework(homework);
        request.getSession().setAttribute("taskManager",taskManager);
        return this;
    }

    public User getUser(){
        Object tm = request.getSession().getAttribute("taskManager");
        if(tm != null){
            return ((TaskManager)tm).getUser();
        }
        return null;
    }

    public Training getTraining(){
        Object tm = request.getSession().getAttribute("taskManager");
        if(tm != null){
            return ((TaskManager)tm).getTraining();
        }
        return null;
    }

    public Homework getHomework(){
        Object tm = request.getSession().getAttribute("taskManager");
        if(tm != null){
            return ((TaskManager)tm).getHomework();
        }
        return null;
    }

    public void destroyTaskManager(){
        request.getSession().setAttribute("taskManager", null);
    }


    class TaskManager{
        private Homework homework;
        private Training training;
        private User user;

        public Homework getHomework() {
            return homework;
        }

        public void setHomework(Homework homework) {
            this.homework = homework;
        }

        public Training getTraining() {
            return training;
        }

        public void setTraining(Training training) {
            this.training = training;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }
    }
}
