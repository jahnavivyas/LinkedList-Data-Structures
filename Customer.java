package nyu.edu.cs.cs102.ask662.crs;

import java.util.ArrayList;

public class Customer {
	
	 int idNum;
	 int arrivalTime;
	 int waitingTime;
	 
	 //3 fields
	 //id, arrival, and waiting
	 //getters and setters

	public int getWaitTime() {
		return waitingTime;
	}

	public void setWaitingTime(int waitTime) {
		this.waitingTime = waitTime;
	}

	public int getIdNum() {
		return idNum;
	}

	public void setIdNum(int idNum) {
		this.idNum = idNum;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Customer(int idNum, int arrivalTime) {
		this.idNum = idNum;
		this.arrivalTime= arrivalTime;
	}

}
