// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/674/
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        init(map, nums1);
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums2.length; i++){
        	if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0){
        		int tempCount = map.get(nums2[i]);
        		map.put(nums2[i], --tempCount);
        		list.add(nums2[i]);
        	}
        }
        int[] result = new int[list.size()];
        int j = 0;
        for(int i : list){
        	result[j++] = i;
        }
        return result;
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
    public void printArray(int[] arr){
    	for(int i : arr){
    		System.out.print(i + " ");
    	}
    	System.out.println();
    }
}
class Practice205{
	public static void main(String[] args) {
		int[] nums1 = {1, 2, 2, 1};
		int[] nums2 = {3, 4, 1};
		Solution solution = new Solution();
		solution.printArray(solution.intersect(nums1, nums2));

	}
}