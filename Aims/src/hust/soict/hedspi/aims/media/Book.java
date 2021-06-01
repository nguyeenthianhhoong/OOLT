package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
//	private String title;
//	private String category;
//	private float cost;
	private List<String> authors = new ArrayList<String>();

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	
	//Constructor
	public Book (String title){
		super(title);
	}
	public Book(String title, String category) {
		super(title,category);
	}
	public Book(String title, String category, List<String> authors) {
		super(title, category);
		this.authors= authors;
	}
	public Book(String title, String category,  float cost) {
		super(title, category);
		this.cost = cost;
	}
	public Book(String title, String category, List<String> authors, float cost) {
		super(title, category);
		this.authors= authors;
		this.cost = cost;
	}
	
	public Book(int id, String title, float cost) {
		super(id, title, cost);
	}
	
	public Book(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}
	public Book(int id, String title, String category, float cost, ArrayList<String> authors) {
		super(id, title, category, cost);
		if(authors.size() != 0) {
			this.authors = authors;
		}else {
			System.out.println("Authors list is empty!");
		}
	}
	
	
	public void addAuthor(String authorName){
		if (!(authors.contains(authorName))) {
			authors.add(authorName);
		}
	}
	
	public void removeAuthor(String authorName) {
		if((authors.contains(authorName))) {
			authors.remove(authorName);
		}
	}
	
	@Override
	public void print() {
		//System.out.println(getId()+". Book: "+getTitle()+" - "+ getCategory()+ " - "+getAuthors()+ " - "+getCost()+"$");
		System.out.printf("%d. BOOK: %s - %s - %.2f$ - %s \n",
				getId(),getTitle(),getCategory(),getCost(),getAuthors());

	}

}
