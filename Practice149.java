// https://www.interviewbit.com/problems/flip/
import java.util.ArrayList;
class Pair{
  int x, y;
  Pair(int x, int y){
    this.x = x;
    this.y = y;
  }
}
class Solution{
  public ArrayList<Integer> flip(String A) {
    char[] chrs = A.toCharArray();
    int length = chrs.length;
    int[][] dp = new int[length][length];
    int countOne = count(chrs, length);
    System.out.println("count : " + countOne);
    init(dp, chrs, length, countOne);
    for(int i = 0;i < length; i++){
      for(int j = i+1; j < length; j++){
        if(chrs[j] == '1'){
          dp[i][j] = dp[i][j-1] - 1;
        }
        else{
          dp[i][j] = dp[i][j-1] + 1;
        }
      }
    }
    displaymatrix(dp, length);
    Pair pair = findMax(dp, length);
    ArrayList<Integer> R = new ArrayList<>();
    R.add(pair.x);
    R.add(pair.y);
    return R;
  }
  private int count(char[] chrs, int length){
    int count = 0;
    for(int i = 0; i < length; i++){
      if(chrs[i] == '1'){
        ++count;
      }
    }
    return count;
  }
  private void init(int[][] dp, char[] chrs, int length, int countOne){
    for(int i = 0;i < length; i++){
      for(int j = 0; j < length; j++){
        if(i == j){
          if(chrs[i] == '1') dp[i][j] = countOne - 1;
          else dp[i][j] = countOne + 1;
        }else{
          dp[i][j] = 0;
        }

      }
    }
  }
  private Pair findMax(int[][] dp, int length){
    Pair pair = new Pair(1, 1);
    for(int i = 0; i < length; i++){
      for(int j = i; j < length; j++){
        if(dp[i][j] > dp[pair.x-1][pair.y-1]){
          pair.x = i + 1;
          pair.y = j + 1;
        }
      }
    }
    return pair;
  }
  private void displaymatrix(int[][] dp, int length){
    for(int i=0;i<length;i++){
      for(int j=0;j<length;j++){
        System.out.print(dp[i][j] + " ");
      }
      System.out.println();
    }
  }
  public void display(ArrayList<Integer> R){
    for(int i : R){
      System.out.print(i + " ");
    }
    System.out.println();
  }
}
class Practice149{
  public static void main(String[] args) {
    String str = "1101010001";
    Solution solution = new Solution();
    Solution2 solution2 = new Solution2();
    solution.display(solution2.flip(str));
    // solution.display(solution.flip(str));

  }
}
class Solution2{
  public ArrayList<Integer> flip(String A) {
    char[] chrs = A.toCharArray();
    int length = chrs.length;
    int[] arr = new int[length];
    int countOne = 0;
    for(int i=0;i<length;i++){
      arr[i] = Character.getNumericValue(chrs[i]);
      if(arr[i] == 1) countOne++;
    }
    if(countOne == length) return new ArrayList<>();
    for(int i=0;i<length;i++){
      if(arr[i] == 1){
        arr[i] = -1;
      }
      else if(arr[i] == 0){
        arr[i] = 1;
      }
    }
    // for(int i=0;i<length;i++){
    //   System.out.print(arr[i] + " ");
    // }
    int maxSum = Integer.MIN_VALUE;
    int sum = 0;
    int sp = 0, ep = 0, tempSP = 0, tempEP = 0;
    // Pair pair = new Pair(1, 1);
    for(int i=0;i<length;i++){
      sum += arr[i];
      if(maxSum < sum){
        // Pair.y = i;
        tempEP = i;
        sp = tempSP;
        ep = tempEP;
        maxSum = sum;
      }
      if(sum < 0){
        sum = 0;
        tempSP = i + 1;
        tempEP = i + 1;
        // Pair.x = i+1;
      }
    }
    ArrayList<Integer> R = new ArrayList<Integer>();
    R.add(sp + 1);
    R.add(ep + 1);
    return R;
  }
}
