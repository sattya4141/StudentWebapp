package com.java.restapi.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.restapi.Dao.StudentDao;
import com.java.restapi.bean.StdBean;
import com.java.restapi.entity.Student;
import com.java.restapi.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	static {
		System.out.println("Student service imp loaded");
	}

	@Autowired
	StudentDao stdDao;

	public Student beanToEntity(StdBean stdBean) {
		Student studentity = new Student();
		studentity.setStdId(stdBean.getStdId());
		studentity.setStdName(stdBean.getStdName());
		studentity.setStdEmail(stdBean.getStdEmail());
		studentity.setStdFees(stdBean.getStdFees());
		
		studentity.setStdAddress(stdBean.getStdAddress());
		return studentity;
	}

	@Override
	public String addNewStudent(StdBean bean) {

		return stdDao.saveStudent(beanToEntity(bean));
	}

	public StdBean studEntityToBean(Student entity) {
		StdBean bean = new StdBean();
		bean.setStdId(entity.getStdId());
		bean.setStdName(entity.getStdName());
		bean.setStdEmail(entity.getStdEmail());
		bean.setStdFees(entity.getStdFees());
		
		bean.setStdAddress(entity.getStdAddress());
		return bean;
	}

	@Override
	public StdBean getStudentById(int stdId) {
		Student entity = stdDao.getStudentById(stdId);
		return studEntityToBean(entity);
	}
	
	@Override
	public StdBean getStudentByName(String studName) {
		//StudentEntity entity = stdDao.getStudentByName(studName);
		//return studEntityToBean(entity);
		return null;
	}

	@Override
	public List<StdBean> listStudent() {
		List<Student> entities = stdDao.getListOfStudent();

		List<StdBean> beans = convertEntitiesToBeans(entities);
		return beans;

	}

	private List<StdBean> convertEntitiesToBeans(List<Student> entities) {
		List<StdBean> list = new ArrayList<StdBean>();
		for (Student std : entities) {
			StdBean bean = studEntityToBean(std);
			bean.setStdId(std.getStdId());
			bean.setStdName(std.getStdName());
			bean.setStdEmail(std.getStdEmail());
			bean.setStdFees(std.getStdFees());
			bean.setStdAddress(std.getStdAddress());
			list.add(bean);
		}
		return list;
	}

	@Override
	public String deleteStudent(int stdId) {

		return stdDao.deleteStudent(stdId);
	}

	@Override
	public StdBean updateStudent(StdBean bean, int stdId) {
		List<Student> studList=stdDao.getListOfStudent();
		System.out.println("list-----"+studList);
				for (Student entity: studList) {
					if(entity.getStdId()==stdId) {
						
						entity.setStdId(bean.getStdId());
						entity.setStdName(bean.getStdName());
						entity.setStdEmail(bean.getStdEmail());
						entity.setStdFees(bean.getStdFees());
						
						entity.setStdAddress(bean.getStdAddress());
			
						return studEntityToBean(stdDao.saveUpdatedStudent(entity));
						
					}
				}
				return null;
			}

}
