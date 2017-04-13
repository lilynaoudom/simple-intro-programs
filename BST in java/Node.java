//@author Lily Naoudom

public class Node {
	
	public String word;							//reference to string field of node
	private int freq;							//reference to frequency of string
	public Node leftChild;						//references to left/right children
	public Node rightChild;
	
	public Node (String w) {					//constructor accepts String to create a node
		word = w;
		leftChild = rightChild = null;
		freq = 0;
		freq++;									//update frequency
	}
	
	
	public void setLeft (Node n) {				//setter and getters for left/right children
		leftChild = n;
	}
	
	public void setRight (Node n) {
		rightChild = n;
	}
	
	public Node getLeft () {
		return leftChild;
	}
	
	public Node getRight () {
		return rightChild;
	}
	
	public int getFreq () {
		return freq;
	}
	
	public String getWord () {
		return word;
	}
	
	public String toString () {
		return "word:\t" + word + "\t\t" + "frequency: " + freq;
	}
	
	public void insert (Node w) {							//insert method call from BinarySearchTree class
		if (w.getWord().compareTo(this.word) < 0) {			//compare with current node
			if (leftChild == null) {					
				leftChild = w;								//if leftChild is empty, set node to leftChild
			} else {
				leftChild.insert(w);						//else, call recursive insert method
			}
		} else if (w.getWord().compareTo(this.word) == 0) {	//if duplicate word found
			freq++;											//do not add, increase frequency	
		} else {
			if (rightChild == null) {						//look right
				rightChild = w;								//if rightChild is empty, set node to rightChild
			} else {
				rightChild.insert(w);						//else, call recursive insert method
			}
		}
			
	}

	public Node search (String w) {							//search method call from BinarySearchTree class
		if (word == w) {
			return this;									//if String matches existing word, return the string
		} else {
			if (w.compareTo(word) <= 0) {					
				if (leftChild == null) {					//if String does not match leftChild, return null
					return null;
				} else {
					return leftChild.search(w);				//else, call recursive search method
				}
			} else {
				if (rightChild == null) {					//if String does not match rightChild, return null
					return null;
				} else {
					return rightChild.search(w);			//else, call recursive search method
				}
			 }
		 }	
		
	}
}//end class definition
