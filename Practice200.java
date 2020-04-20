// Remove Duplicates from Sorted Array
class Solution{
	public int removeDuplicates(int[] nums){
		int count = 0;
		for(int i=0;i<nums.length;i++){
			int lastIndex = lastIndex(nums, nums[i], i, nums.length-1);
			// System.out.println(lastIndex);
			count++;
			i = lastIndex;
		}
		return count;
	}
	private int lastIndex(int[] nums, int n, int low, int high){
		if(low <= high){
			int mid = low + (high - low)/2;
			if(nums[mid] == n && ((mid == nums.length-1) || (nums[mid+1] != nums[mid]))){
				return mid;
			}
			else if(nums[mid] > n){
				return lastIndex(nums, n, low, mid-1);
			}
			else{
				return lastIndex(nums, n, mid+1, high);
			}	
		}
		else{
			return -1;
		}
	}
}
class Solution2{
	public int removeDuplicates(int[] nums){
		for(int i=0;i<nums.length;i++){
			System.out.print(nums[i] + ",");
		}
		System.out.println();
		int uniqueElements = 0;
		int swapIndex = 0;
		for(int i=0;i<nums.length;i++){
			int lastIndex = lastIndex(nums, nums[i], i, nums.length-1);
			System.out.println("Last Index :: " + lastIndex);
			uniqueElements++;
			/*if(lastIndex > i && lastIndex < nums.length-1){
				nums[swapIndex + 1] = nums[lastIndex + 1];
				swapIndex++;
			}*/
			if(swapIndex < nums.length-1){
				nums[swapIndex++] = nums[lastIndex];
			}
			i = lastIndex;
		}
		for(int i=0; i<nums.length; i++){
            System.out.print(nums[i] + ", ");
        }
        System.out.println("Unique Elements : " + uniqueElements);
		return uniqueElements;
	}
	private int lastIndex(int[] nums, int n, int low, int high){
		if(low <= high){
			int mid = low + (high - low)/2;
			if(nums[mid] == n && ((mid == nums.length-1) || (nums[mid+1] != nums[mid]))){
				return mid;
			}
			else if(nums[mid] > n){
				return lastIndex(nums, n, low, mid-1);
			}
			else{
				return lastIndex(nums, n, mid+1, high);
			}	
		}
		else{
			return -1;
		}
	}
}
class Practice200{
	public static void main(String[] args) {
		int[] nums = {1, 1, 2, 3};
		// int[] nums = {0,0,1,1,1,2,2,3,3,4};
		// int[] nums = {1, 2, 3, 4, 4, 4};
		// int[] nums = {1, 1};
		// [1,1,2, 3, 4 , 1, 2]
		// Solution solution = new Solution();
		Solution2 solution = new Solution2();
		System.out.println(solution.removeDuplicates(nums));
	}
}