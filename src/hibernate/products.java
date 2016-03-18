package hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class products {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String urunAdi;
	private String urunKodu;
	private int markaId;
	private int alisFiyati;
	private int satisFiyati;
	private int karOrani;
	private String detay;
	private String img;
	private String kategori;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	
	
	
}
