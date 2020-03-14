// Majority Element ( element that appears more than N/2 times in the array.)
class Solution{
  public int getMajorityElement(int[] arr){
    int count = 1;
    int majorityElement = arr[0];
    for(int i=1;i<arr.length;i++){
      if(majorityElement != arr[i]){
        count--;
      }
      else{
        count++;
      }
      if(count == 0){
        majorityElement = arr[i];
        count++;
      }
    }
    if(isMajorityElement(majorityElement, arr)) return majorityElement;
    else return -1;
    // return majorityElement;
  }

  private boolean isMajorityElement(int majorityElement, int[] arr){
    int count = 0;
    for(int i=0;i<arr.length;i++){
      if(arr[i] == majorityElement) count++;
    }
    if(count > arr.length/2) return true;
    else return false;
  }
}
class Practice19{
  public static void main(String[] args){
    System.out.println(new Solution().getMajorityElement(new int[]{3, 1, 3, 3, 2}));
  }
}
