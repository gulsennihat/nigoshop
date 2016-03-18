package nihat;

import java.util.List;

import org.hibernate.Session;

import beans.urunListele;
import hibernate.categories;
import hibernate.hibernateUtil;
import hibernate.products;
import hibernate.subCategories;

public class test {

	public static void main(String[] args) {
//		Session session= hibernateUtil.getSessionFactory().openSession();
//		categories ctg = new categories();
//		subCategories sctg = new subCategories();
//		
//		ctg.setCategoryName("dekorasyon");	
//		sctg.setSubCategoryName("bahce2");
//		
//		
//		subCategories sctg2 = new subCategories();
//		sctg2.setSubCategoryName("evici2");
//		
//		
//		session.beginTransaction();
//		session.save(ctg);
//		session.save(sctg);
//		session.save(sctg2);
//		session.getTransaction().commit();
//    	session.close();
//		
		urunListele dao = new urunListele();
		List<products> listem = dao.dbList();
		for (products prd : listem) {
			System.out.println("Kategori :" + prd.getKategori());
			System.out.println("ürun adi: " + prd.getUrunAdi());
		}
		
		
	}

}
