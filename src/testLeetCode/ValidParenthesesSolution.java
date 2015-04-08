package testLeetCode;

import java.util.Stack;

public class ValidParenthesesSolution {
	
	private Stack<String> stack = new Stack<String>();
	
	public boolean isValid(String s) {
        boolean res = true;
        for ( int i = 0; i < s.length(); ++i ) {
        	String target = s.substring( i, i + 1 );
        	if ( isBracket( target ) ) {
        		if ( stack.empty() && isLeft( target ) ) stack.push( target );
        		else if ( stack.empty() && isRight( target ) ) {
        			res = false;
        			break;
        		} else {
        			String top = stack.peek();
        			if ( ( isLeft( top ) && isRight( target ) ) || isRight( top ) && isLeft( target ) ) {
        				if ( isMatch( top, target ) ) stack.pop();
        				else {
        					res = false;
        					break;
        				}
        			} else stack.push( target );
        		}
        	}
        }
        if ( stack.size() > 0 ) res = false;
        return res;
    }
	
	private boolean isLeft( String s ) {
		boolean res = true;
		String template = "({[";
		if ( s.length() != 1 || !template.contains(s) ) res = false;
		return res;
	}
	
	private boolean isRight( String s ) {
		boolean res = true;
		String template = ")]}";
		if ( s.length() != 1 || !template.contains(s) ) res = false;
		return res;
	}
	
	private boolean isBracket( String s ) {
		boolean res = true;
		String template = "(){}[]";
		if ( s.length() != 1 || !template.contains(s) ) res = false;
		return res;
	}
	
	private boolean isMatch( String s1, String s2 ) {
		boolean res = true;
		if ( !isBracket( s1 ) || !isBracket( s2 ) ) res = false;
		else if ( s1.equals( "(" ) ) {
			if ( !s2.equals( ")" ) ) res = false;
		}
		else if ( s1.equals( ")" ) ) {
			if ( !s2.equals( "(" ) ) res = false;
		}
		else if ( s1.equals( "[" ) ) {
			if ( !s2.equals( "]" ) ) res = false;
		}
		else if ( s1.equals( "]" ) ) {
			if ( !s2.equals( "[" ) ) res = false;
		}
		else if ( s1.equals( "{" ) ) {
			if ( !s2.equals( "}" ) ) res = false;
		}
		else if ( s1.equals( "}" ) ) {
			if ( !s2.equals( "{" ) ) res = false;
		}
		else res = false;
		return res;
	}
}
