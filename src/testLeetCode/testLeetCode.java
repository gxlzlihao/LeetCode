package testLeetCode;

import java.util.ArrayList;
import java.util.List;

public class testLeetCode {
	
	public static void main(String[] args) {
//		InsertIntervalSolution solution  = new InsertIntervalSolution();
//		int[][] data = {{1,2},{3,5},{6,7},{8,10},{12,16}};
//		List<Interval> intervals = generateIntervals( data );
//		output( intervals );
//		List<Interval> res = solution.insert(intervals, new Interval(4,9));
//		output( res );
		DistinctSubsequencesSolution solution = new DistinctSubsequencesSolution();
		int res = solution.numDistinct( "rabbbit", "rabbit" );
		System.out.println( "the answer: " + res );
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
