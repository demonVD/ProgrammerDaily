// https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3298/
import java.util.HashMap;
class Solution {
    public int findMaxLength(int[] nums) {
    	int length = nums.length;
        for(int i = 0; i < length; i++){
        	nums[i] = (nums[i] == 0) ? -1 : 1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        // int[] sum = new int[length];
        int currSum = 0;
        int maxLength = Integer.MIN_VALUE;
        for(int i = 0; i < length; i++){
        	currSum += nums[i];
        	if(currSum == 0){
        		maxLength = i + 1;
        	}
        	else if(map.containsKey(currSum)){
        		if(maxLength < (i - map.get(currSum))){
					maxLength = i - map.get(currSum);
        		}
        	}
        	else{
        		map.put(currSum, i);
        	}
    	}
    	return maxLength;
    }
}
class Practice208{
	public static void main(String[] args) {
		// int[] nums = {0, 1, 0};
		// int[] nums = {0,0,0,0,0,0,0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0};
		int[] nums = {1, 0, 1, 1, 1, 0, 0};
		Solution solution = new Solution();
		System.out.println(solution.findMaxLength(nums));
	}
}