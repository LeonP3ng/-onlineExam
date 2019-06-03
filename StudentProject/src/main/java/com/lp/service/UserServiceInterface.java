package com.lp.service;

import com.lp.entity.Student;
import com.lp.entity.Teacher;
import org.apache.ibatis.annotations.Param;


public interface UserServiceInterface {

    Student findStudentByStudentId(String studentId);

    Teacher findTeacherById(String teacherId);

    void addStudent(Student studnet);

}
