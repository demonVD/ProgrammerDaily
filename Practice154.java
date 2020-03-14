// Proving Dua Wrong
class Solution{
  public int getMaxSum(int[] arr){
    int maxSum = 0;
    int sum = 0;
    for(int i=0;i<arr.length;i++){
      if(arr[i] >= 0){
        sum += arr[i];
      }
      else{
        if(sum > maxSum){
          maxSum  = sum;
          sum = 0;
        }
      }
    }
    if(sum > maxSum){
      maxSum = sum;
    }
    return maxSum;
  }
}
class Practice154{
  public static void main(String[] args) {
    int[] arr = {1, 2, 5, -4, 5};
    Solution solution = new Solution();
    System.out.println(solution.getMaxSum(arr));;
  }
}
