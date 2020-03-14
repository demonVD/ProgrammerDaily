// Closest (or Next) smaller and greater numbers with same number of set bits
class Solution{
	public int getClosestLargest(int n){
		int negate  = ~n;
		System.out.println("negate : " + negate);
		int temp = ~negate + 1;
		System.out.println("temp : " + temp);
		int result = temp & negate;
		System.out.println(result);
		int pos = (int)(Math.log10(result)/Math.log10(2));
		System.out.println(pos);
		// /(int)Math.log(2);
		int mask = 1 << pos;
		int largeNo = n | mask;
		mask = ~(1 << (pos - 1));
		largeNo = largeNo & mask; 
		return largeNo;
	}
}
class Practice76{
	public static void main(String[] args) {
		System.out.println(new Solution().getClosestLargest(Integer.parseInt(args[0])));
	}
}