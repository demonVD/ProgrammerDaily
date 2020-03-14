// String contains unique Characters using bitArray
class Solution{
	public boolean containsUniqueChars(String str){
		// for this method to work 
		int checker = 0;
		for(int i=0;i<str.length();i++){
			int pos = str.charAt(i) - 'a';
			if ((checker & (1<<pos)) != 0){
				return false;
			}
			checker |= (1<<pos);
		}
		return true;
	}
}
class Practice64{
	public static void main(String[] args) {
		// String str = "Vishant";
		System.out.println(new Solution().containsUniqueChars("abca"));
	}
}