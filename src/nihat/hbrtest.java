package nihat;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import hibernate.hibernateUtil;
import hibernate.users;

public class hbrtest {

	public static void veriler(){
		Session session= hibernateUtil.getSessionFactory().openSession();
		String hql = "FROM users";
		Query query = session.createQuery(hql);
		String results = query.toString();
		System.out.println("size of list result=" + results);
		
		
//		session.beginTransaction();
//		
//		session.getTransaction().commit();
	}
	
	public static void main(String[] args) {
		Session session= hibernateUtil.getSessionFactory().openSession();
		users user = new users();
		user.setName("leyla");
		user.setEmail("leyla");
		user.setPassword("123");
		user.setSurname("leyla");
		user.setTelNumber("4565454");
		
		try{
		session.beginTransaction();
		session.save(user);	
		session.getTransaction().commit();
		
		
		} catch(Exception ex) {
			System.out.println("hata" +ex);
			
		}
		
		
		
		
		
	}
}
