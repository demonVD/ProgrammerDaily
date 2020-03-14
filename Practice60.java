// iven three increasingly sorted arrays A, B, C of sizes N1, N2, and N3 respectively,
 // you need to print all common elements in these arrays.
import java.util.HashMap;
class Solution{
	public void commonElement(int[] a1, int[] a2, int[] a3){
		HashMap<Integer, Integer> numbers = new HashMap<>();
		for(int i=0;i<a1.length;i++){
			if(numbers.containsKey(a1[i])){
				// System.out.print(a1[i] + " ");
				numbers.put(a1[i], numbers.get(a1[i]) + 1);
			}
			else{
				numbers.put(a1[i], 1);	
			}
		}
		for(int i=0;i<a2.length;i++){
			if(numbers.containsKey(a2[i])){
				// System.out.print(a2[i] + " ");
				numbers.put(a2[i], numbers.get(a2[i]) + 1);
			}
			else{
				numbers.put(a2[i], 1);	
			}
		}
		for(int i=0;i<a3.length;i++){
			if(numbers.containsKey(a3[i])){
				// System.out.print(a3[i] + " ");
				numbers.put(a3[i], numbers.get(a3[i]) + 1);
			}
			else{
				numbers.put(a3[i], 1);	
			}
		}
		for(int i : numbers.keySet()){
			if(numbers.get(i) > 1)
				System.out.print(i + " ");
		}
	}
}
class Practice60{
	public static void main(String[] args) {
		new Solution().commonElement(new int[]{1, 5, 10, 20, 40, 80}, 
			new int[]{6, 7, 20, 80, 100}, 
			new int[]{3, 4, 15, 20, 30, 70, 80, 120});
	}
}