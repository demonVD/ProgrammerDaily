// Given a binary array sorted in non-increasing order, count the number of 1's in it.
public class Practice2{
  public static void main(String[] args){
    int n = 7;
    int[] arr = {1, 1, 1, 0, 0, 0, 0};
    // {1, 1, 1, 1};
    // {0, 0, 0, 0};
    //
    // int startIndex = getStartIndex(arr, n);
    GFG obj = new GFG();
    System.out.println(obj.count(arr, 0, n-1));
  }
}
class GFG{
  public int count(int[] arr, int low, int high){
    if(arr[high] == 1) return (high +1);
    else if(arr[low] == 0) return 0;
    else{
      int endIndex = getEndIndex(arr, 0, high);
      int startIndex = getStartIndex(arr, 0, high);
      return endIndex - startIndex + 1;
    }
  }
  private int getEndIndex(int[] arr, int low, int high){
    int mid = (low + high)/2;
    if(low == high){
      if(arr[mid] == 1) return mid;
      else return -1;
    }
    else if(low < high){
      if(arr[mid] == 1 && arr[mid + 1] == 0) return mid;
      else if(arr[mid] == 1 && arr[mid + 1] == 1) return getEndIndex(arr, mid +1, high);
      else return getEndIndex(arr, low, mid -1);
    }
    else{
      return -1;
    }
  }
  private int getStartIndex(int[] arr, int low, int high){
    int mid = (low + high)/2;
    if(low == high) {
      if(arr[mid] == 1){
        return mid;
      }
      else return -1;
    }else if(low<high){
      if(arr[mid] == 1 && arr[mid - 1] == 0) return mid;
      else if(arr[mid] == 1 && arr[mid - 1] == 1) return getStartIndex(arr, low, mid-1);
      else return getStartIndex(arr, low, mid -1);
    }
    else return -1;
  }
}
