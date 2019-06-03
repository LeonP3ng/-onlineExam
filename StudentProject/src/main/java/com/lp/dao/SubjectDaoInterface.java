package com.lp.dao;

import com.lp.entity.Subject;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectDaoInterface {
	void addSubject(Subject subject);

	List<Subject> findAllSubject();

	Subject findSubjectById(int subjectId);

	List<Integer> findAllSubjectId();
	
	void updateSubject(Subject subject);
	
	void deleteSubject(int subjectId);
	
	List<Subject>findSubjectBySubjectTitle(String subjectTitle);
	
	List<Subject>randomFindSubject();
}
