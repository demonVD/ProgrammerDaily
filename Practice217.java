// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3304/
//   Search in Rotated Sorted Array
class Solution {
    public int search(int[] nums, int target) {
    	int length = nums.length;
 		int pivot = findPivot(nums, 0, length-1);
 		System.out.println("Pivot :: " + pivot);
 		if(nums[length-1] < target){
 			return searchHelper(nums, target, 0, pivot-1);
 		}
 		else{
 			return searchHelper(nums, target, pivot, length-1);
 		}
    }
    private int searchHelper(int[] nums, int target, int low, int high){
    	if(low <= high){
    		int mid = low + (high - low)/2;
    		if(nums[mid] == target) return mid;
    		else if(nums[mid] < target){
    			return searchHelper(nums, target, mid+1, high);
    		}
    		else{
    			return searchHelper(nums, target, low, mid-1);
    		}
    	}
    	return -1;
    }
    private int findPivot(int[] nums, int low, int high){
    	// System.out.println("CAlled ");
    	if(low <= high){
    		int mid = low + (high - low)/2;
    		if((mid == 0 || (nums[mid-1] > nums[mid]) )
    			&&
    			(mid == high || (nums[mid+1] > nums[mid]))){
    			return mid;
    		}
    		else if(nums[high] < nums[mid]){
    			return findPivot(nums, mid+1, high);
    		}
    		else{
    			return findPivot(nums, low, mid-1);
    		}
    	}
    	return -1;
    }
}

class Practice217{
	public static void main(String[] args) {
		// int[] nums = {4, 5, 6, 7, 0, 1, 2, 3};
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 0};
		Solution solution = new Solution();
		System.out.println(solution.search(nums, 0));
	}
}