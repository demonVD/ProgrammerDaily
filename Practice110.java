// String is palindrome or not 
class Solution{
	// private static final REGEX = "[!@#$%^&*(),.?":{}|<>]";
	public boolean isPalindrome(String s){
		int i=0,j=s.length()-1;
		// Pattern p = Pattern.compile(REGEX);
		// Matcher m = p.matcher(s);
		while(i <= j){
			if(!Character.isAlphabetic(s.charAt(i)) && !Character.isDigit(s.charAt(i))){
				i++;
			}
			else if(!Character.isAlphabetic(s.charAt(j)) && !Character.isDigit(s.charAt(j))){
				j--;
			}
			else if(Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--))){
				return false;
			}
		}
		return true;
	}
}
class Practice110{
	public static void main(String[] args) {
		String s = args[0];
		System.out.println(new Solution().isPalindrome(s));
	}
}