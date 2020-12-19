
/**
 * This is the core file of the application.
 * This file contains all core methods like Add, Find, Reset, and PrintTree.
 * @author RajKumar
 *
 */
public class SearchTree {

	Node root;

	public SearchTree() {
		root = new Node();
	}

	/**
	 * adds given key to the Tree. if insertion succeed return true else
	 * returns false.
	 * 
	 * @param key
	 * @return
	 */
	public boolean add(String key) {
		if (!isStrBlank(key)) {
			Node current = root;
			Node prev = null;
			boolean isRight = false;
			key = key.trim();
			// if root is empty, then new node is root
			if (!current.hasRoot(current)) {
				root = new Node(key);
			} else {
				while (current != null) {
					// points to the parent node of current.left/right node.
					prev = current;
					int comp = key.compareToIgnoreCase(current.value);
					// given key is greater than node's value
					// then search in right node, else left node.
					if (comp > 0) {
						current = current.Right;
						isRight = true;
					} else if (comp < 0) {
						current = current.Left;
						isRight = false;
					} else {
						return false;
					}
				}
				//add new node to the end of the tree.
				prev.AddNode(prev, key, isRight);

			}
			return true;
		}
		return false;
	}

	/**
	 * search for the key in the tree.
	 * @param key
	 * @return
	 */
	public int find(String key) {
		if (!isStrBlank(key)) {
			boolean isRight = false;
			int depth = 1;
			Node current = root;
			key = key.trim();
			// if root is empty, then return 0.
			if (!current.hasRoot(current)) {
				return 0;
			}
			while (current != null) {
				int comp = key.compareToIgnoreCase(current.value);
				// given key is greater than node's value
				// then search in right node, else left node.
				if (comp > 0) {
					current = current.Right;
					isRight = true;
				} else if (comp < 0) {
					current = current.Left;
					isRight = false;
				} else {
					current.frequency++;
					//if key found, move element one level up.
					if(moveOneLevelUp(current, isRight)) {
						return depth-1; 
					}
					return depth;
				}
				depth++;
			}

		}
		return 0;
	}

	/**
	 * if frequency of the current node is greater than its parent's frequency. then
	 * promote current node one level up.
	 * 
	 * @param current
	 * @param flag
	 */
	private boolean moveOneLevelUp(Node current, boolean flag) {
		if (current.Parent != null && current.frequency > current.Parent.frequency) {
			Node c_parent = current.Parent;
			current.Parent = c_parent.Parent;
			c_parent.Parent = current;
			if (current.Parent != null) {
				int cmp = current.value.compareToIgnoreCase(current.Parent.value);
				if (cmp > 0) {
					current.Parent.Right = current;
				} else {
					current.Parent.Left = current;
				}
			}
			
			if (flag) {
				//while performing operation on the right node,
				//move node's parent down towards left.
				Node temp = current.Left;
				current.Left = c_parent;
				c_parent.Right = temp;
				if (temp != null) {
					temp.Parent = c_parent;
				}
			} else {
				//while performing operation on the left node,
				//move node's parent down towards right.
				Node temp = current.Right;
				current.Right = c_parent;
				c_parent.Left = temp;
				if (temp != null) {
					temp.Parent = c_parent;
				}
			}
			//if repositioned node does not have any patent then make it root node.
			if (c_parent.value.equalsIgnoreCase(root.value)) {
				root = current;
			}
			return true;
		}
		return false;
	}

	/**
	 * set search frequencies of the elements to zero. 
	 */
	public void reset() {

		StackLList stack = new StackLList();
		//call recursive function to iterate over tree
		resetFrequency(root, stack);

	}
	
	/**
	 * prints the tree in sorted order.
	 * @return
	 */
	public String printTree() {
		if(root.hasRoot(root)) {
			StackLList stack = new StackLList();
			String st = "";
			//call recursive function to iterate over tree
			st = iterateTree(root, stack, st);
			return st;
		}
		return null;		
	}

	/**
	 * a recursive function sets search frequencies of the elements to zero.
	 * @param n
	 * @param stack
	 */
	private void resetFrequency(Node n, StackLList stack) {

		// go to left most element.
		while (n != null) {
			// push each element to stack.
			stack.Push(n);
			n = n.Left;
		}
		//check if stack has elements.
		if (stack.topElement != null) {
		    stack.Peek().treeNode.frequency = 0;
			resetFrequency(stack.Pop().treeNode.Right, stack);
		}

	}

	/**
	 * a recursive function prints the tree in sorted order.
	 * @param n
	 * @param stack
	 * @param printTree
	 * @return
	 */
	private String iterateTree(Node n, StackLList stack, String printTree) {
		// go to left most element.
		while (n != null) {
			// push each element to stack.
			stack.Push(n);
			n = n.Left;
		}

		if (stack.topElement != null) {
			StackNode sn = stack.Peek();
			printTree += sn.treeNode.value + " " + sn.level + "\n";
			return iterateTree(stack.Pop().treeNode.Right, stack, printTree);
		}
		return printTree;
	}

	

	/**
	 * check given string is null or blank else return true.
	 * 
	 * @param str
	 * @return
	 */
	private static boolean isStrBlank(String str) {
		if (str != null && !str.isEmpty()) {
			return str.split(" +").length == 0;
		}

		return true;
	}

}
