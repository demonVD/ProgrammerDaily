import java.util.Arrays;
class Solution{
  public void chocolateDistribution(int[] arr, int m){
    if(m > arr.length) {
      System.out.println("-1");
      return;
    }
    Arrays.sort(arr);
    // int i 0;j
    int startIndex = 0, endIndex = 0;
    int minDiff = Integer.MAX_VALUE;
    for(int i = m-1;i<arr.length;i++){
      // System.out.println("end " + arr[i] + " start " + arr[i - (m-1)]);
      if( arr[i] - arr[i - (m-1)] < minDiff){
        startIndex = i - (m-1);
        endIndex = i;
        minDiff = arr[i] - arr[i - (m-1)];
      }
    }
    // for(int i=startIndex;i<=endIndex;i++) System.out.print(arr[i] + " ");
    System.out.println(minDiff);
  }
}
class Practice23{
  public static void main(String[] args){
    // new Solution().chocolateDistribution(new int[]{3, 4, 1, 9, 56, 7, 9, 12}, 5);
    // new Solution().chocolateDistribution(new int[]{12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50}, 7);
    new Solution().chocolateDistribution(new int[]{1}, 1);
  }
}
