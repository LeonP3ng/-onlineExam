package com.lp.service.serviceImple;

import com.lp.dao.SubjectDaoInterface;
import com.lp.entity.Subject;
import com.lp.service.SubjectServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImple implements SubjectServiceInterface {
    @Autowired
    SubjectDaoInterface subjectDaoInterface;

    @Override
    public void addSubject(Subject subject) {
        subjectDaoInterface.addSubject(subject);
    }

    @Override
    public List<Subject> findAllSubject() {
        return subjectDaoInterface.findAllSubject();    }

    @Override
    public Subject findSubjectById(int subjectId) {
        return subjectDaoInterface.findSubjectById(subjectId);
    }

    @Override
    public List<Integer> findAllSubjectId() {
        return subjectDaoInterface.findAllSubjectId();    }

    @Override
    public void updateSubject(Subject subject) {
        subjectDaoInterface.updateSubject(subject);
    }

    @Override
    public void deleteSubject(int subjectId) {
        subjectDaoInterface.deleteSubject(subjectId);
    }

    @Override
    public List<Subject> findSubjectBySubjectTitle(String subjectTitle) {
        return subjectDaoInterface.findSubjectBySubjectTitle(subjectTitle);    }

    @Override
    public List<Subject> randomFindSubject() {
        return subjectDaoInterface.randomFindSubject();    }
}
