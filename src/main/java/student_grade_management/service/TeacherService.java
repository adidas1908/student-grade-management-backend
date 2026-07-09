package student_grade_management.service;

import java.util.List;

import student_grade_management.dto.teacher.TeacherRequest;
import student_grade_management.entity.Teacher;

public interface TeacherService {

    Teacher addTeacher(TeacherRequest request);

    List<Teacher> getAllTeachers();

    Teacher getTeacherById(Long id);

    Teacher updateTeacher(Long id, TeacherRequest request);

    void deleteTeacher(Long id);

}