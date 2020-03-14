// Largest Sum Contiguous SubArray
class Solution{
  public int getMaxSum(int[] arr){
    int maxSum = Integer.MIN_VALUE;
    int sum = 0;
    for(int i = 0; i < arr.length; i++){
      sum += arr[i];
      if(maxSum < sum){
        maxSum = sum;
      }
      if(sum < 0){
        sum = 0;
      }
    }
    return maxSum;
  }
}
class Practice146{
  public static void main(String[] args) {
    int[] arr = {-9, -3, -2};
    // {-2, -3, 4, -1, -2, 1, 5, -3};
    Solution solution = new Solution();
    System.out.println(solution.getMaxSum(arr));
  }
}
