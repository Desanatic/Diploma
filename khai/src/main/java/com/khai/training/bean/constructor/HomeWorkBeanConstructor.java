package com.khai.training.bean.constructor;

import com.khai.training.bean.HomeworkBean;
import com.khai.training.entity.*;
import com.khai.training.entity.util.HomeworkState;
import com.khai.training.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ������� on 10.11.2015.
 */
@Component
public class HomeWorkBeanConstructor {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TrainingRepository trainingRepository;
    @Autowired
    private HomeworkRepository homeworkRepository;
    @Autowired
    private SolutionRepository solutionRepository;
    @Autowired
    private UserHomeworkRepository userHomeworkRepository;
    @Autowired
    private HomeworkTaskRepository homeworkTaskRepository;


    public List<HomeworkBean> getAllByUserId(int userId) {
        List<HomeworkBean> homeworkBeans = new ArrayList<>();
        List<UserHomeWork> userHomeWorks = userHomeworkRepository.getByUserId(userId);

        for (UserHomeWork userHomeWork : userHomeWorks) {
            Homework homework = homeworkRepository.get(userHomeWork.getHomeworkId());
            Training training = trainingRepository.get(homework.getTrainingId());
            Solution solution = solutionRepository.getByHomeworkId(homework.getId());
            HomeworkTask homeworkTask = homeworkTaskRepository.get(userHomeWork.getHomeworkTaskId());
            homeworkBeans.add(entityToBean(homework, training, solution,homeworkTask));
        }

        return homeworkBeans;
    }

    public List<HomeworkBean> get(int userId, HomeworkState state) {
        return homeworkBeansStateFilter(getAllByUserId(userId), state);
    }

    private List<HomeworkBean> homeworkBeansStateFilter(List<HomeworkBean> homeworkBeans, HomeworkState state) {
        List<HomeworkBean> homeworkList = new ArrayList<>();
        for (HomeworkBean homework : homeworkBeans) {
            if (filterState(homework, state)) {
                homeworkList.add(homework);
            }
        }
        return homeworkList;
    }

    private boolean filterState(HomeworkBean homeworkBean, HomeworkState state) {
        return homeworkBean.getState().equals(state);
    }

    private HomeworkBean entityToBean(Homework homework, Training training, Solution solution, HomeworkTask homeworkTask) {
        HomeworkBean homeworkBean = new HomeworkBean();
        homeworkBean.setHomeWorkId(homework.getId());
        homeworkBean.setHomeWorkName(homework.getName());
        homeworkBean.setTrainingId(homework.getTrainingId());
        homeworkBean.setTrainingName(training.getTrainingName());
        homeworkBean.setDateOfDelivery(homework.getDateOfDelivery());
        homeworkBean.setState(homeworkTask.getState());
        homeworkBean.setTaskId(homeworkTask.getId());
        if(solution != null){
            homeworkBean.setAssessment(solution.getAssessment());
        }else{
            homeworkBean.setAssessment(0);
        }
        return homeworkBean;
    }

    //ToDo
    /*public List<HomeworkBean> get(int userId){
        List<HomeworkBean> homeworkBeans = new ArrayList<>();
        for(Homework homework : homeworkRepository.getByUserId(userId)){
            Training training = trainingRepository.get(homework.getTrainingId());
            homeworkBeans.add(entityToBean(homework, training));
        }
        return homeworkBeans;
    }

    public HomeworkBean getById(int id){
        Homework homework = homeworkRepository.get(id);
        Training training = trainingRepository.get(homework.getTrainingId());
        Solution solution = solutionRepository.getByHomeworkId(homework.getId());

        return entityToBean(homework, training);
    }

    */


}
