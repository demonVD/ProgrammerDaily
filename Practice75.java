// You have an integer and you can flip exactly one bit from a O to a 1. Write code to
// find the length of the longest sequence of 1 s you could create.
class Solution{
	public int findMaxConsecutiveOnes(int num) {
		int currentLength = 0;
		int prevLength = 0;
		int maxLength = 0;
		while(num != 0){
			if((num & 1) == 1 ) currentLength++;
			else if((num & 1) == 0){
				prevLength = ((num & 2) == 0) ? 0 : currentLength; 
				currentLength = 0;
			}
			maxLength = Math.max(prevLength + currentLength, maxLength);
			num >>= 1;
		}
		return maxLength + 1;
	}
}
class Practice75{
	public static void main(String[] args) {
		System.out.println(new Solution().findMaxConsecutiveOnes(1775));
	}
}