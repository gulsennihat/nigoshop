package beans;

import java.io.Serializable;
import java.sql.*;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="registerBean")
public class RegisterBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getSurname() {
	        return surname;
	    }

	    public void setSurname(String surname) {
	        this.surname = surname;
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
	    private String surname;
	    private String email;
	    private String password;
	    
	    public String dbSave()
	    {
	        PreparedStatement ps = null;
	        Connection connection = null;
	        int i=0;
	        try
	        {
	            Class.forName("com.mysql.jdbc.Driver");
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/portal","root","root");
	            ps = (PreparedStatement) connection.prepareStatement("INSERT INTO user(name, surname,"
	                    + " email, password) VALUES(?,?,?,?)");
	             ps.setString(1, name);
	             ps.setString(2, surname);
	             ps.setString(3, email);
	             ps.setString(4, password);
	             i=ps.executeUpdate();//executeUpdate verilen sorguyu çalıştırır ve integer değer döndürür.
	            //exequteUdate eğer 0'dan büyük değer döndürürse kayıt başarılı olmuş demektir. 
	        }
	        catch(Exception ex)
	        {
	            ex.printStackTrace();
	            System.out.println("Exception Occured in the process (veritabani hatasi):" + ex);
	        }
	         finally //Ne olursa olsun her koşulda çalışacak kısım 
	        {
	            try{
	            connection.close();
	            ps.close();
	            }
	            catch(Exception e)
	            {
	                System.out.println(e);
	            }
	        }
	        if(i>0) //Sorgu başarılı olarak çalışınca i 0'dan büyük oluyor ve bizi başarılı sayfasına yönlediriyor.
	        {
	        return "basarili";
	        }
	        else //Sorgu başarısız ise başarısız sayfasına gidiyoruz.
	        {
	        return "basarisiz";
	        }
	    }
}
