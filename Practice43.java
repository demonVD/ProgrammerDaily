// Insertion Sort
class Solution{
	public void insertionSort(int[] arr){
		for(int i=0;i<arr.length;i++){
			int temp = arr[i];
			int curr = i-1;
			while(curr >=0 && arr[curr] > temp){
				arr[curr + 1] = arr[curr];
				curr--;
			}
			arr[curr + 1] = temp;
			// display(arr);
		}
		display(arr);
	}
	private void display(int[] arr)
{		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
}
class Practice43{
	public static void main(String[] args) {
		int[] arr = {5, 4, 4, 2, 1};
		new Solution().insertionSort(arr);
		// for(int i=0;if<arr.length;i++) System.out.print(arr[i] + " ");
	}
}