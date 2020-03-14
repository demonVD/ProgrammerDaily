// Finds Subsets in an array that add upto a given sum
class Solution{
	public int numberOfSubset(int sum, int[] arr, int current){
		if(sum == 0) return 1;
		else if(sum < 0) return 0;
		else if(current >= arr.length) return 0;
		int total = numberOfSubset(sum, arr, current+1) + numberOfSubset(sum-arr[current], arr, current+1);
		return total;
	}
}
class Practice38{
	public static void main(String[] args) {
		System.out.println(new Solution().numberOfSubset(16, new int[]{2, 4, 6, 10}, 0));
	}
}