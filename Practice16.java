// kadane's Algo
// Longest Sum Contiguous Array
class Solution{
  public int getLargestSumContiguousSubarray(int[] arr){
      int maxSumSoFar = Integer.MIN_VALUE;
      int maxEndingHere = 0;
      for(int i = 0;i<arr.length;i++){
        maxEndingHere = Math.max(maxEndingHere + arr[i], arr[i]);
        maxSumSoFar = Math.max(maxSumSoFar, maxEndingHere);
      }
      return maxSumSoFar;
  }
}
class Practice16{
  public static void main(String[] args){
    // int[] arr = {-1, -2, -3, -4};
    // {1, 2, 3, -2, 5};
    System.out.println(new Solution().getLargestSumContiguousSubarray(new int[]{-1, -2, -3, -4}));
  }
}
