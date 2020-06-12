package com.niit.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.demo.dao.StudentDao;
import com.niit.demo.model.Student;

@RestController
public class StudentController {
	
	@Autowired
	private StudentDao studentDao;

	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ResponseEntity<String> addStudent(@RequestBody Student student)
	{
		boolean result = studentDao.addStudent(student);
		if(result)
		{
			return new ResponseEntity<String>("Student Record Inserted Succesfully", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error While inserting data",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping("/getAllStudent")
	public ResponseEntity<List<Student>> getAllStudent()
	{
		return new ResponseEntity<List<Student>>(studentDao.getAllStudents(),HttpStatus.OK);
	}
}
