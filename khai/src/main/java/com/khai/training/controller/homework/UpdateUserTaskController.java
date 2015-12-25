package com.khai.training.controller.homework;

import com.khai.training.bean.SolutionBean;
import com.khai.training.bean.TaskBean;
import com.khai.training.entity.Homework;
import com.khai.training.entity.HomeworkTask;
import com.khai.training.repository.HomeworkRepository;
import com.khai.training.repository.HomeworkTaskRepository;
import com.khai.training.repository.manager.RepositoryWriteManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ������� on 11.11.2015.
 */
@Controller
public class UpdateUserTaskController {
    @Autowired
    private RepositoryWriteManager repositoryWriteManager;
    @Autowired
    private HomeworkRepository repository;
    @Autowired
    private HomeworkTaskRepository homeworkTaskRepository;

    @RequestMapping(value = "/update/task", method = RequestMethod.POST)
    public void initialTask(HttpServletResponse response,
                            @RequestParam String valueTask,
                            @RequestParam String valueChart,
                            @RequestParam int id) {

        repositoryWriteManager.updateTask(id, valueChart, valueTask);
        response.addHeader("contentType", "application/json");
        response.setStatus(HttpServletResponse.SC_OK);
    }


    @RequestMapping(value = "/update/task.solution", method = RequestMethod.POST)
    public void initialTaskSolution(HttpServletResponse response,
                                    @RequestParam String valueTask,
                                    @RequestParam String valueChart,
                                    @RequestParam int id) {
        repositoryWriteManager.updateSolution(id, valueChart, valueTask);
        response.addHeader("contentType", "application/json");
        response.setStatus(HttpServletResponse.SC_OK);
    }

    private String trimChart(String chart) {
        String result = "";
        String reg = "(<div[\\s\\S]+</script>)"; //захватывает лишнее
        Pattern pattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(chart);
        int count = 0;
        while (matcher.find()){
            result += matcher.group(count++);
            System.out.print(result);
        }


        return result;
    }
}