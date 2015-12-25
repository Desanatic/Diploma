package com.khai.training.util.managers;

import com.khai.training.bean.SolutionBean;
import com.khai.training.bean.TaskBean;
import com.khai.training.entity.Homework;
import com.khai.training.entity.HomeworkTask;
import com.khai.training.entity.Solution;
import com.khai.training.entity.Training;

/**
 * Created by Vladyslav_Dubinin on 25.12.2015.
 */
public class BeanManager {
    public static class HomeworkBean {
        public static com.khai.training.bean.HomeworkBean adapt(Homework homework,HomeworkTask homeworkTask,Training training,Solution solution){
            com.khai.training.bean.HomeworkBean homeworkBean = new com.khai.training.bean.HomeworkBean();
            homeworkBean.setHomeWorkId(homework.getId());
            homeworkBean.setHomeWorkName(homework.getName());
            homeworkBean.setTaskId(homeworkTask.getId());
            homeworkBean.setTrainingId(training.getId());
            homeworkBean.setTrainingName(training.getTrainingName());
            homeworkBean.setDateOfDelivery(homework.getDateOfDelivery());
            homeworkBean.setState(homeworkTask.getState());
            if(solution != null){
                homeworkBean.setAssessment(solution.getAssessment());
            }else {
                homeworkBean.setAssessment(0);
            }
            return homeworkBean;
        }
    }

    public static class TaskBean {
        public static com.khai.training.bean.TaskBean adapt(HomeworkTask homeworkTask, Training training){
            com.khai.training.bean.TaskBean taskBean = new com.khai.training.bean.TaskBean();
            taskBean.setId(homeworkTask.getId());
            taskBean.setChart(homeworkTask.getChart());
            taskBean.setTask(homeworkTask.getTask());
            taskBean.setTrainingName(training.getTrainingName());
            return taskBean;
        }
    }

    public static class SolutionBean{
        public static com.khai.training.bean.SolutionBean adapt(Solution solution){
            com.khai.training.bean.SolutionBean solutionBean = new com.khai.training.bean.SolutionBean();
            solutionBean.setId(solution.getId());
            solutionBean.setChart(solution.getChart());
            solutionBean.setDecision(solution.getDecision());
            solutionBean.setDateOfExecution(solutionBean.getDateOfExecution());
            return solutionBean;
        }
    }
}
