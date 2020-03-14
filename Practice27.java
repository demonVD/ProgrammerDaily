class MinHeap{

  int[] harr;
  int capacity;
  int heapSize;

  MinHeap(int capacity){
    this.capacity = capacity;
    this.heapSize = 0;
    this.harr = new int[capacity];
  }

  int parent(int i) {return (i-1)/2;}
  int left(int i) {return (2*i + 1);}
  int right(int i) {return (2*i + 2);}
  void insertKey(int k){
    heapSize++;
    int i = heapSize - 1;
    harr[heapSize-1] = k;

  }
}
