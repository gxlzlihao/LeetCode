package testLeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringwithConcatenationofAllWordsSolution {
	public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> res = new ArrayList<Integer>();
        if ( S != null && L != null && L.length > 0 && S.length() > 0 ) {
	        int numOfWords = L.length;
	        int wordLength = L[0].length();
	        int resStrLength = numOfWords * wordLength;
	        
	        if ( S.length() >= resStrLength ) {
	        	// work out the solution
	        	Map<String, Integer> check = new HashMap<String, Integer>();
	        	Map<String, Integer> originalCheck = new HashMap<String, Integer>();
		        for ( String str : L ) 
		        	if ( !originalCheck.containsKey(str) ) originalCheck.put(str, 1);
		        	else originalCheck.put( str, originalCheck.get(str) + 1 );
		        
	        	for( int start = 0; start <= S.length() - resStrLength; ++start ) {
	        		boolean valid = true;
	        		String testSubStr = S.substring( start, start + resStrLength );
	        		for ( String str : originalCheck.keySet() ) check.put( str, originalCheck.get(str) );
	        		for ( int j = 0; j < testSubStr.length() && valid; j += wordLength ) {
	        			String testWord = testSubStr.substring( j, j + wordLength );
	        			if ( !check.containsKey(testWord) || check.get(testWord) < 1 ) {
	        				valid = false;
	        			} else {
	        				check.put(testWord, check.get(testWord) - 1);
	        			}
	        		}
	        		if ( valid ) res.add( start );
	        	}
	        	
	        }
        }
        return res;
    }
}
