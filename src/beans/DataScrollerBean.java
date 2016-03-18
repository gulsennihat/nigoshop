package beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
 
import java.util.List;
import java.util.ArrayList;

@ManagedBean
@SessionScoped
public class DataScrollerBean {
	
	List<IsletimSistemleri> isletimSistemleri;
	
	public List<IsletimSistemleri> getIsletimSistemleri() {
		return isletimSistemleri;
	}
	
	public void setIsletimSistemleri(List<IsletimSistemleri> isletimSistemleri) {
		this.isletimSistemleri = isletimSistemleri;
	}
	
	@PostConstruct
	public void listeyiDoldur()
	{
		isletimSistemleri=new ArrayList<>();
		IsletimSistemleri osx=new IsletimSistemleri("Mac OS X","Mac Bilgisayarlara Özel İşletim Sistemi","osx.png");
		IsletimSistemleri ubuntu=new IsletimSistemleri("Arc Linux","Belirli Düzeyde Linux Bilgisi Olanları Hedefleyen Dağıtım","arch.png");
		IsletimSistemleri fedora=new IsletimSistemleri("Fedora","Red Hat Ticari Linux'un Ücretsiz Dağıtımı","fedora.png");
		IsletimSistemleri arch=new IsletimSistemleri("Linux Mint","Son Kullanıcı Hedefli Kullanımı Kolay Dağıtım","linuxmint.png");
		IsletimSistemleri mint=new IsletimSistemleri("Manjaro","Arch Linux'un Son Kullanıcı Hedeflenmiş Hali","manjaro.png");
		IsletimSistemleri manjaro=new IsletimSistemleri("Ubuntu","Mint İle Beraber Son Kullanıcı Odaklı En Popüler Dağıtımlardan Biri","ubuntu.jpg");
		
		isletimSistemleri.add(osx);
		isletimSistemleri.add(ubuntu);
		isletimSistemleri.add(fedora);
		isletimSistemleri.add(arch);
		isletimSistemleri.add(mint);
		isletimSistemleri.add(manjaro);
		
	}
}
