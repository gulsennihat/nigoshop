package nihat;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import hibernate.categories;
import hibernate.hibernateUtil;
import hibernate.subCategories;

import org.hibernate.Query;
import org.hibernate.Session;
import org.primefaces.model.menu.*;

@ManagedBean(name="menuBean2")
public class menuBuild implements Serializable {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	public void menu(){
//	Session session= hibernateUtil.getSessionFactory().openSession();
//	Query query = session.createSQLQuery("from categories");
//	List<?> liste = query.list();
//	Iterator<?> iter = liste.iterator();
//	
//	while (iter.hasNext()) {
//    	categories ctg = (categories) iter.next();
//    	System.out.println(ctg.getCategoryName());	
//    	}
//	}
	 MenuModel model = new DefaultMenuModel();

	 public MenuModel getModel() {
	        return model;
	    }  
	    public void save() {
	        addMessage("Success", "Data saved");
	    }
	     
	    public void update() {
	        addMessage("Success", "Data updated");
	    }
	     
	    public void delete() {
	        addMessage("Success", "Data deleted");
	    }
	     
	    public void addMessage(String summary, String detail) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
	 
	 @PostConstruct
	 public void init() {
	   
		Session session= hibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from categories");
		List<?> liste = query.list();
		Iterator<?> iter = liste.iterator();
		System.out.println(liste.size());	
		
		while (iter.hasNext()) {
	    	categories ctg = (categories) iter.next();
	    	String menuad=ctg.getCategoryName();
	    	for(int i=0; i<liste.size();i++){
	    		
			     DefaultSubMenu firstSubmenu = new DefaultSubMenu(ctg.getCategoryName());
			     
		    		Query query2 = session.createQuery("from subcategories where categoryId=?");
		    		query2.setInteger(0, ctg.getCategoryId());
		    		List<?> liste2 = query.list();
		    		Iterator<?> iter2 = liste2.iterator();
		    		while (iter2.hasNext()) {
		    	    	subCategories sctg = (subCategories) iter2.next();
		    		for(int y=0; y<liste2.size();y++){
		    			DefaultMenuItem item = new DefaultMenuItem(sctg.getSubCategoryName());
		    	        item.setUrl("http://www.primefaces.org");
		    	        item.setIcon("ui-icon-home");
		    	        firstSubmenu.addElement(item); 
		    		}
		    		}
		    		model.addElement(firstSubmenu);
	    	}

	    }
		 
	}//main metodunun
	
	
	
	
	
}
