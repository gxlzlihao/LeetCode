package testLeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WordBreak2Solution {
	
	private List<String> res = new ArrayList<String>();
	private List<String> array = new ArrayList<String>();
		
	public List<String> wordBreak(String s, Set<String> dict) {
        
        List<String>[] check = new ArrayList[ s.length() + 1 ];
        check[ 0 ] = new ArrayList<String>();
		
        for ( int iter = 0; iter < s.length(); ++iter ) {
        	if ( check[iter] == null ) continue;
        	for ( String word : dict ) {
        		int end = iter + word.length();
        		if ( end > s.length() ) continue;
        		if ( s.substring( iter, end ).equals(word) ) {
        			if ( check[ end ] == null ) check[ end ] = new ArrayList<String>();
        			check[ end ].add( word );
        		}
        	}
        }
        
        dfs( s, s.length(), check );
        
        return res;
    }
	
	private void dfs( String s, int iter, List<String>[] check ) {
		if ( s == null || s.length() == 0 || iter == 0 ) {
			String temp = "";
			for ( int j = array.size() - 1; j >=0; j-- )
				temp = temp + " " + array.get(j);
			if ( temp.length() > 0 ) {
				temp = temp.substring( 1 );
				res.add( temp );
			}
		} else {
			if ( check[ iter ] == null ) return;
			List<String> candidates = check[ iter ];
			for ( String word : candidates ) 
				if ( word.length() <= s.length() ) {
					array.add( word );
					dfs( s.substring( 0, s.length() - word.length() ), iter - word.length(), check );
					array.remove( array.size() - 1 );
				}
		}
	}
	
}
