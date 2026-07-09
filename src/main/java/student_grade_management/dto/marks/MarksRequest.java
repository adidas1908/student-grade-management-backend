package student_grade_management.dto.marks;

import jakarta.validation.constraints.NotNull;

public class MarksRequest {

    @NotNull
    private Long studentId;

    @NotNull
    private Long subjectId;

    @NotNull
    private Integer internalMarks;

    @NotNull
    private Integer externalMarks;

    public MarksRequest() {
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getInternalMarks() {
        return internalMarks;
    }

    public void setInternalMarks(Integer internalMarks) {
        this.internalMarks = internalMarks;
    }

    public Integer getExternalMarks() {
        return externalMarks;
    }

    public void setExternalMarks(Integer externalMarks) {
        this.externalMarks = externalMarks;
    }
}