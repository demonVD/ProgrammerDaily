// QuickSort
class Solution{
	public int[] quickSort(int[] arr){
		quickSortHelper(arr, 0, arr.length-1);
		return arr;
	}
	private void quickSortHelper(int[] arr, int low, int high){
		if(low < high){
			int pi = partition(arr, low, high);
			display(arr);
			quickSortHelper(arr, low, pi-1);
			quickSortHelper(arr, pi+1, high);
		}
	}
	private int partition(int[] arr, int low, int high){
		int pivot = arr[high];
		int i = low-1;
		for(int j=low;j<high;j++){
			if(arr[j] < pivot){
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i+1, high);
		return i+1;
	}
	private void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public void display(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

}
class Practice120{
	public static void main(String[] args) {
		String[] str = args[0].trim().split(" ");
		int[] arr = new int[str.length];
		for(int i=0;i<str.length;i++){
			arr[i] = Integer.parseInt(str[i]); 
		}
		Solution solution = new Solution();
		solution.display(solution.quickSort(arr));
	}
}