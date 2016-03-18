package beans;

import hibernate.hibernateUtil;
import hibernate.users;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
//import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Query;
import org.hibernate.Session;

@ManagedBean(name="loginBean")
@SessionScoped
//@RequestScoped
public class LoginBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String email;
    private String password;
    private String dbEmail;
    private String dbPassword;
    private boolean useronline=false;

    public boolean isUseronline() {
        return useronline;
    }

    public void setUseronline(boolean useronline) {
        this.useronline = useronline;
    }
    
//    Connection connection=null;
//    Statement statement=null;
//    ResultSet resultSet=null;
//    String SQL=null;

   
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

     public String logout(){
      FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
      return "/index.xhtml?faces-redirect=true";
    }
      
    public void userLogindbData(String email){
    	Session session= hibernateUtil.getSessionFactory().openSession();
    	Query query = session.getNamedQuery("userLogin");
    	query.setString(0, email);
    	List<?> results = query.list();
    	Iterator<?> iter = results.iterator();
    	while (iter.hasNext()) {
        	users user = (users) iter.next();
        	dbEmail=user.getEmail().toString();
        	dbPassword = user.getPassword().toString();
        	
        	}
    }
    
    public String checkUser()
    {
    	userLogindbData(email);
  
        if(email.equalsIgnoreCase(dbEmail))
        {
  
            if(password.equals(dbPassword))
            { useronline=true;
                return "basarili";
            }
                else
            {
                return "error";
            }
        }
        else
        {
            return "error";
        }
    }
     
//    public void dbData(String email)
//    {
//        try
//        {
//            Class.forName("com.mysql.jdbc.Driver");
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/portal","root","root");
//            statement = connection.createStatement();
//            SQL = "Select * from user where email like ('" + email +"')";
//            resultSet = statement.executeQuery(SQL);
//            resultSet.next();
//            dbEmail = resultSet.getString("email").toString();
//            dbPassword = resultSet.getString("password").toString();
//        }
//        catch(Exception ex)
//        {
//            ex.printStackTrace();
//            System.out.println("Exception Occured in the process (veritabani hatasi):" + ex);
//        }
//    }
//    
//    public String checkValidUser()
//    {
//        dbData(email);
//  
//        if(email.equalsIgnoreCase(dbEmail))
//        {
//  
//            if(password.equals(dbPassword))
//            { useronline=true;
//                return "basarili";
//            }
//                else
//            {
//                return "error";
//            }
//        }
//        else
//        {
//            return "error";
//        }
//    }
}
