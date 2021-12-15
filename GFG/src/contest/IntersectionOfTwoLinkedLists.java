package contest;

import java.util.HashSet;

public class IntersectionOfTwoLinkedLists {
	
	class ListNode {
		int data;
		ListNode next;

		ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}
	ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		HashSet<ListNode> set=new HashSet<>();
        while(headA!=null)
        {
            set.add(headA);
            headA=headA.next;
        }
        while(headB!=null){
            if(set.contains(headB))
                return headB;
            headB=headB.next;
        }
        return null;
    }
}
