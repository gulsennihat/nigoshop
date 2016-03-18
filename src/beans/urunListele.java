package beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.hibernate.Query;
import org.hibernate.Session;

import hibernate.hibernateUtil;
import hibernate.products;


@ManagedBean(name="urunListele")
public class urunListele {

    public List<products> dbList(){
    	
    	//public static void main(String[] args) {
    	Session session= hibernateUtil.getSessionFactory().openSession();
    	session.beginTransaction();
    	List<products> prdList = session.createQuery("from products as p order by p.id desc").list();
    	session.getTransaction().commit();
    	session.close();
  
    	return prdList;
    }

}
