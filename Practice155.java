// Find factors of a number
import java.util.ArrayList;
import java.util.Collections;
class Solution{
  public ArrayList<Integer> getFactors(int A){
    ArrayList<Integer> R = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<>();
    // R.add(1);
    for(int i = 1; i <= Math.sqrt(A); i++){
      if(A%i == 0){
        int a = i;
        int b = A / a;
        R.add(a);
        if( a != b) temp.add(b);
      }
    }
    Collections.reverse(temp);
    for(int i : temp){
      R.add(i);
    }
    // R.add(A);
    return R;
  }
  public void display(ArrayList<Integer> R){
    for(int i : R){
      System.out.print(i + " ");
    }
  }
}
class Practice155{
  public static void main(String[] args) {
    int A = 6;
    Solution solution = new Solution();
    solution.display(solution.getFactors(A));
  }
}
