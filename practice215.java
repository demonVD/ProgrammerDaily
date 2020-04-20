// https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3302/
// No of Islands
import java.util.Arrays;
class Solution {
    public int numIslands(char[][] grid) {
    	int row = grid.length;
    	if(row == 0) return 0;
    	int col = grid[0].length;
 		boolean[][] visited = new boolean[row][col];
 		for(boolean[] currentRow : visited){
 			Arrays.fill(currentRow, false);
 		}
 		// init(visited);
 		// Arrays.fill(visited, false);
 		int count = 0;
 		for(int i=0;i<row;i++){
 			for(int j=0;j<col;j++){
 				if(!visited[i][j] && grid[i][j] == '1'){
					formsAnIsland(grid, visited,i,j, row, col);
					count++;
 				}
 			}
 		}  
 		return count;     
    }
    private void formsAnIsland(char[][] grid, boolean[][] visited, int i, int j, int row, int col){
    	visited[i][j] = true;
    	if(j-1 >= 0 && !visited[i][j-1] && grid[i][j-1] == '1'){
    		formsAnIsland(grid, visited, i, j-1, row, col);
    	}
    	if(j+1 < col && !visited[i][j+1] && grid[i][j+1] == '1'){
    		formsAnIsland(grid, visited, i, j+1, row, col);
    	}
    	if(i-1 >= 0 && !visited[i-1][j] && grid[i-1][j] == '1'){
    		formsAnIsland(grid, visited, i-1, j, row, col);
    	}
    	if(i+1 < row && !visited[i+1][j] && grid[i+1][j] == '1'){
    		formsAnIsland(grid, visited, i+1, j, row, col);
    	}
    	// return 1;
    }
}
class Practice215{
	public static void main(String[] args) {
		char[][] grid = {{'1','1','1'},{'1','1','1'},{'1','1','1'}};
		Solution solution = new Solution();
		System.out.println(solution.numIslands(grid));
	}
}