package com.niit.demo.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.niit.demo.dao.StudentDao;
import com.niit.demo.model.Student;

@Repository(value="studentDao")
@Component
@Transactional
public class StudentDAOImpl implements StudentDao {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public boolean addStudent(Student student) {
		try
		{
			sessionFactory.openSession().save(student);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Student> getAllStudents() {

		try
		{
			List<Student> allStudents = sessionFactory.openSession().createQuery("from Student").list();
			return allStudents;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}

}
