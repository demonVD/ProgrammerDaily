// https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3297/
class Solution {
    public int lastStoneWeight(int[] stones) {
 		int firstIndex = 0;
 		int secondIndex = -1;
 		int first = Integer.MIN_VALUE;
 		int second = 0;
    	for(int j = 1; j < stones.length; j++){
    		firstIndex = -1;
    		secondIndex = -1;
	 		for(int i=0;i<stones.length;i++){
	 			if(stones[i] > first){
	 				secondIndex = firstIndex;
	 				firstIndex = i;
	 				second = first;
	 				first = stones[firstIndex];
	 				
	 			}
	 			else if( stones[i] > second && stones[i] <= first){
	 				secondIndex = i;
	 				second = stones[secondIndex];
	 			} 
	 		}
	 		first = Integer.MIN_VALUE;
	 		second = 0;
	 		int diff = Math.abs(stones[firstIndex] - stones[secondIndex]);
	 		stones[secondIndex] = diff;
	 		stones[firstIndex] = 0;
    	}
    	for(int i=0;i<stones.length;i++){
    		if(stones[i] > 0) return stones[i];
    	}
    	return 0;
    }
}
class Practice207{
	public static void main(String[] args) {
		int[] stones = {2, 7, 4, 1, 1, 8};
		Solution solution = new Solution();
		System.out.println(solution.lastStoneWeight(stones));
	}
}