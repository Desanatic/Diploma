package com.khai.training.bean.constructor;

import com.khai.training.bean.SolutionBean;
import com.khai.training.bean.TaskBean;
import com.khai.training.entity.Homework;
import com.khai.training.entity.HomeworkTask;
import com.khai.training.entity.Solution;
import com.khai.training.entity.Training;
import com.khai.training.repository.HomeworkRepository;
import com.khai.training.repository.HomeworkTaskRepository;
import com.khai.training.repository.SolutionRepository;
import com.khai.training.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ������� on 19.11.2015.
 */
@Component
public class TaskBeanConstructor {

    @Autowired
    private HomeworkRepository homeworkRepository;
    @Autowired
    private HomeworkTaskRepository homeworkTaskRepository;
    @Autowired
    private TrainingRepository trainingRepository;

//ToDo homeWorkId на task id
    public TaskBean get(int homeWorkId){
        Homework homework = homeworkRepository.get(homeWorkId);
        Training training = trainingRepository.get(homework.getTrainingId());
        //HomeworkTask homeworkTask = homeworkTaskRepository.get()
        return entityToBean(homework,training);
    }

    private TaskBean entityToBean(Homework homeworkBean, Training trainingBean){
        TaskBean taskBean = new TaskBean();
        taskBean.setId(homeworkBean.getId());
        //taskBean.setChart(homeworkBean.getChart());
        //taskBean.setTask(homeworkBean.getTask());
        taskBean.setTrainingName(trainingBean.getTrainingName());
        return taskBean;
    }
}
