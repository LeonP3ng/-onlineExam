package com.lp.service;

import com.lp.entity.Student;

import java.util.List;

public interface StudentServiceInterface {

    List<Student> findAllStudent();
    List<String>findAllStudentId();
    void updateStudent(Student student);
    void deleteStudent(String studentId);
}
