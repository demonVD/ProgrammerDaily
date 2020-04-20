// Given an array nums, 
// write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
class Solution {
    public int[] moveZeroes(int[] nums) {
        int firstZero = findFirstZero(nums, 0);
        int firstNonZeroAfterFisrtZero = findNonZero(nums, firstZero+1);
        while(firstZero < nums.length && firstNonZeroAfterFisrtZero < nums.length){
        	swap(nums, firstZero, firstNonZeroAfterFisrtZero);
        	firstZero = findFirstZero(nums, firstZero+1);
        	firstNonZeroAfterFisrtZero = findNonZero(nums, firstZero+1);
        }
        return nums;
    }
    private int findFirstZero(int[] nums, int index){
    	for(int i=index;i<nums.length;i++){
    		if(nums[i] == 0) return i;
    	}
    	return nums.length;
    }
    private int findNonZero(int[] nums, int index){
    	for(int i=index;i<nums.length;i++){
    		if(nums[i] != 0) return i;
    	}
    	return nums.length;
    }
    private void swap(int[] nums, int i, int j){
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    }
    public void display(int[] nums){
    	for(int i=0;i<nums.length;i++){
    		System.out.print(nums[i] + " ");
    	}
    	System.out.println();
    }
}
class Practice198{
	public static void main(String[] args) {
		int[] nums = {0, 0, 1, 1, 1, 4};
		//{1, 2, 3, 0, 0, 1};
		Solution solution = new Solution();
		solution.display(solution.moveZeroes(nums));
	}
}