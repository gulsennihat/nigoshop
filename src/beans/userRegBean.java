package beans;

import java.io.Serializable;
import hibernate.hibernateUtil;
import hibernate.users;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.hibernate.Session;

@ManagedBean(name="userRegBean")
public class userRegBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String email;
	private String password;
	private String surname;
	private String telNumber;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	 public void submit() {
	        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correct", "Correct");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	 
	public String save() {
		Session session= hibernateUtil.getSessionFactory().openSession();
		users user = new users();
		user.setName(this.getName());
		user.setEmail(this.getEmail());
		user.setPassword(this.getPassword());
		user.setSurname(this.getSurname());
		user.setTelNumber(this.getTelNumber());
		
		try{
		session.beginTransaction();
		session.save(user);	
		session.getTransaction().commit();
		session.close();
		return "index";
		
		} catch(Exception ex) {
			System.out.println("hata" +ex + this.getName());
			return "error";
		}
	}
	
}
