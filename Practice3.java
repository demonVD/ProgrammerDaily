public class Practice3{
  public static void main(String[] args){
    int[] arr = {1, 1, 1,1, 1}; 
    // {1,8, 6, 2, 5, 4, 8, 3, 7};
    int left = 0;
    int right = arr.length-1;
    int area = Integer.MIN_VALUE;
    // int count =
    while(left < right){
      int tempArea = Math.min(arr[left], arr[right]) * (right - left);
      if(tempArea > area) area = tempArea;
      if(arr[left] < arr[right]) left++;
      else right--;
    }
    System.out.println(area);
  }
}
