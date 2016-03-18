package nihat;

import org.hibernate.Session;


import hibernate.hibernateUtil;
import hibernate.products;


public class urunEkle {
	public static void main(String[] args) {
		Session session= hibernateUtil.getSessionFactory().openSession();
		products prd = new  products();
		prd.setKategori("dekorasyon");
		prd.setMarkaId(7);
		prd.setUrunAdi("dekoratif masa");
		prd.setUrunKodu("hgf765");
		prd.setDetay("sdgsdfgdfgdfgdfgdfg");
		prd.setSatisFiyati(4);
		
		
		session.beginTransaction();
		session.save(prd);
		session.getTransaction().commit();
    	session.close();
		
		
		
		
	}

}
