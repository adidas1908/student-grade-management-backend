package student_grade_management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student_grade_management.dto.marks.MarksRequest;
import student_grade_management.entity.Marks;
import student_grade_management.entity.Student;
import student_grade_management.entity.Subject;
import student_grade_management.exception.ResourceNotFoundException;
import student_grade_management.repository.MarksRepository;
import student_grade_management.repository.StudentRepository;
import student_grade_management.repository.SubjectRepository;
import student_grade_management.service.MarksService;

@Service
public class MarksServiceImpl implements MarksService {

    @Autowired
    private MarksRepository marksRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Marks addMarks(MarksRequest request) {

        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        Subject subject = subjectRepository.findById(request.getSubjectId())
                .orElseThrow(() -> new ResourceNotFoundException("Subject not found"));

        Marks marks = new Marks();

        marks.setStudent(student);
        marks.setSubject(subject);

        marks.setInternalMarks(request.getInternalMarks());
        marks.setExternalMarks(request.getExternalMarks());

        int total = request.getInternalMarks() + request.getExternalMarks();

        marks.setTotalMarks(total);

        if (total >= 90) {
            marks.setGrade("A+");
        } else if (total >= 80) {
            marks.setGrade("A");
        } else if (total >= 70) {
            marks.setGrade("B");
        } else if (total >= 60) {
            marks.setGrade("C");
        } else if (total >= 40) {
            marks.setGrade("D");
        } else {
            marks.setGrade("F");
        }

        if (total >= 40) {
            marks.setResult("PASS");
        } else {
            marks.setResult("FAIL");
        }

        return marksRepository.save(marks);
    }

    @Override
    public List<Marks> getAllMarks() {
        return marksRepository.findAll();
    }

    @Override
    public Marks getMarksById(Long id) {

        return marksRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Marks not found"));
    }

    @Override
    public Marks updateMarks(Long id, MarksRequest request) {

        Marks marks = getMarksById(id);

        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        Subject subject = subjectRepository.findById(request.getSubjectId())
                .orElseThrow(() -> new ResourceNotFoundException("Subject not found"));

        marks.setStudent(student);
        marks.setSubject(subject);

        marks.setInternalMarks(request.getInternalMarks());
        marks.setExternalMarks(request.getExternalMarks());

        int total = request.getInternalMarks() + request.getExternalMarks();

        marks.setTotalMarks(total);

        if (total >= 90) {
            marks.setGrade("A+");
        } else if (total >= 80) {
            marks.setGrade("A");
        } else if (total >= 70) {
            marks.setGrade("B");
        } else if (total >= 60) {
            marks.setGrade("C");
        } else if (total >= 40) {
            marks.setGrade("D");
        } else {
            marks.setGrade("F");
        }

        if (total >= 40) {
            marks.setResult("PASS");
        } else {
            marks.setResult("FAIL");
        }

        return marksRepository.save(marks);
    }

    @Override
    public void deleteMarks(Long id) {

        Marks marks = getMarksById(id);

        marksRepository.delete(marks);
    }
}