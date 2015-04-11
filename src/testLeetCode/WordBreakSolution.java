package testLeetCode;

import java.util.Set;

public class WordBreakSolution {
	
	public boolean wordBreak(String s, Set<String> dict) {
        boolean res = false;
        boolean[] check = new boolean[ s.length() + 1 ];
        check[ 0 ] = true;
        for( int i = 0; i < check.length; ++ i ) {
        	if ( !check[ i ] ) continue;
        	for ( String word : dict ) {
        		int end = i + word.length();
        		if ( end > s.length() ) continue;
        		if ( check[ end ] ) continue;
        		if ( s.substring( i, end ).equals( word ) ) check[ end ] = true;
        	}
        }
        res = check[ s.length() ];
        return res;
    }
}
