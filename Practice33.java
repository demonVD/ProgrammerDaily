class Solution{
  public int intGetMinUnit(int[] arr, int k){
    int length = arr.length;
    int maxHurdle = Integer.MIN_VALUE;
    for(int i =0;i<arr.length;i++){
      if(maxHurdle < arr[i]) maxHurdle = arr[i];
    }
    // System.out.println(m);
    if((maxHurdle - k) < 0) return 0;
    else return maxHurdle - k;
  }
}
class Practice33{
  public static void main(String[] args) {
    System.out.println(new Solution().intGetMinUnit(new int[]{1, 6, 3, 5, 2}, 4));
  }
}
