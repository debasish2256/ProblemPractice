package practice_450_dsa;
/* Java program to convert a Binary tree to BST 
using sets as containers. */
import java.util.*;

class BST
{
static class Node 
{
	int data;
	Node left, right;
}

// set 
static Set<Integer> s = new HashSet<Integer>(); 

// function to store the nodes in set while
// doing inorder traversal.
static void storeinorderInSet(Node root)
{
	if (root == null)
		return;

	// visit the left subtree first
	storeinorderInSet(root.left);

	// insertion takes order of O(logn) for sets
	s.add(root.data); 

	// visit the right subtree
	storeinorderInSet(root.right);

} // Time complexity = O(nlogn)

// function to copy items of set one by one 
// to the tree while doing inorder traversal
static void setToBST( Node root)
{
	// base condition
	if (root == null)
		return;

	// first move to the left subtree and 
	// update items
	setToBST( root.left);

	// iterator initially pointing to the
	// beginning of set
	// copying the item at beginning of 
	// set(sorted) to the tree.
	root.data = s.iterator().next(); 

	// now erasing the beginning item from set.
	s.remove(root.data);

	// now move to right subtree and update items
	setToBST( root.right);

} // T(n) = O(nlogn) time

// Converts Binary tree to BST.
static void binaryTreeToBST(Node root)
{
	s.clear();

	// populating the set with the tree's 
	// inorder traversal data
	storeinorderInSet(root);

	// now sets are by default sorted as
	// they are implemented using self-
	// balancing BST

	// copying items from set to the tree 
	// while inorder traversal which makes a BST
	setToBST( root);

} // Time complexity = O(nlogn), 
// Auxiliary Space = O(n) for set.

// helper function to create a node
static Node newNode(int data)
{
	// dynamically allocating memory
	Node temp = new Node();
	temp.data = data;
	temp.left = temp.right = null;
	return temp;
}

// function to do inorder traversal
static void inorder(Node root)
{
	if (root == null)
		return;
	inorder(root.left);
	System.out.print(root.data + " ");
	inorder(root.right);
}

// Driver code
public static void main(String args[])
{
	Node root = newNode(5);
	root.left = newNode(7);
	root.right = newNode(9);
	root.left.left = newNode(1);
	root.left.right = newNode(6);
	root.right.left = newNode(10);
	root.right.right = newNode(11);

	/* Constructing tree given in the above figure
		  5
		 / \
		7	 9
		/\   / \
		1 6 10 11 */

	// converting the above Binary tree to BST
//	binaryTreeToBST(root);
	System.out.println( "Inorder traversal of BST is: " );
	inorder(root);
}
}

