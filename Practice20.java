// Sorted Rotated Array Element Search
class Solution{
  public int getElementIndex(int[] arr, int element){
    return getElementHelper(arr, 0, arr.length-1, element);
  }
  private int getElementHelper(int[] arr, int low, int high, int element){
    int mid = (low + high)/2;
    System.out.println("Mid : " + mid);
    int length = arr.length;
    if(low<=high){
      if(arr[mid] == element) return mid;
      else if(mid == low && arr[mid] > element) return getElementHelper(arr, mid+1, length-1, element);
      else if(mid == high && arr[mid] < element) return getElementHelper(arr, 0, mid-1, element);
      else if(arr[mid] > element && arr[mid+1]>arr[mid]) return getElementHelper(arr, low, mid-1, element);
      else if(arr[mid] > element && arr[mid+1]<arr[mid]) return getElementHelper(arr, mid+1, high, element);
      else if(arr[mid] < element && arr[mid+1]>arr[mid]) return getElementHelper(arr, mid+1, high, element);
      else if(arr[mid] < element && arr[mid+1]<arr[mid]) return getElementHelper(arr, low, mid-1, element);
    }
    return -1;
  }
}
class Practice20{
  public static void main(String[] args){
    System.out.println(new Solution().getElementIndex(new int[]{6, 8, 9, 1, 3, 4, 5}, 1));
    // System.out.println(new Solution().getElementIndex(new int[]{5, 6, 7, 8, 9, 10, 1, 2, 3}, 10));
  }
}
