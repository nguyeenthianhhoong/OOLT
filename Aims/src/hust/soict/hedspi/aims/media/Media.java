package hust.soict.hedspi.aims.media;

public abstract class Media implements Comparable<Object>{
	protected String title;
	protected String category;
	protected float cost;
	protected int id;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//Constructor
	public Media(String title) {
		this.title = title;
	}
	public Media(String title, String category) {
		this.title = title;
		this.category = category;
	}
	public Media(int id, String title, float cost) {
		this.id = id;
		this.title = title;
		this.cost = cost;
	}
	
	public Media(int id, String title, String category, float cost) {
		this(id, title, cost);
		this.category = category;
	}
	
	public Media(String title, String category, float cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public void print() {
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Media){
			if(this.getTitle().equalsIgnoreCase( ((Media)obj).getTitle() ) && 
					this.getCost() == ((Media)obj).getCost() )
				return true;
		}
		return false;
	}
	
	public int compareTo(Object obj) {
		if(obj instanceof Media) {
			Media media = (Media) obj;
			if(this.id == media.id) return 1;
			if(this.title.equals(media.title)) return 1;
		}
		return 0;
	}
		
}
