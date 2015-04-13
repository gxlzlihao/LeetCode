package testLeetCode;

public class UniqueBinarySearchTreesSolution {
	public int numTrees(int n) {
        int res = 0;
        if ( n == 0 ) res = 1;
        else if ( n == 1 ) res = 1;
        else if ( n == 2 ) res = 2;
        else {
	        int[] numbers = new int[n+1];
	        numbers[0] = 1;
	        numbers[1] = 1;
	        numbers[2] = 2;
	        for ( int number = 3; number <= n; ++number ) {
	        	int count = 0;
	        	for ( int middle = 1; middle <= number; ++middle ) {
	        		int left = middle - 1;
	        		int right = number - middle;
	        		count += numbers[left] * numbers[right];
	        	}
	        	numbers[number] = count;
	        }
	        res = numbers[n];
        }
        return res;
    }
}
