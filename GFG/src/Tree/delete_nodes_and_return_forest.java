package Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class delete_nodes_and_return_forest {

	public static void main(String[] args) {
		int to_delete[] = new int[]{3,5};
		TreeNode root;
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		for(TreeNode s:delNodes(root,to_delete)) {
			System.out.println(s.val +" ");
		}
		//postorder printing order
//		System.out.println(delNodes(root,to_delete).toString());
	}
	public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		HashSet<Integer> set=new HashSet<>();
		for(int a:to_delete){
			set.add(a);
		}
		List<TreeNode> list=new ArrayList<>();
		//call for deleteNode
		deleteNode(root,set,false,list);
		return list;
	}

	static TreeNode deleteNode(TreeNode root,HashSet<Integer> set,boolean isChild,List<TreeNode> list){
		if(root==null ) return null;
		if(set.contains(root.val)){
			deleteNode(root.left,set,false,list);
			deleteNode(root.right,set,false,list);
			root=null;
		}
		else{
			if(!isChild){
				list.add(root);
			}
			root.left=deleteNode(root.left,set,true,list);
			root.right=deleteNode(root.right,set,true,list);
		}
		return root;
	}
}