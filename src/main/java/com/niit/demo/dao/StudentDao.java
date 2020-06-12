package com.niit.demo.dao;

import java.util.List;

import com.niit.demo.model.Student;

public interface StudentDao {

	boolean addStudent(Student student);
	List<Student> getAllStudents();
}
