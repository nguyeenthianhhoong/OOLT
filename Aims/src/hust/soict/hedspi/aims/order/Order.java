package hust.soict.hedspi.aims.order;

import java.util.ArrayList;

import javax.swing.JOptionPane;


import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.utils.MyDate;

public class Order {
	public static final int MAX_NUMBERS_ORDERED = 10;  //final: khai bao hang
    public static final int MAX_LIMITTED_ORDERS = 5;
    
    private static final int numberofOrder = 3;
    private static final float thresholdsTotal = 50;
    private static final float thresholdsSale = 0.3f;

	private int qtyOrdered;
    private static int nbOrders = 0;

	public ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    private MyDate dateOrdered;
	
	private Order() {
        dateOrdered = new MyDate();
    }
   
    public MyDate getDateOrdered() {
		return dateOrdered;
	}


	public static Order getInstanceOrder() { 
        
            nbOrders++;
            Order newOrder = new Order();
            return newOrder;
        }
    
   	public void dateOrder() {
   		dateOrdered.print();
   	}
    
//    public void printDVD() {
//        
//        System.out.println("Ordered DVD Items:");
//        
//        for(int i=0;i<itemsOrdered.size();i++) {
//            System.out.printf("%d. DVD - " + itemsOrdered.get(i).getTitle() + " - " + itemsOrdered.get(i).getCategory() +
//                    " - " + itemsOrdered.get(i).getDirector() + " - %d: %.2f $\n",i+1,itemsOrdered.get(i).getLength(),itemsOrdered.get(i).getCost());
//        }
//        System.out.printf("Total cost: %.2f\n", totalCost());
//        System.out.println("***************************************************");
//    }
    public void printOrdered() {

    	System.out.println("***********************Order***********************");
      System.out.print("Date: ");
      dateOrdered.print();
      System.out.println("Ordered Items:");
      
      for(Media item: itemsOrdered) {
    	  item.print();
      }
      System.out.println("---------------------------------------------------");
      System.out.printf("Total cost: %.2f\n", totalCost());
      System.out.println("***************************************************");
  
    }
	
	public int getQtyOrdered() {
		return qtyOrdered;
	}
	public void setQtyOrdered(int qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}
	
//	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
//		if(qtyOrdered == MAX_NUMBERS_ORDERED) {
//			System.out.println("Insert failed");
//		}
//		else {
//			itemsOrdered[qtyOrdered]= disc;
//			qtyOrdered ++ ;
//			System.out.println("Insert success");
//		}
//	}
//	
	public void addMedias(Media[] media) {
		for(int i=0; i<media.length; i++)
			this.addMedia(media[i]);	
	}
	
	public void addMedia(Media media) {
		itemsOrdered.add(media);
		//media.setId(itemsOrdered.size());
		System.out.println("Insert success");
		
	}
	
	
//	public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
//		if(qtyOrdered +2 >MAX_NUMBERS_ORDERED)
//			System.out.println("Insert failed");
//		else {
//			this.addDigitalVideoDisc(dvd1);
//			this.addDigitalVideoDisc(dvd2);
//		}
//	}
	
//	public void removeDigitalVidelDisc(DigitalVideoDisc disc) {
//		for (int i=0; i< qtyOrdered; i++) {
//			if (itemsOrdered[i] == disc) {
//				for(int j=i; j<qtyOrdered-1; j++) {
//					itemsOrdered[j] = itemsOrdered[j+1];
//				}
//				qtyOrdered--;
//			}
//		}
//	}
	
	public void removeMedia(Media media) {
//	C1
		for(int i=0; i<itemsOrdered.size(); i++) {
			if(itemsOrdered.get(i) == media) {
				itemsOrdered.remove(media);
			}	
		}

//	C2
//		if (itemsOrdered.contains(media)) {
//			itemsOrdered.remove(media);
//		}
	
	}
	
	public int removeMediaId(int id) {
		int check =0;
		for (int i=0; i<itemsOrdered.size();i++ ) {
			if(itemsOrdered.get(i).getId()==id) {
				check =1; 
				removeMedia(itemsOrdered.get(i));
				System.out.println("Media Deleted!");
			}
		}
		if(check == 0) System.out.println("Can't find");
		return check;
	}
	
	
	
//	public float totalCost() {
//		float totalCost = 0.0f;
//		for (int i=0 ; i<qtyOrdered; i++) {
//			totalCost += itemsOrdered[i].getCost();
//		}
//		return totalCost;		
//	}
	
	public float totalCost() {
		float total =0 ;
		Media mediaItem;
		java.util.Iterator iter = itemsOrdered.iterator(); // duyet tuan hoan
		while (iter.hasNext()) {
			mediaItem = (Media) (iter.next());
			total += mediaItem.getCost();
		}
		return total;
	}
	
	public float totalCost1() {
		float total =0;
		for(int i=0;i<itemsOrdered.size();i++) {
			total += itemsOrdered.get(i).getCost();
		}
		return total;
	}
	
//	public Media getALuckyItem() {
//		int i= (int)(Math.random()* qtyOrdered);
//		Media lucky = itemsOrdered.get(i);
//		lucky.setCost(0.0f);
//		return lucky;
//	}
	
//	public Media getALuckyItemm() throws LuckyItemException{
//		if(itemsOrdered.size() >= numberofOrder && this.totalCost() >= thresholdsTotal) {
//			if(checkOrder(this)) {
//				int i=0;
//				do {
//					i= (int)(Math.random()* qtyOrdered);
//				} while (itemsOrdered.get(i).getCost() <= this.totalCost()*thresholdsSale);
//				itemsOrdered.get(i).setCost(0.0f);
//				return itemsOrdered.get(i);
//			}else {
//				throw new LuckyItemException("All products are greater than value of gift (" + totalCost()*thresholdsSale + ")");
//			}
//		}else {
//			throw new LuckyItemException("Not qualify:\n  - Number of Order: " + numberofOrder + "\n  - Total Cost >= " + thresholdsTotal);
//		}
//		
//	}
	
	public Media getALuckyItem() throws Exception{
		if(itemsOrdered.size() >= numberofOrder && this.totalCost() >= thresholdsTotal) {
			if(checkOrder(this)) {
				int item = 0;
				do {
					double random = Math.random();
					random *= itemsOrdered.size();
					item = (int)random;
				} while (itemsOrdered.get(item).getCost() <= this.totalCost()*thresholdsSale);
				itemsOrdered.get(item).setCost(0.0f);
				return itemsOrdered.get(item);
			}else {
				throw new Exception("All products are greater than value of gift (" + totalCost()*thresholdsSale + ")");
			}
		}else {
			throw new Exception("Not qualify:\n  - Number of Order: " + numberofOrder + "\n  - Total Cost >= " + thresholdsTotal);
		}
	}
	
	private boolean checkOrder(Order order) {
		for(Media media: order.itemsOrdered) {
			if(media.getCost() <= order.totalCost()*thresholdsSale)
				return true;
		}
		return false;
	}
}
