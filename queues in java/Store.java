/**
 * Driver that demonstrates the PriorityCustomer and PriorityQueue classes by
 * simulating 60 minutes of time in a grocery store.
 * 
 * @author Lily Naoudom
 * @version 11/10/2015
 */

import java.util.*;

public class Store {

	public static void main(String[] args) {
		
		Random r = new Random ();						//create random number object for % chance of adding customers
		
		PriorityQueue line = new PriorityQueue();		//create PriorityQueue object (max heap)
		
		int chance = 0;									//chance of customers being added to queue
		int served = 0;									//total number of customers serviced and removed
		int max = 0;									//maximum number of customers in line during simulation
		
		
		for (int i=0; i < 60; i++) {					//simulate 60 mins
			
			chance = new Random().nextInt(4) + 1;
			
			PriorityCustomer p = new PriorityCustomer();
			
			//adding new customer
			if (chance == 1) {
				line.add(p);
				System.out.println("New customer added! Queue length is now " + line.getSize());
				//System.out.println("New customer service time: " + p.getServiceTime());
				//System.out.println("New customer's priority is " + p.getPriority());
				
				
				if (line.getSize() > max ) {			//determine max queue length
					max = line.getSize();
				}
			}
			
			//removing customer
			if (line.isEmpty() == false) {				//if queue not empty
				
				//decrease service time of customer
				line.getRoot().decServiceTime();
				
				if (line.getRoot().getServiceTime () == 0 && line.getSize() > 0) {
					line.remove();					
					served++;							//update total customers serviced
					
					System.out.println("Customer serviced and removed from the queue. Queue length is now " + (line.getSize ()));
				}
				
			}
			System.out.println("-------------");		//mark each iteration (simulates 1 minute has passed)
					
		}//end for
		
		System.out.println("Total number of customers serviced: " + served);
		System.out.println("Maximum line length: " + max);

	}//end main

}
