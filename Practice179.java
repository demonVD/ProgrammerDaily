// K smallest Element Closest to X
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Comparator;
class Solution{
	int lastIndex = -1;
	public int[] kClosestElement(int[] arr, int k, int x){
		lastIndex = arr.length-1;
		Pair[] elements = new Pair[arr.length];
		for(int i = 0; i < arr.length; i++){
			elements[i] = new Pair(arr[i], Math.abs(arr[i] - x));
		}
		display(elements);
		buildMinHeap(elements);
		display(elements);
		int[] kClosestElementArray = new int[k];
		for(int i = 0; i < k; i++){
			kClosestElementArray[i] = extractMin(elements).x;
		}
		return kClosestElementArray;
	}
	private void display(Pair[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]);
		}
		System.out.println();
	}
	private Pair extractMin(Pair[] elements){
		Pair min = elements[0];
		elements[0] = elements[lastIndex];
		lastIndex -= 1;
		heapify(elements, 0);
		return min;
	}
	private void buildMinHeap(Pair[] elements){
		int lastNonLeafNode = parent(lastIndex);
		for(int i = lastNonLeafNode; i >= 0; i--){
			heapify(elements, i);
		}
	}
	private void heapify(Pair[] arr, int i){
		int smallest = i;
		int left = left(i);
		int right = right(i);
		if(left <= lastIndex && arr[smallest].y > arr[left].y){
			smallest = left; 
		}
		if(right <= lastIndex && arr[smallest].y > arr[right].y){
			smallest = right;
		}
		if(i != smallest){
			swap(arr, i, smallest);
			heapify(arr, smallest);
		}
	}
	private void swap(Pair[] arr, int i, int j){
		Pair temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	private int parent(int i){
		return (i-1)/2;
	}
	private int left(int i){
		return (2*i) + 1;
	}
	private int right(int i){
		return (2*i) + 2;
	}
}


class Pair{
	int x, y;
	public Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
	public String toString(){
		return "[" + x + "," + y + "]";
	}
}
class Practice179{
	public static void main(String[] args){
		int[] arr = {10, 2, 14, 4, 7, 6};
		Solution solution = new Solution();
		display(solution.kClosestElement(arr, 3, 5));
		Solution2 solution2 = new Solution2();
		display(solution2.kClosestElement(arr, 3, 5));
	}
	static void display(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
class Solution2{
	public int[] kClosestElement(int[] arr, int k, int x){
		ArrayList<Pair> elements = new ArrayList<>();
		for(int i=0;i<arr.length;i++){
			elements.add(new Pair(arr[i], Math.abs(arr[i] - x)));
		}
		// PriorityQueue<Pair> heap = new PriorityQueue<>(new ComparatorExample());
		PriorityQueue<Pair> heap = new PriorityQueue<>((Pair p1, Pair p2)->{
			return p1.y - p2.y;
		});
		for(int i = 0; i < elements.size(); i++){
			heap.add(elements.get(i));
		}
		for(Pair p1 : heap){
			System.out.print(p1);
		}
		System.out.println();
		int[] kClosestElementArray = new int[k];
		for(int i = 0; i < k; i++){
			kClosestElementArray[i] = heap.poll().x;
		}
		return kClosestElementArray;
	}
}
class ComparatorExample implements Comparator<Pair>{
	public int compare(Pair p1, Pair p2){
		return p1.y - p2.y;
	}
}