package nihat;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.faces.model.ResultSetDataModel;

import org.hibernate.Query;
import org.hibernate.Session;

import hibernate.categories;
import hibernate.hibernateUtil;



public class menuItems {
	
	private Set<String> liste = new HashSet<String>();
	
	public void islem(){
		Session session= hibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from categories");
		List<?> results = query.list();
		Iterator<?> iter = results.iterator();	
		while (iter.hasNext()) {
	    	categories ctg = (categories) iter.next();
	    	liste.add(ctg.getCategoryName());
	    	System.out.println(ctg.getCategoryName());	
	    	}
	}
	
	
	public static void main(String[] args)
	{
		Session session= hibernateUtil.getSessionFactory().openSession();
		Query query = session.createSQLQuery(	
				 "SELECT c.categoryId, s.subCategoryId,"
				+ " c.categoryName, s.subCategoryName FROM niko.categories c LEFT JOIN"
				+ " niko.subcategories s ON c.categoryId=s.categoryId");
		
//		"select new menupojo(c.categoryId, s.subCategoryId, c.categoryName, s.subCategoryName)"
//		+ " from niko.categories c left join niko.subcategories s"
//		+ " ON c.categoryId=s.categoryId");
		
		List<Object[]> results = query.list();
		Iterator iter = results.iterator();
//		
//		 while(iter.hasNext()){  
//			Object Object=(Object) iter.next();
//			menupojo mp = (menupojo) Object;	
//			   System.out.println(mp.getCategoryName());
//			  
//		 }
//		System.out.println(results.get(0) + " " + results.get(1) );
		Map<Integer,String> basliklar = new HashMap<Integer, String>();
		for(Object[] ct : results){
			basliklar.put((Integer) ct[1], ct[3].toString());
//			System.out.println(ct[3].toString());
		}
		 Set<Integer> keys = basliklar.keySet();
	       //Kural treeset elemanları natural ordering ile sıralar
	      Iterator<Integer> it = keys.iterator();
	      while(it.hasNext())
	      {
	           System.out.println(basliklar.get(1));
	      }
		
//		Iterator<menupojo> iter = results.iterator();	
//		while (iter.hasNext()) {
//			Object ctg = (Object) iter.next();
//	    	System.out.println(ctg.getClass());	
//	    	}
	}
    
}
