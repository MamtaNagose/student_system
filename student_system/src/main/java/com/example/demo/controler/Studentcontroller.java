package com.example.demo.controler;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.Studentservice;


@RestController
@RequestMapping("/api/students")
public class Studentcontroller {
	private static final Logger logger=LoggerFactory.getLogger(Studentcontroller.class);

	@Autowired
	private Studentservice studentService;

	@GetMapping("/getAll")
	public List<Student> getAllStudents() {
		logger.trace("get all student with trace");
		logger.info("get all student with info");

		return studentService.getAllStudents();
	}

	@GetMapping("/getById/{id}")
	public Student getStudentById(@PathVariable Long id) {
		return studentService.getStudentById(id);
	}

	@PostMapping("/add")
	public Student createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}

	@PutMapping("/update/{id}")
	public Student updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
		return studentService.updateStudent(id, studentDetails);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return "student deleted by id";
	}

	@GetMapping("/check")
	public int expCheck() {
		return studentService.divide();

	}
}
