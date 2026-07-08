package student_grade_management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student_grade_management.dto.subject.SubjectRequest;
import student_grade_management.entity.Subject;
import student_grade_management.entity.Teacher;
import student_grade_management.exception.ResourceNotFoundException;
import student_grade_management.repository.SubjectRepository;
import student_grade_management.repository.TeacherRepository;
import student_grade_management.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Subject addSubject(SubjectRequest request) {

        Teacher teacher = teacherRepository.findById(request.getTeacherId())
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found"));

        Subject subject = new Subject();

        subject.setSubjectCode(request.getSubjectCode());
        subject.setSubjectName(request.getSubjectName());
        subject.setCredits(request.getCredits());
        subject.setSemester(request.getSemester());
        subject.setTeacher(teacher);

        return subjectRepository.save(subject);
    }

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject getSubjectById(Long id) {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subject not found"));
    }

    @Override
    public Subject updateSubject(Long id, SubjectRequest request) {

        Subject subject = getSubjectById(id);

        Teacher teacher = teacherRepository.findById(request.getTeacherId())
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found"));

        subject.setSubjectCode(request.getSubjectCode());
        subject.setSubjectName(request.getSubjectName());
        subject.setCredits(request.getCredits());
        subject.setSemester(request.getSemester());
        subject.setTeacher(teacher);

        return subjectRepository.save(subject);
    }

    @Override
    public void deleteSubject(Long id) {

        Subject subject = getSubjectById(id);

        subjectRepository.delete(subject);
    }
}