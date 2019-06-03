package com.lp.dao;

import com.lp.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDaoInterface {

  List<Student>findAllStudent();

  List<String>findAllStudentId();

  void updateStudent(Student student);

  void deleteStudent(String studentId);
}
