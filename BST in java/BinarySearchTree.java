//@author Lily Naoudom
public class BinarySearchTree {

	private Node root;							//reference to tree root
	int size = 0;								//keep track of tree size
	
	public BinarySearchTree () {				
		root = null;
	}
	
	public boolean isEmpty () {
		return root == null;
	}
	
	public void insert (String w) {				//insert method called from treeDemo
		Node newNode = new Node(w);				//create node with passing string
		
		if (isEmpty()) {						//if tree is empty, place string at root
			root = newNode;
		} else {
			root.insert(newNode);				//else, call recursive insert method
		}
		
		size++;									//update size
	}

	public void search (String w) {				//search method called from treeDemo
		if (root == null) {						
			System.out.println("empty");		//print message if tree is empty
		} else {
			System.out.println(root.search(w));	//else, call recursive search method
		}
	}
	
	public void printInOrder () {				//in order traversal
		inOrder(root);
		System.out.println("----");
	}
	
	private void inOrder (Node n) {
		if (n != null) {
			inOrder(n.getLeft());
			System.out.println(n.toString() + " ");
			inOrder(n.getRight());
			
		}
	}
	
	public void printPreOrder () {				//preorder traversal
		preOrder(root);
		System.out.println("----");
	}
	
	private void preOrder (Node n) {
		if (n != null) {
			System.out.println(n.toString() + " ");
			preOrder(n.getLeft());
			preOrder(n.getRight());
			
		}
	}

	public void printPostOrder () {				//postorder traversal
		postOrder(root);
	}

	private void postOrder (Node n) {
		if (n != null) {
			postOrder(n.getLeft());
			postOrder(n.getRight());
			System.out.println(n.toString() + " ");
			
		}
	}
}//end class definition
