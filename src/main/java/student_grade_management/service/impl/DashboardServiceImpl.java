package student_grade_management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student_grade_management.dto.dashboard.DashboardResponse;
import student_grade_management.repository.AttendanceRepository;
import student_grade_management.repository.MarksRepository;
import student_grade_management.repository.StudentRepository;
import student_grade_management.repository.SubjectRepository;
import student_grade_management.repository.TeacherRepository;
import student_grade_management.service.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private MarksRepository marksRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public DashboardResponse getDashboard() {

        return new DashboardResponse(
                studentRepository.count(),
                teacherRepository.count(),
                subjectRepository.count(),
                marksRepository.count(),
                attendanceRepository.count()
        );
    }
}