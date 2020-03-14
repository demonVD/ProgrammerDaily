// Subarray with given sum
class Solution{
  public void subArrayGivenSum(int[] arr, int sum){
  //   int tempSum = 0;
  //   // int i = 0;
  //   int startPoint = 0, endPoint = 0;;
  //   while(endPoint < arr.length && tempSum < sum){
  //     tempSum += arr[endPoint];
  //     endPoint++;
  //   }
  //   // System.out.println("Starting : " + startPoint + " endPoint : " + endPoint);
  //   while(startPoint < arr.length && tempSum > sum){
  //     tempSum -= arr[startPoint];
  //     startPoint++;
  //   }
  //   // System.out.println("Starting : " + startPoint + " endPoint : " + endPoint);
  //   if(startPoint > endPoint || endPoint > arr.length-1) System.out.println("-1");
  //   else System.out.println(startPoint+1 + " " + (endPoint+1));
  // }
  int tempSum = 0;
  int startIndex = 0;
  int endIndex = 0;
  while(endIndex < arr.length && startIndex < arr.length && tempSum != sum){
    // tempSum += arr[endIndex];
    // if(tempSum > sum)
    while(endIndex < arr.length && tempSum < sum){
      tempSum += arr[endIndex];
      endIndex++;
    }
    while(startIndex < arr.length && tempSum > sum){
      tempSum -= arr[startIndex];
      startIndex++;
    }
  }
  if(tempSum == sum && startIndex < endIndex) System.out.println("Starting : " + (startIndex+1) + " endPoint : " + endIndex);
  else System.out.println("-1");
  }
}
class Practice18{
  public static void main(String[] args){
    new Solution().subArrayGivenSum(new int[]{1, 2, 3, 7, 5}, 0);
  }
}
