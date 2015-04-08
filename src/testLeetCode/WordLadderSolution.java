package testLeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

// this solution works but has time limit problem in LeetCode
public class WordLadderSolution {
	public int ladderLength(String start, String end, Set<String> dict) {
		
		// to initialize
        int res = 0;
        int maxLength = dict.size();
        if ( !dict.contains(start) ) ++maxLength;
        if ( !dict.contains(end) ) ++maxLength;
        boolean[][] check = new boolean[maxLength][maxLength];
        boolean[] marked = new boolean[maxLength];
        
        Map<String, Integer> index = new HashMap<String, Integer>();
        index.put( start, 0 );
        index.put( end, maxLength - 1 );
        int count = 1;
        for( String str : dict )
        	if ( !str.equals(start) && !str.equals(end) ) index.put( str, count++ );
        
        // calculate the distance
        if ( dict.contains(start) ) dict.remove(start);
        if ( dict.contains(end) ) dict.remove(end);
        String[] strs = dict.toArray( new String[0] ); // strs does not contain start and end strings
        
//        for ( int i = 0; i < strs.length; ++i )
//        	for ( int j = i + 1; j < strs.length; ++j )
//        		if ( ifClose( strs[i], strs[j] ) ){
//        			check[ index.get(strs[i]) ][ index.get(strs[j]) ] = true;
//        			check[ index.get(strs[j]) ][ index.get(strs[i]) ] = true;
//        		}
//        for ( String str : strs )
//        	if ( ifClose( start, str ) ) {
//        		check[ index.get( start ) ][ index.get( str ) ] = true;
//        		check[ index.get( str ) ][ index.get( start ) ] = true;
//        	}
//        for ( String str : strs )
//        	if ( ifClose( end, str ) ) {
//        		check[ index.get( end ) ][ index.get( str ) ] = true;
//        		check[ index.get( str ) ][ index.get( end ) ] = true;
//        	}
        String candidateStr = "qwertyuioplkjhgfdsazxcvbnm";
        for ( String str : strs ) {
        	for ( int target = 0; target < str.length(); ++target ) 
        		for ( int rep = 0; rep < candidateStr.length(); ++rep ) 
        			if ( str.charAt(target) != candidateStr.charAt(rep) ) {
        				String temp = str.substring(0, target) + candidateStr.substring(rep, rep+1) + str.substring(target+1, str.length());
        				if ( dict.contains(temp) ) {
        					check[ index.get(str) ][ index.get(temp) ] = true;
        					check[ index.get(temp) ][ index.get(str) ] = true;
        				}
        			}
        }
        for ( int target = 0; target < start.length(); ++target ) 
    		for ( int rep = 0; rep < candidateStr.length(); ++rep ) 
    			if ( start.charAt(target) != candidateStr.charAt(rep) ) {
    				String temp = start.substring(0, target) + candidateStr.substring(rep, rep+1) + start.substring(target+1, start.length());
    				if ( dict.contains(temp) ) {
    					check[ index.get(start) ][ index.get(temp) ] = true;
    					check[ index.get(temp) ][ index.get(start) ] = true;
    				}
    			}
        for ( int target = 0; target < end.length(); ++target ) 
    		for ( int rep = 0; rep < candidateStr.length(); ++rep ) 
    			if ( end.charAt(target) != candidateStr.charAt(rep) ) {
    				String temp = end.substring(0, target) + candidateStr.substring(rep, rep+1) + end.substring(target+1, end.length());
    				if ( dict.contains(temp) ) {
    					check[ index.get(end) ][ index.get(temp) ] = true;
    					check[ index.get(temp) ][ index.get(end) ] = true;
    				}
    			}
        
        // find the shortest path
        boolean foundSolution = false;
        Set<String> candidates = new HashSet<String>();
        Map<String, String> prevs = new HashMap<String, String>();
        candidates.addAll(dict);
        candidates.add(end);
        if ( !start.equals( end ) ) {
        	if ( ifClose( start, end ) ) {
        		res = 1;
        	} else {
		        Queue<String> queue = new ConcurrentLinkedQueue<String>();
		        queue.add(start);
		        while( res <= maxLength && !foundSolution ) {
		        	String str1 = queue.poll();
		        	if ( str1 == null && !foundSolution ) {
		        		break;
		        	}
		        	for ( String str2 : candidates )
		        		if ( !str1.equals(str2) && check[ index.get(str1) ][ index.get(str2) ] && !marked[ index.get(str2) ] )
		        			if ( str2.equals( end ) ) {
		        				prevs.put(str2, str1);
		        				foundSolution = true;
		        				break;
		        			}
		        			else {
		        				queue.add( str2 );
		        				marked[ index.get(str2) ] = true;
		        				prevs.put(str2, str1);
		        			}
		        	
		        }
		        if ( !foundSolution ) res = 0;
		        else {
		        	String str = end;
		        	res = 1;
		        	while( !str.equals(start) ) {
		        		++res;
		        		str = prevs.get(str);
		        	}
		        }
		        
        	}
        }
        return res;
    }
	
	private boolean ifClose( String str1, String str2 ) {
		int iter = 0;
		int distance = 0;
		boolean res = false;
		while( iter < str1.length() ) {
			if ( str1.charAt(iter) != str2.charAt(iter) ) ++distance;
			if ( distance > 1 ) break;
			++iter;
		}
		if ( distance == 1 ) res = true;
		return res;
	}
}
