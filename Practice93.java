// Sort an array of 0's and 1's
class Solution{
	public void segregateZeroAndOne(int[] arr){
		int index0 = 0;
		int index1 = arr.length-1;
		while(index0<index1){
			if(arr[index0] == 0) index0++;
			else if(arr[index1] == 1) index1--;
			else{
				int temp = arr[index0];
				arr[index0] = arr[index1];
				arr[index1] = temp;
			}
		}
		for(int i=0;i<arr.length;i++) System.out.print(arr[i] + " ");
	}
}
class Practice93{
	public static void main(String[] args) {
		String[] str = args[0].split(" ");
		int[] arr = new int[str.length];
		for(int i=0;i<arr.length;i++) arr[i] = Integer.parseInt(str[i]);
		new Solution().segregateZeroAndOne(arr); 
	}
}