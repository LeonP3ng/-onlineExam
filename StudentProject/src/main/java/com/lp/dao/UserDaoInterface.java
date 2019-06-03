package com.lp.dao;


import com.lp.entity.Student;
import com.lp.entity.Teacher;
import com.lp.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDaoInterface {

    Student findStudentByStudentId(String studentId);
    Teacher findTeacherById(String teacherId);

    void addStudent(Student studnet);
}
