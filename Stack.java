import java.util.*;

public class Stack {

	//Used an arraylist because it seemed easier than a normal array
	private ArrayList<String> songs;
	
	public Stack() {
		songs = new ArrayList<String>();
	}
	
	//Returns top of playlist. Same as peekin functionality. 
	public String lastSongListenedTo() {
		return songs.get(songs.size() -1);
	}
	
	public void push(String song) {
		songs.add(song);
	}
	
	public void pop() {
		songs.remove(songs.size()-1);
	}
	
	//Same as lastSonglistenedTo. Added it because I know 
	//it is one of the basic stack methods
	public String peek() {
		return songs.get(songs.size()-1);
	}
}

