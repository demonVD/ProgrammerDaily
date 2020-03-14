// https://www.interviewbit.com/problems/pascal-triangle/
import java.util.ArrayList;
class Solution{
  public ArrayList<ArrayList<Integer>> solve(int A) {
    ArrayList<ArrayList<Integer>> R = new ArrayList<ArrayList<Integer>>();
    for(int i = 0; i < A; i++){
      ArrayList<Integer> B = new ArrayList<>();
      for(int j = 0; j <= i; j++){
        if(j == 0 || j == i){
          B.add(1);
        }
        else{
          // System.out.println("i : " + i + " j : " + j);
          // System.out.println(R.get(i-1).size());
          // System.out.println(R.get(i-1).get(j));
          // System.out.println(R.get(i-1).get(j-1));
          B.add(R.get(i-1).get(j) + R.get(i-1).get(j-1));
        }
      }
      R.add(B);
    }
    return R;
  }
  public void display(ArrayList<ArrayList<Integer>> R){
    for(ArrayList<Integer> A : R){
      for(int i : A){
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }
}
class Practice152{
  public static void main(String[] args) {
    int A = 5;
    Solution solution = new Solution();
    solution.display(solution.solve(A));
  }
}
