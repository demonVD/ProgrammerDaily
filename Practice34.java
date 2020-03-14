// https://www.hackerrank.com/challenges/stockmax/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign

class Solution{
  public int getMaxProfit(int[] arr){
    // Stack<Integer> s = new Stack<>();
    int maxElement = Integer.MIN_VALUE;
    int maxProfit = 0;
    for(int i =arr.length-1;i>=0;i--){
       if(arr[i] > maxElement) maxElement = arr[i];
       maxProfit += (maxElement - arr[i]);
    }
    return maxProfit;
  }
}
class Practice34{
  public static void main(String[] args) {
    int[] arr = {5, 4, 3, 4, 5};
    // s{1, 3, 1, 2};
    System.out.println(new Solution().getMaxProfit(arr));
  }
}
