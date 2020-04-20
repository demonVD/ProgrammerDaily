// https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3284/
// Happy Number
import java.util.HashSet;
class Solution {
    public boolean isHappy(int n) {
    	int originalNumber = n;
    	HashSet<Integer> set = new HashSet<>();
    	do{
    		int sum  = 0;
	    	while(n != 0){
		   		int digit = n % 10;
		   		sum += (digit * digit);
	    		n = n / 10;
	    	}
	    	n = sum;
	    	if(n == 1) return true;
	    	if(set.isEmpty() || !set.contains(n)){
	    		set.add(n);
	    	}
	    	else{
	    		return false;
	    	}
	    	// System.out.println(n);
	    	// if(n == originalNumber) return false;
    	}while(true);
    }
}
class Practice194{
	public static void main(String[] args) {
		int n = 2;
		Solution solution = new Solution();
		System.out.println(solution.isHappy(n));
	}
}