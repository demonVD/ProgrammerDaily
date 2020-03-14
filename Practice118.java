/*Given a N X N  matrix Matrix[N][N] of positive integers.  There are only 
three possible moves from a cell Matrix[r][c].

1. Matrix[r+1][c]

2. Matrix[r+1][c-1]

3. Matrix[r+1][c+1]

Starting from any column in row 0, 
return the largest sum of any of the paths up to row N-1.*/
class Solution{
	public int largestSum(int[][] mat){
		int rows = mat.length;
		int cols = mat[0].length;
		int[][] max = new int[rows][cols];
		// max[0][0] = mat[0][0];
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				int maxFromUp = 0, maxFromLeft = 0, maxFromRight = 0;
				if( i-1 >= 0 ){
					maxFromUp = max[i-1][j];
				}
				if( i-1 >= 0 && j+1 < cols ){
					maxFromRight = max[i-1][j+1];
				}
				if( i-1 >= 0 && j-1 >= 0){
					maxFromLeft = max[i-1][j-1];
				}
				max[i][j] = Math.max(Math.max(maxFromUp, maxFromLeft), maxFromRight) + mat[i][j];
			}
		}
		int largestSum = 0;
		for(int i=0;i<cols;i++){
			if(largestSum < max[rows-1][i]){
				largestSum = max[rows-1][i];
			}
		}
		return largestSum;
	}

}
class Practice118{
	public static void main(String[] args) {
		int[][] mat = {{348, 391}, {618, 193}};
		// {{0, 3, 1, 1}, {2, 8, 9, 4}, {1, 5, 3, 1}};
		System.out.println(new Solution().largestSum(mat));
	}
}