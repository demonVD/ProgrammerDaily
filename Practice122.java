// KlargestElement in decreasing Order
class Solution{
	int[] arr;
	int current;
	int size;
	Solution(int size){
		arr = new int[size];
		this.current = -1;
		this.size = size;
	}
	private void insert(int element){
		current++;
		arr[current] = element;
		int i = current;
		while(i > 0 && arr[i] > arr[parent(i)]){
			swap(arr, i, parent(i));
			i = parent(i);
		}
	}
	private int extractMax(){
		int element = arr[0];
		arr[0] = arr[current];
		current--;
		maxHeapify(0);
		return element;
	}
	private void maxHeapify(int index){
		int largest = index;
		int left = leftChild(index);
		int right = rightChild(index);
		if(right < size && arr[right] > arr[index]){
			largest = right;
		}
		if(left < size && arr[left] > arr[largest]){
			largest = left;
		}
		if(largest != index){
			swap(arr, index, largest);
			maxHeapify(largest);
		}
	}
	private int leftChild(int index){
		return (index*2 + 1);
	}
	private int rightChild(int index){
		return (index*2 + 2);
	}
	private int parent(int index){
		return (index-1)/2;
	}
	public void KlargestElement(int[] arr, int k){
		for(int i=0;i<arr.length;i++){
			insert(arr[i]);
		}
		StringBuilder str = new StringBuilder();
		for(int i=0;i<k;i++){
			str.append(extractMax()+" ");
		}
		str.deleteCharAt(str.length()-1);
		System.out.println(str.toString());
	}
	private void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
class Practice122{
	public static void main(String[] args) {
		String[] str = args[0].trim().split(" ");
		int[] arr = new int[str.length];
		for(int i=0;i<str.length;i++){
			arr[i] = Integer.parseInt(str[i]);
		}
		int k = Integer.parseInt(args[1]);
		Solution solution = new Solution(arr.length);
		solution.KlargestElement(arr, k);
	}
}