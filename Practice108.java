// https://practice.geeksforgeeks.org/problems/special-keyboard/0
class Solution{
	public int maxAs(int n){
		int step = 1;
		// if(n==) return 1;
		maxHelper(step, op, aCount);
		// maxHelper(n-1, B, step);
		// maxHelper(n-1, C, step);
		// maxHelper(n-1, D, step);
	}
	private int maxHelper(int step, Char op, int acount){
		if(step > 75) return 0;
		switch(op){
			case 'A' : 
				// acount += 1;
			return Math.max(maxHelper(step+1, acount+1), maxHelper(step+1, acount), maxHelper(step+1, acount))
		}
		

	}
}
class Practice108{
	public static void main(String[] args) {
		
	}
}