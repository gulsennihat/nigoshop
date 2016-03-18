package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class hibernateUtil {

	 public static SessionFactory sessionFactory = null;

	 public static SessionFactory getSessionFactory() {
	  if(sessionFactory == null) {
	   sessionFactory = new Configuration().configure().buildSessionFactory();
	  }
	  return sessionFactory;
	 }

	 public static void setSessionFactory(SessionFactory sessionFactory) {
	  hibernateUtil.sessionFactory = sessionFactory;
	 }

	}




//public class hibernateUtil {
//
//	public static SessionFactory sessionFactory = null;
//	
//	public static SessionFactory getSessionFactory() {
//
//		if(sessionFactory == null) {
//
//	 sessionFactory = new Configuration().configure().buildSessionFactory();
//		}
//			return sessionFactory;
//		}
//		
//		public static void setSessionFactory(SessionFactory sessionFactory) {
//			 hibernateUtil.sessionFactory = sessionFactory;
//		}
//		
//		
//		
////		Session session= sessionFactory.openSession();
////		session.beginTransaction();
////		session.save(users);
////		session.getTransaction().commit();
//		
//	}


