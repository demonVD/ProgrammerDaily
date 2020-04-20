// https://leetcode.com/problems/remove-element/
class Solution {
    public int removeElement(int[] nums, int val) {
        int firstValIndexFromStart = findFirstValIndexFromStart(nums, 0, val);
        int firstNonValIndexFromLast = findFirstNonValIndexFromLast(nums, nums.length-1, val);
        System.out.println("val index :: " + firstValIndexFromStart + " swap index ::" + firstNonValIndexFromLast);
        while(firstValIndexFromStart < firstNonValIndexFromLast){
        	swap(nums, firstValIndexFromStart, firstNonValIndexFromLast);
        	firstValIndexFromStart = findFirstValIndexFromStart(nums, firstValIndexFromStart + 1, val);
        	firstNonValIndexFromLast = findFirstNonValIndexFromLast(nums, firstNonValIndexFromLast - 1, val);
        }
        display(nums);
        System.out.println("Returned value :: " + firstValIndexFromStart);
        return firstValIndexFromStart;
    }
    private void display(int[] nums){
    	for(int i = 0; i < nums.length; i++){
    		System.out.print(nums[i] + " ");
    	}
    	System.out.println();
    }
    private int findFirstValIndexFromStart(int[] nums, int start, int val){
    	for(int i = start; i < nums.length; i++){
    		if(nums[i] == val) return i;
    	}
    	return nums.length;
    }
    private int findFirstNonValIndexFromLast(int[] nums, int end, int val){
    	for(int i = end; i >= 0; i--){
    		if(nums[i] != val) return i;
    	}
    	return -1;
    } 
    private void swap(int[] nums, int start, int end){
    	int temp = nums[start];
    	nums[start] = nums[end];
    	nums[end] = temp;
    }   
}
class Practice209{
	public static void main(String[] args) {
		// int[] nums = {3, 2, 2, 3};
		int[] nums = {0,1,2,2,3,0,4,2};
		Solution solution = new Solution();
		solution.removeElement(nums, 2);
		// solution.display()
	}
}