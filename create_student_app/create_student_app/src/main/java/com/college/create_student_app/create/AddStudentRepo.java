package com.college.create_student_app.create;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddStudentRepo extends JpaRepository<StudentModel, Integer> {

}
