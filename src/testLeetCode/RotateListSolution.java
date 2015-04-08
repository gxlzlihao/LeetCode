package testLeetCode;

import testLeetCode.util.ListNode;

public class RotateListSolution {
	
	ListNode res = null;
	ListNode tail = null;
	
	public ListNode rotateRight(ListNode head, int k) {
		int num = check( head );
		if ( num == 0 || num == 1 || k == 0 ) res = head;
		else {
			int rotateNum = k % num;
			if ( rotateNum != 0 ) {
				ListNode newHead = head;
				ListNode newTail = null;
				int count = 0;
				while( count < num - rotateNum ) {
					newTail = newHead;
					newHead = newHead.next;
					++count;
				}
				
				if ( newTail != null ) newTail.next = null;
				res = newHead;
				tail.next = head;
			} else {
				res = head;
			}
			
		}
		return res;
	}
	
	private int check( ListNode node ) {
		if ( node == null ) return 0;
		else {
			int temp = check( node.next );
			if ( temp == 0 ) tail = node;
			return temp + 1;
		}
	}

}
