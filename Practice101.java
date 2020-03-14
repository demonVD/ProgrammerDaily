import java.util.HashSet;
class Solution{
	public void printMissingNumbers(int[] arr, int n){
		HashSet<Integer> set = new HashSet<>();
		for(int i=0;i<arr.length;i++){
			if(set.isEmpty() || !set.contains(arr[i])){
				set.add(arr[i]);
			}
		}
		System.out.println(set.size());
		StringBuilder s = new StringBuilder();
		for(int i=1;i<=n;i++){
			// System.out.println(arr[i]);
			// System.out.println(set.contains(arr[i]));
			if(!set.contains(i)){
				// System.out.println(arr[i]+" ");
				s.append(i+" ");
			}
		}
		s. deleteCharAt(s.length()-1);
		System.out.println(s);
	}
}
class Practice101{
	public static void main(String[] args) {
		String[] str = args[0].split(" ");
		int[] arr = new int[Integer.parseInt(args[1])];
		for(int i=0;i<arr.length;i++){
			arr[i] = Integer.parseInt(str[i]);
		}
		new Solution().printMissingNumbers(arr, arr.length);	
	}
}