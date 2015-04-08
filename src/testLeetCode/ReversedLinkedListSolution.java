package testLeetCode;

import testLeetCode.util.ListNode;

public class ReversedLinkedListSolution {
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode res = head;
        int index = 1;
        ListNode current = head;
        ListNode second = head.next;
        ListNode third = null;
        ListNode start = null;
        
        while( second != null ) {
        	
        	if ( index == m-1 && m > 1 )
    			start = current;
        	
        	if ( index >= m && index < n) {
        		// reverse the linked list
        		
        		ListNode last = current;
        		ListNode first = null;
        		
        		while( index >= m && index < n && second != null ) {
        			third = second.next;
        			second.next = current;
        			current = second;
        			second = third;
        			++index;
        		}
        		
        		first = current;
        		last.next = second;
        		if ( start != null )
        			start.next = first;
        		else
        			res = first;
        		
        	} else {
        		// keep original order
        		
        		++index;
        		current = second;
        		second = second.next;
        	}
        }
        
        return res;
    }
}
