package testLeetCode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import testLeetCode.util.ListNode;

public class MergeKSortedListsSolution {
	
	private class listNodeComparator implements Comparator<ListNode> {

		@Override
		public int compare(ListNode o1, ListNode o2) {
			int res = 0;
			if ( o1.val > o2.val ) res = 1;
			else if ( o1.val < o2.val ) res = -1;
			else res = 0;
			return res;
		}}
	
	public ListNode mergeKLists(List<ListNode> lists) {
		ListNode res = null;
		if ( lists.size() > 0 ) {
    		Queue<ListNode> queue = new PriorityQueue<ListNode>( lists.size(), new listNodeComparator() );
    		for ( ListNode node : lists ) {
    			if ( node != null ) queue.add( node );
    		}
    		ListNode tempNode = null;
    		while ( queue.size() != 0 ) {
    			ListNode node = queue.poll();
    			if ( node.next != null ) queue.add( node.next );
    			if ( tempNode == null ) {
    				res = node;
    				tempNode = node;
    			}
    			else { 
    				tempNode.next = node;
    				tempNode = tempNode.next;
    			}
    		}
		}
        return res;
    }
}
