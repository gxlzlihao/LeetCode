package testLeetCode;

public class DecodeWaysSolution {
	public int numDecodings(String s) {
		int res = 0;
		if ( s.length() == 0 ) res = 0;
		else if ( s.length() == 1 ) {
			if ( !s.equals("0") ) res = 1;
			else res = 0;
		}
		else if ( s.length() == 2 && !s.substring(0, 1).equals("0") ) {
			int num = Integer.valueOf( s );
			if ( ( num > 0 && num <= 10 ) || ( num > 26 ) ) 
			    if ( num % 10 != 0 || num == 10 ) res = 1;
			    else res = 0;
			else if ( num == 0 ) res = 0; 
			else if ( num != 20 ) res = 2;
			else res = 1;
		} else if ( s.length() == 2 && s.substring(0, 1).equals("0") ) {
			res = 0;
		} else if ( !s.substring(0, 1).equals("0") ) {
			int[] possibilites = new int[ s.length() ];
			possibilites[0] = 1;
			int num = Integer.valueOf( s.substring(0, 2 ) );
			if ( ( num > 0 && num <= 10 ) || ( num > 26 ) ) 
				if ( num % 10 != 0 || num == 10) possibilites[ 1 ] = 1;
				else return 0;
			else possibilites[ 1 ] = 2;
			
			for ( int i = 2; i < s.length(); ++i ) {
				int n = Integer.valueOf( s.substring(i-1,i+1) );
				if ( ( n > 0 && n < 10 ) || ( n > 26 ) ) 
					if ( n % 10 != 0 ) possibilites[i] = possibilites[i-1];
					else {
						res = 0;
						break;
					}
				else if ( n == 10 || n == 20 ) {
					possibilites[i] = possibilites[i-2];
				} else if ( n == 0 ) {
					res = 0;
					break;
				}
				else possibilites[i] = possibilites[i-1]+possibilites[i-2];
			}
			res = possibilites[ s.length() - 1 ];
		} else 
			res = 0;
		return res;
    }
}
