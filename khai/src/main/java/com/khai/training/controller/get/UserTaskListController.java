package com.khai.training.controller.get;

import com.khai.training.bean.HomeworkBean;
import com.khai.training.entity.User;
import com.khai.training.entity.util.HomeworkState;
import com.khai.training.repository.manager.RepositoryManager;
import com.khai.training.util.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by PC on 20.12.2015.
 */
@Controller
public class UserTaskListController {
    @Autowired
    private RepositoryManager repositoryManager;


    @RequestMapping(value = "home_work_list", method = RequestMethod.GET)
    public String getPage() {
        return "home_work_list";
    }

    @RequestMapping(value = "home_work_list.init", method = RequestMethod.GET)
    public
    @ResponseBody
    Map<String, List<HomeworkBean>> init(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        List<HomeworkBean> homeworkBeen = repositoryManager.getHomeworkBeans(user.getId());

        return getHomeworkBeanMap(homeworkBeen);
    }

    private Map<String, List<HomeworkBean>> getHomeworkBeanMap(List<HomeworkBean> homeworkBeen) {
        Map<String, List<HomeworkBean>> homeworkBeanMap = new HashMap<>();
        if (!homeworkBeen.isEmpty()) {
            homeworkBeanMap.put(HomeworkState.NEW.name(), Filter.homeWorkBeanFilter().add(homeworkBeen).stateFilter(HomeworkState.NEW));
            homeworkBeanMap.put(HomeworkState.CLOSE.name(), Filter.homeWorkBeanFilter().add(homeworkBeen).stateFilter(HomeworkState.CLOSE));
            homeworkBeanMap.put(HomeworkState.DONE.name(), Filter.homeWorkBeanFilter().add(homeworkBeen).stateFilter(HomeworkState.DONE));
            homeworkBeanMap.put(HomeworkState.IN_PROGRESS.name(), Filter.homeWorkBeanFilter().add(homeworkBeen).stateFilter(HomeworkState.IN_PROGRESS));
            homeworkBeanMap.put(HomeworkState.OVERDUE.name(), Filter.homeWorkBeanFilter().add(homeworkBeen).stateFilter(HomeworkState.OVERDUE));
        }
        return homeworkBeanMap;
    }
}
