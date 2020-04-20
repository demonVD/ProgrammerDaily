// https://leetcode.com/problems/search-insert-position/
class Solution {
    public int searchInsert(int[] nums, int target) {
    	// if(num)
        return searchInsertHelper(nums, target, 0, nums.length-1);
    }
    private int searchInsertHelper(int[] nums, int target, int low, int high){
    	while(low <= high){
    		int mid = low + (high - low)/2;
    		if(nums[mid] == target){
    			return mid;
    		}
    		else if(nums[mid] < target){
    			return searchInsertHelper(nums, target, mid+1, high);
    		}
    		else{
    			return searchInsertHelper(nums, target, low, mid-1);
    		}
    	}
    	return low;
    }
}
class Practice213{
	public static void main(String[] args) {
		int[] nums = {1, 3, 5, 6};
		Solution solution = new Solution();
		System.out.println(solution.searchInsert(nums, 10));
	}
}