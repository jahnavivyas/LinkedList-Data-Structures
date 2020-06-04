package nyu.edu.cs.cs102.ask662.crs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main (String[] args) throws FileNotFoundException {
		
		
		//create linkedlist
		LinkedList customers = new LinkedList();
		LinkedList copy = new LinkedList();
		String file = "customersfile.txt";
		//should this be courses.ser??
		File f = new File(file);
		String filef = "queries.txt";
		File h = new File(filef);
		//same implementation as hw 1!! hhahaha
		//do i need the above statements, did this in hw 1??
		
		int T = 0;
		//initialize service time to 0
		try { //do i need try catch block??
		Scanner scan = new Scanner(new File("customersfile.txt"));
		//read in this file!!
		
		String line = scan.nextLine();
		T = Integer.parseInt(line);
		//need to parse cuz it was read in as a string
		//LinkedList customers = new LinkedList();
		while (scan.hasNextLine()) {
			line = scan.nextLine();			
			line = scan.nextLine();
			//skip first two lines
			if (! line.isEmpty()) {
				String[] a = line.split(":");
				//split lines by colon into strings, then parse into integers
				int iD = Integer.parseInt(a[1].trim());
				line = scan.nextLine();
				a = line.split(":");
				//trim empty space around time components
				int hours = Integer.parseInt(a[1].trim());
				if (hours < 6) {
					hours += 12;
					hours*=3600;
					//making the assumptions that any time before 6 is in the afternoon
					//any time greater than that is in the morning
				}
				else {
					hours*=3600;
				}
				int min = Integer.parseInt(a[2].trim())*60;
				int secs = Integer.parseInt(a[3].trim());
				int arrival = hours + min + secs;
				//calculate their arrival in seconds
				Customer c = new Customer(iD, arrival);
				//customer object created
				//System.out.println(c.getArrivalTime());
				customers.add(c);
				copy.add(c);
				//copy of this original linkedlist
					
			}
			}
	
		} catch(Exception e) {
		System.out.println("This file does not exist!");
		//might not be true..............
		}
		
		try { //do i need try catch block?
		Scanner scn = new Scanner(new File("queriesfile.txt"));
		ArrayList<String> questions = new ArrayList<String>();
		while (scn.hasNextLine()) {
			String lne = scn.nextLine();
			questions.add(lne);
			//add these strings to the arraylist
		}
		
		}catch(Exception e) {
			System.out.println("This file does not exist!");
			//might not be true either................
		}
			
		
		
		
			//initialize all values we have to find to 0!!!!!!
			//break cusromers down into cases1!!!!!!
			int longBreak = 0;
			int maxLine = 0;
			int freeTime = 0;
			int customersServed = 0;
			int wait = 0;
			//Node current;
			//Customer c = customers.remove().getData();
			LinkedList counter = new LinkedList();
			//linkedlist of ppl in line
			int time = 32400;
			//assuming we open the store at 9
			while (customers.first() != null && time <= 61200) {
				//while the linkedlist has custsomers and its before 5
				//System.out.println("loop");
				while (customers.first() != null && customers.first().getData().getArrivalTime() < time) {
					//customers who arrived before 9 am
					//System.out.println("adding");
					Customer  c = customers.remove().getData();
					//put both of those ppl into the line
					counter.add(c);
					//method for current customer is next/first customer in line??
				}
				//method for updating how many customers in line- curr > max
				
				//size method for line
				//public static int maxLine() {
					if (counter.size() > maxLine) {
						maxLine = counter.size();
					}
					//if the counter has more ppl in it than before, update!!!!!!!!!!!!!!!
				
					
				//somebody is waiting in line
				if ( counter.first!=null) {
					Customer c = counter.remove().getData();
					//System.out.println("number served");
					//if this guy has been served, remove him from the counter linkedlsit
					//use this setter to set the waiting time for this customer, which is a data field for them
					c.setWaitingTime(time - c.getArrivalTime());
					//change this to a method
					//t is the serving time so the new time is their arrival plus their serving time which 
					//is uniform
					time += T;
					customersServed++;
					//increment how many customers have been served
				}
				
				//nobody is in line
				else {
					//System.out.println("no one waits");
					Customer c = customers.remove().getData();
					//remove the person from customer and return their info
					//how long is the break for the employee?
					//its their arrival time minus the current time (which is when last person left)
					int breaks = c.getArrivalTime() - time;
					if (breaks > longBreak) {
							longBreak = breaks;
					}
					//now add the break to total free time
					freeTime += breaks;
					//we had initialized longBreak to 0, and if any break is longer, then update
					//method for if this break is longer than other breaks, then it is longest
					time = c.getArrivalTime();
					//the time is basically when the person arrived in line, and add them to the queue
					counter.add(c);
					//method for current customer is next customer in line??
					//need to make first method in Linkedlist
					//freeTime += breaks;
				}
					
					
				}
			
			//if person arrived basically right before 5 and other pppl being served, they just wont get served, but waiting time
			//is arrival time to 5 pm
			while (! counter.isEmpty()) {
				Customer c =  counter.remove().getData();
				c.setWaitingTime(61200 - c.getArrivalTime());
				
			}
	
	//outside main method
		/**public static int longestBreak(int breaks) {
		int longBreak /**start from beginning??;
		breaks = longBreak;
		if (breaks > longBreak) {
			longBreak = breaks;
		}
		return longBreak;
		}**/
		
		//parameter would be size of line
		/**public int maxLine() {
			if (counter.size() > maxLine) {
				maxLine = counter.size();
			}
			return maxLine;
		}**/
		
		//pararmeter is current 
		/**public int waitTime() {
			int wait = time - arrival time of previous;
			return wait;
		}**/
					
			
					
			
			
				System.out.println("NUMBER-OF-CUSTOMERS-SERVED: " + customersServed); //size method how many nodes in counter);
				System.out.println("LONGEST-BREAK-LENGTH: " + longBreak);//longest break method or comparison??)
				System.out.println("TOTAL-IDLE-TIME: " + freeTime);
				//total free time
				System.out.println("MAXIMUM-NUMBER-OF-PEOPLE-IN-QUEUE-AT-ANY-TIME: " + maxLine); //);
				//maxline variable
				System.out.println("WAITING-TIME-OF 1: " + copy.find(1).getWaitTime());//);
				//go thru copy of linkedlist and find their waiting timeeeee
				System.out.println("WAITING-TIME-OF 2: " + copy.find(2).getWaitTime());//);
				System.out.println("WAITING-TIME-OF 3: " + copy.find(3).getWaitTime());//);
				System.out.println("WAITING-TIME-OF 7: "+ copy.find(7).getWaitTime()); //);
				
				/**public static int first(Customer c) {
					c.find(1);**?
					
					
					
					
					
					
					
					

			/**NUMBER-OF-CUSTOMERS-SERVED
			LONGEST-BREAK-LENGTH
			TOTAL-IDLE-TIME
			MAXIMUM-NUMBER-OF-PEOPLE-IN-QUEUE-AT-ANY-TIME
			WAITING-TIME-OF 1
			WAITING-TIME-OF 2
			WAITING-TIME-OF 3
			WAITING-TIME-OF 7**/
	}
			/**public int customersServed() {
			//number of customers served
			int customers = how many nodes in linkedlist?
			
			//longest break length
			int longestbreak = 0;
			for (int i = 0; i < customers.length, i+2) {
				longestbreak = breaks;
				breaks = current arrival time - (previous customer arrival time +300);
				if (breaks > longestbreaks) {
					breaks = longestbreaks;
				}
					
			}
			
			//total idle time
			int idleTime;
			for (Customers: c) {
				idle = current customer arrival time -(previous customer arrival time +300); 
				idleTime += idle;
			}
			
			//maximum people in line at once
			int line;
			for (Customers:c) {
				if  current arrival time < (previous customer arrival time +300){
					line+=1;
				}
				
			}
			
			public int findWait() {	
			//waiting time
			int wait;
			while (current != null && arrivaltime <= 61200) {
				if (Customer.previous = null) {
					wait = Math.abs(32400-arrivaltime);
				}
				else {
					if (arrivaltime <= 32400 ) {
						wait = 
				
					}
				 {
					waiting time = 32400-arrivaltime
				}
				else {
					//
				}
			}
			if (arrivaltime > 32400) {
				if (current arrival time > previous customer arrival time +300){
					wait time = 0;
				}
				else {
					
				}
			}
			
			
			
			
			
			
			
		/**String waitTime = myBuffer[0];
		int wait = Integer.parseInt(myBuffer[0]);
		String courseid = myBuffer[1];
		LinkedList<Customer> customer = new LinkedList<Customer>();
		if ( != "") {
			if ( == "ID") {
				
			}
				
				
		int maxstuds = Integer.parseInt(myBuffer[2]);
		int currstuds = Integer.parseInt(myBuffer[3]);
		LinkedList<Customer> customer = new LinkedList<Customer>();
		
		String courseprof = myBuffer[5];
		int coursesec = Integer.parseInt(myBuffer[6]);
		String courselocation = myBuffer[7];**/
		
	}



