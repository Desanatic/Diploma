package com.khai.training.controller.homework;

import com.khai.training.entity.Teacher;
import com.khai.training.entity.Training;
import com.khai.training.entity.UserHomeWork;
import com.khai.training.repository.TeacherRepository;
import com.khai.training.repository.TrainingRepository;
import com.khai.training.repository.UserHomeworkRepository;
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
import java.util.List;

/**
 * Created by PC on 27.12.2015.
 */
@Controller
public class HomeWorkManagerController {
    @Autowired
    private UserUtil userUtil;

    @Autowired
    private UserHomeworkRepository userHomeworkRepository;

    @Autowired
    private TrainingRepository trainingRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    @RequestMapping(value = "/homeWorkManager/getTraining", method = RequestMethod.GET)
    public @ResponseBody List<Training> initialTask(HttpServletRequest request) {
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
}
