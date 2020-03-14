// https://www.interviewbit.com/problems/max-non-negative-subarray/
import java.util.ArrayList;
class Solution{
  public ArrayList<Integer> maxset(ArrayList<Integer> A){
    int length = A.size();
    long sum = 0;
    int lengthSubArray = Integer.MIN_VALUE;
    long maxSum = Integer.MIN_VALUE;
    int sp = -1, ep = -1;
    int tsp = 0, tep = 0;
    for(int i = 0; i < length; i++){
      System.out.println(A.get(i));
      if(A.get(i) < 0){
        System.out.println("less than zero");
        sum = 0;
        tsp = i + 1;
        tep = i + 1;
      }
      else{
        sum += A.get(i);
        System.out.println("Sum : " + sum);
        if(maxSum < sum ){
          maxSum = sum;
          // System.out.println("Max Sum : " + maxSum);
          tep = i;
          sp = tsp;
          ep = tep;
        }
        else if(maxSum == sum && lengthSubArray < (tep - tsp)){
            lengthSubArray = tep - tsp;
            tep = i;
            sp = tsp;
            ep = tep;
        }
      }
    }
    System.out.println(sp + " " + ep);
    ArrayList<Integer> R = new ArrayList<>();
    if(sp == -1 || ep == -1) return R;
    R = addToList(A, sp, ep);
    return R;
  }

  private ArrayList<Integer> addToList(ArrayList<Integer> A, int sp, int ep){
    ArrayList<Integer> R = new ArrayList<>();
    for(int i = sp; i <= ep; i++){
      R.add(A.get(i));
    }
    return R;
  }

  public void display(ArrayList<Integer> R){
    for(int i : R){
      System.out.print(i + " ");
    }
    System.out.println();
  }
}
class Practice150{
  public static void main(String[] args) {
    // [1, 2, 5, -7, 2, 3]
    ArrayList<Integer> A = new ArrayList<>();
    // A.add(1);    A.add(2);    A.add(5);    A.add(-7);    A.add(2);    A.add(3);
    // A.add(10);    A.add(-1);    A.add(2);    A.add(-4);    A.add(100);
    // A.add(0);    A.add(0);    A.add(-1);    A.add(0);
    // A.add(1967513926); A.add(1540383426); A.add(-1303455736); A.add(-521595368);
    A.add(756898537); A.add(-1973594324); A.add(-2038664370); A.add(-184803526); A.add(1424268980);
    System.out.println(Integer.MAX_VALUE);
    Solution solution = new Solution();
    // System.out.println(solution.maxset(A));
    solution.display(solution.maxset(A));
  }
}
