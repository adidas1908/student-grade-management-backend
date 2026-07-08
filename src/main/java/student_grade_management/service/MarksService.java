package student_grade_management.service;

import java.util.List;

import student_grade_management.dto.marks.MarksRequest;
import student_grade_management.entity.Marks;

public interface MarksService {

    Marks addMarks(MarksRequest request);

    List<Marks> getAllMarks();

    Marks getMarksById(Long id);

    Marks updateMarks(Long id, MarksRequest request);

    void deleteMarks(Long id);
}