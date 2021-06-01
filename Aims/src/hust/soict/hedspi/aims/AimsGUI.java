package hust.soict.hedspi.aims;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.order.Order;
import hust.soict.hedspi.aims.utils.MyDate;

public class AimsGUI extends JFrame{
	protected JButton createButton = new JButton("Create new Order");;
	protected JButton addButton = new JButton("Add item to the order");
	protected JButton deleteButton = new JButton("Delete item by Id");
	protected JButton displayButton =  new JButton("Display the items of list order ");
	protected JButton exitButton = new JButton("Exit");
	
	public static Order anOrder;
	private Calendar date = Calendar.getInstance();;
	
	public  AimsGUI() {
		
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
		String day = dayFormat.format(date.getTime());
		
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setResizable(false);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - 500))/2;
		int y = (int) ((dimension.getHeight() - 500))/2;
		setLocation(x, y);
		setVisible(true);
		setTitle("Order System");
		
		//createButtonSetting();
		createButton.setSize(300, 60);
		createButton.setLocation(100,20);
		createButton.setFocusPainted(false);
		createButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
					anOrder = Order.getInstanceOrder();
					JOptionPane.showMessageDialog(null,"Created new Order");			
			}
		});
		add(createButton);
		
		//addButtonSetting();
		addButton.setSize(300, 60);
		addButton.setLocation(100,100);
		addButton.setFocusPainted(false);
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(anOrder != null) {
					new AddMedia();
				}else {
					JOptionPane.showMessageDialog(null,"Please create an order","WARNING",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		add(addButton);
		
		//deteleButtonSetting();
		deleteButton.setSize(300, 60);
		deleteButton.setLocation(100,180);
		deleteButton.setFocusPainted(false);
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(anOrder != null) {
					String strid = JOptionPane.showInputDialog(null,"Input ID: ","Delete ID",JOptionPane.INFORMATION_MESSAGE);
					int id = Integer.parseInt(strid);
					if(anOrder.removeMediaId(id) == 1) {
						JOptionPane.showMessageDialog(null,"Deleted Media have ID = "+ strid);
					}
					else {
						JOptionPane.showMessageDialog(null,"Don't find Media have ID = " + strid,"WARNING",JOptionPane.WARNING_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null,"Please create an order","WARNING",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		add(deleteButton);
	
		
		//displayButtonSetting();
		displayButton.setSize(300, 60);
		displayButton.setLocation(100,260);
		displayButton.setFocusPainted(false);
		displayButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("hi");
				anOrder.printOrdered();
				if(anOrder != null) {
					JDialog displayDialog = new JDialog();
					displayDialog.setSize(800,600);
					displayDialog.setLayout(null);
					displayDialog.setResizable(false);
					
					Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
					int x = (int) ((dimension.getWidth() - 800))/2;
					int y = (int) ((dimension.getHeight() - 600))/2;
					displayDialog.setLocation(x, y);
					
					displayDialog.setModal(true);
					displayDialog.setTitle("Ordered Items:");
					
					String column_names[]= {"ID","Type","Title","Category","Cost ($)"};
					List<Media> items = new ArrayList<Media>();
					items = anOrder.itemsOrdered;
					java.util.Collections.sort(items);
					DefaultTableModel model = new DefaultTableModel(null,column_names); 
					JTable table = new JTable(model);
					Media temp = null;
					try {
						 temp = anOrder.getALuckyItem();
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage(), "LUCKY ITEM", JOptionPane.WARNING_MESSAGE);
					}

					for(Media media: items) {
						String typeString = "" ;
						if(media instanceof Book)
							typeString = "Book"; 
						else if (media instanceof DigitalVideoDisc) {
							typeString = "DVD"; 
						}
						else {
							typeString = "CD";
						}
						if(media == temp) {
							model.addRow(new Object[]{media.getId()+" (Lucky)",typeString,
									media.getTitle(),media.getCategory(),0.0});
						}else {
							model.addRow(new Object[]{media.getId(),typeString,
									media.getTitle(),media.getCategory(), media.getCost()});
						}
					}
					model.addRow(new Object[] {"","","","",""});
					model.addRow(new Object[] {"","","","Date: ", day});	
					model.addRow(new Object[] {"","", "","Total: ",anOrder.totalCost()});					
					table.setSize(700, 500);
					table.setLocation(50,30);
					displayDialog.setLayout(new BorderLayout());
					displayDialog.add(table.getTableHeader(), BorderLayout.PAGE_START);
					displayDialog.add(table, BorderLayout.CENTER);	
					TableColumn column = null;
					for (int i = 0; i < 5; i++) {
					    column = table.getColumnModel().getColumn(i);
					    if (i == 0) {
					        column.setPreferredWidth(100); 
					    } 
					    if (i == 1) {
					        column.setPreferredWidth(50); 
					    }
					    if (i == 2) {
					        column.setPreferredWidth(300); 
					    }
					    if (i == 3) {
					        column.setPreferredWidth(150); 
					    }
					    if (i == 4) {
					        column.setPreferredWidth(100); 
					    }
					    
					}
					displayDialog.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null,"Please create an order","Warning",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		add(displayButton);
		
		//exitButtonSetting();
		exitButton.setSize(300, 60);
		exitButton.setLocation(100,340);
		exitButton.setFocusPainted(false);
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		add(exitButton);
		
		setVisible(true);
	}
}
