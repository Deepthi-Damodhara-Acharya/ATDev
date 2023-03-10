package com.student.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.crud.entity.Student;
import com.student.crud.service.StudentService;


@RestController
public class StudentController {

	@Autowired
	StudentService stdService;
	
	@PostMapping("/student")      
	public ResponseEntity<Student> saveStudent(@RequestBody Student s)
	{
		return ResponseEntity.ok().body(stdService.saveStudent(s));
	}
	
	@PutMapping("/student/{rno}")
	public ResponseEntity<Student> updateStudent(@PathVariable int rno,@RequestBody Student s){
		s.setRno(rno);
		return ResponseEntity.ok().body(stdService.updateStudent(s));
	}
	
	@GetMapping("/student/{rno}")
	public ResponseEntity<Student> getStudentByRno(@PathVariable int rno){
		return ResponseEntity.ok().body(stdService.getStudentByRno(rno));
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getStudents(){
		return ResponseEntity.ok().body(stdService.getStudents());
	}
	
	@DeleteMapping("/student/{rno}")
	public HttpStatus deleteStudent(@PathVariable int rno){
		stdService.deleteStudent(rno);
		return HttpStatus.OK;
	}
}
