// Rat in a Maze | Backtracking-2
class Solution{
	private static final int rows = 4;
	private static final int cols = 4;
	public void findPath(int[][] maze){
		int[][] path = new int[rows][cols];
		initialize(path);
		path[0][0] = 1;
		// findPathHelper(maze, 0, 0, path);
		countPathHelper(maze, 0, 0, path);
		// display(path);
		System.out.println(count);
	}
	private void initialize(int[][] path){
		for(int i=0;i<rows;i++)
			for(int j=0;j<cols;j++)
				path[i][j] = 0;
	}
	private void display(int[][] path){
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++)
				System.out.print(path[i][j] + " ");
			System.out.println();
		}
	}
	private boolean findPathHelper(int[][] maze, int x, int y, int[][] path){
		if(x == rows-1 && y == cols-1) return true;
		// forward direction
		if(y+1 >= 0 && y+1<cols && path[x][y+1] == 0 && maze[x][y+1] == 1){
			path[x][y+1] = 1;
			if(findPathHelper(maze,x, y+1, path)) return true;
			else path[x][y+1] = 0;
		}
		// downward direction
		if(x+1 >= 0 && x+1<rows && path[x+1][y] == 0 && maze[x+1][y] == 1){
			path[x+1][y] = 1;
			if(findPathHelper(maze, x+1, y, path)) return true;
			else path[x+1][y] = 0;
		}
		return false;
	}
	int count = 0;
	private void countPathHelper(int[][] maze, int x, int y, int[][] path){
		if(x == rows-1 && y == cols-1){
			System.out.println("count : " + count);
			count++;
			return;
		} 
		// forward direction
		if(y+1 >= 0 && y+1<cols && maze[x][y+1] == 1){
			countPathHelper(maze,x, y+1, path);
		}
		// downward direction
		if(x+1 >= 0 && x+1<rows && maze[x+1][y] == 1){
			countPathHelper(maze, x+1, y, path);
		}
	}
}
class Practice40{
	public static void main(String[] args) {
		int[][] maze = {{1, 1, 1, 1}, {1, 0, 1, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}};
		// {{1, 0, 0, 0}, {1, 1, 0, 1}, {0, 1, 0, 0}, {1, 1, 1, 1}};
		// new int[4][4];
		// maze[0] = new int[4]{1, 0, 0, 0};
		// maze[1] = new int[4]{1, 1, 0, 1};
		// maze[2] = new int[4]{0, 1, 0, 0};
		// maze[3] = new int[4]{1, 1, 1, 1};
		// 1 is block that can be used
		// 0 is a dead end
		new Solution().findPath(maze);
	}
}