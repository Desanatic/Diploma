package com.khai.training.controller.get;

import com.khai.training.bean.HomeworkBean;
import com.khai.training.bean.constructor.HomeWorkBeanConstructor;
import com.khai.training.entity.User;
import com.khai.training.entity.util.HomeworkState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by PC on 20.12.2015.
 */
@Controller
public class UserTaskListController {
    @Autowired
    private HomeWorkBeanConstructor homeWorkBeanConstructor;

    @RequestMapping(value = "home_work_list", method = RequestMethod.GET)
    public String getPage() {
        return "home_work_list";
    }

    @RequestMapping(value = "home_work_list.init", method = RequestMethod.GET)
    public @ResponseBody Map<String,List<HomeworkBean>> init(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        List<HomeworkBean> homeworkBeen = homeWorkBeanConstructor.getAllByUserId(user.getId());
        Map<String,List<HomeworkBean>> homeworkBeanMap = new HashMap<>();

        if(!homeworkBeen.isEmpty()){
            homeworkBeanMap = getHomeworkBeanMap(homeworkBeen);
        }

        return homeworkBeanMap;
    }

    private Map<String,List<HomeworkBean>> getHomeworkBeanMap(List<HomeworkBean> homeworkBeen){
        Map<String,List<HomeworkBean>> homeworkBeanMap = new HashMap<>();
        homeworkBeanMap.put(HomeworkState.NEW.name(),getHomeWorkByState(HomeworkState.NEW,homeworkBeen));
        homeworkBeanMap.put(HomeworkState.CLOSE.name(),getHomeWorkByState(HomeworkState.CLOSE,homeworkBeen));
        homeworkBeanMap.put(HomeworkState.DONE.name(),getHomeWorkByState(HomeworkState.DONE,homeworkBeen));
        homeworkBeanMap.put(HomeworkState.IN_PROGRESS.name(),getHomeWorkByState(HomeworkState.IN_PROGRESS,homeworkBeen));
        homeworkBeanMap.put(HomeworkState.OVERDUE.name(),getHomeWorkByState(HomeworkState.OVERDUE,homeworkBeen));
        return homeworkBeanMap;
    }

    private List<HomeworkBean> getHomeWorkByState(HomeworkState state, List<HomeworkBean> homeworkBeenList){
        List<HomeworkBean> subListOfHomeworkBeenList = new ArrayList<>();
        for(HomeworkBean homeworkBean : homeworkBeenList){
            if(homeworkBean.getState().equals(state)){
                subListOfHomeworkBeenList.add(homeworkBean);
            }
        }
        return subListOfHomeworkBeenList;
    }
}
