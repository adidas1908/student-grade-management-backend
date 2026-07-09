package student_grade_management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student_grade_management.dto.teacher.TeacherRequest;
import student_grade_management.entity.Teacher;
import student_grade_management.exception.ResourceNotFoundException;
import student_grade_management.repository.TeacherRepository;
import student_grade_management.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Teacher addTeacher(TeacherRequest request) {

        Teacher teacher = new Teacher();

        teacher.setName(request.getName());
        teacher.setEmail(request.getEmail());
        teacher.setPhone(request.getPhone());
        teacher.setDepartment(request.getDepartment());
        teacher.setDesignation(request.getDesignation());
        teacher.setSalary(request.getSalary());

        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacherById(Long id) {

        return teacherRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Teacher not found"));
    }

    @Override
    public Teacher updateTeacher(Long id, TeacherRequest request) {

        Teacher teacher = getTeacherById(id);

        teacher.setName(request.getName());
        teacher.setEmail(request.getEmail());
        teacher.setPhone(request.getPhone());
        teacher.setDepartment(request.getDepartment());
        teacher.setDesignation(request.getDesignation());
        teacher.setSalary(request.getSalary());

        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacher(Long id) {

        Teacher teacher = getTeacherById(id);

        teacherRepository.delete(teacher);
    }

}