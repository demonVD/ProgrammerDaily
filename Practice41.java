// N Queen Problem | Backtracking-3
class Solution{
	int n;
	int[][] board;
	public Solution(int n){
		this.n = n;
		board = new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++)
				board[i][j] = 0;
		}
	}
	int count = 0;
	public void nQueenPlacement(){
		if(nQueenPlacementHelper()){
			
		}
		showPlacement();
	}
	private  boolean isSafe(int board[][], int row, int col){ 
        int i, j; 
  
        /* Check this row on left side */
        for (i = 0; i < col; i++) 
            if (board[row][i] == 1) 
                return false; 
  
        /* Check upper diagonal on left side */
        for (i=row, j=col; i>=0 && j>=0; i--, j--) 
            if (board[i][j] == 1) 
                return false; 
  
        /* Check lower diagonal on left side */
        for (i=row, j=col; j>=0 && i<N; i++, j--) 
            if (board[i][j] == 1) 
                return false; 
  
        return true; 
    } 
	/*private boolean nQueenPlacementHelper(int[][] board, int x, int y){
		System.out.println("In here helper");
		if(count == n){
			System.out.println("In here exit");
			return true;
		}
		if(x+1>=0 && y-2>=0 && x+1<n && y-2<n && board[x+1][y-2]==0){
			board[x+1][y-2] = 1;
			count++;
			if(nQueenPlacementHelper(board, x+1, y-2)){
				return true;
			}
			else{
				board[x+1][y-2] = 0;
				count--;
			}
		}
		// x+2, y-1
		if(x+2>=0 && y-1>=0 && x+2<n && y-1<n && board[x+2][y-1]==0){
			board[x+2][y-1] = 1;
			count++;
			if(nQueenPlacementHelper(board, x+2, y-1)){
				return true;
			}
			else{
				board[x+2][y-1] = 0;
				count--;
			}
		}
		// x+2, y+1
		if(x+2>=0 && y+1>=0 && x+2<n && y+1<n && board[x+2][y+1]==0){
			board[x+2][y+1] = 1;
			count++;
			if(nQueenPlacementHelper(board, x+2, y+1)){
				return true;
			}
			else{
				board[x+2][y+1] = 0;
				count--;
			}
		}
		// x+1, y+2
		if(x+1>=0 && y+2>=0 && x+1<n && y+2<n && board[x+1][y+2]==0){
			board[x+1][y+2] = 1;
			count++;
			if(nQueenPlacementHelper(board, x+1, y+2)){
				return true;
			}
			else{
				board[x+1][y+2] = 0;
				count--;
			}
		}
		// x-1, y+2
		if(x-1>=0 && y+2>=0 && x-1<n && y+2<n && board[x-1][y+2]==0){
			board[x-1][y+2] = 1;
			count++;
			if(nQueenPlacementHelper(board, x-1, y+2)){
				return true;
			}
			else{
				board[x-1][y+2] = 0;
				count--;
			}
		}
		// x-2, y+1
		if(x-2>=0 && y+1>=0 && x-2<n && y+1<n && board[x-2][y+1]==0){
			board[x-2][y+1] = 1;
			count++;
			if(nQueenPlacementHelper(board, x-2, y+1)){
				return true;
			}
			else{
				board[x-2][y+1] = 0;
				count--;
			}
		}
		// x-2, y-1
		if(x-2>=0 && y-1>=0 && x-2<n && y-1<n && board[x-2][y-1]==0){
			board[x-2][y-1] = 1;
			count++;
			if(nQueenPlacementHelper(board, x-2, y-1)){
				return true;
			}
			else{
				board[x-2][y-1] = 0;
				count--;
			}
		}
		// x-1, y-2
		if(x-1>=0 && y-2>=0 && x-1<n && y-2<n && board[x-1][y-2]==0){
			board[x-1][y-2] = 1;
			count++;
			if(nQueenPlacementHelper(board, x-1, y-2)){
				return true;
			}
			else{
				board[x-1][y-2] = 0;
				count--;
			}
		}
		return false;
	}*/
	private void showPlacement(){
		System.out.println("In here show");
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
}
class Practice41{
	public static void main(String[] args) {
		new Solution(5).nQueenPlacement();
	}
}