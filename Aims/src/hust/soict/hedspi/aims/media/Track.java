package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.PlayerException;

public class Track implements Playable,Comparable<Object>{
	private int length;
	private String title;
	public String play;
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	
//	public void play() {
//		System.out.println("Playing DVD: " + this.getTitle());
//		System.out.println("DVD length: " + this.getLength());
//	}
	
	public void play() throws PlayerException{
		if(this.getLength() > 0) {
			System.out.println("Playing Track: " + this.getTitle());
			System.out.println("Track length: " + this.getLength());
			play = "\nPlaying Track: " + this.getTitle() + "\nTrack length: " + this.getLength();
		}else {
			throw new PlayerException("ERROR: Track length is non-positive");
		}
	}
	
		
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Track) {
			Track t = (Track) obj;
			if(this.length != t.length) return false;
			if(!this.title.equals(t.title)) return false;
		}
		return true;
	}
	
	public int compareTo(Object obj) {
		if(obj instanceof Track) {
			Track track = (Track) obj;
			if(this.title.equals(track.title))
			return 1;
		}
		return 0;
	}
}
