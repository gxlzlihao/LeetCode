package testLeetCode;

import testLeetCode.util.ListNode;

public class IntersectionOfTwoLinkedListsSolution {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode res = null;
        int lenA = listlength( headA );
        int lenB = listlength( headB );
        int move = 0;
        
        ListNode a = headA;
        ListNode b = headB;
        
        if ( lenA > lenB ) {
            move = lenA - lenB;
            while( move > 0 ) {
                a = a.next;
                --move;
            }
        } else if ( lenB > lenA ) {
            move = lenB - lenA;
            while( move > 0 ) {
                b = b.next;
                --move;
            }
        }
        
        while( a != null && b != null ) {
            if ( a == b ) {
            	res = a;
            	break;
            }
            else {
                a = a.next;
                b = b.next;
            }
        }
        
        return res;
    }
    
    private int listlength( ListNode node ) {
        if (node == null) return 0;
        int temp = listlength( node.next );
        return temp+1;
    }
}
