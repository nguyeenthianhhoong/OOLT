package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;



public class TestMediaCompareTo {
	
	
	public static void main(String[] args) {
		//List<DigitalVideoDisc> list = new ArrayList();
		java.util.Collection collection = new java.util.ArrayList();
		
		DigitalVideoDisc d1 = new DigitalVideoDisc("The Lion King");
		d1.setCategory("Animation");
		d1.setCost(25.03f);
		d1.setDirector("Roger Allers");
		d1.setLength(87);
			
				
	    DigitalVideoDisc d2 = new DigitalVideoDisc("Mulan");
		d2.setCategory("Animation");
		d2.setCost(33.23f);
		d2.setDirector("John Lasseter");
		d2.setLength(112);
					
		DigitalVideoDisc d3 = new DigitalVideoDisc("Toy Story");
		d3.setCategory("Animation");
		d3.setCost(20.01f);
		d3.setDirector("Allers");
		d3.setLength(90);
		
		
		collection.add(d1);
		collection.add(d2);
		collection.add(d3);
		
		java.util.Iterator iterator = collection.iterator()	;
		
		System.out.println("---------------------------");
		System.out.println("The DVDs currently in the order are: ");
		while( iterator.hasNext()) {
			//System.out.println(((DigitalVideoDisc) iterator.next()).getTitle());
			((DigitalVideoDisc) iterator.next()).print();
		}
		
		java.util.Collections.sort((java.util.List)collection);
		
		iterator = collection.iterator();
		System.out.println("---------------------------");
		System.out.println("The DVDs in sorted order are: ");
		
		while( iterator.hasNext()) {
			//System.out.println(((DigitalVideoDisc) iterator.next()).getTitle());
			((DigitalVideoDisc) iterator.next()).print();
		}
	}

}
