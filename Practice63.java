import java.lang.Math;
class Solution{
	public int getMaxSumContiguousArray(int[] arr){
		int sum = 0;
		int maxSum = 0;
		for(int i=0;i<arr.length;i++){
			// sum += arr[i];
			sum = Math.max(sum + arr[i], arr[i]);
			maxSum = Math.max(maxSum, sum);
		}
		return maxSum;
	}
}
class Practice63{
	public static void main(String[] args) {
		// System.out.println(new Solution().getMaxSumContiguousArray(new int[]{1, 2, 3, -2, 5}));		
		System.out.println(new Solution().getMaxSumContiguousArray(new int[]{1, 2, -2, -2, -2, 4}));
	}
}