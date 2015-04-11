package testLeetCode;

public class DungeonGameSolution {
	
	private int maxX;
	private int maxY;
	
	public int calculateMinimumHP(int[][] dungeon) {
        int res = 0;
        
        maxX = dungeon.length;
        maxY = dungeon[0].length;
        if ( maxX < 1 || maxY < 1 ) res = 0;
        else {
        	int[][] steps = {{-1,0}, {0,-1}};
        	int[][] blood = new int[ maxX ][ maxY ];
        	if ( dungeon[ maxX - 1 ][ maxY - 1 ] < 1 )
        		blood[ maxX - 1 ][ maxY - 1 ] = 1 - dungeon[ maxX - 1 ][ maxY - 1 ];
        	else
        		blood[ maxX - 1 ][ maxY - 1 ] = 1;
        	for ( int x = maxX - 1; x >= 0; --x ) {
        		for ( int y = maxY - 1; y >= 0; --y ) 
        				for ( int i = 0; i < steps.length; ++i ) {
        					int newX = x + steps[i][0];
        					int newY = y + steps[i][1];
        					if ( checkValid( newX, newY ) ) {
        						int newBlood = blood[x][y] - dungeon[ newX ][ newY ];
        						if ( newBlood < 1 ) newBlood = 1;
        						if ( blood[ newX ][ newY ] == 0 ) blood[ newX ][ newY ] = newBlood;
        						else if ( newBlood < blood[ newX ][ newY ] ) blood[ newX ][ newY ] = newBlood; 
        					}
        				}
        	res = blood[0][0];
        	}
        }
        
        return res;
    }
	
	private boolean checkValid( int x, int y ) {
		boolean res = !( x < 0 || x >= maxX || y < 0 || y >= maxY );
		return res;
	}
}
