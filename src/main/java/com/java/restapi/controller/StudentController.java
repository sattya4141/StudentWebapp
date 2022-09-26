package com.java.restapi.controller;

import java.lang.annotation.Annotation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.restapi.bean.StdBean;
import com.java.restapi.entity.Student;
import com.java.restapi.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService stdservice;

	@PostMapping("/")
	public String saeStudenttInfo(@RequestBody StdBean stdBean) {
		System.out.println(stdBean);
		stdservice.addNewStudent(stdBean);
		return "Student Save method is called..";
	}

	@GetMapping("/{stdId}")
	public StdBean searchStudentById(@PathVariable("stdId") int stdId) {
		StdBean bean = stdservice.getStudentById(stdId);
		System.out.println("std by id----" + bean);
		return bean;
	}
	


	@GetMapping("/list")
	public List<StdBean> listofStudent() {

		List<StdBean> bean = stdservice.listStudent();
		System.out.println("std by id----" + bean);
		return bean;
	}

	@DeleteMapping("/{stdId}")

	public ResponseEntity deleteStudent(@PathVariable("stdId") int stdId) {
		stdservice.deleteStudent(stdId);

		return new ResponseEntity("student deleted successfully",HttpStatus.OK);

	}
	
	@PutMapping("/{stdId}")
	public ResponseEntity updateStudentById(@RequestBody StdBean bean, @PathVariable("stdId") int stdId) {
		System.out.println("std by id----"+bean);
		StdBean studentBean=stdservice.updateStudent(bean,stdId);
		if(stdId==bean.getStdId()) {
 
		System.out.println(studentBean);
		return new ResponseEntity(studentBean,HttpStatus.OK);
		}		
		return new ResponseEntity("No student found of given id...",HttpStatus.OK);

	}
			
		
}
