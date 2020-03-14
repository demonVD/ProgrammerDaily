// Array Subset of another array 
import java.util.HashSet;
class Solution{
	public boolean isSubset(int[] arr1, int[] arr2){
		HashSet<Integer> set = new HashSet<>();
		for(int i=0;i<arr1.length;i++){
			set.add(arr1[i]);
		}
		for(int i=0;i<arr2.length;i++){
			if(!set.contains(arr2[i])){
				return false;
			}
		}
		return true;
	}
}
class Practice87{
	public static void main(String[] args) {
		String[] s1 = args[0].split(" ");
		int[] arr1 = new int[s1.length];
		for(int i=0;i<arr1.length;i++) arr1[i] = Integer.parseInt(s1[i]);

		String[] s2 = args[1].split(" ");
		int[] arr2 = new int[s2.length];
		for(int i=0;i<arr2.length;i++) arr2[i] = Integer.parseInt(s2[i]);

		System.out.println(new Solution().isSubset(arr1, arr2));
	}
}