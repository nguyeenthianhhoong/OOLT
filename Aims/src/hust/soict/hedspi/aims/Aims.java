package hust.soict.hedspi.aims;

import java.util.Scanner;

import javax.swing.JOptionPane;

import hust.soict.hedspi.aims.PlayerException;
import hust.soict.hedspi.aims.order.Order;
import hust.soict.hedspi.aims.media.*;


public class Aims {
	public static void showMenu() {
		System.out.println("Order Management Application: ");
		System.out.println("--------------------------------");
		System.out.println("1. Create new order");
		System.out.println("2. Add item to the order");
		System.out.println("3. Delete item by id");
		System.out.println("4. Display the items list of order");
		System.out.println("0. Exit");
		System.out.println("---------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		}
		
	public static void main(String[] args) {
		MemoryDaemon md = new MemoryDaemon();
		Thread thread = new	Thread(md);
		thread.setDaemon(true);
		thread.start();
		
		Scanner sc= new Scanner(System.in);
		Order order = Order.getInstanceOrder();
		
		DigitalVideoDisc dvd;
		Book b;
		CompactDisc cd;
		int ord =0, choose, length;
		int iAuthor;
		String title,category,director,author,artist;
		float cost;
		do {
			showMenu();
			choose =sc.nextInt();
			switch(choose) {
			case 1: 
				System.out.println("Create DVD (1) or Book (2) or CompactDisc (3): ");
				ord =sc.nextInt();
				break;
			case 2:
				if(ord == 1) {
					System.out.println("Title:");
					sc.nextLine();
					title= sc.nextLine();
					System.out.println("Category:");
					category =sc.nextLine();
					System.out.println("Director:");
					director = sc.nextLine();
					System.out.println("Length:");
					length = sc.nextInt();
					System.out.println("Cost:");
					cost = sc.nextFloat();
					//cost = Float.parseFloat(sc.nextLine());
					dvd= new DigitalVideoDisc(title,category,director,length,cost);
					order.addMedia(dvd);
				}else if(ord ==2) {
					System.out.println("Title:");
					sc.nextLine();
					title= sc.nextLine();
					System.out.println("Category:");
					category =sc.nextLine();
					System.out.println("Cost:");
					cost = sc.nextFloat();
					b = new Book(title,category,cost);
					System.out.printf("Authors's number:");
					iAuthor = sc.nextInt();
					//iAuthor = Integer.parseInt(sc.nextLine());
					System.out.println("Author's name:");
					sc.nextLine();
					for(int i=0;i<iAuthor; i++) {
						author = sc.nextLine();
						b.addAuthor(author);
					}
					order.addMedia(b);
				}else {
					System.out.println("Title:");
					sc.nextLine();
					title= sc.nextLine();
					System.out.println("Category:");
					category =sc.nextLine();
					System.out.println("Artist:");
					artist = sc.nextLine();
					System.out.println("Cost:");
					cost = sc.nextFloat();
					cd = new CompactDisc(title,category,artist,cost);
					
					System.out.printf("Track's number: ");
					int count = sc.nextInt();
					//sc.nextLine();
					Track track ;
					String titleTrack;
					int lengthTrack;
					for(int i = 0; i < count; i++) {
						System.out.println("Track " + (i+1));
						System.out.println("Title: ");
						sc.nextLine();
						titleTrack = sc.nextLine();
						System.out.println("Length: ");
						lengthTrack = sc.nextInt();
						track = new Track(titleTrack, lengthTrack);
						cd.addTrack(track);
						//sc.nextLine();
					}
					order.addMedia(cd);
				}
				break;
			case 3:		
				System.out.println("Enter ID:");
				int id= sc.nextInt();
				order.removeMediaId(id);
				break;
			case 4:
//				try {
//					 order.getALuckyItemm();
//				} catch (Exception e2) {
//					JOptionPane.showMessageDialog(null, e2.getMessage(), "LUCKY ITEM", JOptionPane.WARNING_MESSAGE);
//				}
				order.printOrdered();
				break;
			case 0:
				System.out.println("Bye!");
				break;
			}
		}while(choose != 0);

	}

}
