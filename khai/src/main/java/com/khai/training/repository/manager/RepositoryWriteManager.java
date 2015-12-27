package com.khai.training.repository.manager;

import com.khai.training.entity.HomeworkTask;
import com.khai.training.entity.Solution;
import com.khai.training.entity.UserHomeWork;
import com.khai.training.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Vladyslav_Dubinin on 25.12.2015.
 */
@Component
public class RepositoryWriteManager {
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



    public void updateTask(int homeWorkId, String chart, String task){
        UserHomeWork userHomeWork = userHomeworkRepository.getByTaskId(homeWorkId);
        HomeworkTask homeworkTask = homeworkTaskRepository.get(userHomeWork.getHomeworkTaskId());
        if(homeworkTask != null){
            homeworkTask.setChart(chart);
            homeworkTask.setTask(task);
            homeworkTaskRepository.update(homeworkTask);
        }else {
            //ToDo
            homeworkTask = new HomeworkTask();

        }

    }

    public void updateSolution(int homeWorkId, String chart, String decision){
        UserHomeWork userHomeWork = userHomeworkRepository.getBySolutionId(homeWorkId);
        Solution solution = solutionRepository.get(userHomeWork.getSolutionId());
        solution.setChart(chart);
        solution.setDecision(decision);
        solutionRepository.update(solution);
    }
}
