package com.lp.controller;

import com.lp.entity.Subject;
import com.lp.service.SubjectServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


//@RequestMapping("/student")
@Controller
public class StudentController {

    @Autowired
    SubjectServiceInterface subjectServiceInterface;
    /*
     * 学生后台管理逻辑
     * */
    @RequestMapping("/exam")
    public String exam(@RequestParam(value="pn",defaultValue="1")int num , HttpSession session) {
        int pageSize=10;
        List<Subject> subjects=subjectServiceInterface.randomFindSubject();
        List<Integer>subjectIds=new ArrayList<Integer>();
        for(Subject subject:subjects) {
            subjectIds.add(subject.getSubjectId());
        }
        session.setAttribute("subjects",subjects);
        session.setAttribute("subjectIds", subjectIds);
        return "exam";
    }


    @RequestMapping(value="/getScore",method=RequestMethod.POST)
    public String getScore(HttpServletRequest request, HttpSession session) {
        int score=0;
        List<Integer>subjectIds=(List<Integer>) session.getAttribute("subjectIds");
        List<String> userAnswers=new ArrayList<String>();
        List<String> subjectAnswers=new ArrayList<String>();
        for(int i=0;i<20;i++) {//获取用户选择
            userAnswers.add(request.getParameter("subjectOption-"+subjectIds.get(i)));
        }
        for(int i=0;i<20;i++) {//从数据库中获取答案
            subjectAnswers.add(subjectServiceInterface.findSubjectById(subjectIds.get(i)).getSubjectAnswer());
        }
        for(int i=0;i<20;i++) {
            if((userAnswers.get(i)).equals(subjectAnswers.get(i))) {
                score+=5;
            }
            else {
                score+=0;
            }
        }
        session.setAttribute("score",score);
        return "score";

    }
}
