package nyu.edu.cs.cs102.ask662.crs;

public class Node {
	
	public Customer data;
	public Node next;
	public Node previous;

	//fields??
	public Node() {
		
	}
	public void storeCustomer(Customer data) {
		//how to store customer in node?
		this.data= data;
		
	}
	
	public Customer getData(){
		return this.data;
		//get data method
		
	}
	
	public void displayNode(Customer c) {
		System.out.println("ID: " + c.getIdNum() + "\n" + "Arrival time" + c.getArrivalTime());
		//incase we need to print out the node??
		
	}
}
	/**public Customer getC() {
		return c;**/
	
	/**public void setC(Customer c) {
		this.c = c;
	}
	
	/**public Node next(Customer c) {
		current = current.next;
	}**/
	
	/**public Node previous(Customer c) {
	
	
	}**/

//getter 
//setter
//display node
