// Given a non-empty array of integers, every element appears twice except for one. Find that single one.
class Solution{
	public int singleNumber(int[] nums){
		int singleNumber = 0;
		for(int i=0;i<nums.length;i++){
			singleNumber ^= nums[i];
		}
		return singleNumber;
	}
}
class Practice193{
	public static void main(String[] args){
		int[] nums = {-2, -2, 1};
		Solution solution = new Solution();
		System.out.println(solution.singleNumber(nums));
	}
}