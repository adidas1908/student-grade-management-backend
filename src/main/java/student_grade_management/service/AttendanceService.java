package student_grade_management.service;

import java.util.List;

import student_grade_management.dto.attendance.AttendanceRequest;
import student_grade_management.entity.Attendance;

public interface AttendanceService {

    Attendance addAttendance(AttendanceRequest request);

    List<Attendance> getAllAttendance();

    Attendance getAttendanceById(Long id);

    Attendance updateAttendance(Long id, AttendanceRequest request);

    void deleteAttendance(Long id);
}