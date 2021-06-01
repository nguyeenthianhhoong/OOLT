package hust.soict.hedspi.test.disc;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class TestPassingParameter {

	public static void main(String[] args) {
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
	
		swap(jungleDVD,cinderellaDVD);
		System.out.println("jungle dvd title: "+ jungleDVD.getTitle());
		System.out.println("cinderella dvd title: "+ cinderellaDVD.getTitle());
		
		changeTitle(jungleDVD,cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: "+ jungleDVD.getTitle());

	}
	
	public static void swap(Object o1,Object o2) {//truyen ban sao tham so cua doi tuong
		Object tmp=o1;
		o1=o2;
		o2=tmp;
	}
	
	public static void changeTitle(DigitalVideoDisc dvd,String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);//truy cap den vung nho va thay doi noi dung
		dvd = new DigitalVideoDisc(oldTitle);
	}

}
