package nyu.edu.cs.cs102.ask662.crs;

public class LinkedList {
	
	public Node first;
	public Node last;

	//slide 53
	//constructor for this class
	public LinkedList() {
		
	}
	
	//method to add customer to linkedlist
	public void add(Customer c){
		Node newNode = new Node();
		newNode.storeCustomer(c);
		//Node current = first;
		if (last == null) {
			last = newNode;
			first = newNode;
			//putting the customer at the end of the linkedlist in a node
		}
		else {
			last.next = newNode;
			last = last.next; 			
			}
			
		
		}
		
		//newNode.next = first;
		//first = newNode;
		
		
		
	
	
	
	
	public Node remove() {
		Node current = first;
		if (first == null) {
			return null;
		}
		else {
			current = first;
			first = first.next;
			if (first == null) {
				last = null;
			}
		}
		
		return current;
	}
	
	
	
	public Customer find(int id) {
		Node current = first;
		while (current != null) {
			if (current.getData().getIdNum() == id) {
				return current.getData();
			}
			current = current.next;
		}
		return null;
	}
		/**if (c.getIdNum() == 1) {
			return c.getWaitTime();
		}
		else if (c.getIdNum() == 2) {
			return c.getWaitTime();
		}
		else if (c.getIdNum() == 3) {
			return c.getWaitTime();
		}
		else if (c.getIdNum() == 7) {
			return c.getWaitTime();
		}
	}**/

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		
		return (size() == 0);

		}

	

	
	public int size() {
		int size = 0;
		Node current = first;//very first of linkedlist null;
		if (current == null) {
			return 0;
			
		}
		while (current != null) {
			current = current.next;
			size++;
		}
		return size;
		}
	
	public Node first() {
		return first;
	}


















	
	

}

//find method
//next method
//previous method