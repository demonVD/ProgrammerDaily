// segregate 0's, 1's, and 2's
class Solution{
	public void segregate(int[] arr){
		int index0 = 0, index1 = 0, index2 = arr.length-1;
		while(index1 <= index2){
			switch(arr[index1]){
				case 0:
					swap(arr,index0, index1);
					index0++;
					index1++;
					break;
				case 1:
					index1++;
					break;
				case 2:
					swap(arr, index1, index2);
					index2--;
					break;
			}
		}
		for(int i=0;i<arr.length;i++) System.out.print(arr[i] + " ");
		System.out.println();
	}
	private void swap(int[] arr, int index1, int index2){
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
}
class Practice94{
	public static void main(String[] args) {
		String[] str = args[0].split(" ");
		int[] arr = new int[str.length];
		for(int i=0;i<arr.length;i++) arr[i] = Integer.parseInt(str[i]);
		new Solution().segregate(arr);
	}
}