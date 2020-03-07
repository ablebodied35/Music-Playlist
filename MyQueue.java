

import java.util.*;
import java.io.*;

public class MyQueue extends LinkedList{

	private LinkedList<String> que;
	
	
	public LinkedList getQue() {
		return que;
	}
	
	//Retrieves specific string in queue. Used for printing
	//and used to test 
	public String get(int index) {
		return que.get(index);
	}
	
	public MyQueue() {
		que = new LinkedList<String>();
	}
	
	//Used to help print out the separate lists of songs
	public void displayWeek(int week, PrintWriter out)throws IOException {
		for (int i = 0 ; i < que.size(); i++) {
			out.println((i+1) + " " + que.get(i));
		}
	}
	
	//Constructor that reads in the file and puts it into a linked list. 
	//Sorts the list as well. 
	public MyQueue(String filename)throws IOException {
		
		que = new LinkedList<>();
		BufferedReader week = new BufferedReader(new FileReader(filename));
		Scanner read = new Scanner(week);
		String line;
		//Skipping two lines here so the files is read from the beginning of the songs being listed
		line = read.nextLine();
		line = read.nextLine();

		while (read.hasNextLine()) {
			line = read.nextLine();
			String[] token = line.split(",");
			que.add(token[1]);
		}
		Collections.sort(que);
	}
	
	//Used to merge our 3 files into one giant playlist. 
	public MyQueue merge(MyQueue que1, MyQueue que2) {
		
		MyQueue newQue = new MyQueue();
		for(int i =0; i < que2.getQue().size(); i++) {
			que1.getQue().add(que2.getQue().get(i));
		}
		Collections.sort(newQue.que);
		return newQue;
	
	}
}
