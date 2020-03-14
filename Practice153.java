// https://www.interviewbit.com/problems/kth-row-of-pascals-triangle/
import java.util.ArrayList;
class Solution{
  public ArrayList<Integer> getRow(int A) {
    ArrayList<Integer> R = new ArrayList<Integer>();
    for(int i = 0; i <= A; i++){
      R.add(1);
    }
    for(int i = 0; i <= A; i++){
      int prev = 1, curr = 1;
      for(int j = 0; j <= i; j++){
        if(j == 0 || j == i){
          R.set(j, 1);
        }
        else{
          prev = curr;
          curr = R.get(j);
          R.set(j, prev + curr);
        }
      }
    }
    return R;
  }
  public void display(ArrayList<Integer> A){
    for(int i : A){
      System.out.print(i + " ");
    }
    System.out.println();
  }
}
class Practice153{
  public static void main(String[] args) {
    int A = 4;
    Solution solution = new Solution();
    solution.display(solution.getRow(A));
  }
}
