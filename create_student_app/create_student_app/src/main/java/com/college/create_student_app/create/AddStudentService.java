package com.college.create_student_app.create;

import org.springframework.stereotype.Service;

@Service
public interface AddStudentService {

	public StudentModel addStudentInSystem(StudentModel stu)throws Exception;
}
