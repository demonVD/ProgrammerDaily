class Solution{
  public int getNumber(int[] arr){
    int number = 0;
    for(int i=0;i<arr.length;i++){
      number ^= arr[i];
    }
    return number;
  }
}
class Practice167{
  public static void main(String[] args) {
    int[] arr = {1, 1, 3, 3, 3};
    Solution solution = new Solution();
    System.out.println(solution.getNumber(arr));
  }
}
