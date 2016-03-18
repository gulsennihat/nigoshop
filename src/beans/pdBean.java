package beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import org.hibernate.Session;

import hibernate.hibernateUtil;
import hibernate.products;

@ManagedBean
public class pdBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String urunId; // db tencekmek icin
	
	//db eklemek icin
	private String urunAdi;
	private String urunKodu;
	private int markaId;
	private int alisFiyati;
	private int satisFiyati;
	private int karOrani;
	private String detay;
	private String img;
	private String kategori;

	public String getUrunId() {
				return urunId;
			}

			public void setUrunId(String urunId) {
				this.urunId = urunId;
			}
			
			// db eklemwk icin

public String getUrunAdi() {
				return urunAdi;
			}

			public void setUrunAdi(String urunAdi) {
				this.urunAdi = urunAdi;
			}

			public String getUrunKodu() {
				return urunKodu;
			}

			public void setUrunKodu(String urunKodu) {
				this.urunKodu = urunKodu;
			}

			public int getMarkaId() {
				return markaId;
			}

			public void setMarkaId(int markaId) {
				this.markaId = markaId;
			}

			public int getAlisFiyati() {
				return alisFiyati;
			}

			public void setAlisFiyati(int alisFiyati) {
				this.alisFiyati = alisFiyati;
			}

			public int getSatisFiyati() {
				return satisFiyati;
			}

			public void setSatisFiyati(int satisFiyati) {
				this.satisFiyati = satisFiyati;
			}

			public int getKarOrani() {
				return karOrani;
			}

			public void setKarOrani(int karOrani) {
				this.karOrani = karOrani;
			}

			public String getDetay() {
				return detay;
			}

			public void setDetay(String detay) {
				this.detay = detay;
			}

			public String getImg() {
				return img;
			}

			public void setImg(String img) {
				this.img = img;
			}

			public String getKategori() {
				return kategori;
			}

			public void setKategori(String kategori) {
				this.kategori = kategori;
			}
//--------
			
public String yonlendir(){
	return "/productDetail.xhtml?faces-redirect=true";
}

public List<products> dbPdDetail(){
    
    	Session session= hibernateUtil.getSessionFactory().openSession();
    	session.beginTransaction();
    	List<products> prdList = session.createQuery("from products where id=" +getUrunId()).list();
    	session.getTransaction().commit();
    	session.close();
  
    	return prdList;
    	
    }


// db urun save
public String save() {
	Session session= hibernateUtil.getSessionFactory().openSession();
	products product = new products();
	product.setUrunAdi(this.getUrunAdi());
	product.setKategori(this.getKategori());
	product.setImg(this.getImg());
	product.setSatisFiyati(this.getSatisFiyati());
	product.setDetay(this.getDetay());
	
	try{
	session.beginTransaction();
	session.save(product);	
	session.getTransaction().commit();
	session.close();
	
	return "addProduct";
	
	} catch(Exception ex) {
		System.out.println("hata" +ex );
		return "error";
	}
}



}
