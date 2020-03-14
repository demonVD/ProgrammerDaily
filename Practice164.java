// Maximum sum of lengths of non-overlapping subarrays with k as the max element.
// https://www.geeksforgeeks.org/maximum-sum-lengths-non-overlapping-subarrays-k-max-element/
class Solution{
  public int maxSumOfLengths(int[] arr, int element){
    int i = 0, length = 0, totalLength = 0;
    boolean found = false;
    while(i < arr.length){
      if(arr[i] > element){
        if(found){
          totalLength += length;
        }
        length = 0;
        found = false;
      }
      else{
        if(arr[i] == element){
          found = true;
        }
        length += 1;
      }
    ++i;
    }
    if(found){
      totalLength += length;
    }
    return totalLength;
  }
}
class Practice164{
  public static void main(String[] args){
    int[] arr = {4, 1, 5, 1, 1, 4};
    // {2, 1, 4, 9, 2, 3, 8, 3, 4};
    Solution solution = new Solution();
    System.out.println(solution.maxSumOfLengths(arr, 6));
  }

}
