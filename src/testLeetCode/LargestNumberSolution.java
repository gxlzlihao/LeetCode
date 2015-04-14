package testLeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LargestNumberSolution {
	
	private class numComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			int res = 0;
			String str1 = o1 + "";
			String str2 = o2 + "";
			int shortLen = Math.min( str1.length(), str2.length() );
			for ( int i = 0; i < shortLen; ++i  ) {
				int num1 = Integer.valueOf(str1.substring(i, i+1));
				int num2 = Integer.valueOf(str2.substring(i, i+1));
				if ( num1 > num2 ) {
					res = -1;
					break;
				} else if ( num1 < num2 ) {
					res = 1;
					break;
				} else res = 0;
			}
			if ( res == 0 && ( shortLen < str1.length() || shortLen < str2.length() ) ) {
				long combine1 = Long.parseLong( o1 + "" + o2 );
				long combine2 = Long.parseLong( o2 + "" + o1 );
				if ( combine1 > combine2 ) res = -1;
				else if ( combine1 < combine2 ) res = 1;
				else res = 0;
			}
			return res;
		}}
	
	public String largestNumber(int[] num) {
        String res = "";
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>( num.length, new numComparator() );
        for ( int n : num )
        	queue.add(n);
        while ( queue.size() > 0 ) {
        	res = res + queue.poll();
        }
        res = deleteZeros( res );
        return res;
    }
	
	private String deleteZeros( String str ) {
		if ( str == null || str.length() == 1 ) return str;
		String res;
		int p = 0;
		while ( p < str.length() && str.charAt(p) == '0' ) ++p;
		if ( p == str.length() ) res = "0";
		else res = str.substring(p);
		return res;
	}
}
