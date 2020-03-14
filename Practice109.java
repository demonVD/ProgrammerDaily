// Turn the image by 90 degree
class Solution{

	// taking extra space
	public int[][] rotate90(int[][] a){
		int[][] b = new int[a[0].length][a.length];
		int aCol = 0, bRow = 0;
		while(aCol < a[0].length || bRow < b.length){
			int i = a.length-1, j = 0;
			while(i >= 0 && j <= b[0].length){
				b[bRow][j++] = a[i--][aCol];
			}
			bRow++;
			aCol++;
		}
		return b;
	}

	// without taking extra space
	public int[][] rotate90Inplace(int[][] a){
		int startRow = 0, endRow = a.length-1, startCol = 0, endCol = a[0].length-1;
		int currRow = 0, currCol = 0;
		int cols = (endCol - startCol) + 1;
		int numRotation = 4;
		while(cols > 0){
			while(currCol < cols-1){
				int prev = a[currRow][currCol];
				for(int i=1;i<=numRotation;i++){
					System.out.print("a[" + currRow + "][" + currCol + "] -> ");
					int next = a[currCol][endRow - currRow];
					a[currCol][endRow - currRow] = prev;
					prev = next;
					int s = currRow;
					currRow = currCol;
					currCol = endRow - s;
					System.out.print("a[" + currRow + "][" + currCol + "]");
					System.out.println();
				}
				currCol += 1;
				System.out.println();
			}
			cols -=2;
		}
		return a;
	}	

	public void display(int[][] a){
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[0].length;j++){
				System.out.print(a[i][j] +" ");
			}
			System.out.println();
		}
	}
}
class Practice109{
	public static void main(String[] args) {
		int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		// {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		
		/*a[0] = [1, 2, 3];
		a[1] = [4, 5, 6];
		a[2] = [7, 8, 9];*/
		Solution sol = new Solution();
		// sol.display(a);
		// sol.display(sol.rotate90(a));
		sol.display(sol.rotate90Inplace(a));
	}
}