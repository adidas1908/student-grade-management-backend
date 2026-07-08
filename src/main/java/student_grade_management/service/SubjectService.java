package student_grade_management.service;

import java.util.List;

import student_grade_management.dto.subject.SubjectRequest;
import student_grade_management.entity.Subject;

public interface SubjectService {

    Subject addSubject(SubjectRequest request);

    List<Subject> getAllSubjects();

    Subject getSubjectById(Long id);

    Subject updateSubject(Long id, SubjectRequest request);

    void deleteSubject(Long id);

}
