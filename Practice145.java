// https://www.interviewbit.com/problems/add-one-to-number/
import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
      int length = A.size();
      int i = length - 1;
      // int carry = 0, sum = 0;
        while(i >= 0 && A.get(i) == 9){
          // carry = 1;
          A.set(i, 0);
          i--;
        }
        if(i < 0){
          ArrayList<Integer> B = new ArrayList<>();
          B.add(1);
          for(int j = 1; j < length + 1; j++){
            B.add(0);
          }
          return B;
        }
        A.set(i, A.get(i) + 1);
        return A;
    }

}
class Practice145{
  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>();
    A.add(-1);
    A.add(0);
    // A.add(9);
    Solution solution  = new Solution();
    display(solution.plusOne(A));
  }
  public static void display(ArrayList<Integer> A){
    for(int  i = 0; i < A.size(); i++ ){
      System.out.print(A.get(i) + " ");
    }
  }
}
