// Product of Array Except Self
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        result[0] = 1;
        // int leftProduct = 1;
        for(int i=1;i<length;i++){
        	result[i] = result[i-1] * nums[i-1];
        }
        int rightProduct = nums[length-1];
        for(int i=length-2;i>=0;i--){
        	result[i] *= rightProduct;
        	rightProduct *= nums[i];
        }
        for(int i=0;i<length;i++){
        	System.out.print(result[i] + " ");
        }
        System.out.println();
        return result;
    }
}
class Practice212{
	public static void main(String[] args) {
		// int[] nums = {1, 2, 3, 4};
		int[] nums = {0};
		Solution solution = new Solution();
		solution.productExceptSelf(nums);
	}
}