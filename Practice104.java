// Max Sum without Adjacents 
class Solution{
	public int maxSumWithNoAdjacent(int[] arr){
		int sumI = arr[0];
		int sumExcludingPrevious = 0;
		int sumE = 0;
		for(int i=1;i<arr.length;i++){
			// if(i==1){
			// 	// sumE = sumI;
			// 	sumI = Math.max(sumExcludingPrevious + arr[i], sumI);
			// 	// sumI = a[i];
			// }else{
			// 	// sumE = sumI;
			// 	sumI = Math.max(sumExcludingPrevious + arr[i], sumI);
			// }
			sumE = sumI;
			sumI = Math.max(sumExcludingPrevious + arr[i], sumE);
			sumExcludingPrevious = sumE;
		}
		return sumI;
	}
}
class Practice104{
	public static void main(String[] args) {
		String[] str = args[0].split(" ");
		int[] arr = new int[str.length];
		for(int i=0;i<arr.length;i++){
			arr[i] = Integer.parseInt(str[i]);
		}
		System.out.println(new Solution().maxSumWithNoAdjacent(arr));
	}
}