// All subarray 
class Solution{
	public void getSubArray(int[] arr, int start, int end){
		if(end == arr.length) return;
		if(start > end){
			getSubArray(arr, 0, end + 1);
			return;
		}
		for(int i=start;i<=end;i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		getSubArray(arr, start+1, end);
	}

}
class Practice58{
	public static void main(String[] args){
		int[] arr = {1,2,3};
		// System.out.println(new Solution().getMaxSum(arr, size));
		new Solution().getSubArray(arr, 0, 0);
	}
}