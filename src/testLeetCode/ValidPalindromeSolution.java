package testLeetCode;

public class ValidPalindromeSolution {
	public boolean isPalindrome(String s) {
        boolean res = true;
        if ( s == null ) res = false;
        else if ( s.length() == 1 || s.length() == 0 ) res = true;
        else {
        	int left = 0;
        	int right = s.length() - 1;
        	while ( left < right ) {
        		while ( left < s.length() && !isValidChar( s.charAt(left) ) ) {
        			++left;
        		}
        		if ( left == s.length() ) break;
        		while ( right >= 0 && !isValidChar( s.charAt( right ) ) ) {
        			--right;
        		}
        		if ( !compareChar( s.charAt(left), s.charAt(right) ) ) {
        			res = false;
        			break;
        		} else {
        			++left;
        			--right;
        		}
        	}
        }
        return res;
    }
	
	private boolean compareChar( char chr1, char chr2 ) {
		char c1 = chr1;
		if ( isBigChar( chr1 ) ) c1 = toSmallChar( chr1 );
		char c2 = chr2;
		if ( isBigChar( chr2 ) ) c2 = toSmallChar( chr2 );
		
		return c1 == c2;
	}
	
	private boolean isValidChar( char chr ) {
		return isBigChar( chr ) || isSmallChar( chr ) || isNumber( chr );
	}
	
	private boolean isNumber( char chr ) {
		int res = (int) chr - '0';
		return ( res >= 0 && res <10 )? true:false;
	}
	
	private boolean isBigChar( char chr ) {
		int res = (int) chr - 'A';
		return ( res >= 0 && res <26 )? true:false;
	}
	
	private boolean isSmallChar( char chr ) {
		int res = (int) chr - 'a';
		return ( res >= 0 && res <26 )? true:false;
	}
	
	private char toSmallChar( char chr ) {
		if ( isBigChar( chr ) )
			return (char) ( (int) chr - 'A' + 'a' );
		else return chr;
	}
}
