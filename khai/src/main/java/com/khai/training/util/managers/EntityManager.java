package com.khai.training.util.managers;

import com.khai.training.entity.Homework;
import com.khai.training.entity.User;
import com.khai.training.entity.UserHomeWork;
import com.khai.training.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Vladyslav_Dubinin on 25.12.2015.
 */
@Component
public class EntityManager {
    private User user;
    private Homework homework;
    private HomeworkTask homeworkTask;
    private Training training;
    private Solution solution;

    @Autowired
    private  UserHomeworkRepository userHomeworkRepository;
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private  HomeworkTaskRepository homeworkTaskRepository;
    @Autowired
    private  HomeworkRepository homeworkRepository;
    @Autowired
    private  TrainingRepository trainingRepository;
    @Autowired
    private  SolutionRepository solutionRepository;

    public User adaptToUser(){
        if(user == null){
            user = new User();
        }
        return user;
    }

    public Homework adaptToHomework(){
        if(homework == null){
            homework = new Homework();
        }
        return homework;
    }

    public HomeworkTask adaptToHomeworkTask(){
        if(homeworkTask == null){
            homeworkTask = new HomeworkTask();
        }
        return homeworkTask;
    }

    public Training adaptToTraining(){
        if(training == null){
            training = new Training();
        }
        return training;
    }

    public Solution adaptToSolution(){
        if(solution == null){
            solution = new Solution();
        }
        return solution;
    }

    public class User{
        private User() {
        }

        public  com.khai.training.entity.User adapt(UserHomeWork userHomeWork){
            if(userHomeWork.getId() == null){
                return null;
            }
            return userRepository.get(userHomeWork.getUserId());
        }
    }

    public class Homework{
        private Homework() {
        }

        public  com.khai.training.entity.Homework adapt(UserHomeWork userHomeWork){
            if(userHomeWork.getHomeworkId() == null){
                return null;
            }
            return homeworkRepository.get(userHomeWork.getHomeworkId());
        }
    }

    public class HomeworkTask{
        private HomeworkTask() {
        }

        public  com.khai.training.entity.HomeworkTask adapt(UserHomeWork userHomeWork){
            if(userHomeWork.getHomeworkTaskId() == null){
                return null;
            }
            return homeworkTaskRepository.get(userHomeWork.getHomeworkTaskId());
        }
    }

    public class Training{
        private Training() {
        }

        public  com.khai.training.entity.Training adapt(UserHomeWork userHomeWork){
            if(userHomeWork.getTrainingId() == null){
                return null;
            }
            return trainingRepository.get(userHomeWork.getTrainingId());
        }
    }

    public class Solution{
        private Solution() {
        }

        public  com.khai.training.entity.Solution adapt(UserHomeWork userHomeWork){
            if(userHomeWork.getSolutionId() == null){
                return null;
            }
            return solutionRepository.get(userHomeWork.getSolutionId());
        }
    }
}
