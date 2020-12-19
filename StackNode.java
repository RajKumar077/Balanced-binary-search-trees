
/**
 * Each element of the stack is again a LinkedList, 
 * which keeps track of the next element. 
 * This file provides the node implementation for the LinkedList.
 * @author RajKumar
 *
 */
public class StackNode {
	Node treeNode;
	int level;
	StackNode next;
	
	//Constructor to create new element in stack
	public StackNode(){
		level = 0;
		next = null;
	}
}
