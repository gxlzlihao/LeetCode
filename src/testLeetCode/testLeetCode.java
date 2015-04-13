package testLeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import testLeetCode.util.ListNode;
import testLeetCode.util.TreeNode;

public class testLeetCode {
	
	public static void main(String[] args) {
//		InsertIntervalSolution solution  = new InsertIntervalSolution();
//		int[][] data = {{1,2},{3,5},{6,7},{8,10},{12,16}};
//		List<Interval> intervals = generateIntervals( data );
//		output( intervals );
//		List<Interval> res = solution.insert(intervals, new Interval(4,9));
//		output( res );
		UniqueBinarySearchTrees2Solution solution = new UniqueBinarySearchTrees2Solution();
		List<TreeNode> res = solution.generateTrees(3);
		System.out.println( "the answer: " + res.size() );
	}
	
	private static ListNode generateNode( int start, int index, int length ) {
		ListNode res = null;
		if ( index > length ) res = null;
		else {
			res = new ListNode( start + index );
			res.next = generateNode( start, index + 1, length );
		}
		return res;
	}
	
	private static void outputList( ListNode node ) {
		System.out.println( "the list: " );
		ListNode temp = node;
		while ( temp != null ) {
			System.out.print( temp.val + "--" );
			temp = temp.next;
		}
		System.out.println( "  " );
	}
	
//	private static List<Interval> generateIntervals( int[][] data ) {
//		List<Interval> res = new ArrayList<Interval>();
//		for ( int[] row : data ) {
//			res.add( new Interval( row[0], row[1] ) );
//		}
//		return res;
//	}
//	
//	private static void output( List<Interval> intervals ) {
//		System.out.println( "" );
//		System.out.print( "{ " );
//		for ( Interval interval : intervals ) {
//			System.out.print( "{" + interval.start + "," + interval.end + "}," );
//		}
//		System.out.print( " }" );
//		System.out.println( "" );
//	}
	
//	private static ListNode generate( int index, int num ) {
//		if ( index > num ) return null;
//		ListNode newNode = new ListNode( index );
//		newNode.next = generate( index + 1, num );
//		return newNode;
//	}
//	
//	private static void output( ListNode node ) {
//		if ( node == null ) return;
//		System.out.print( "-" + node.val );
//		output( node.next );
//	}
	
}
