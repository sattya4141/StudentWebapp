package com.java.restapi.service;

import java.util.List;

import com.java.restapi.bean.StdBean;


public interface StudentService {

	public String addNewStudent(StdBean bean);
	public List<StdBean> listStudent();
	public String deleteStudent(int stdId);
	public StdBean getStudentByName(String studName);
	
	public StdBean getStudentById(int stdId);
	
	public StdBean updateStudent(StdBean bean,int stdId);

}
