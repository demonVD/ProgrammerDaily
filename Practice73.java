// Relative Sort Array
import java.util.Map;
import java.util.TreeMap;
class Solution{
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		Map<Integer, Integer> treeMap = new TreeMap<>();
		for(int i=0;i<arr1.length;i++){
			if(treeMap.size()!=0 && treeMap.containsKey(arr1[i])){
				int count = treeMap.get(arr1[i]);
				treeMap.put(arr1[i], ++count);
			}
			else{
				treeMap.put(arr1[i], 1);
			}
		}
		int j=0;
		for(int key : arr2){
			for(int i=treeMap.get(key);i>0;i--){
				arr1[j++] = key;
			}
			treeMap.remove(key);
		}
		for(int key : treeMap.keySet()){
			for(int i=treeMap.get(key);i>0;i--){
				arr1[j++] = key;
			}
		}
		/*for(int j=0;i<arr1.length;i++){
			System.out.println(arr1[i]+" ");
		}*/
		return arr1;
    }

	/*class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001], res = new int[arr1.length];
        for(int e : arr1) count[e]++;
        int idx = 0;
        for(int e : arr2) {
            for(int i= 0; i < count[e]; i++) res[idx++] = e;
            count[e] = 0;
        }

        for(int i = 0; i <= 1000; i++) {
            for(int j= 0; j < count[i]; j++) res[idx++] = i;
        }
        return res;
    }*/
}    
}
class Practice73{
	public static void main(String[] args) {
		int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
		int[] arr2 = {2,1,4,3,9,6};
		int[] result = new Solution().relativeSortArray(arr1, arr2);
		for(int i=0;i<result.length;i++){
			System.out.print(result[i]+" ");
		}
	}
}