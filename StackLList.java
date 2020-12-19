
/**
 * A Stack is required to traverse each element of the tree; 
 * Stack is used to storing the visited items and is used to print the tree 
 * and reset the frequency of the nodes. 
 * This file provides the implementation of the Stack. 
 * Core methods of the file include Pop, Push, and Peek. 
 * 
 * @author RajKumar
 *
 */
public class StackLList {

	StackNode topElement;
	int depth = 0;
	
	//constructor to point top element to null.
	public StackLList() {
		topElement = null;
	}
	
	//pops the top element and and makes 2nd element as top.
	public StackNode Pop() {
		if(topElement != null) {
			StackNode sn = topElement;
			topElement= topElement.next;
			return sn;
		}
		return null;
	}
	
	//push new node to the top of the stack
	public void Push(Node n) {
		StackNode sn = new StackNode();
		sn.treeNode = n;
		sn.next = topElement;
		sn.level = ++depth;
		topElement = sn;
	}
	
	//get the top element from the stack
	public StackNode Peek() {
		if(topElement != null) {
			depth = topElement.level;
			return topElement;
		}
		return null;
	}

}
