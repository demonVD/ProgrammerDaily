// Daily Coding Problem: Problem #273
class Solution{
  public int getFixedPoint(int[] arr){
    return getFixedPointHelper(arr, 0, arr.length - 1);
  }
  private int getFixedPointHelper(int[] arr, int low, int high)
  {
    if(low <= high){
      int mid = low + (high - low)/2;
      if(mid == arr[mid]){
        return mid;
      }
      else if(mid > arr[mid]){
        return getFixedPointHelper(arr, mid + 1, high);
      }
      else{
        return getFixedPointHelper(arr, low, mid - 1);
      }
    }
    return -1;
  }
}
class Practice171{
  public static void main(String[] args) {
    int[] arr = {-6, 0, 1, 40};
    Solution solution = new Solution();
    System.out.println(solution.getFixedPoint(arr));
  }
}
