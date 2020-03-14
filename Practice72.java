// Given a binary array, find the maximum number of consecutive 1s in this array.
import java.lang.Math;
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max1s = Integer.MIN_VALUE;
        int noOf1s = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1) noOf1s += 1;
            else if(nums[i] == 0){            	
                noOf1s = 0;
            }
            max1s = Math.max(noOf1s, max1s);
        }

        max1s = (noOf1s == nums.length) ? noOf1s: max1s;
        return max1s;
    }
}
class Practice72{
	public static void main(String[] args) {
		System.out.println(new Solution().findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
	}
}