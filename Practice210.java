// https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3299/
class Solution {
    public String stringShift(String s, int[][] shift) {
        if(s.length() == 1) return s;
        int[] rotation = new int[2];
        for(int i=0;i<shift.length;i++){
        		rotation[shift[i][0]] += shift[i][1];
        }
        int resultRotation = Math.abs(rotation[0] - rotation[1]) % s.length();
        int resultDirection = (rotation[0] > rotation[1]) ? 0 : 1;
        if(resultRotation == 0){
        	return s;
        }
        if(resultDirection == 0) return leftRotation(s, resultRotation);
        else return rightRotation(s, resultRotation);
    }
    private String leftRotation(String s, int degree){
    	char[] sChar = s.toCharArray();
    	reverse(sChar, 0, degree-1);
    	reverse(sChar, degree, sChar.length-1);
    	reverse(sChar,0, sChar.length-1);
    	return String.valueOf(sChar);
    }
    private String rightRotation(String s, int degree){
    	char[] sChar = s.toCharArray();
    	reverse(sChar,0,s.length()-degree-1);
    	reverse(sChar, s.length()-degree, s.length()-1);
    	reverse(sChar, 0, s.length()-1);
    	return String.valueOf(sChar);
    }
    private void reverse(char[] s, int start, int end){
    	while(start < end){
    		char temp = s[start];
    		s[start] = s[end];
    		s[end] = temp;
    		start++;
    		end--;

    	}
    }
}
/*
class Solution {
    public static String doShift(String str, int dis) {
    	dis = dis % str.length();
    	System.out.println(str.length());
    	System.out.println("str :: " + str + " dis :: " + dis);
        String s = str.substring(dis) + str.substring(0, dis); 
        return s; 
    }
    public String stringShift(String str, int[][] shift) {
        // count the number of final shifts
        boolean s = false; // left shift is true
        int resultant_shift = 0;
        for(int i=0;i<shift.length;i++) {
        	System.out.println(shift[i][0] + " " + shift[i][1]);
        	// resultant_shift += (shift[i][0] == 0) ? shift[i][1] : -1 * shift[i][1];
            for(int j=0;j<shift[0].length;j++) {
                // check which shift it is

                if(j==0) {
                    s = shift[i][0]==0 ? true : false;
                } else {
                    // check for the amount of shift
                    resultant_shift += ( s==true ? shift[i][j] : -1*shift[i][j] );
                }
            }
        }
        System.out.println("resultant_shift :: " + resultant_shift);
        if(resultant_shift < 0) {
            // right shift
            str = doShift(str, Math.abs(str.length() + resultant_shift)); 
        } else {
            // left shift
            str = doShift(str, resultant_shift);
        }
        return str;
    }
}
*/
class Practice210{
	public static void main(String[] args) {
		// String s = "abcdefg";
		// int[][] shift = {{1,1},{1,1},{0,2},{1,7}
		// String s = "xqgwkiqpif";
		// int[][] shift = {{1,4},{0,7},{0,8},{0,7},{0,6},{1,3},{0,1},{1,7},{0,5},{0,6}};
		// zeuobhwxatulpruiaby
		String s = "yzeuobhwxatulpruiab";
		int[][] shift = {{1,15},{0,18},{0,12},{0,7},{0,7},{1,17},{1,15},{0,9},{1,4},{0,19},{1,16},{0,7},{1,4},{1,17},{1,19},{1,10},{1,2},{0,18},{1,15}};
		// {{1,8},{1,4},{1,3},{1,6},{0,6},{1,4},{0,2},{0,1}};
// [[1,8],[1,4],[1,3],[1,6],[0,6],[1,4],[0,2],[0,1]]};
		Solution solution = new Solution();
		System.out.println(solution.stringShift(s,shift));
	}
}