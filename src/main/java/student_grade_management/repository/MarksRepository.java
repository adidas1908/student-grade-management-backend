package student_grade_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import student_grade_management.entity.Marks;

@Repository
public interface MarksRepository extends JpaRepository<Marks, Long> {

}