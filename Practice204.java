// Given an integer array arr, count element x such that x + 1 is also in arr.

// If there're duplicates in arr, count them seperately.
import java.util.HashMap;
import java.util.HashSet;
class Solution {
    public int countElements(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        init(map, arr);
        int count = 0;
        for(int i = 0; i < arr.length; i++){
        	int nextElement = arr[i]+1;
        	if(map.containsKey(nextElement) && map.get(nextElement) > 0){
        		int tempCount = map.get(nextElement);
        		map.put(nextElement, --tempCount);
        		count++;
        	}
        }
        return count;
    }
    	private void init(HashMap<Integer, Integer> map, int[] arr){
    		for(int i = 0; i < arr.length; i++){
    			if(map.containsKey(arr[i])){
    				int tempCount = map.get(arr[i]);
    				map.put(arr[i], ++tempCount);
    			}
    			else{
    				map.put(arr[i], 1);
    			}
    		}
    	}
}
class Solution2{
	public int countElements(int[] arr){
		HashSet<Integer> set = new HashSet<>();
		init(set, arr);
		int count = 0;
		for(int i = 0; i < arr.length; i++){
			int nextElement = arr[i] + 1;
			if(set.contains(nextElement)){
				count++;
			}
		}
		return count;
	}
	private void init(HashSet<Integer> set, int[] arr){
		for(int i = 0; i < arr.length; i++){
			set.add(arr[i]);
		}
	}
}
class Practice204{
	public static void main(String[] args) {
		int[] arr = {1,1,2};
		// int[] arr = {1, 3, 2, 3, 5, 0};
		// Solution solution = new Solution();
		Solution2 solution = new Solution2();
		System.out.println(solution.countElements(arr));
	}
}