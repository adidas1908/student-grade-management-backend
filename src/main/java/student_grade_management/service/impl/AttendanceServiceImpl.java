package student_grade_management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student_grade_management.dto.attendance.AttendanceRequest;
import student_grade_management.entity.Attendance;
import student_grade_management.entity.Student;
import student_grade_management.exception.ResourceNotFoundException;
import student_grade_management.repository.AttendanceRepository;
import student_grade_management.repository.StudentRepository;
import student_grade_management.service.AttendanceService;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Attendance addAttendance(AttendanceRequest request) {

        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        Attendance attendance = new Attendance();

        attendance.setStudent(student);
        attendance.setAttendanceDate(request.getAttendanceDate());
        attendance.setStatus(request.getStatus());

        return attendanceRepository.save(attendance);
    }

    @Override
    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    @Override
    public Attendance getAttendanceById(Long id) {

        return attendanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Attendance not found"));
    }

    @Override
    public Attendance updateAttendance(Long id, AttendanceRequest request) {

        Attendance attendance = getAttendanceById(id);

        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        attendance.setStudent(student);
        attendance.setAttendanceDate(request.getAttendanceDate());
        attendance.setStatus(request.getStatus());

        return attendanceRepository.save(attendance);
    }

    @Override
    public void deleteAttendance(Long id) {

        Attendance attendance = getAttendanceById(id);

        attendanceRepository.delete(attendance);
    }
}