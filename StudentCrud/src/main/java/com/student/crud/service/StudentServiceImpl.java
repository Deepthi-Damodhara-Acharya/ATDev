package com.student.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.crud.entity.Student;
import com.student.crud.error.RecordNotFoundException;
import com.student.crud.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRep;

	@Override
	public Student saveStudent(Student s) {
		return studentRep.save(s);
	}

	@Override
	public Student updateStudent(Student s) {
		Optional<Student> std=studentRep.findById(s.getRno());
		
		if(std.isPresent()) {
			Student studentUpdate=std.get();
			studentUpdate.setAddress(s.getAddress());
			studentRep.save(studentUpdate);
			return studentUpdate;
		}
		else
		{
			throw new RecordNotFoundException("Student Record is not found");
		}

	}

	@Override
	public Student getStudentByRno(int rno) {
		Optional<Student> std = studentRep.findById(rno);
		
		if(std.isPresent())
		{
			return std.get();
		}
		else
		{
			throw new RecordNotFoundException("Student Record Not Found");
		}
		
	}

	@Override
	public List<Student> getStudents() {
		List<Student> students= studentRep.findAll();
		return students;
	}

	@Override
	public void deleteStudent(int rno) {
		Optional<Student> std= studentRep.findById(rno);
       
		if(std.isPresent())
		{
			studentRep.delete(std.get());
			
		}
		else
		{
			throw new RecordNotFoundException("Student Not Found");
		}
	}

}
