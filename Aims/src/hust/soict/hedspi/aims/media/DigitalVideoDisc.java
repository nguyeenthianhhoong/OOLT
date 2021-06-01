package hust.soict.hedspi.aims.media;
import java.util.List;
import java.util.Scanner;

import hust.soict.hedspi.aims.PlayerException;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class DigitalVideoDisc extends Disc implements Playable {
//	private String title;
//	private String category;
//	private String director;
//	private int length;
//	private float cost;
//	public String getDirector() {
//		return director;
//	}
//	public void setDirector(String director) {
//		this.director = director;
//	}
//	public int getLength() {
//		return length;
//	}
//	public void setLength(int length) {
//		this.length = length;
//	}

	
	// Xay dung cac phuong thuc khoi tao lop
	// Constructor method
//	public DigitalVideoDisc() {
//		this.title = "noname";
//		this.category = "unknown";
//		this.director = "unknown";
//		this.length = 0;
//		this.cost = 0.0f;
//	}
	
	public DigitalVideoDisc(String title) {
		super(title);
	}
	
	public DigitalVideoDisc(String title, String category) {
		super(title,category);
	}
	
	public DigitalVideoDisc(String title, String category, int length) {
		super(title,category,length);
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title,category,length,director);
		this.cost= cost;
	}
	
	public DigitalVideoDisc(int id, String title, int length, float cost) {
		super(id, title, length, cost);
	}
	
	public DigitalVideoDisc(int id, String title, String category, int length, float cost) {
		super(id, title, category, length, cost);
	}
	
	public DigitalVideoDisc(int id, String title, String category, int length, String director, float cost) {
		super(id, title, category, length, director, cost);
	}
	

	@Override
	public void print() {
		System.out.printf("%d. DVD: %s - %s - %.2f$ - %s - %dm\n",
				getId(),getTitle(),getCategory(),getCost(),getDirector(),getLength());

	}	

	public boolean search(String title) {
		String stitle = this.title.toLowerCase();
		String s = title.toLowerCase();
		String str[] = s.split(" ");
		for(int i=0; i< str.length; i++) {
			if(!stitle.contains(str[i]))
				return false;
			else return true;
		}
		return false;
	}
	
//	public void play() {
//		System.out.println("Playing DVD: " + this.getTitle());
//		System.out.println("DVD length: " + this.getLength());
//
//	}
	
	public void play() throws PlayerException {
		if(this.getLength() > 0) {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
		}else {
			throw new PlayerException("ERROR: DVD length is non-positive");
		}
	}
	
	public int compareTo(Media media) {
		if(media instanceof DigitalVideoDisc) {
			if(this.getCost() < media.getCost())
				return -1;
			else if(this.getCost() == media.getCost())
				return 0;
			else return 1;
		}else {
			return super.compareTo(media);
		}
	}
}
