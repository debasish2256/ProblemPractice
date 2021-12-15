package Tree;

// Java program to delete element
// in binary tree
import java.util.LinkedList;
import java.util.Queue;
public class deletion_in_bt {

		
	// A binary tree node has key, pointer to
	// left child and a pointer to right child
	static class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		
		// Constructor
		TreeNode(int val)
		{
			this.val = val;
			left = null;
			right = null;
		}
	}



	// Inorder traversal of a binary tree
	static void inorder(TreeNode temp)
	{
		if (temp == null)
			return;

		inorder(temp.left);
		System.out.print(temp.val + " ");
		inorder(temp.right);
	}

	// Function to delete deepest
	// element in binary tree
	static void deleteDeepest(TreeNode root,
							TreeNode delNode)
	{
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		
		TreeNode temp = null;
		
		// Do level order traversal until last node
		while (!q.isEmpty())
		{
			temp = q.peek();
			q.remove();
			
			if (temp == delNode)
			{
				temp = null;
				return;
				
			}
			if (temp.right!=null)
			{
				if (temp.right == delNode)
				{
					temp.right = null;
					return;
			}
			else
				q.add(temp.right);
		}

		if (temp.left != null)
		{
			if (temp.left == delNode)
			{
				temp.left = null;
				return;
			}
			else
				q.add(temp.left);
		}
	}
	}

	// Function to delete given element
	// in binary tree
	static void delete(TreeNode root, int key)
	{
		if (root == null)
			return;
			
		if (root.left == null &&
		root.right == null)
		{
			if (root.val == key)
			{
				root=null;
				return;
			}
			else
				return;
		}
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		TreeNode temp = null, keyNode = null;
		
		// Do level order traversal until
		// we find key and last node.
		while (!q.isEmpty())
		{
			temp = q.peek();
			q.remove();
			
			if (temp.val == key)
				keyNode = temp;

			if (temp.left != null)
				q.add(temp.left);

			if (temp.right != null)
				q.add(temp.right);
		}

		if (keyNode != null)
		{
			int x = temp.val;
			deleteDeepest(root, temp);
			keyNode.val = x;
		}
	}

	// Driver code
	public static void main(String args[])
	{
		TreeNode root;

		root = new TreeNode(10);
		root.left = new TreeNode(11);
		root.left.left = new TreeNode(7);
		root.left.right = new TreeNode(12);
		root.right = new TreeNode(9);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(8);

		System.out.print("Inorder traversal " +
						"before deletion:");
		inorder(root);

		int key = 11;
		delete(root, key);

		System.out.print("\nInorder traversal " +
						"after deletion:");
		inorder(root);
	}
}
