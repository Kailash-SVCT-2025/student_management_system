package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.student;
import com.example.demo.repository.Student_repository;

@RestController
public class Student_controller {
	@Autowired
	Student_repository repo;
	//get all students
	//localHost:8080/students
	@GetMapping("/students")
	public List<student>getAllStudents(){
		List<student> students=repo.findAll();
		return students;
		}
	@GetMapping("/students/{id}")
	public student getstudent(@PathVariable int id) {
		student student =repo.findById(id).get();
		return student;
		
	}
	@PostMapping("/students/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void create_student(@RequestBody student student) {
		repo.save(student);
	}
	@PutMapping("/students/update/{id}")
	public void update_student(@PathVariable int id) {
		student student = repo.findById(id).get();
		student.setName("raghul");
		student.setBranch("core");
		student.setPercentage(89.0f);
		repo.save(student);
		
	}
	@DeleteMapping("/students/delete/{id}")
	public void delete_student(@PathVariable int id) {
	student student = repo.findById(id).get();
	repo.delete(student);
	}
}
