// Build a MAX HEAP
class Solution{
	int[] arr;
	final int size = 10;
	int lastIndex;
	public Solution(){
		arr[] = new int[size];
		for(int i = 0; i < size; i++){
			arr[i] = -1;
		}
		lastIndex = -1;
	}
	public int[] buildMaxHeap(int[] arr){
		int lastNonLeafNode = parent(arr.length - 1);
		for(int i = lastNonLeafNode; i >= 0; i--){
			heapify(arr, i);
		}
		return arr;
	}
	private void heapify(int[] arr, int i){
		int largest = i;
		int left = left(i);
		int right = right(i);
		if(left < arr.length && arr[largest] < arr[left]){
			largest = left;
		}
		if(right < arr.length && arr[largest] < arr[right]){
			largest = right;
		}
		if(i != largest){
			swap(arr, i, largest);
			heapify(arr, largest);
		}
	}
	public void insert(int element){
		arr[++lastIndex] = element;
		int lastNonLeafNode = parent(lastIndex);
		for(int i = lastNonLeafNode; i >= 0; i--){
			heapify(arr, i);
		}
	}
	public int extractMax(){
		int max = arr[0];
		arr[0] = arr[lastIndex];
		arr[lastIndex--] = -1;
		heapify(arr, 0);
		return max;
	}
	private void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	private int left(int i){
		return (2*i) + 1;
	}
	private int parent(int i){
		return (i-1)/2;
	}
	private int right(int i){
		return (2*i) + 2;
	}
	public void display(int[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
class Practice178{
	public static void main(String[] args){
		int[] arr = {4, 10, 3, 5, 1};
		Solution solution = new Solution();
		solution.display(solution.buildMaxHeap(arr));
	}
}