package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.PlayerException;
import hust.soict.hedspi.aims.media.*;
//import hust.soict.hedspi.aims.media.disc.Track;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	private String playTrack ="";
	
	public String getplayTrack() {
		return playTrack;
	}
	
	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public ArrayList<Track> getTracks() {
		return tracks;
	}

	public void setTracks(ArrayList<Track> tracks) {
		this.tracks = tracks;
	}

	
	public void addTrack(Track track) {
		if (!(tracks.contains(track))) {
			tracks.add(track);
		}
	}
	public void removeTrack(Track track) {
		if (tracks.contains(track))
			tracks.remove(track);
	}
	
	@Override
	public int getLength() {
		int length =0;
		for(int i=0;i<tracks.size();i++) {
			length += tracks.get(i).getLength();
		}
		return length;
	}

	// constructor
	public CompactDisc(String title, String category, int length, float cost) {
		super(title, category, length, cost);
		// TODO Auto-generated constructor stub
	}
	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
		// TODO Auto-generated constructor stub
	}
	public CompactDisc(String title, String category) {
		super(title, category);
		// TODO Auto-generated constructor stub
	}

	public CompactDisc(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	
	public CompactDisc(String title, String category, String artist,
			 float cost) {
		super(title, category,  cost);
		this.artist = artist;
	}

	public CompactDisc(String title, String category, int length, String artist,
			ArrayList<Track> tracks) {
		super(title, category, length);
		this.artist = artist;
		this.tracks = tracks;
	}
	public CompactDisc(int id, String title, String category, String artist, float cost) {
		super(id, title, cost);
		this.artist = artist;
		this.category = category;
	}


	public void play() throws PlayerException {
		this.playTrack = "Playing CD: " + this.getTitle() + "\nCD length: " + this.getLength();
		if (this.getLength() > 0) {
			for (int i = 0; i < tracks.size(); i++) {
				tracks.get(i).play();
				this.playTrack += tracks.get(i).play; 
			}
			System.out.println("Track's length:" + getLength());
		} else {
			throw new PlayerException("ERROR: CD length is non-positive");
		}
	}
	
	public void getTitleTracks() {
		for(int i=0;i<tracks.size();i++) {
			System.out.print(tracks.get(i).getTitle()+",");
		}
	}
	@Override
	public void print() {
		//System.out.println(getId()+". CD: "+getTitle()+" - "+ getCategory()+ " - "+getArtist() + 
		//		" - " + getTracks().size() + " - "+ getLength()+ "m - "+getCost() + "$");
		System.out.printf("%d. CD: %s - %s - %.2f$ - %s\n",
						getId(),getTitle(),getCategory(),getCost(),getArtist());

	}
	
	public int compareTo(Media media) {
		if(media instanceof CompactDisc) {
			CompactDisc cd = (CompactDisc)media;
			if(tracks.size() == cd.tracks.size()) {
				if(this.length < cd.getLength())
					return -1;
				else if(this.length == cd.getLength())
					return 0;
				else return 1;
			}
			else if(tracks.size() < cd.tracks.size())
				return -1;
			else return 1;
		}else {
			return super.compareTo(media);
		}
	}
}
