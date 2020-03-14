// minimum steps from source to destination
// https://www.interviewbit.com/problems/min-steps-in-infinite-grid/
import java.util.ArrayList;
class Solution{
  public int getMin(ArrayList<Integer> A, ArrayList<Integer> B){
    int minDis = 0;
    for(int i = 0; i < A.size()-1; i++){
      int x1 = A.get(i), y1 = B.get(i);
      int x2 = A.get(i+1), y2 = B.get(i+1);
      int diffX = Math.abs(x1 - x2);
      int diffY = Math.abs(y1 - y2);
      if(diffX == diffY){
        minDis += diffX;
      }else{
        minDis += Math.min(diffX, diffY) + Math.abs(diffX - diffY);
      }
    }
    return minDis;
  }
}
class Practice144{
  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>();
    ArrayList<Integer> B = new ArrayList<>();
    A.add(0); B.add(0);
    A.add(-5); B.add(1);
    A.add(3); B.add(2);
    Solution solution = new Solution();
    System.out.println(solution.getMin(A, B));
  }
}
