package com.java.restapi.Dao;

import java.util.List;

import com.java.restapi.bean.StdBean;
import com.java.restapi.entity.Student;

public interface StudentDao {

	public String saveStudent(Student entity);
	public List<Student> getListOfStudent();
	public String deleteStudent(int stId);
	public Student getStudentByName(String stdName);
	public Student saveUpdatedStudent(Student entity);
	public Student getStudentById(int stdId);
	

	

}
