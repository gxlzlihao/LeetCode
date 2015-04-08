package testLeetCode;

import java.util.ArrayList;
import java.util.List;

public class InsertIntervalSolution {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = null;
        if ( newInterval == null ) res = intervals;
        else if ( intervals == null ) {
        	res = new ArrayList<Interval>();
        	res.add( newInterval );
        } else if ( intervals.size() == 0 ) {
        	intervals.add( newInterval );
        	res = intervals;
        } else { // the length of intervals array is at least one
        	boolean inserted = false;
	        for ( int i = 0; i < intervals.size() && !inserted; ++i ) 
	        	if ( newInterval.start < intervals.get(i).start ) 
	        		if ( i == 0 ) {
	        			// at the begining of the array
	        			if ( newInterval.end < intervals.get(i).start ) {
	        				intervals.add( i, newInterval );
	        				inserted = true;
	        			} else {
	        				int item = i;
	        				List<Integer> temp = new ArrayList<Integer>();
	        				while( intervals.get(item).end < newInterval.end ) {
	        					temp.add( item );
	        					++item;
	        				}
	        				int newStart = newInterval.start;
	        				int newEnd = intervals.get(item).end;
	        				for ( int deleted : temp ) 
	        					intervals.remove( (int) temp.get(0) );
	        				if ( intervals.size() == 0 ) intervals.add(new Interval( newStart, newEnd ));
	        				else intervals.add(i, new Interval( newStart, newEnd ));
	        				inserted = true;
	        			}
	        		} else {
	        			// at the middle of the array
	        			if ( newInterval.start <= intervals.get(i-1).end ) {
	        				// former item must be included
	        				int item = i;
	        				List<Integer> temp = new ArrayList<Integer>();
	        				temp.add(item-1);
	        				while( intervals.get(item).end <= newInterval.end ) {
	        					temp.add( item );
	        					++item;
	        				}
	        				if ( intervals.get(item).start <= newInterval.end  ) temp.add(item);
	        				int newStart = intervals.get(i-1).start;
	        				int newEnd = intervals.get(item).end;
	        				for ( int deleted : temp ) 
	        					intervals.remove( (int) temp.get(0) );
	        				if ( intervals.size() == 0 )
	        					intervals.add(new Interval( newStart, newEnd ));
	        				else intervals.add(i-1, new Interval( newStart, newEnd ));
	        				inserted = true;
	        			} else {
	        				// former item does not need to be included
	        				int item = i;
	        				List<Integer> temp = new ArrayList<Integer>();
	        				while( intervals.get(item).end <= newInterval.end ) {
	        					temp.add( item );
	        					++item;
	        				}
	        				int newStart = newInterval.start;
	        				int newEnd = intervals.get(item).end;
	        				for ( int deleted : temp ) 
	        					intervals.remove( (int) temp.get(0) );
	        				if ( intervals.size() == 0 ) intervals.add(new Interval( newStart, newEnd ));
	        				else intervals.add(i-1, new Interval( newStart, newEnd ));
	        				inserted = true;
	        			}
	        		}
	        if ( !inserted ) // at the end of the array
	        {
	        	int newStart = intervals.get( intervals.size()-1 ).start;
        		int newEnd = Math.max( newInterval.end, intervals.get( intervals.size()-1 ).end );
        		intervals.remove( intervals.size() - 1 );
        		intervals.add( new Interval( newStart, newEnd ) );
        		inserted = true;
	        }
	        res = intervals;
        }
        return res;
    }
}
