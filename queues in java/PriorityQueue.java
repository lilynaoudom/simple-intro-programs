/**
 * Use Max heap to implement queue.
 * 
 * @author Lily Naoudom
 * @version 11/10/2015
 *
 */
public class PriorityQueue {

	private PriorityCustomer [] heap;					//array that will store the PriorityCustomer objects in line
	private int size;

	private PriorityCustomer leftChild, rightChild;		//access to left and right child of each PriorityCustomer object
	
	public PriorityQueue () {
		heap = new PriorityCustomer [50];
		size = 0;
	}
	
	//add method
	public void add (PriorityCustomer p) {
		int index = size + 1;							//index of new priority customer
		heap [index] = p;								//add priority customer at that position
		
		while  (index > 1) {
			int parentIndex = index / 2;
			
			//if parent priority is lower and parent is NOT at the root (do not sort)
			if (heap[parentIndex].getPriority() < p.getPriority() && heap[parentIndex] != heap[1]) {
				
				heap[index] = heap[parentIndex];		//perform swap
				heap[parentIndex] = p;
				
				index = parentIndex;					//update index after swap
				
			} else {									//no swap needed
				break;
			}
		}
			
		size++;											//update size
	}
	
	//remove method
	public PriorityCustomer remove () {
		PriorityCustomer rootCustomer = heap[1];
		PriorityCustomer x = heap[size];				//store last priority customer in heap in x
		heap[1] = x;									//take x and move to root
		heap[size] = null;								//delete node at last position (its been moved to root)
		
		int index = 1;
		
		while (index * 2 < size) {						//is there at least one child at index?
			int leftIndex = index * 2;
			int rightIndex = leftIndex + 1;
			
			leftChild = heap[leftIndex];
			rightChild = heap[rightIndex];
			
			if (rightIndex < size) { 					//right child exists
				rightChild = heap[rightIndex];
			}
			
			PriorityCustomer maxChild;
			int maxIndex;								//find index of and priority of larger child

			
			//if left and right child exists, and the left child is greater than right child
			if (getLeft() != null || getRight() != null && leftChild.getPriority() >= rightChild.getPriority() ) {		
				maxChild = leftChild;
				maxIndex = leftIndex;
			} else {
				maxChild = rightChild;
				maxIndex = rightIndex;
			}
			
			if (x.getPriority() < maxChild.getPriority()) {		//priority is less than larger child, swap
				heap[index] = maxChild;							//perform swap with larger child
				heap[maxIndex] = x;
				index = maxIndex;
			} else {
				break;									//priority customer is in valid position, stop
			}

		}
		
		size --; 										//update size
		
		return rootCustomer;				
	}
	
	//size of array
	public int getSize() {
		return size;
	}
	
	//get root
	public PriorityCustomer getRoot () {
		return heap[1];
	}
	
	//determine if array is empty
	public boolean isEmpty() {
		return heap[1] == null;
	}
	
	//get left child
	public PriorityCustomer getLeft () {
		return leftChild;
	}
	
	//get right child
	public PriorityCustomer getRight () {
		return rightChild;
	}

}//end class definition
