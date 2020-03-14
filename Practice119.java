// Bubble Sort
// Selection Sort
// Insertion Sort
class Solution{
	public void bubbleSort(int[] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length-i-1;j++){
				if(arr[j] > arr[j+1]){
					swap(arr, j, j+1);
				}
			}
		}
	}
	public void selectionSort(int[] arr){
		for(int i=0;i<arr.length;i++){
			int minIndex = i;
			for(int j=i;j<arr.length;j++){
				if(arr[j] < arr[minIndex]){
					minIndex = j;
				}
			}
			swap(arr, i, minIndex);
		}
	}
	public void insertionSort(int[] arr){
		for(int i=1;i<arr.length;i++){
			int j=i-1;
			int temp = arr[i];
			while( j >= 0 && arr[j] > temp ){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = temp;
		}
	}
	/*public void mergeSort(int[] arr){
		merge(arr, 0, arr.length-1);
	}*/
	private void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public  void display(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

}
class Practice119{
	public static void main(String[] args) {
		String[] str = args[0].split(" ");
		int[] arr = new int[str.length];
		for(int i=0;i<arr.length;i++){
			arr[i] = Integer.parseInt(str[i]);
		}
		Solution solution = new Solution();
		solution.bubbleSort(arr);
		solution.display(arr);
		solution.selectionSort(arr);
		solution.display(arr);
		solution.insertionSort(arr);
		solution.display(arr);
	}
}