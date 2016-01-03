package com.khai.training.controller.homework;

import com.khai.training.entity.*;
import com.khai.training.entity.util.HomeworkState;
import com.khai.training.repository.*;
import com.khai.training.repository.manager.RepositoryReadManager;
import com.khai.training.util.TaskManagerUtil;
import com.khai.training.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by PC on 27.12.2015.
 */
@Controller
public class HomeWorkManagerController {
    @Autowired
    private UserUtil userUtil;
    @Autowired
    private TaskManagerUtil taskManagerUtil;
    @Autowired
    private RepositoryReadManager readManager;
    @Autowired
    private UserHomeworkRepository userHomeworkRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TrainingRepository trainingRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private HomeworkTaskRepository homeworkTaskRepository;
    @Autowired
    private HomeworkRepository homeworkRepository;

    @RequestMapping(value = "/homeWorkManager/getTraining", method = RequestMethod.GET)
    public @ResponseBody List<Training> getTraining(HttpServletRequest request) {
        List<Training> trainingList = new ArrayList<>();
        Integer id = userUtil.setRequest(request).getUser().getId();
        if(id == null){
            return trainingList;
        }
        List<Teacher> teacherList = teacherRepository.getByUserId(id);

        for(Teacher teacher : teacherList){
            trainingList.add(trainingRepository.get(teacher.getTrainingId()));
        }
        return trainingList;
    }

    @RequestMapping(value = "/homeWorkManager/setTraining", method = RequestMethod.POST)
    public void setTrainings(HttpServletRequest httpServletRequest, HttpServletResponse response, @RequestParam Integer training_id) {
        if(training_id == null){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        Training training = trainingRepository.get(training_id);
        taskManagerUtil.init(httpServletRequest).addTraining(training);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = "/homeWorkManager/setHomework", method = RequestMethod.POST)
    public void setHomeworkTask(HttpServletRequest httpServletRequest, HttpServletResponse response, @RequestParam Integer id) {
        if(id == null){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        Homework homeworkTask = homeworkRepository.get(id);
        taskManagerUtil.init(httpServletRequest).addHomework(homeworkTask);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = "/homeWorkManager/setUser", method = RequestMethod.POST)
    public void setUser(HttpServletRequest httpServletRequest, HttpServletResponse response, @RequestParam Integer id) {
        if(id == null){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        User user = userRepository.get(id);
        taskManagerUtil.init(httpServletRequest).addUser(user);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = "/homeWorkManager/getUsers", method = RequestMethod.GET)
    public @ResponseBody List<User> getUsers() {
        List<User> userList = userRepository.listAll();
        if(userList == null){
            return new ArrayList<>();
        }
        return userList;
    }

    @RequestMapping(value = "/homeWorkManager/getHomework", method = RequestMethod.GET)
    public @ResponseBody List<Homework> getHomeworkTasks(HttpServletRequest httpServletRequest) {
        Training training = taskManagerUtil.init(httpServletRequest).getTraining();
        return readManager.getHomeworkByTraining(training.getId());
    }

    @RequestMapping(value = "/homeWorkManager/create", method = RequestMethod.POST)
    public void createTask(HttpServletRequest httpServletRequest, HttpServletResponse response) {
        Integer homeWorkTaskId;
        HomeworkTask homeworkTask = new HomeworkTask();
        homeworkTask.setState(HomeworkState.NEW);
        homeWorkTaskId = homeworkTaskRepository.put(homeworkTask);
        if(homeWorkTaskId == null){
            return;
        }
        UserHomeWork userHomeWork = new UserHomeWork();
        userHomeWork.setHomeworkId(taskManagerUtil.init(httpServletRequest).getHomework().getId());
        userHomeWork.setTrainingId(taskManagerUtil.init(httpServletRequest).getTraining().getId());
        userHomeWork.setHomeworkTaskId(homeWorkTaskId);
        userHomeWork.setUserId(taskManagerUtil.init(httpServletRequest).getUser().getId());
        userHomeworkRepository.put(userHomeWork);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = "/homeWorkManager/destroy", method = RequestMethod.POST)
    public void destroy(HttpServletRequest httpServletRequest, HttpServletResponse servletResponse) {
        taskManagerUtil.init(httpServletRequest).destroyTaskManager();
        servletResponse.setStatus(HttpServletResponse.SC_OK);
    }
}
