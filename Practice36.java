// Smallest subarray with sum greater than a given value
class Solution{
  public int smallestLength(int[] arr, int val){
    int i =0;
    int startIndex = 0, endIndex = 0;
    int minLength = Integer.MAX_VALUE;
    int sum = 0;
      // {1, 4, 45, 6, 0, 19} val = 51
      while(endIndex < arr.length && startIndex <= endIndex){
        while(sum <= val && end < n){
          sum += arr[endIndex];
          endIndex++;
        }
        while(sum > val && start < n){
          if(minLength > (endIndex - startIndex)) minLength = endIndex - startIndex;
          sum -= arr[startIndex];
          startIndex++;
        }
      }
      return minLength;
    }
  }
class Practice36{
  public static void main(String[] args) {
    int[] arr = {1, 4, 45, 6, 0, 19};
    System.out.println(new Solution().smallestLength(arr, 4));;
  }
}
