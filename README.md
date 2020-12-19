# Balanced-binary-search-trees
Java | Balanced binary search trees from basic objects

Balanced binary search trees can be tricky to code and expensive to maintain. However, we
don’t always need a perfectly balanced tree. We are often content with an approximation to
the tree or a heuristic structure that mimics the balanced binary tree.

Solution Overview:
The objective of the application is to create an unbalanced binary search tree where new values are
added at the bottom of the tree and make search operations on the tree. Based on the frequency of
search, if the frequency of one node is higher than its parent node, then promote the node with the
highest frequency to one level up and the parent goes down.
Files and structure:
There is a total of 4 java files in the application.
1. SearchTree.java: This is the core file of the application. This file contains all core methods like
Add, Find, Reset, and PrintTree.
2. Node.java: Each key is a “Node” in the LinkedList. This file provides the node structure for the
LinkedList. Methods of the file include addNode and hasRoot.
3. StackLList.java: A Stack is required to traverse each element of the tree; Stack is used to
storing the visited items and is used to print the tree and reset the frequency of the nodes.
This file provides the implementation of the Stack. Core methods of the file include Pop, Push,
and Peek.
4. StackNode.java: Each element of the stack is again a LinkedList, which keeps track of the next
element. This file provides the node implementation for the LinkedList.
Data structures:
Two main data structures used in the application are LinkedList and Stack.
LinkedList is used to implement an Unbalanced binary tree where each element has Right, Left
pointers to point to child nodes, and a parent-link to point to its parent node.
Similarly, Stack is used to iterating over each element of the binary tree to perform print and reset
operations.
Again Stack is implemented using LinkedList, where each element stores the node data and a link to
its next element.
Methods and Implementation:
SearchTree.java:
1. boolean add(): Adds the given key to the tree. If insertion succeeds returns True else returns
False. This method is the initial step in the application to construct the unbalance binary tree.
I. Check the input key is not blank or null
II. If Tree does not has any nodes, make this key as the root node.
III. Else, compare current position value to the input value.
IV. If the key is higher, then go to the right node of the current node and execute step III.
V. Else go to the left of the left node of the current node and execute step III.
VI. Continue III, V, and VI till we reach the leaf node.
VII. Once the leaf node is found, add the key to the leaf node(left/right) depends on the
value.
2. Int Find(): This method is used to locate the key In the given tree and returns the level of the
node in which the key is found after rotation. In addition to the finding this method also
promotes the key to one level up if the frequency of the current node is higher than the
frequency of its parent node.
I. Check the input key to search for is not blank or null.
II. If the tree is null, then return 0.
III. Else, compare current value to the input value.
IV. If the key is higher, then go to the right node of the current node and execute step III.
V. Else go to the left of the left node of the current node and execute step III.
VI. Continue III, V, and VI till we find the key in the tree.
VII. If the key is found, increment the frequency of the element and promote the node
one element up.
VIII. Else, return 0.
3. Reset(): This method is used to reset the search frequencies of the nodes in the tree. A Stack
is used in this method to iterate over the tree and a recursive function ResetFrequency() is
called.
4. String PrintTree(): Prints the tree in the sorted order. A Stack is used in this method to iterate
over the tree, and a recursive function IterateTree() is called.
5. Boolean MoveOneLevelUp(): if the frequency of the found key is greater than the frequency
of the parent node then promote the key node to one level up. This involves the following
steps.
I. Get the current node and node’s parent.
II. Make current’s parent as current node parent’s parent.
III. Now make current’s parent to current.
IV. If the current node is not the root node, then
V. Compare the current value and current’s parent value.
VI. If higher then link attach current parent's right to current
VII. Else current parent's left to current.

IX. Making changes to B. B is moved one level up. As a result, D moved one level below.
X. Similarly, when a right node is moved one level above, vice versa happens.
XI. Finally, if the current node has no parent, then make it a root node.
6. ResetFrequency(): this is a recursive method used to reset the frequencies of the node.
I. If the node is not null, push the current node to the stack.
II. Then proceed to the left node and continue with the step I.
III. When a left-most node is reached, make the frequency of the first element in the
stack to zero.
IV. Call this method again with the right node of the first element of the stack and pop
the value from the stack.
7. String IterateTree(): this is a recursive method used to iterate over the tree to print the keys
of the tree in sorted order.
V. If the node is not null, push the current node to the stack.
VI. Then proceed to the left node and continue with the step I.
VII. When a left-most node is reached, print the first element in the stack.
VIII. Call this method again with the right node of the first element of the stack and pop
the value from the stack.
Node.java:
1. addNode(): This method is used to add the element to the tree. Each element is a node in the
LinkedList, which stores the links to the child nodes and a pointer to the parent node.
I. If the current value is greater than the parent’s value then add to the right node.
II. Else add to the left node.
2. Boolean HasRoot(): this method checks whether the given tree has a root node, if yes then
returns true else returns false.
StackLList.java:
1. StackNode Pop(): Pop is used to get the top element from the stack. Here stack is a LinkedList.
After getting the top item from the LinkedList unlink the first element and make the next
element as a top element.
2. Push(): Push is to add the item to the Stack (LinkedList). Always add the item in the front of
the LinkedList and make it top element.
3. StackNode Peek(): Peek used to see the first element in the stack. If top element is not null,
then return the top element from the stack.
Key Algorithm and design:
The key implementation of the application is promoting the child node to one level up if search
frequency of the child is higher than the parent node and move the parent node one level down.
Algorithm and design as follows
1. Get the current node and node’s parent.
2. Make current’s parent as current node parent’s parent.
3. Now make current’s parent to current.
4. If the current node is not the root node, then
5. Compare the current value and current’s parent value.
6. If higher then link current parent's right to current
7. Else current parent's left to current.
8. If currently shifting node is right node
9. Store current left in temp.
10. Assign current’s parent to current left
11. Assign temp to current parent right
12. Else if current node is left node
13. Assign current’s parent to right node
14. Assign temp to current parent left
15. If current’s parent is null, make current node as root node.
References:
1. https://makeinjava.com/create-implement-stack-using-array-java-example/
2. https://opendatastructures.org/versions/edition-0.1d/ods-java/node37.html
3. https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
