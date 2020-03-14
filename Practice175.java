// next greater permutation with same digits
class Solution{
  public int[] nextGreaterPermutation(int[] arr){
    int i = arr.length -2;
    while(i >= 0 && arr[i] >= arr[i+1]){
      i--;
    }
    if(i < 0){
      reverse(arr, 0, arr.length-1);
      return arr;
    }
    System.out.println("Index : " + i);
    int index = i;
    int max = Integer.MAX_VALUE;
    int j = i;
    i++;
    for(; i < arr.length; i++){
      // if(arr[i] < arr[j] && arr[index] < arr[i]){
      if(arr[i] > arr[j] && arr[i] <= max){
        max = arr[i];
        index = i;
      }
    }
    swap(arr, j, index);
    reverse(arr, j+1, arr.length-1);
    return arr;
  }
  private void swap(int[] arr, int i, int j){
    int temp = arr[j];
    arr[j] = arr[i];
    arr[i] = temp;
  }
  private void reverse(int[] arr, int start, int end){
    while(start < end){
      swap(arr, start++, end--);
    }
  }
  public void display(int[] arr){
    for(int i = 0; i < arr.length; i++){
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
}
class Practice175{
  public static void main(String[] args) {
    int[] arr = {2, 3, 1, 3, 3};
    // {3, 2, 1};
    // {1, 2, 3};
    // {1, 2, 3, 6, 5, 4};
    Solution solution = new Solution();
    solution.display(solution.nextGreaterPermutation(arr));
  }
}
