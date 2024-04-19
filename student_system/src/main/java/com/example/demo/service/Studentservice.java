package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repo.Studentrepo;

import ch.qos.logback.classic.Logger;

@Service
public class Studentservice {
	Logger logger=(Logger) LoggerFactory.getLogger(Studentservice.class);
	@Autowired
	private Studentrepo studentRepository;

	public List<Student> getAllStudents() {
		List<Student> findAll=new ArrayList<Student>();
		try {
		logger.info("getallstudent in service class start");
		 findAll = studentRepository.findAll();
//		 findAll=new ArrayList<>();
//		 if(findAll.isEmpty()) {
//			 throw new Exception();
//		 }
			logger.info("getallstudent in service class end");
		}catch(Exception e) {
			logger.error("exception");
			e.printStackTrace();
		}
		return  findAll;
		

		 
		 
	}

	public Student getStudentById(Long id) {
		Optional<Student> studentOptional = studentRepository.findById(id);
		return studentOptional.orElse(null);
	}

	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	public Student updateStudent(Long id, Student studentDetails) {
		Optional<Student> studentOptional = studentRepository.findById(id);
		if (studentOptional.isPresent()) {
			Student student = studentOptional.get();
			student.setName(studentDetails.getName());
			student.setEmail(studentDetails.getEmail());
			return studentRepository.save(student);
		} else {
			return null;
		}
	}

	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}

	public int divide() {
		return 10 / 0;

	}
}
