// Leetcode Problem 16  3SumClosest
import java.util.Arrays;
import java.lang.Math;
class Solution{
  public int threeSumClosest(int[] nums, int target){
    if(nums.length <3) return 0;
    int diff = Integer.MAX_VALUE;
    int sum = Integer.MAX_VALUE;
    Arrays.sort(nums);
    // -4, -1, 1, 2
    for(int i=0;i<nums.length-2;i++){
      int l = i+1;
      int r = nums.length-1;
      while(l<r){
        int tempSum = nums[i] + nums[l] + nums[r];
        int tempDiff = (target > 0) ? Math.abs(target - tempSum) : Math.abs((-1*target) + tempSum);
        // System.out.println(nums[i]+" "+nums[l]+" "+nums[r]+" "+tempSum+" "+tempDiff);
        if(diff > tempDiff){
        // if(sum > tempSum){
          diff = tempDiff;
          sum = tempSum;
        }
        if(tempSum > target) r--;
        else l++;
      }
    }
    return sum;
  }
}
class Practice7{
  public static void main(String[] args){
    int[] nums = {-1, 2, 1, -4};
    // {1, 1, 1, 0};
    // {0, 2, 1, -3};
    // {-1, 2, 1, -4};
    int target = 1;
    System.out.println(new Solution().threeSumClosest(nums, target));
  }
}
