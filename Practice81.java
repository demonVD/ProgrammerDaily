// no of ways to climb a staircase with 1, 2, or 3 steps at a time
import java.util.Arrays;
class Solution{
	static int[] ways = new int[100001];
	public static void initialize(){
		ways[0] = 1;
		ways[1] = 1;
	}
	/*public int countWays(int n){
		if(n<0) return 0;
		else if(n == 0) return 1;
		else if(ways[n] > -1) return ways[n];
		else{
			ways[n] = countWays(n-1) + countWays(n-2) + countWays(n-3);
			return ways[n];
		}
	}*/
	public int noOfWays(int stairs){
		for(int i=2;i<=stairs;i++){
			ways[i] = (((i - 1 >= 0) ? ways[i-1] : 0) + ((i - 2 >= 0) ? ways[i - 2] : 0) 
							+ ((i - 3 >= 0) ? ways[i - 3] : 0)) % 1000000007;
			// System.out.println(ways[i]);

		}
		return ways[stairs];
	}
}
class Practice81{
	public static void main(String[] args) {
		Solution.initialize();
		System.out.println(new Solution().noOfWays(100000));
	}
}