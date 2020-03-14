// Max Contiguous SubArray Sum
class Solution{
	public int maxContiguousSubArraySum(int[] arr){
		int currSum = 0;
		int maxSum = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++){
			currSum = Math.max(arr[i], currSum + arr[i]);
			maxSum = Math.max(currSum, maxSum);
		}
		return maxSum;
	}
}
class Practice78{
	public static void main(String[] args) {
		// System.out.println(new Solution().maxContiguousSubArraySum(new int[]{34, -50,  42, 14, -5, 86}));
		System.out.println(new Solution().maxContiguousSubArraySum(new int[]{-5, -2}));
	}
}