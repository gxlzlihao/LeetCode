package testLeetCode;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class NumberofIslandsSolution {
	public int numIslands(char[][] grid) {
		int res = 0;
		if ( grid == null || grid.length == 0 || grid[0].length == 0 ) return res;
		char[][] extendedGrid = generateExtentedGrid( grid );
		boolean[][] used = new boolean[ extendedGrid.length ][ extendedGrid[0].length ];
		int[][] steps = {{1,0}, {-1,0}, {0,1}, {0,-1}};
		Queue<Integer> xq = new ConcurrentLinkedQueue<Integer>();
		Queue<Integer> yq = new ConcurrentLinkedQueue<Integer>();
		for ( int x = 1; x < extendedGrid.length - 1; ++x )
			for ( int y = 1; y < extendedGrid[0].length - 1; ++y ) {
				if ( grid[ x - 1 ][ y - 1 ] == '1' && !used[ x ][ y ] ) {
					++res;
					xq.clear();
					yq.clear();
					xq.add(x);
					yq.add(y);
					used[x][y] = true;
					while ( xq.size() != 0 && yq.size() != 0 ) {
						int beginX = xq.poll();
						int beginY = yq.poll();
						for ( int i = 0; i < steps.length; ++i ) {
							int newX = beginX + steps[i][0];
							int newY = beginY + steps[i][1];
							if ( newX == 0 || newY == 0 || newX == grid.length + 1 || newY == grid[0].length + 1 ) 
								continue;
							if ( grid[ newX - 1 ][ newY - 1 ] == '1' && !used[ newX ][ newY ] ) {
								used[newX][newY] = true;
								xq.add(newX);
								yq.add(newY);
							}
						}
					}
				}
			}
		return res;
    }
	private char[][] generateExtentedGrid( char[][] grid ) {
		char[][] res = new char[ grid.length + 2 ][ grid[0].length + 2 ];
		for ( int x = 0; x < res.length; ++x )
			for ( int y = 0; y < res[0].length; ++y ) {
				if ( x == 0 || y == 0  || x == res.length - 1 || y == res[0].length - 1 )
					res[x][y] = '0';
				else if ( grid[ x - 1 ][ y - 1 ] == '1' )
					res[x][y] = '1';
				else 
					res[x][y] = '0';
			}
		return res;
	}
}
