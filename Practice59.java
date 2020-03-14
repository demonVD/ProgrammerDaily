// Find the length of largest subarray with 0 sum
import java.util.HashMap;
class Solution{
	public int getLargestSubarrayWithSumZero(int[] arr){
		if(arr.length <= 0 ) return -1;
		HashMap<Integer, Integer> sumMap = new HashMap<>();
		int sum = 0;
		int maxLength = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++){
			sum += arr[i];
			if(arr[i] == 0 && maxLength == 0) maxLength = 1;
			if(sum == 0) maxLength = i+1;
			if(sumMap.containsKey(sum)){
				int temp = sumMap.get(sum);
				if(maxLength < (i - temp)){
					maxLength = i - temp;
				}
			}else{
				sumMap.put(sum, i);
			}
		}
		return maxLength;
	}
}
class Practice59{
	public static void main(String[] args){
		System.out.println(new Solution().getLargestSubarrayWithSumZero(new int[]{-2, 2}));
	}
}