package testLeetCode;

import java.math.BigDecimal;

public class FractionToDecimalSolution {
	
	boolean positive = true;
	
    public String fractionToDecimal( int numerator, int denominator ) {
    	
    	if ( numerator * denominator > 0 ) positive = true;
    	else positive = false;
    	
    	if ( numerator<0 ) numerator*=-1;
    	if ( denominator<0 ) {
    		denominator=-denominator;
    	}
    	
    	String res = null;
    	int res1 = numerator / denominator;
    	double doubleValue = (double) numerator / denominator;
    	String res2Str = doubleValue + "";
    	
    	if ( res2Str.contains("E") ) res2Str = new BigDecimal( res2Str ).toPlainString();
    	System.out.println( res2Str );
    	
    	if ( denominator == -2147483648 ) denominator = 1000; 
    	
    	boolean decimal = res2Str.indexOf(".") == -1?true:false;
    	if(decimal) {
    		res = res1 + "";
    	} else {
    		int commaIndex = res2Str.indexOf(".");
    		res2Str = res2Str.substring(commaIndex+1);
    		String template = null;
    		
//    		System.out.println( res2Str );
    		
    		if ( denominator<res2Str.length() ) {
    			template = res2Str.substring(0, Math.abs(denominator));
    		} else 
    			template = res2Str;
    		for( int i = denominator; i<res2Str.length(); ++i ) {
    			String temp = res2Str.substring(i, i+1);
    			
    			if ( template.indexOf(temp) != -1 ) {
    				int beginIndex = template.indexOf(temp);
    				String tempStr = findRecursion( res2Str, template, temp, beginIndex, i );
    				if ( !tempStr.equals("") ) {
    					res = res1 + ".(" + tempStr + ")";
    					break;
    				}
    			}
    		}
    		if ( res == null ) res = res2Str + "";
    	}
    	
    	if( !positive ) res = "-" + res;
    	return res;
    }
    
    private String findRecursion( String ori, String checkTemplate, String beginStr, int beginIndex, int checkIndex ) {
    	String res = "";
    	int x = checkIndex+1;
    	int y = beginIndex+1;
    	while( x < ori.length() && y < checkTemplate.length() ) {
    		if ( ori.charAt(x) != checkTemplate.charAt(y) ) { 
    			res="";
    			break;
    		}
    		if ( ori.substring(x, x+1).equals(beginStr) ) {
    			res = beginStr + res;
    			break;
    		}
    		res += ori.substring(x, x+1);
    		++x;
    		++y;
    	}
    	return res;
    }
}
