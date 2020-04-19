package com.lp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lp.entity.Student;
import com.lp.entity.Subject;
import com.lp.service.StudentServiceInterface;
import com.lp.service.SubjectServiceInterface;
import com.lp.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    StudentServiceInterface studentDaoImpl;
    @Autowired
    SubjectServiceInterface subjectServiceInterface;
    @Autowired
    UserServiceInterface userServiceInterface;
    @Autowired
    PageHelper pageHelper;


    /*
     * 老师后台管理逻辑
     * */

    @RequestMapping("/addSubject")
    public String addSubject(Subject subject, HttpSession session) {
        session.setAttribute("url","/addSubject");
        subjectServiceInterface.addSubject(subject);
        return "redirect:success.jsp";
    }
    @RequestMapping("/controlSubject")
    public String controlSubject(@RequestParam(value="pn",defaultValue="1") Integer pn, HttpSession session) {
        int pageSize=10;
        pageHelper.startPage(pn, pageSize);
        //只有startPage后面的第一条select才会被分页之后的需要再次startPage
        List<Subject> subjects=subjectServiceInterface.findAllSubject();
        List<Integer>ids=subjectServiceInterface.findAllSubjectId();
        PageInfo pageInfo=new PageInfo(subjects);//没想明白这个subjects怎么在spring.xml中得到，就直接new了
        session.setAttribute("PageInfo",pageInfo);
        session.setAttribute("ids",ids);
        return "redirect:controlSubject.jsp";
    }
    @RequestMapping("/showSubject")
    public String showSubject(@RequestParam(value="num",defaultValue="1")int num,HttpSession session) {
        Subject subject=subjectServiceInterface.findSubjectById(num);
        if(subject==null) {
            return "controlSubject";
        }
        session.setAttribute("subject", subject);
        return "redirect:showSubject.jsp";
    }
    @RequestMapping(value="/beforeUpdateSubject")
    public String updateSubject(@RequestParam(value="num",defaultValue="1")int num,HttpSession session) {
        Subject subject=subjectServiceInterface.findSubjectById(num);
        if(subject==null) {
            return "controlSubject";
        }
        session.setAttribute("subject", subject);
        return "redirect:updateSubject.jsp";
    }
    @RequestMapping("/updateSubject")
    public String updateSubject(@RequestParam(value="num",defaultValue="1")int num,Subject subject,HttpSession session) {
        subject.setSubjectId(num);
        subjectServiceInterface.updateSubject(subject);
        session.setAttribute("url", "/updateSubject");
        return "redirect:success.jsp";
    }
    @RequestMapping("/deleteSubject")
    public String deleteSubject(@RequestParam(value="num",defaultValue="1")int num,HttpSession session) {
        subjectServiceInterface.deleteSubject(num);
        session.setAttribute("url","/deleteSubject");
        return "redirect:success.jsp";
    }
    @RequestMapping(value="/findSubject",method=RequestMethod.POST)
    public String findSubject(String subjectTitle,@RequestParam(value="pn",defaultValue="1")int pn,HttpSession session) {
        int pageSize=10;
        pageHelper.startPage(pn, pageSize);
        List<Subject>subjects=subjectServiceInterface.findSubjectBySubjectTitle(subjectTitle);
        List<Integer>ids=subjectServiceInterface.findAllSubjectId();
        PageInfo pageInfo=new PageInfo(subjects);
        session.setAttribute("PageInfo",pageInfo);
        session.setAttribute("ids",ids);
        return "redirect:findSubjectResult.jsp";
    }
    @RequestMapping(value="/findStudent")
    public String findStudent(@RequestParam(value="pn",defaultValue="1")int pn,HttpSession session) {
        int pageSize=10;
        pageHelper.startPage(pn, pageSize);
        List<Student>students=studentDaoImpl.findAllStudent();
        List<String>ids=studentDaoImpl.findAllStudentId();
        PageInfo pageInfo=new PageInfo(students);
        session.setAttribute("PageInfo",pageInfo);
        session.setAttribute("ids",ids);
        return "redirect:findStudent.jsp";
    }
    @RequestMapping("/beforeUpdateStudent")
    public String beforeUpdateStudent(@RequestParam("num")String num,HttpSession session) {
        Student student=userServiceInterface.findStudentByStudentId(num);
        session.setAttribute("student",student);
        return "redirect:updateStudent.jsp";
    }
    @RequestMapping("/updateStudent")
    public String updateStudent(@RequestParam("num")String num,HttpSession session,Student student) {
        student.setStudentId(num);
        studentDaoImpl.updateStudent(student);
        session.setAttribute("url","/updateStudent");
        return "redirect:success.jsp";
    }
    @RequestMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("num")String num,HttpSession session) {
        studentDaoImpl.deleteStudent(num);
        session.setAttribute("url","/deleteStudent");
        return "redirect:success.jsp";
    }



}
