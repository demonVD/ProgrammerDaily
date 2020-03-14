// Implement strStr()
// LeetCode P28
class Solution {
	public int strStrKMP(String haystack, String needle)
	{
		if(haystack == null || needle == null)
		{
			return -1;	
		} 
		
		// hello 
		// ll
		int haystackLength = haystack.length();
		int needleLength = needle.length();

		for (int i = 0; i <= haystackLength - needleLength; i++) {
            int j = 0;
            for (j = 0; j < needleLength; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                } 
            }
            if (j == (needleLength)) {
                return i;
            }
        }

        return -1;

		// if(l2 > l1) return -1;
		// int[] lps = new int[l2];
		// computeLps(lps, l2, needle);
		// // Util.display(lps);
		// int i = 0, j = 0;
		// while(i < l1)
		// {
		// 	if(haystack.charAt(i) == needle.charAt(j))
		// 	{
		// 		i++;
		// 		j++;
		// 	}
		// 	if(l2 == j)
		// 	{
		// 		System.out.println("Found");
		// 		return i - l2;
		// 	}
		// 	else if( i < l1 && haystack.charAt(i) != needle.charAt(j))
		// 	{
		// 		if(j != 0)
		// 		{
		// 			j = lps[j-1];
		// 		}
		// 		else
		// 		{
		// 			i++;
		// 		}
		// 	}
		// }
		// return -1;
	}

	private void computeLps(int[] lps, int lengthLps, String pattern)
	{
		lps[0] = 0;
		int i=1;
		int lenOfSuffix = 0;
		while(i < lengthLps)
		{
			if(i < lengthLps && pattern.charAt(i) == pattern.charAt(lenOfSuffix))
			{
				lenOfSuffix++;
				lps[i] = lenOfSuffix;
				i++;
			}
			else
			{	
				if(lenOfSuffix != 0)
				{
					lenOfSuffix = lps[lenOfSuffix - 1];
				}
				else
				{
					lps[i] = lenOfSuffix;
					i++;
				}
				
			}
		}
	}


	// AAACAAAA
    
    public int strStr(String haystack, String needle) 
    {
    	// hlell
    	// ll
    	int lengthNeedle = needle.length();
    	int lengthHaystack = haystack.length();
    	if(lengthNeedle == 0) return 0;
        for(int i = 0; i < lengthHaystack-lengthNeedle; i++)
        {
        	int j = 0;
        	// int l = i;
        	while(j < lengthNeedle && haystack.charAt(i + j) == needle.charAt(j))
        	{
        		j = j + 1;
        	}
        	if(j == lengthNeedle)
        	{
        		return i;
        	}
        	// i = l;
        }
        return -1;
    }
}
class Practice133{
	public static void main(String[] args){
		System.out.println(new Solution().strStrKMP(args[0], args[1]));
	}
}
