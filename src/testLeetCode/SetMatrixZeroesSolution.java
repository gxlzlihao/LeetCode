package testLeetCode;

public class SetMatrixZeroesSolution {
	
	private class point {
		public int x;
		public int y;
		public point( int x, int y ) {
			this.x = x;
			this.y = y;
		}
	}
	
	public void setZeroes(int[][] matrix) {
        point zero = work( 0, 0, matrix );
        if ( zero != null ) 
        {
        	for ( int y = 0; y < matrix[0].length; ++y ) matrix[ zero.x ][ y ] = 0;
        	for ( int x = 0; x < matrix.length; ++x ) matrix[ x ][ zero.y ] = 0;
        }
    }
	
	private point work( int startX, int startY, int[][] matrix ) {
		point res = null;
		boolean found = false;
		point next = null;
		if ( startX >= 0 && startX < matrix.length && startY >= 0 && startY < matrix[0].length ) {
			for ( int y = startY; y < matrix[0].length && !found; ++y ) 
				if ( matrix[ startX ][ y ] == 0 ) {
					found = true;
					next = nextPoint( startX, y, matrix );
					res = new point( startX, y );
				}
			for ( int x = startX + 1; x < matrix.length && !found; ++x )
				for ( int y = 0; y < matrix[0].length && !found; ++y ) 
					if ( matrix[ x ][ y ] == 0 ) {
						found = true;
						next = nextPoint( x, y, matrix );
						res = new point( x, y );
					}
			if ( found ) {
				point newZero = work( next.x, next.y, matrix );
				if ( newZero != null ) 
		        {
		        	for ( int y = 0; y < matrix[0].length; ++y ) matrix[ newZero.x ][ y ] = 0;
		        	for ( int x = 0; x < matrix.length; ++x ) matrix[ x ][ newZero.y ] = 0;
		        }
			}
		}
		return res;
	}
	
	private point nextPoint( int startX, int startY, int[][] matrix ) {
		point res = null;
		if ( startY + 1 >= matrix[0].length ) {
			res = new point( startX + 1, 0 );
		} else {
			res = new point( startX, startY + 1 );
		}
		return res;
	}
}
