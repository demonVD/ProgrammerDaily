// Valid Palindrome
// LeetCode 125
class Solution
{
	public boolean isPalindrome(String s) 
	{
		int high = s.length()-1;
		int low = 0;
		while(low < high)
		{
			// char a = s.charAt(low);
			// char b = s.charAt(high);
			// A man, a plan, a canal: Panama
			/*while(low < high && !Character.isLetter(s.charAt(low)))
			{
				++low;
			}
			while(low < high && !Character.isLetter(s.charAt(high)))
			{
				--high;
			}
			while(low < high && Character.toLowerCase(s.charAt(low)) == Character.toLowerCase(s.charAt(high)))
			{
				++low;
				--high;
			}*/
			// A man, a plan, a canal: Panama
			if(!Character.isLetterOrDigit(s.charAt(low)))
			{
				++low;
			}
			else if(!Character.isLetterOrDigit(s.charAt(low)))
			{
				--high;
			}
			else if(Character.toLowerCase(s.charAt(low)) == Character.toLowerCase(s.charAt(high)))
			{
				++low;
				--high;
			}
			else
			{
				return false;
			}
		}
		return true;
    }
}
class Practice134
{
	public static void  main(String[] args)
	{
 		System.out.println(new Solution().isPalindrome(args[0]));
	}

}