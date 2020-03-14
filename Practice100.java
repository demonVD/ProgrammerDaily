// Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
import java.util.HashSet;
class Practice100{
	public static void main(String[] args){
		String[] str = args[0].split(" ");
		int[] arr = new int[str.length];
		for(int i=0;i<arr.length;i++) arr[i] = Integer.parseInt(str[i]);
		System.out.println(new Solution().getMaxLength(arr)); 
	}

}
class Solution{
	public int getMaxLength(int[] arr){
		HashSet<Integer> set = new HashSet<>();
		for(int i=0;i<arr.length;i++) set.add(arr[i]);
		int maxLength = 0;
		for(int i=0;i<arr.length;i++){
			int j = arr[i]+1;
			int length = 1;
			while(set.contains(j)){
				length++;
				maxLength = Math.max(maxLength, length);
				j = j+1;
			}
		}
		return maxLength;
	}
}