// https://www.interviewbit.com/problems/spiral-order-matrix-ii/
import java.util.ArrayList;
class Solution{
  public ArrayList<ArrayList<Integer>> generateMatrix(int A){
    int count = 1;
    int sq = A*A;
    int sr = 0, er = A-1, sc = 0, ec = A-1;
    ArrayList<ArrayList<Integer>> mat = new ArrayList<ArrayList<Integer>>();
    for(int i = 0; i < A; i++){
      mat.add(new ArrayList<Integer>());
      for(int j = 0; j < A; j++){
        mat.get(i).add(0);
      }
    }
    while(count <= sq){
      for(int i = sc; i <= ec; i++){
        // System.out.println(sr+ "," + i + " " + count);
        mat.get(sr).set(i, count++);
      }
      sr++;
      for(int i = sr; i <= er; i++){
        // System.out.println(i + "," + ec + " " + count);
        mat.get(i).set(ec, count++);
      }
      ec--;
      for(int i = ec; i >= sc; i--){
        // System.out.println(er + "," + i + " " + count);
        mat.get(er).set(i, count++);
      }
      er--;
      for(int i = er; i >= sr; i--){
        // System.out.println(sc + "," + i + " " + count);
        mat.get(i).set(sc, count++);
      }
      sc++;
    }
    return mat;
  }
  public void display(ArrayList<ArrayList<Integer>> mat, int A){
    for(int i = 0; i < A; i++){
      for(int j = 0; j < A; j++){
        System.out.print(mat.get(i).get(j) + " ");
      }
      System.out.println();
    }
  }
}
class Practice151{
  public static void main(String[] args) {
    int A = 0;
    Solution solution = new Solution();
    solution.display(solution.generateMatrix(A), A);
  }
}
