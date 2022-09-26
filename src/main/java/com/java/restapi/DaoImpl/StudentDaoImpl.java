package com.java.restapi.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.java.restapi.Dao.StudentDao;
import com.java.restapi.bean.StdBean;
import com.java.restapi.entity.Student;
import com.java.restapi.util.HibernateUtil;

@Repository
public class StudentDaoImpl implements StudentDao {
	static {
		System.out.println("StudentDaoImpl  Loaded...");
	}

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public String saveStudent(Student entity) {
		Session session = null;
		Transaction tr = null;
		try
		{
			session = sessionFactory.openSession();
			tr = session.beginTransaction();
	
			session.save(entity);
			return "Student Record Saved";
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Problem in Inseration..!");
		}finally {
			HibernateUtil.resorceClean(session, tr);
		}
		return "Inseration Failed";
	}

	
	
	@Override
	public Student getStudentById(int studId) {

		Session session=null;
		Transaction tr=null;
		try {
			session= sessionFactory.openSession();
			tr=session.beginTransaction();

			Student info=session.get(Student.class, studId);
			return info;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			HibernateUtil.resorceClean(session, tr);
		}
		return null;
	}

	@Override
	public Student getStudentByName(String studName) {
		
		return null;
	}

	@Override
	public List<Student> getListOfStudent() {
		Session session = null;
		Transaction tr = null;
		try {
			session = sessionFactory.openSession();
			tr=session.beginTransaction();
			Criteria cr = session.createCriteria(Student.class);
			List<Student> entities=cr.list();
			return entities;
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			HibernateUtil.resorceClean(session, tr);
		}
		return null;
	
	}

	@Override
	public String deleteStudent(int studId) {
		Session session = null;
		Transaction tr = null;
		try {
			session = sessionFactory.openSession();
			tr=session.beginTransaction();
			Student entity=session.get(Student.class, studId);
			session.delete(entity);
			return "student deleted";
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			HibernateUtil.resorceClean(session, tr);
		}
		return null;
	
	}



	@Override
	public Student saveUpdatedStudent(Student entity) {
		Session session=null;
		Transaction tr=null;
		try {
			session= sessionFactory.openSession();
			tr=session.beginTransaction();
			session.update(entity);
			Student stdentity=session.get(Student.class, entity.getStdId());
			return stdentity;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			HibernateUtil.resorceClean(session, tr);
		}
		return null;
	}

	

	



}
