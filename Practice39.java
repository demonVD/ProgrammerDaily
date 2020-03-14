// The Knight’s tour problem | Backtracking-1
class Solution{
	private static final int rows = 8;
	private static final int cols = 8;
	public void markPath(){
		int[][] path = new int[rows][cols];
		initialize(path);
		path[0][0] = 0;
		if(markPathHelper(path, 0, 0, 0)){
			showPath(path);
		}else{
			System.out.println("No Path");
		}
	}
	private void initialize(int[][] path){
		for(int i=0;i<rows;i++)
			for(int j=0;j<cols;j++)
				path[i][j] = -1;
	}
	private void showPath(int[][] path){
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++)
				System.out.print(path[i][j] + " ");
			System.out.println();
		}
	}
	// x-2 y-1
	// x-2 y+1
	// x-1 y-2
	// x+1 y-2
	// x-1 y+2
	// x+1 y+2
	// x+2 y+1
	// x+2 y-1
	private boolean markPathHelper(int[][] path, int x, int y, int steps){
		if(steps == rows*cols-1) return true;
		steps = steps+1;
		if(x-2>=0 && x-2<rows && y-1>=0 && y-1<cols && path[x-2][y-1]==-1){
			path[x-2][y-1] = steps;
			if(markPathHelper(path, x-2, y-1, steps)) return true;
			else path[x-2][y-1] = -1;
		}
		if(x-2>=0 && x-2<rows && y+1>=0 && y+1<cols && path[x-2][y+1]==-1){
			path[x-2][y+1] = steps;
			if(markPathHelper(path, x-2, y+1, steps)) return true;
			else path[x-2][y+1] = -1;
		}
		if(x-1>=0 && x-1<rows && y-2>=0 && y-2<cols && path[x-1][y-2]==-1){
			path[x-1][y-2] = steps;
			if(markPathHelper(path, x-1, y-2, steps)) return true;
			else path[x-1][y-2] = -1;
		}
		if(x-1>=0 && x-1<rows && y+2>=0 && y+2<cols && path[x-1][y+2]==-1){
			path[x-1][y+2] = steps;
			if(markPathHelper(path, x-1, y+2, steps)) return true;
			else path[x-1][y+2] = -1;
		}
		if(x+1>=0 && x+1<rows && y-2>=0 && y-2<cols && path[x+1][y-2]==-1){
			path[x+1][y-2] = steps;
			if(markPathHelper(path, x+1, y-2, steps)) return true;
			else path[x+1][y-2] = -1;
		}
		if(x+1>=0 && x+1<rows && y+2>=0 && y+2<cols && path[x+1][y+2]==-1){
			path[x+1][y+2] = steps;
			if(markPathHelper(path, x+1, y+2, steps)) return true;
			else path[x+1][y+2] = -1;
		}
		if(x+2>=0 && x+2<rows && y-1>=0 && y-1<cols && path[x+2][y-1]==-1){
			path[x+2][y-1] = steps;
			if(markPathHelper(path, x+2, y-1, steps)) return true;
			else path[x+2][y-1] = -1;
		}
		return false;
	}
}
class Practice39{
	public static void main(String[] args) {
		new Solution().markPath();
	}
}