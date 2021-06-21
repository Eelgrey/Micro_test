package com.college.create_student_app.create;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddStudentTxnRepo extends JpaRepository<StudentModelTxn, Integer> {

}

