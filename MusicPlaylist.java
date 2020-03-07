
//-------------------------------> SHEHRYAR ALI
import java.util.*;
import java.io.*;

public class MusicPlaylist {

	public static void main(String[] args)throws IOException {
		
		File output = new File("output.txt");
		PrintWriter out = new PrintWriter(output);
		
		/**************************************************************
		 From line 13 to line 20 all the code does is read in the 3 files
		 I have chosen from spotify charts, read them into a linked list in
		 the QUEUE interface and store them in an Arraylist. The number
		 at the end of each "Spotify" represents the day in February. 
		 So Spotify6 is the chart of the week of February 6.
		 **************************************************************/
		String[] myFiles = {"Spotify6.csv", "Spotify13.csv", "Spotify20.csv"};
	
		ArrayList<MyQueue> allWeeks = new ArrayList<>();
	
		for(int i = 0; i < myFiles.length; i++) { 
			MyQueue q = new MyQueue(myFiles[i]);
			allWeeks.add(q);
		}
		
		
		out.println("Lists of songs of each week");
		for (int i = 0; i < myFiles.length; i++) {
			out.println(myFiles[i]);
			allWeeks.get(i).displayWeek(i,out);
			out.println();
		}
		out.println();
		/*****************************************************************
		 Line 27 to line 31 the code creates a new MyQueue object since it has
		 a linked list inside of it. It takes the 3 playlists that are in
		 the arraylist from th previous code and merges them all into one
		 huge playlist of 600 songs where many songs repeat. I choose to use
		 MyQueue here because it already had a linked list inside of it and 
		 would also allow me to place the merge method in the class. 
		 *****************************************************************/
		MyQueue playlist = new MyQueue();
		
		for(int i =0; i < allWeeks.size();i++) {
			playlist.merge(playlist, allWeeks.get(i));
		}
		
		/********************************************************************
		 The nested for loop here basically runs through my playlist of 600 
		 songs which I got after merging my 3 separate lists in the arraylist
		 and deletes any repeat songs. So if the same justin bieber song
		 shows up twice it deletes one occurrence of it. 
		 ********************************************************************/
		System.out.println("PLAYLIST SIZE BEFORE SORT : " + playlist.getQue().size());//For me
		
		for(int i = 0; i< playlist.getQue().size(); i++)
			for(int j = playlist.getQue().size() -1; j > i; j--) {
				if(playlist.getQue().get(j).equals(playlist.getQue().get(i))) {
					playlist.getQue().remove(j);
				}
			}
		
		//Sorts the playlist for ascending order
		Collections.sort(playlist.getQue());
		
		//For loop to check order of songs
		System.out.println("PLAYLIST SIZE AFTER SORT : " + playlist.getQue().size());
		for(int i = 0; i < playlist.getQue().size();i++)
			System.out.println((i+1) + " " + playlist.getQue().get(i));
		
		
		/**************************************************************************
		 The following code creates a stack object which contains an arraylist of 
		 strings. Everytime a song is printed from our linked list in our Queue class
		 it adds it to the stack. Essentially, the stack is just the linke
		 **************************************************************************/
		Stack songs = new Stack();
		
		out.println("WEEKLY SONGS THIS QUARTER JOINED PLAYLIST");
		for(int i = 0; i < playlist.getQue().size(); i++) {
			out.println((i+1) + " " + playlist.getQue().get(i));
			songs.push(playlist.get(i));
		}
		
		
		
		//Checking Functionality of Stack class. Works as intended!
		System.out.println("Last Song: " + songs.lastSongListenedTo());
		songs.pop();
		System.out.println("PEEK: " + songs.peek());
		
		out.close();
	}

}
