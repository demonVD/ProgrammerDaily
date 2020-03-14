// candies Problem https://www.hackerrank.com/challenges/candies/problem
class Solution{
  public int getMinCandy(int[] arr){
    // for(int i =0;i<arr.length;i++) System.out.print(arr[i] + " ");
    // System.out.println();
    int[] candies = new int[arr.length];
    for(int i=0;i<candies.length;i++) candies[i] = 1;
    for(int i =1;i<arr.length;i++){
      if(arr[i] > arr[i-1]) candies[i] = candies[i-1]+1;
    }
    // for(int i =0;i<candies.length;i++) System.out.print(candies[i] + " ");
    // System.out.println();
    for(int i =arr.length-2;i>=0;i--){
      if(arr[i] > arr[i+1] && candies[i] <= candies[i+1]) candies[i] = candies[i+1]+1;
    }
    // for(int i =0;i<candies.length;i++) System.out.print(candies[i] + " ");
    // System.out.println();
    int sum =0;
    for(int i =0;i<candies.length;i++) sum += candies[i];
    return sum;
  }
}
class Practice21{
  public static void main(String[] args){
    int[] arr = {2, 3, 4, 4, 3, 2, 1};
    // {1, 2, 2, 2};
    // {2, 4, 2, 6, 1, 7, 8, 9, 2, 1};
    // {2, 4, 3, 5, 2, 6, 4, 5};

    System.out.println(new Solution().getMinCandy(arr));
  }
}
