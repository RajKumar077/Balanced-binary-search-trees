
	
/**
 *Node is each element in the unbalanced binary search tree 
 * @author RajKumar
 *
 */
public class Node{
	String value;
	int frequency;
	Node Left;
	Node Right;
	Node Parent;
	
	//Constructor to create empty node.
	public Node() {
		value = null;
		frequency = 0;
		Left = null;
		Right = null;
		Parent = null;
	}
	
	//Constructor to create a node with given key.
	public Node(String value) {
		this.value = value;
		frequency = 0;
		Left = null;
		Right = null;
		Parent = null;
	}
	
	/**
	 * add new node to the end of the unbalanced binary tree
	 * @param n
	 * @param key
	 * @param flag
	 */
	public void AddNode(Node n, String key, boolean flag) {
		//add new node to the last node in the tree.
		Node newNode = new Node(key);
		//if true then add new node to the right of last node
		//else add to the left
		if(flag) {
			n.Right = newNode;
		}
		else {
			n.Left = newNode;
		}
		newNode.Parent = n;
	}
	
	/**
	 * check tree has root
	 * @param current
	 * @return
	 */
	public boolean hasRoot(Node current) {
		
		return !(current.Parent == null && 
				current.Left == null && 
				current.Right == null && 
				current.value == null);
	}
	
}


