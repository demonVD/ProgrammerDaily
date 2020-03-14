// Rotate an array
class Solution{
  int[] rotate(int[] arr, int n, int k){
    int[] temp = new int[k];
    int i = 0;
    for(;i<k;i++){
      temp[i] = arr[i];
    }
    for(;i<n;i++){
      arr[i-k] = arr[i];
    }
    int j = 0;
    for(i = n-k;i<n;i++){
      arr[i] = temp[j++];
    }
    return arr;
  }
  void display(int[] arr){
    for(int i=0;i<arr.length;i++){
      System.out.println(arr[i]+" ");
    }
  }
}
class Practice139{
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6};
    int k = 1;
    Solution solution = new Solution();
    solution.display(solution.rotate(arr, arr.length, k));
  }
}
