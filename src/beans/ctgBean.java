package beans;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;


import org.eclipse.jdt.internal.compiler.batch.Main;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import hibernate.categories;
import hibernate.hibernateUtil;
import hibernate.products;
import hibernate.subCategories;


@ManagedBean
public class ctgBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ctgName;
	private String subCtgName;
	private int ctgId;
	private String option;
	private List<String> ctgList;
	
	
	

	public List<String> getCtgList() {
		return ctgList;
	}
	public void setCtgList(List<String> ctgList) {
		this.ctgList = ctgList;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public String getCtgName() {
		return ctgName;
	}
	public void setCtgName(String ctgName) {
		this.ctgName = ctgName;
	}	
	public String getSubCtgName() {
		return subCtgName;
	}
	public void setSubCtgName(String subCtgName) {
		this.subCtgName = subCtgName;
	}
	public int getCtgId() {
		return ctgId;
	}
	public void setCtgId(int ctgId) {

		this.ctgId = ctgId;
	}

	public String addCtg() {
		
		Session session= hibernateUtil.getSessionFactory().openSession();
		categories ctg = new categories();
		ctg.setCategoryName(this.getCtgName());
	
		try{
		session.beginTransaction();
		
		session.save(ctg);	
		
		session.getTransaction().commit();
		session.close();
		return "index";
		
		} catch(Exception ex) {
			System.out.println("hata" +ex );
			return "error";
		}
	}
	
	public String addSubCtg() {
		Session session= hibernateUtil.getSessionFactory().openSession();
		subCategories subCtg = new subCategories();
		
	
		subCtg.setCategoryId(this.getCtgId());
		subCtg.setSubCategoryName(this.getSubCtgName());
		subCtg.setCategoryId(this.getCtgId());
	
		try{
		session.beginTransaction();
		
		session.save(subCtg);	
		
		session.getTransaction().commit();
		session.close();
		return "index";
		
		} catch(Exception ex) {
			System.out.println("hata" +ex );
			return "error";
		}
	}
	
	
	public List<categories> categories(){
		//public static void main(String[] args) {
    	Session session= hibernateUtil.getSessionFactory().openSession();
    	session.beginTransaction();   
    	List<categories> ctg = session.createSQLQuery("select categoryId from categories").list();
    	session.getTransaction().commit();
    	session.close();

    	
    	return ctg;
    	
    }
	
	
	
}
