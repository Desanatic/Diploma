package com.khai.training.bean.constructor;

import com.khai.training.bean.SolutionBean;
import com.khai.training.entity.Solution;
import com.khai.training.repository.HomeworkRepository;
import com.khai.training.repository.SolutionRepository;
import com.khai.training.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ������� on 19.11.2015.
 */
@Component
public class SolutionBeanConstructor {
    @Autowired
    private SolutionRepository solutionRepository;

    @Autowired
    private HomeworkRepository homeworkRepository;

    public SolutionBean get(int homeWorkId){
        int solutionId = homeworkRepository.get(homeWorkId).getTrainingId();
        return entityToBean(solutionRepository.get(solutionId));
    }

    //ToDo
    private SolutionBean entityToBean(Solution bean){
        SolutionBean solutionBean = new SolutionBean();
        solutionBean.setId(bean.getId());
        solutionBean.setDecision(bean.getDecision());
        solutionBean.setChart(bean.getChart());
        //solutionBean.setDateOfExecution(bean.getDateOfExecution());
        return solutionBean;
    }
}
