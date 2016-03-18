package beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.menu.*;

@ManagedBean(name="menuBean")
public class MenuBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private MenuModel model;
	
	  @PostConstruct
	    public void init() {
	        model = new DefaultMenuModel();
	         
	        //First submenu
	        DefaultSubMenu firstSubmenu = new DefaultSubMenu("Baslik 1");
	         
	        DefaultMenuItem item = new DefaultMenuItem("Alt baslik 1");
	        item.setId("id1");
	        item.setUrl("http://www.primefaces.org");
	        item.setIcon("ui-icon-home");
	        firstSubmenu.addElement(item);
	         
	        model.addElement(firstSubmenu);
	         
	        //Second submenu
	        DefaultSubMenu secondSubmenu = new DefaultSubMenu("baslik 2");
	 
	        item = new DefaultMenuItem("alt baslik 2 1");
	        item.setIcon("ui-icon-disk");
	        item.setCommand("#{menuBean.save}");
	        item.setUpdate("messages");
	        secondSubmenu.addElement(item);
	         
	        item = new DefaultMenuItem("alt baslik 2 2");
	        item.setIcon("ui-icon-close");
	        item.setCommand("#{menuBean.delete}");
	        item.setAjax(false);
	        secondSubmenu.addElement(item);
	         
	        item = new DefaultMenuItem("alt baslik 2 3");
	        item.setIcon("ui-icon-search");
	        item.setCommand("#{menuBean.redirect}");
	        secondSubmenu.addElement(item);
	 
	        model.addElement(secondSubmenu);
	    }
	 
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
	}



