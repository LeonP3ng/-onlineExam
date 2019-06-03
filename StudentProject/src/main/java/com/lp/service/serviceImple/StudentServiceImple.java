package com.lp.service.serviceImple;

import com.lp.dao.StudentDaoInterface;
import com.lp.entity.Student;
import com.lp.service.StudentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImple implements StudentServiceInterface {

    @Autowired
    StudentDaoInterface studentDaoInterface;

    @Override
    public List<Student> findAllStudent() {
        return studentDaoInterface.findAllStudent();
    }

    @Override
    public List<String> findAllStudentId() {
        return studentDaoInterface.findAllStudentId();
    }

    @Override
    public void updateStudent(Student student) {
        studentDaoInterface.updateStudent(student);
    }

    @Override
    public void deleteStudent(String studentId) {
        studentDaoInterface.deleteStudent(studentId);
    }
}
