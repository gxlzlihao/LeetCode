package testLeetCode;

import java.util.Stack;

import testLeetCode.util.ListNode;

public class ReorderListSolution {
	
	private ListNode target = null;
	private boolean toEnd = false;
	private Stack<ListNode> stack = new Stack<ListNode>();
	
	public void reorderList( ListNode head ) {
		if ( head == null || head.next == null ) return;
		else { 
			target = head;
			while ( target != null ) {
				stack.push(target);
				target = target.next;
			}
			target = head;
			while ( !toEnd ) {
				ListNode node = stack.pop();
				ListNode second = target.next;
				target.next = node;
				if ( node == second ) node.next = null;
				else {
					target.next.next = second;
					target = second;
					if ( second.next == node ) second.next = null;
				}
				if ( target.next == null ) toEnd = true;
			}
		}
        return;
    }
	
}
