// k smallest element
class BinaryHeap{
	int[] arr;
	int heapSize;
	int capacity;
	
	public BinaryHeap(int capacity){
		this.heapSize = 0;
		this.capacity = capacity;
		arr = new int[capacity];
	}

	public int parent(int i){
		return (i-1)/2;
	}

	public int leftChild(int i){
		return 2*i + 1;
	}

	public int rightChild(int i){
		return 2*i + 2;
	}

	public int getMin(){
		return arr[0];
	}

	public void insert(int key){
		if(heapSize == capacity){
			return; 	
		}
		arr[heapSize] = key;
		heapSize++;
		// System.out.println("HeapSize After : " + heapSize);
		if(arr[parent(heapSize-1)] < key){
			// System.out.println("Parent Smaller than ");
			return;
		}else{
			// maintaining MinHeap property
				
			int i=heapSize-1;
			while(i>0 && arr[parent(i)] > arr[i]){
				int temp = arr[parent(i)];
				arr[parent(i)] = arr[i];
				arr[i] = temp;
				i = parent(i);
			}
		}
	}
	public int extractMin(){
		int element = arr[0];
		// System.out.println("Min Element : " + element);
		// System.out.println("HeapSize Before : " + heapSize);
		// System.out.println("0 Element : " + arr[0]);
		// System.out.println("last Element : " + arr[heapSize-1]);
		arr[0] = arr[heapSize-1];
		heapSize--;
		// System.out.println("HeapSize After : " + heapSize);
		minHeapify(0);
		return element;
	}
	public void minHeapify(int i){
		// if(i >= heapSize) return;
		int left = leftChild(i);
		// System.out.println("Left Child" + arr[left]);
		int right = rightChild(i);
		// System.out.println("Right Child" + arr[right]);
		int smallest = i;
		if(left < heapSize && arr[left] < arr[i]){
			// System.out.println("Inside Left comparison");
			smallest = left;
		}
		if(right < heapSize && arr[right] < arr[smallest]){
			// System.out.println("Inside Right comparison");
			smallest = right;
		}
		if(smallest != i){
			int temp = arr[smallest];
			arr[smallest] = arr[i];
			arr[i] = temp;
			minHeapify(smallest);
		}
	}
	public void display(){
		for(int i=0;i<heapSize;i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public int kSmallestElement(int k){
		int element = 0 ;
		for(int i=1;i<=k;i++){
			element = extractMin();
			// display();
		}
		// System.out.println(element);
		return element;
	}
}
class Practice44{
	public static void main(String[] args) {
		int[] arr = {7, 10, 4, 3, 20 ,15};
		// {5, 4, 3, 2, -2};
		BinaryHeap binaryHeap = new BinaryHeap(arr.length);
		for(int i=0;i<arr.length;i++){
			binaryHeap.insert(arr[i]);
			// binaryHeap.display();
		}
		binaryHeap.display();
		System.out.println(binaryHeap.kSmallestElement(3));
		// binaryHeap.display();
	}
}