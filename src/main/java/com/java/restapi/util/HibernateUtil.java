package com.java.restapi.util;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateUtil {

	public static void resorceClean(Session session, Transaction tr) {
		

		if(session!=null) {
		if(tr!=null) {
			session.flush();
			tr.commit();
		}
		session.close();		
		
		}
      }
		
	}


