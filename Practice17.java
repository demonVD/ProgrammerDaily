// Missing number in array
class Solution{
  public int missingNumber(int[] arr, int n){
    int expectedXor = 0;
    for(int i=1;i<=n;i++) expectedXor ^= i;
    int originalXor = 0;
    for(int i =0;i<n-1;i++) originalXor ^= arr[i];
    return expectedXor ^ originalXor;
  }
}

class Practice17{
  public static void main(String[] args){
    System.out.println(new Solution().missingNumber(new int[]{1, 2, 3, 5, 6, 7, 8, 9, 10}, 10));
  }
}
