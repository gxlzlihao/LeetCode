package testLeetCode;

public class CountAndSaySolution {
	public String countAndSay(int n) {
        String res = null;
        if ( n <= 0 ) res = null;
        else if ( n == 1 ) res = "1";
        else {
        	String temp = "1";
        	int number = 1;
        	while ( number < n ) {
        		temp = next( temp );
        		++number;
        	}
        	res = temp;
        }
        return res;
    }
	
	private String next( String str ) {
		int iter = 0;
		String res = "";
		while ( iter < str.length() ) {
			int count = 1;
			String temp = str.substring( iter, iter + 1 );
			while ( iter + count < str.length() && temp.equals( str.substring( iter + count, iter + count + 1 ) ) )
				++count;
			iter = iter + count;
			res = res + count + temp;
		}
		return res;
	}
}
