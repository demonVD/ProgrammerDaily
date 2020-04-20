// https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3291/
class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int count1 = 0, count2 = 0;

        while (i >= 0 || j >= 0) { 
            while (i >= 0) { 
                if (S.charAt(i) == '#') {count1++; i--;}
                else if (count1 > 0) {count1--; i--;}
                else break;
            }
            while (j >= 0) { 
                if (T.charAt(j) == '#') {count2++; j--;}
                else if (count2 > 0) {count2--; j--;}
                else break;
            }
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            
            // if((i < 0) && (j < 0))
            // if ((i >= 0) != (j >= 0))
                // return false;
            i--; j--;
        }
        return true;
    }
}
class Practice206{
	public static void main(String[] args) {
		String S = "ab#cdef###";
		String T = "az#cd#";
		
		// String S = "###";
		// String T = "#a#z#cd##";
		
		Solution solution = new Solution();
		System.out.println(solution.backspaceCompare(S, T));
	}
}