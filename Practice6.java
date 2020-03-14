// LeetCode Problem15. 3sum
// -1, 0, 1, 2, -1, -4
// -4, -1, -1, 0, 1, 2
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
class Solution{
  public List<List<Integer>> threeSum(int[] nums){
    if(nums.length < 3) return null;
    Arrays.sort(nums);
    // -4, -1, -1, 0, 1, 2
    // -2, 0, 0, 2, 2
    List<List<Integer>> list1 = new ArrayList<>();
    for(int i=0;i<nums.length-2;i++){
      // int sum = 0 - (nums[i]);
      int left = i + 1;
      int right = nums.length-1;
      if( i==0 || (i>0 && nums[i] != nums[i-1])){
        while(left < right){
          // System.out.println(nums[i] + " " + nums[left] + " " + nums[right]);
          // if((nums[left] != nums[i]) && (nums[right] != nums[i]) && (sum == (nums[left] + nums[right]))) {
          if(nums[i] + nums[left] + nums[right] == 0){
            // List<Integer> list = new ArrayList<>();
            // list.add(nums[i]);
            // list.add(nums[left]);
            // list.add(nums[right]);
            list1.add(Arrays.asList(nums[i], nums[left], nums[right]));
            // left++;
            // right--;
            // break;
            while(left<right && nums[left] == nums[left+1]) left++;
            while(left<right && nums[right] == nums[right-1]) right--;
            left++;
            right--;
          }
          else if(nums[i]+ nums[left] + nums[right] > 0) right--;
          else left++;
        }
      }
    }
    return list1;
  }
    // return list1;
}
class Practice6{
  public static void main(String[] args){
    int[] nums = {-2, 0, 0, 2, 2};
    // {-2, 0, 0, 2, 2};
    // {0, 0, 0};
    // {-1, 0, 1, 2, -1, -4};
    List<List<Integer>> list = new Solution().threeSum(nums);
    for(List<Integer> temp : list){
      for(int i : temp) System.out.print(i + " ");
      System.out.println();
    }
  }
}
