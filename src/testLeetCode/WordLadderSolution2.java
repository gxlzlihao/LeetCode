package testLeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

// this solution works and pass the LeetCode
public class WordLadderSolution2 {
	public int ladderLength(String start, String end, Set<String> dict) {
		int res = 0;
		String candidate = "qwertyuioplkjhgfdsazxcvbnm";
		boolean found = false;
		Queue<String> queue = new ConcurrentLinkedQueue<String>();
		Set<String> used = new HashSet<String>();
		Map<String, String> prevs = new HashMap<String, String>();
		queue.add(start);
		used.add(start);
		int upbound = dict.size()+1;
		if ( dict.contains(end) ) ++upbound;
		while ( !found && used.size() < upbound ) {
			String str = queue.poll();
			if ( str == null ) break;
			for ( int target = 0; target < str.length() && !found; ++target )
				for ( int rep = 0; rep < candidate.length() && !found; ++rep )
					if ( str.charAt(target) != candidate.charAt(rep) ) {
						String temp = str.substring(0,target) + candidate.substring(rep,rep+1) + str.substring(target+1);
						if ( temp.equals(end) ) {
							found = true;
							prevs.put(temp, str);
						}
						else if ( dict.contains(temp) && !used.contains(temp) ) {
							queue.add(temp);
							used.add(temp);
							prevs.put(temp, str);
						}
					}
		}
		if ( !found ) res = 0;
		else {
			String str = end;
			res = 0;
			while( !str.equals(start) ) {
				str = prevs.get(str);
				++res;
			}
			++res;
		}
		return res;
	}
}
