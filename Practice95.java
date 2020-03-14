// Maximum difference between two elements such that 
// larger element appears after the smaller number
class Solution{
	public int maxDiff(int[] arr){
		int max = 0;
		int maxDiff = Integer.MIN_VALUE;
		for(int i=arr.length-1;i>=0;i--){
			// if(arr[i] < 0) 
			int tempDiff = max - arr[i];
			if(tempDiff > maxDiff){
				maxDiff = tempDiff;
			}
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		return maxDiff;
	}
}
class Practice95{
	public static void main(String[] args) {
		String[] str = args[0].split(" ");
		int[] arr = new int[str.length];
		for(int i=0;i<arr.length;i++) arr[i] = Integer.parseInt(str[i]);
		System.out.println(new Solution().maxDiff(arr));
	}
}