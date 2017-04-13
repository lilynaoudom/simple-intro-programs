public class Queue {
	
	private Customer first, last;
	private int count;
	
	//constructor
	public Queue () {
		first = null;
		last = null;
	}
	
	//get first
	public Customer getFirst () {
		return first;
	}
	
	//get last
	public Customer getLast () {
		return last;
	}
	
	//add method
	public void enqueue (Customer c) {
		if (isEmpty() ) {
			first = c;				//if queue is empty, set new Customer object equal to first
		} else {
			last.setNext(c);		//if queue is not empty, set new Customer to next in queue
		}
		
		last = c;			
		count++;					//update queue length
	}
	
	//remove method
	public Customer dequeue () {
		count--;					//update queue length
		
		if (isEmpty() ) {			//if queue is empty, return null
			return null;
		}
		
		Customer c = first;			//store reference to first
		
		if (first == last) {		//if there's only one person in queue, set last equal to null 
			last = null;
		}
		
		first = first.getNext();	//set first to next in queue 
		
		return c;					//return the stored person 
	}
	
	//method to determine current queue length
	public int size () {
		return count;
	}
	
	//determine if queue is empty
	public boolean isEmpty() {
		return first == null;
	}
	
}//end of class definition
