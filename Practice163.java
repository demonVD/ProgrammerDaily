// FirstOccurence, Last Occurence and Count of an integer in an array
class Solution{
  public int firstOccurence(int[] arr, int element){
    return firstOccurenceHelper(arr, element, 0, arr.length - 1);
  }
  private int firstOccurenceHelper(int[] arr, int element, int low, int high){
    if(low > high) return -1;
    int mid = low + (high - low)/2;
    if(arr[mid] == element && (mid == 0 || arr[mid - 1] < element)){
      return mid;
    }
    else if(arr[mid] >= element){
      return firstOccurenceHelper(arr, element, low, mid - 1);
    }
    else{
      return firstOccurenceHelper(arr, element, mid + 1, high);
    }
  }
  public int lastOccurence(int[] arr, int element){
    return lastOccurenceHelper(arr, element, 0, arr.length - 1);
  }
  private int lastOccurenceHelper(int[] arr, int element, int low, int high){
    if(low > high) return -1;
    int mid = low + (high - low)/2;
    // System.out.println("Mid element: " + arr[mid]);
    if(arr[mid] == element && ((mid == high) || arr[mid + 1] > element)){
      return mid;
    }
    else if(arr[mid] <= element){
      return lastOccurenceHelper(arr, element, mid + 1, high);
    }
    else{
      return lastOccurenceHelper(arr, element, low, mid - 1);
    }
  }
  public int count(int[] arr, int element){
    int firstIndex = firstOccurence(arr, element);
    int lastIndex = lastOccurence(arr, element);
    // System.out.println("First Index : " + firstIndex);
    // System.out.println("Second Index : " + lastIndex);
    int count = (firstIndex == -1) ? 0 : lastIndex - firstIndex + 1;
    return count;
  }
}
class Practice163{
  public static void main(String[] args){
    int[] arr = {1, 2, 3, 4, 4, 4, 4, 67, 123, 125};
    Solution solution = new Solution();
    // System.out.println(solution.firstOccurence(arr, 5));
    // System.out.println(solution.lastOccurence(arr, 5));
    System.out.println(solution.count(arr, 5));
  }
}
