package testLeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import testLeetCode.util.ListNode;

public class testLeetCode {
	
	public static void main(String[] args) {
//		InsertIntervalSolution solution  = new InsertIntervalSolution();
//		int[][] data = {{1,2},{3,5},{6,7},{8,10},{12,16}};
//		List<Interval> intervals = generateIntervals( data );
//		output( intervals );
//		List<Interval> res = solution.insert(intervals, new Interval(4,9));
//		output( res );
		WordLadder2Solution solution  = new WordLadder2Solution();
		String start = "qa";
		String end = "sq";
		String[] data = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
		Set<String> dict = new HashSet<String>();
		for ( String str : data ) {
			dict.add( str );
		}
		List<List<String>> res = solution.findLadders(start, end, dict);
		for ( List<String> array : res ) {
			System.out.println( " " );
			for ( String str : array )
				System.out.print( "-" + str );
		}
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
