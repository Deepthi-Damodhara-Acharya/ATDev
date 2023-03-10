package com.student.crud.service;

import java.util.List;
import com.student.crud.entity.Student;

public interface StudentService {
	
	Student saveStudent(Student s);
	Student updateStudent(Student s);
	Student getStudentByRno(int rno);
	List<Student> getStudents();
	void deleteStudent(int rno);

}
