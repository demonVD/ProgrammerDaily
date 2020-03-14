// Daily Coding Problem: Problem #272
import java.util.HashMap;
class Solution{
	int m = 1000000007;
	public int throw_dice1(int n, int face, int total){
		HashMap<Integer, HashMap<Integer, Integer>> countMap = new HashMap<Integer, HashMap<Integer, Integer>>();
		return throw_dice_helper(n, face, total, countMap);
		// return countMap.get(n).
	}
	private int throw_dice_helper(int n, int face, int total, HashMap<Integer, HashMap<Integer, Integer>> map){
		//	    System.out.println("N : " + n + " face : " + face + " total : " + total );
		if(n == 1){
			if(map.containsKey(n)){
				if(!map.get(n).containsKey(total)){
					if(total <= face){
						map.get(n).put(total, 1);
					}else{
						map.get(n).put(total, 0);
					}
				}
			}
			else{
				HashMap<Integer, Integer> tempMap = new HashMap<>();
				if(total <= face){
					tempMap.put(total, 1);
				}else{
					tempMap.put(total, 0);
				}
				map.put(n, tempMap);
			}
		}else{
			if(map.containsKey(n)){
				if(!map.get(n).containsKey(total)){
					int count = 0;
					for(int i = 1; i <= face; i++) {
						int newTotal = total - i;
						if(newTotal > 0) {
							System.out.println("Previous COUnt : " + count);
							System.out.println("n : " + (n - 1) + " face : " + face + " total : " + total);
//							count += throw_dice_helper(n-1, face, newTotal, map) % m;
							count = (count % m) + (throw_dice_helper(n-1, face, newTotal, map) % m);
						}
					}
					map.get(n).put(total, count % m);
				}
			}
			else{
				HashMap<Integer, Integer> tempMap = new HashMap<Integer, Integer>();
				int count = 0;
				for(int i = 1; i <= face; i++) {
					int newTotal = total - i;
					if(newTotal > 0) {
						System.out.println("Previous COUnt : " + count);
						System.out.println("n : " + (n - 1) + " face : " + face + " total : " + total);
						count = (count % m) + (throw_dice_helper(n-1, face, newTotal, map) % m);
					}
				}
				tempMap.put(total, count % m);
				map.put(n, tempMap);
			}
		}
		//	    System.out.println("count : " + map.get(n).get(total));
		return map.get(n).get(total);
	}
	public int throw_dice(int n, int face, int total) {
		// TODO Auto-generated method stub
		HashMap<Integer, HashMap<Integer, Integer>> countMap = new HashMap<Integer, HashMap<Integer, Integer>>();
		return throw_dice_helper(n, face, total, countMap);
	}
}
class Practice170{
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.throw_dice(3, 6, 7));
  }
}
