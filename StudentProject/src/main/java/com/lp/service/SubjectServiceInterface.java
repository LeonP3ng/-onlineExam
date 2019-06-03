package com.lp.service;

import com.lp.entity.Subject;

import java.util.List;

public interface SubjectServiceInterface {

    void addSubject(Subject subject);

    List<Subject> findAllSubject();

    Subject findSubjectById(int subjectId);

    List<Integer> findAllSubjectId();

    void updateSubject(Subject subject);

    void deleteSubject(int subjectId);

    List<Subject>findSubjectBySubjectTitle(String subjectTitle);

    List<Subject>randomFindSubject();
}
