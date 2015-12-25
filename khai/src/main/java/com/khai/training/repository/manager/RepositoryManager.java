package com.khai.training.repository.manager;

import com.khai.training.bean.HomeworkBean;
import com.khai.training.bean.SolutionBean;
import com.khai.training.bean.TaskBean;
import com.khai.training.bean.UserHomeWorkBean;
import com.khai.training.entity.*;
import com.khai.training.repository.*;
import com.khai.training.util.managers.BeanManager;
import com.khai.training.util.managers.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Vladyslav_Dubinin on 25.12.2015.
 */
@Component
public class RepositoryManager {
    private List<UserHomeWorkBean> userHomeWorkBeanList;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private UserHomeworkRepository userHomeworkRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HomeworkTaskRepository homeworkTaskRepository;
    @Autowired
    private HomeworkRepository homeworkRepository;
    @Autowired
    private TrainingRepository trainingRepository;
    @Autowired
    private SolutionRepository solutionRepository;

    public List<HomeworkBean> getHomeworkBeans(int userId) {
        init(userId);
        List<HomeworkBean> homeworkBeans = new ArrayList<>();
        for (UserHomeWorkBean userHomeWorkBean : userHomeWorkBeanList) {
            homeworkBeans.add(BeanManager.HomeworkBean.adapt(
                    userHomeWorkBean.getHomework(),
                    userHomeWorkBean.getHomeworkTask(),
                    userHomeWorkBean.getTraining(),
                    userHomeWorkBean.getSolution()));
        }
        return homeworkBeans;
    }


    public TaskBean getTaskBeanById(int userId, int taskId) {
        init(userId);
        for (UserHomeWorkBean userHomeWorkBean : userHomeWorkBeanList) {
            if (userHomeWorkBean.getHomeworkTask().getId() == taskId) {
                return BeanManager.TaskBean.adapt(userHomeWorkBean.getHomeworkTask(), userHomeWorkBean.getTraining());
            }
        }
        return null;
    }

    public SolutionBean getSolutionBeanById(int userId, int taskId) {
        init(userId);
        for (UserHomeWorkBean userHomeWorkBean : userHomeWorkBeanList) {
            if (userHomeWorkBean.getHomeworkTask().getId() == taskId && userHomeWorkBean.getSolution() != null) {
                return BeanManager.SolutionBean.adapt(userHomeWorkBean.getSolution());
            }
        }
        return null;
    }

    private void init(int userId) {
        userHomeWorkBeanList = new ArrayList<>();
        for (UserHomeWork userHomeWork : userHomeworkRepository.getByUserId(userId)) {
            UserHomeWorkBean userHomeWorkBean = new UserHomeWorkBean();
            userHomeWorkBean.setId(userHomeWork.getId());
            userHomeWorkBean.setUser(entityManager.adaptToUser().adapt(userHomeWork));
            userHomeWorkBean.setHomework(entityManager.adaptToHomework().adapt(userHomeWork));
            userHomeWorkBean.setHomeworkTask(entityManager.adaptToHomeworkTask().adapt(userHomeWork));
            userHomeWorkBean.setTraining(entityManager.adaptToTraining().adapt(userHomeWork));
            userHomeWorkBean.setSolution(entityManager.adaptToSolution().adapt(userHomeWork));
            userHomeWorkBeanList.add(userHomeWorkBean);
        }
    }
}
