// Spiral Order
class Solution{
  public void printSpiral(int[][] mat, int row, int col){
    int startRow = 0, startCol = 0, endRow = row-1, endCol = col-1;
    int count = 0;
    int totalElement = row * col;
    int i = 0;
    while(count < totalElement){
      i = startCol;
      while(i <= endCol && count < totalElement){
        count++;
        System.out.print(mat[startRow][i] + " ");
        i++;
      }
      ++startRow;
      i = startRow;
      while(i <= endRow && count < totalElement)
      {
        count++;
        System.out.print(mat[i][endCol] + " ");
        i++;
      }
      --endCol;
      i = endCol;
      while(i >= startCol && count < totalElement)
      {
        count++;
        System.out.print(mat[endRow][i] + " ");
        i--;
      }
      --endRow;
      i = endRow;
      while(i >= startRow && count < totalElement)
      {
        count++;
        System.out.print(mat[i][startCol] + " ");
        i--;
      }
      ++startCol;
    }
    System.out.println();
  }
}
class Practice140{
  public static void main(String[] args) {
    int row = 3, col = 3;
    int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    Solution solution = new Solution();
    solution.printSpiral(mat, row, col);
  }
}
