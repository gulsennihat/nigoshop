package beans;

public class IsletimSistemleri {
	
	public IsletimSistemleri(String isim,String aciklama,String resimAdi)
	{
		this.isim= isim;
		this.aciklama= aciklama;
		this.resimAdi= resimAdi;
	}
	
	String isim;
	String aciklama;
	String resimAdi;
	
	public String getIsim() {
		return isim;
	}
	public void setIsim(String isim) {
		this.isim = isim;
	}
	public String getAciklama() {
		return aciklama;
	}
	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}
	public String getResimAdi() {
		return resimAdi;
	}
	public void setResimAdi(String resimAdi) {
		this.resimAdi = resimAdi;
	}
}