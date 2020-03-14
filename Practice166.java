// Wave Array
// https://www.interviewbit.com/problems/wave-array/
import java.util.Arrays;
class Solution{
  public int[] waveArray(int[] arr){
    Arrays.sort(arr);
    for(int i = 0; i < arr.length; i = i + 2){
      if((i + 1) < arr.length) swap(arr, i, i + 1);
    }
    return arr;
  }
  private void swap(int[] arr, int i,  int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
  public void display(int[] arr){
    System.out.println(Arrays.toString(arr));
  }
}
class Practice166{
  public static void main(String[] args) {
    int[] arr = {10, 5, 20, 6, 80, 3, 100, 2};
    Solution solution = new Solution();
    solution.display(solution.waveArray(arr));
  }
}
