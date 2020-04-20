// https://leetcode.com/problems/find-the-duplicate-number/

// fails for {2, 2, 2, 2 ,2}
class Solution {
    public int findDuplicate(int[] nums) {
        int xorOriginalElements = 0;
        int xorOnetoN = 0;
        for(int i = 1; i <= nums.length; i++){
        	xorOnetoN ^= i;
        	xorOriginalElements ^= nums[i-1];
        }
        System.out.println(xorOnetoN + " " + xorOriginalElements);
        int xorMissingAndDuplicate = xorOriginalElements ^ xorOnetoN;
        System.out.println(xorMissingAndDuplicate);
        int rmsbMask = (((~xorMissingAndDuplicate) + 1) & xorMissingAndDuplicate);
        System.out.println(rmsbMask);
        int xorSetBit = 0;
        int xorUnsetBit = 0;
        for(int i = 1; i <= nums.length; i++){
        	if((i & rmsbMask) == rmsbMask){
        		System.out.println("set index :: " + i);
        		xorSetBit ^= i;
        	}
        	else{
        		System.out.println("unset index :: " + i);
        		xorUnsetBit ^= i;
        	}
        	if((nums[i-1] & rmsbMask) == rmsbMask){
        		System.out.println("set number :: " + nums[i-1]);
        		xorSetBit ^= nums[i-1];
        	}
        	else{
        		System.out.println("unset number :: " + nums[i-1]);
        		xorUnsetBit ^= nums[i-1];
        	}
        }
        System.out.println(xorSetBit + " " + xorUnsetBit);
        for(int i = 1; i <= nums.length; i++){
        	if(nums[i-1] == xorSetBit){
        		return xorSetBit;
        	}
        	if(nums[i-1] == xorUnsetBit){
        		return xorUnsetBit;
        	}
        }
        return -1;
    }
}
class Solution2{
	public int findDuplicate(int[] nums){
		int slow = nums[0];
		int fast = nums[nums[0]];
		while(slow != fast){
			slow = nums[slow];
			fast = nums[nums[fast]];
		}
		fast = 0;
		while(slow != fast){
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
	}
}
class Practice196{
	public static void main(String[] args) {
		int[] nums = {2, 2, 2};
		// {1, 3, 4, 2, 2};
		// {2, 2, 2};
		// {3, 1, 3, 4, 2};
		// {1, 3, 4, 2, 2};
		Solution solution = new Solution();
		System.out.println(solution.findDuplicate(nums));
		Solution2 solution2 = new Solution2();
		System.out.println(solution2.findDuplicate(nums));

	}
}