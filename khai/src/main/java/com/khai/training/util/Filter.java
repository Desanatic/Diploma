package com.khai.training.util;

import com.khai.training.bean.HomeworkBean;
import com.khai.training.entity.util.HomeworkState;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladyslav_Dubinin on 25.12.2015.
 */
public class Filter{
    private static HomeWorkBeanFilter homeWorkBeanFilter;

    public static HomeWorkBeanFilter homeWorkBeanFilter(){
        if(homeWorkBeanFilter == null){
            homeWorkBeanFilter = new HomeWorkBeanFilter();
        }
        return homeWorkBeanFilter;
    }

    public static class HomeWorkBeanFilter{
        private HomeWorkBeanFilter() {}

        private List<HomeworkBean> homeworkBeans;

        public HomeWorkBeanFilter add(List<HomeworkBean> homeworkBeans){
            this.homeworkBeans = homeworkBeans;
            return this;
        }

        public List<HomeworkBean> stateFilter(HomeworkState state) {
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


    }
}
