// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3303/
// minimum path sum
class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        if(rows == 0){
        	return 0;
        }
        int cols = grid[0].length;

        // populating first row with minSums
      	for(int j=1;j<cols;j++){
      		grid[0][j] += grid[0][j-1];
      	}

      	// for others rows
        for(int i=1;i<rows;i++){
        	for(int j=0;j<cols;j++){
        		int min = grid[i-1][j];
        		if(j-1 >= 0){
        			min = Math.min(min, grid[i][j-1]);
        		}
        		grid[i][j] += min;
        	}
        }
        for(int i=0;i<rows;i++){
        	for(int j=0;j<cols;j++){
        		System.out.print(grid[i][j]);
        	}
        	System.out.println();
        }
        return grid[rows-1][cols-1];
    }
}
class Practice216{
	public static void main(String[] args) {
		// int[][] grid = {{1, 3, 1},{1, 5, 1},{4, 2, 1}};
		// int[][] grid = {{1,0,0},{0,1,0},{1,0,0}};
		int[][] grid = {};
		Solution solution = new Solution();
		System.out.println(solution.minPathSum(grid));
	}
}