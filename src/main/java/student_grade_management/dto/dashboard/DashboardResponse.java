package student_grade_management.dto.dashboard;

public class DashboardResponse {

    private long totalStudents;
    private long totalTeachers;
    private long totalSubjects;
    private long totalMarks;
    private long totalAttendance;

    public DashboardResponse() {
    }

    public DashboardResponse(long totalStudents,
                             long totalTeachers,
                             long totalSubjects,
                             long totalMarks,
                             long totalAttendance) {

        this.totalStudents = totalStudents;
        this.totalTeachers = totalTeachers;
        this.totalSubjects = totalSubjects;
        this.totalMarks = totalMarks;
        this.totalAttendance = totalAttendance;
    }

    public long getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(long totalStudents) {
        this.totalStudents = totalStudents;
    }

    public long getTotalTeachers() {
        return totalTeachers;
    }

    public void setTotalTeachers(long totalTeachers) {
        this.totalTeachers = totalTeachers;
    }

    public long getTotalSubjects() {
        return totalSubjects;
    }

    public void setTotalSubjects(long totalSubjects) {
        this.totalSubjects = totalSubjects;
    }

    public long getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(long totalMarks) {
        this.totalMarks = totalMarks;
    }

    public long getTotalAttendance() {
        return totalAttendance;
    }

    public void setTotalAttendance(long totalAttendance) {
        this.totalAttendance = totalAttendance;
    }
}