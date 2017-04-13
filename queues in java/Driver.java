import java.util.Random;

public class Driver {

	public static void main(String[] args) {
		
		Queue line = new Queue ();								//create object from Queue class
		int chance;
		int served = 0;
		int max = 0;
		
		//simulate 60 minutes of time in grocery store
		for (int i = 0; i < 60; i++) {
			
			chance = new Random ().nextInt(4)+1;				//create object from Random class
																//each iteration has 25% chance	of customer being added
			Customer c = new Customer ();	
			
			//adding a customer to queue
			if (chance == 1) {									//condition to add new customer
				
				line.enqueue(c);
				System.out.println("New customer added! Queue length is now " + line.size());
				
				if (line.size() > max ) {						//determine max queue length
					max = line.size();
				}
			}
			
			//removing a customer from queue							
			if (line.isEmpty() == false) {						//if the queue is not empty, 
				
				line.getFirst().decServiceTime();				//decrease service time of first customer	
				
				if (line.getFirst().getServiceTime () == 0 && line.size() > 0) {		//when first customer's service time is up (equal to 0)
					line.dequeue ();							//remove customer from queue
					served++;									//increment number of customers completely serviced
					System.out.println("Customer serviced and removed from the queue. Queue length is now " + (line.size ()));
				}
			}
			System.out.println("-------------");				//mark each iteration (simulates 1 minute has passed)
		}

		System.out.println("Total number of customers serviced: " + served);
		System.out.println("Maximum line length: " + max);
	}
}//end class definition
