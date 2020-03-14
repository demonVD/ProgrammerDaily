// k largest element in an array
class BinaryHeap{
	int[] arr;
	int heapSize;
	int capacity;
	public BinaryHeap(int capacity){
		this.capacity = capacity;
		arr = new int[capacity];
		heapSize = 0;
	}

	public void display(){
		for(int i=0;i<heapSize;i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public int parent(int i){
		return (i-1)/2;
	} 

	public int leftChild(int i){
		return (2*i)+1;
	}

	public int rightChild(int i){
		return (2*i)+2;
	}

	public void insert(int key){
		if(heapSize == capacity){
			System.out.println("Cant Insert");
			return;
		}
		arr[heapSize] = key;
		heapSize++;
		if (arr[parent(heapSize-1)] >= key) {
			return;
		}
		else{
			// maxHeapify(parent(heapSize-1));
			int i = heapSize-1;
			while(i > 0 && arr[parent(i)] < arr[i]){
				int temp = arr[parent(i)];
				arr[parent(i)] = arr[i];
				arr[i] = temp;
				i = parent(i);
			}
		}
	}

	// 2 1 3 4 5 0
	public void maxHeapify(int i){
		int left = leftChild(i);
		int right = rightChild(i);
		int largest = i;
		// System.out.println("Left : " + arr[left] + " Right : " + arr[right]);
		if(left < heapSize && arr[left] > arr[i]){
			// System.out.println("INside Left");
			largest = left;
		}
		if(right < heapSize && arr[right] > arr[largest]){
			// System.out.println("INside right");
			largest = right;
		}
		if(largest != i){
			int temp = arr[largest];
			arr[largest] = arr[i];
			arr[i] = temp;
			maxHeapify(largest);
		}
	}

	public int extractMax(){
		int element = arr[0];
		arr[0] = arr[heapSize-1];
		heapSize--;
		maxHeapify(0);
		return element;
	}

	public void kLargestElement(int k){
		for(int i=1;i<=k;i++){
			System.out.print(extractMax()+" ");
			// display();
		}
	}

} 
class Practice45{
	public static void main(String[] args) {
		int[] arr = {1, 23, 12, 9, 30, 2, 50}; 
		// {1, 2, 3, 4, 5};
	BinaryHeap binaryHeap = new BinaryHeap(arr.length);
		for(int i=0;i<arr.length;i++)
			binaryHeap.insert(arr[i]);
		// binaryHeap.display();
		binaryHeap.kLargestElement(3);
	}
}