package contest;

class Node {
	public Node left;
    public Node right;
    public Node next;
    int data;

    Node(int data) {
        this.data = data;
    }
}

public class populatingNextRightPointersEachNode {
	
	public Node connect1(Node root) {
		Node black=root;
		while(black!=null && black.left!=null){
			Node n=black;
			while(true){
				n.left.next=n.right;
				if(n.next==null) break;
				n.right.next=n.next.left;
				n=n.next;    
			}
			black=black.left;
		} 
		return root;
	}
	
	void connect(Node root) {
		if(root == null) return;

		Node leftN = root.left;
		Node rightN = root.right;
		while(leftN != null){
			leftN.next = rightN;
			leftN = leftN.right;
			rightN = rightN.left;
		}
		connect1(root.left);
		connect1(root.right);
	}

}
