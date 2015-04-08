package testLeetCode;

import testLeetCode.util.ListNode;

public class RemoveNthNodeFromEndofListSolution {
	
	private int index = 0;
	private int lastN = 0;
	private ListNode res = null;
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        lastN = n;
        work( head );
        if ( index == lastN )  { 
        	res = head.next;
        }
        else res = head;
        return res;
    }
	
	private void work( ListNode node ) {
		if ( node == null ) return;
		work( node.next );
		if ( index == lastN ) {
			node.next = node.next.next;
		}
		++index;
	}
	
}
