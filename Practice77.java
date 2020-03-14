class Solution{
	public int getFlipBits(int a, int b){
		int count = 0;
		int c = a ^ b;
		while(c != 0){
			if((c & 1) == 1) count++;
			c >>= 1;
		}
		return count;
	}
}
class Practice77{
	public static void main(String[] args) {
		System.out.println(new Solution().getFlipBits(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
	}
}