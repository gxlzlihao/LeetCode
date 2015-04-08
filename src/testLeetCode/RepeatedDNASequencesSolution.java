package testLeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequencesSolution {
	private final int wordLength = 10;
	public List<String> findRepeatedDnaSequences(String s) {
        Set<String> res = new HashSet<String>();
        if ( s != null && s.length() >= 11 ) {
        	Set<Integer> check = new HashSet<Integer>();
        	for ( int start = 0; start <= s.length() - wordLength; ++start ) {
        		String testWord = s.substring( start, start + wordLength );
        		int testInt = toInt( testWord );
        		if ( check.contains( testInt ) ) res.add( testWord );
        		else check.add( testInt );
        	}
        }
        List<String> finalRes = new ArrayList<String>();
        for ( String str : res ) finalRes.add(str);
        return finalRes;
    }
	
	private int toInt( String s ) {
		int res = 0;
		for ( char chr : s.toCharArray() ) res = res * 10 + charToInt( chr );
		return res;
	}
	
	private int charToInt( char c ) {
		int res = 0;
		switch( c ) {
		case 'A': res = 1; break;
		case 'C': res = 2; break;
		case 'G': res = 3; break;
		case 'T': res = 4; break;
		}
		return res;
	}
}
