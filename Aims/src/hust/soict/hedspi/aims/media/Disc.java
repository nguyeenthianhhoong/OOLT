package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Disc extends Media {
	protected int length;
	protected String director;
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	
	// constructor
	public Disc(String title, String category) {
		super(title, category);
		// TODO Auto-generated constructor stub
	}
	public Disc(String title) {
		super(title);
	}
	public Disc(String title, String category, int length) {
		super(title,category);
		this.length = length;
	}
	public Disc(String title, String category, float cost) {
		super(title,category);
		this.cost = cost;
	}
	public Disc(String title, String category, int length, float cost) {
		super(title,category,cost);
		this.length = length;
	}
	public Disc(String title, String category, int length, String director) {
		super(title,category);
		this.length = length;
		this.director = director;
	}
	public Disc(String title, String category, int length, String director,float cost) {
		super(title,category,cost);
		this.length = length;
		this.director = director;
	}
	public Disc(int id, String title, float cost) {
		super(id, title, cost);
	}
	
	public Disc(int id, String title, int length, float cost) {
		super(id, title, cost);
		this.length = length;
	}
	
	public Disc(int id, String title, String category, int length, float cost ) {
		super(id, title, category, cost);
		this.length = length;
	}
	
	public Disc(int id, String title, String category, int length, String director, float cost) {
		this(id, title, category, length, cost);
		this.director = director;
	}
	
}
