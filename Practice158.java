// https://www.interviewbit.com/problems/noble-integer/
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
class Solution{
  public int solve(ArrayList<Integer> A) {
    Collections.sort(A);
    int length = A.size();
    int i = 0;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for(; i < length; i++){
      if(map.isEmpty() || !map.containsKey(A.get(i))){
        map.put(A.get(i), 1);
      }else{
        map.put(A.get(i), map.get(A.get(i)) + 1);
      }
    }
    int reduncedLength = A.size();
    i = 0;
    for( ; i < reduncedLength; i++){
      int count = map.get(A.get(i));
      i = i + count - 1;
      if((reduncedLength - i - 1) == A.get(i))
        return 1;
    }
    return -1;
  }
}
class Practice158{
  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>();
     // 1, 2, 7, 0, 9, 3, 6, 0, 6
    A.add(1); A.add(2); A.add(7); A.add(0); A.add(9); A.add(3); A.add(6); A.add(0); A.add(6);
    // A.add(1); A.add(3); A.add(4); A.add(3);
    Solution solution = new Solution();
    System.out.println(solution.solve(A));
  }
}
