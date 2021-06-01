package hust.soict.hedspi.aims;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;



public class AddMedia {
	private JDialog selectDialog = new JDialog();
	private JButton bookButton;
	private JButton dvdButton;
	private JButton cdButton;
	private JButton ok;
	
	public AddMedia() {
		// Set Dialog size 
		selectDialog.setSize(500,500);
		selectDialog.getContentPane().setLayout(null);
		selectDialog.setResizable(false);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - 500))/2;
		int y = (int) ((dimension.getHeight() - 500))/2;
		selectDialog.setLocation(x, y);
		//selectDialog.setVisible(true);
		selectDialog.setModal(true);
		selectDialog.setTitle("Select Media");
		
		// Button Add Book 
		bookButton = new JButton("Book");
		bookButton.setSize(300, 60);
		bookButton.setLocation(100,50);
		bookButton.setFocusPainted(false);
		selectDialog.getContentPane().add(bookButton);
		addBookAction();

		
		// Button Add DVD
		dvdButton = new JButton("DVD");
		dvdButton.setSize(300, 60);
		dvdButton.setLocation(100,150);
		dvdButton.setFocusPainted(false);
		selectDialog.getContentPane().add(dvdButton);
		addDVDAction();

		
		cdButton = new JButton("CD");
		cdButton.setSize(300, 60);
		cdButton.setLocation(100,250);
		cdButton.setFocusPainted(false);
		selectDialog.getContentPane().add(cdButton);
		addCDAction();

			
		ok = new JButton("OK");
		ok.setSize(60, 60);
		ok.setLocation(220,350);
		ok.setFocusPainted(false);
		ok.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				selectDialog.setVisible(false);	
			}
		});
		ok.setVisible(true);
		selectDialog.getContentPane().add(ok);
			
		
		selectDialog.setVisible(true);
	}
	
	public void addBookAction() {
		bookButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Book");
				selectDialog.setVisible(false);
				JDialog bookDialog = new JDialog();
				
				// Common dialog of Media
				MediaDialog bookMedia = new MediaDialog(bookDialog);
				
				// Author
				JTextField authorField = new JTextField();
				JLabel authorJLabel = new JLabel("Author");
				authorJLabel.setSize(100,30);
				authorJLabel.setLocation(90,180);
				bookDialog.add(authorJLabel);
				
				authorField.setSize(250, 30);
				authorField.setLocation(200,180);
				bookDialog.add(authorField);
				
				JLabel noteJLabel = new JLabel("** author 1,author 2,..");
				noteJLabel.setSize(300,40);
				noteJLabel.setLocation(100,220);
				bookDialog.add(noteJLabel);
				
				// Handler OK button 
				bookMedia.okJButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						bookDialog.setVisible(false);
						try {
							float i = bookMedia.getCost();
							String[] authors = authorField.getText().split(",");
							ArrayList<String> listauthor = new ArrayList<String>();
							for(String test: authors) {
								listauthor.add(test);
							}
							Book book = new Book(bookMedia.getId(), bookMedia.getTitle(), bookMedia.getCategory(), i, listauthor);
							AimsGUI.anOrder.addMedia(book);
							JOptionPane.showMessageDialog(null,"The Book added");
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Can't add the book", "ERROR", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				bookDialog.setVisible(true);
				selectDialog.setVisible(true);
			}
			
		});
		
	}
	
	public void addDVDAction() {
		dvdButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("DVD");
				selectDialog.setVisible(false);
				JDialog dvdDialog = new JDialog();
				
				// Common dialog of Media
				MediaDialog dvdMedia = new MediaDialog(dvdDialog);
				
				JTextField textField = new JTextField();
				JLabel textJLabel = new JLabel("Length");
				textJLabel.setSize(100,30);
				textJLabel.setLocation(90, 180);
				dvdDialog.add(textJLabel);
				textField.setSize(250,30);
				textField.setLocation(200,180);
				dvdDialog.add(textField);
				
				JTextField directorField = new JTextField();
				JLabel directorJLabel = new JLabel("Director");
				directorJLabel.setSize(100,30);
				directorJLabel.setLocation(90,220);
				dvdDialog.add(directorJLabel);
				
				directorField.setSize(250, 30);
				directorField.setLocation(200,220);
				dvdDialog.add(directorField);
				
				// handler button OK
				dvdMedia.okJButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						dvdDialog.setVisible(false);
						try {
							float i = dvdMedia.getCost();
							int length = Integer.parseInt(textField.getText());
							String director = directorField.getText();
							DigitalVideoDisc dvd = new DigitalVideoDisc(dvdMedia.getId(), dvdMedia.getTitle(), dvdMedia.getCategory(), length, director, i);
							AimsGUI.anOrder.addMedia(dvd);
							int result = JOptionPane.showConfirmDialog(null,"Do you want to play DVD ?","Play",
									JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
							if(result == JOptionPane.YES_OPTION) {
								JOptionPane.showMessageDialog(null, "Playing DVD: " + dvd.getTitle() + "\nDVD length: " + dvd.getLength());								
							}
							JOptionPane.showMessageDialog(null,"The DVD added");
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Can't add the DVD" + "\n" + e2.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				dvdDialog.setVisible(true);
				selectDialog.setVisible(true);
			}
		});
		
	}
	
	
	public void addCDAction() {
		cdButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("CD");
				selectDialog.setVisible(false);
				JDialog cdDialog = new JDialog();
				
				// Common dialog of Media
				MediaDialog cdMedia = new MediaDialog(cdDialog);
				
				JTextField textField = new JTextField();
				JLabel textJLabel = new JLabel("Artist");
				textJLabel.setSize(100,40);
				textJLabel.setLocation(90, 180);
				cdDialog.add(textJLabel);
				textField.setSize(250,30);
				textField.setLocation(200,180);
				cdDialog.add(textField);
				
				JTextField trackField = new JTextField();
				JLabel trackJLabel = new JLabel("Track");
				trackJLabel.setSize(100,40);
				trackJLabel.setLocation(90,220);
				cdDialog.add(trackJLabel);							
				trackField.setSize(250, 30);
				trackField.setLocation(200,220);
				cdDialog.add(trackField);
				
				JLabel noteJLabel = new JLabel("** Track: <Track1>:<Length1>,<Track2>:<Lenght2>,...");
				noteJLabel.setSize(500,40);
				noteJLabel.setLocation(100,260);
				cdDialog.add(noteJLabel);
				// handler button OK
				cdMedia.okJButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						cdDialog.setVisible(false);
						try {
							float i = cdMedia.getCost();
							CompactDisc cd = new CompactDisc(cdMedia.getId(), cdMedia.getTitle(), cdMedia.getCategory(), textField.getText(), i);
							String[] outString = trackField.getText().split(",");
							for(String out : outString) {
								String[] a = out.split(":");
								Track track;
								track = new Track(a[0], Integer.parseInt(a[1]));
								cd.addTrack(track);
							}
							if(cd.getTracks().size() == 0 ) {
								JOptionPane.showMessageDialog(null,"Can't insert into order \n ID, Title, Category, Cost, Tracks can't be empty","Warning",
										JOptionPane.WARNING_MESSAGE);
							}else {
								AimsGUI.anOrder.addMedia(cd); 
								//int result = JOptionPane.showConfirmDialog(null,"Do you want to play CD ?","Play",
								//		JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
								//if(result == JOptionPane.YES_OPTION) {
								//	System.out.println(cd.getplayTrack());
								//	JOptionPane.showMessageDialog(null,cd.getplayTrack());								
								//}
								JOptionPane.showMessageDialog(null,"The CD added");
							}
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Can't add the CD" + "\n" + e2.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				cdDialog.setVisible(true);
				selectDialog.setVisible(true);
			}
		});
		
	}
	
	public void Exit() {
		
	}
	
	public class MediaDialog{
		JLabel idJLabel = new JLabel("ID");
		JLabel costJLabel = new JLabel("Cost");
		JLabel categoryJLabel = new JLabel("Category");
		JLabel titleJLabel = new JLabel("Title");
		
		JTextField idField = new JTextField();
		JTextField costField = new JTextField();
		JTextField cateField = new JTextField();
		JTextField titleField = new JTextField();
		
		JButton okJButton = new JButton("OK");
		
		public int getId() {
			int id = Integer.parseInt(idField.getText());
			return id;
		}
		public Float getCost() throws InputException{
			float f;
			try {
				f = Float.parseFloat(costField.getText());
				return f;
			} catch (Exception e) {
				throw new InputException(e.getMessage() + "\nError Input");
			}
		}
		public String getCategory() throws InputException{
			if(cateField.getText() != "") {
				return cateField.getText();
			}else {
				throw new InputException("ERROR: Category Field is empty");
			}

		}
		public String getTitle() throws InputException{
			if(titleField.getText() != "") {
				return titleField.getText();
			}else {
				throw new InputException("ERROR: Title Field is empty");
			}
		}
		
		public MediaDialog(JDialog mediaDialog) {
			mediaDialog.setSize(500,450);
			mediaDialog.setLayout(null);
			mediaDialog.setResizable(false);
			
			Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
			int x = (int) ((dimension.getWidth() - 500))/2;
			int y = (int) ((dimension.getHeight() - 450))/2;
			mediaDialog.setLocation(x, y);
			
			idJLabel.setSize(100,30);
			idJLabel.setLocation(90,20);
			mediaDialog.add(idJLabel);
			idField.setSize(250, 30);
			idField.setLocation(200,20);
			mediaDialog.add(idField);
			
			categoryJLabel.setSize(100,30);
			categoryJLabel.setLocation(90,100);
			mediaDialog.add(categoryJLabel);
			cateField.setSize(250, 30);
			cateField.setLocation(200,100);
			mediaDialog.add(cateField);
			
			titleJLabel.setSize(100,30);
			titleJLabel.setLocation(90,140);
			mediaDialog.add(titleJLabel);
			titleField.setSize(250, 30);
			titleField.setLocation(200,140);
			mediaDialog.add(titleField);
			
			costJLabel.setSize(100,30);
			costJLabel.setLocation(90,60);
			mediaDialog.add(costJLabel);
			costField.setSize(250, 30);
			costField.setLocation(200,60);
			mediaDialog.add(costField);
				
			
			okJButton.setSize(100,30);
			okJButton.setLocation(200,330);
			okJButton.setFocusPainted(false);
			mediaDialog.add(okJButton);
			
			mediaDialog.setVisible(false);
			mediaDialog.setModal(true);
		}
		
		public boolean isEmpty() {
			return titleField.getText().equals("") || idField.getText().equals("") || 
					cateField.getText().equals("") ||costField.getText().equals("");
		}
	}
}
