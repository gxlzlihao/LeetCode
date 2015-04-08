package testLeetCode;

public class LongestPalindromicSubstringSolution {
	public String longestPalindrome(String s) {
        String res = null;
        int item = 0;
        while( item < s.length() ) {
        	String temp = check( s, item );
        	if ( res == null || temp.length() > res.length() )  { 
        		res = temp;
        	}
        	if ( item < s.length() - 1 ) temp = check( s, item, item + 1 );
        	if ( res == null || temp.length() > res.length() )  { 
        		res = temp;
        	}
        	++item;
        }
        return res;
    }
	
	private String check( String s, int middle ) {
		return check( s, middle, middle );
	}
	
	private String check( String s, int l, int r ) {
		String res = null;
		int left = l;
		int right = r;
		while( left > -1 && right < s.length() && s.charAt(left) == s.charAt(right) ) {
			--left;
			++right;
		}
		res = s.substring( Math.max( left+1, 0 ), Math.min( right, s.length() ) );
		return res;
	}
}
