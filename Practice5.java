// Longest Common Prefix in an array
class Solution{
  public String getLCP(String[] arr){
    int minLengthIndex = 0;
    for(int i=0;i<arr.length;i++){
      if(arr[i].length() <= arr[minLengthIndex].length()) minLengthIndex = i;
    }
    // System.out.println(minLengthIndex);
    String lcpString = arr[minLengthIndex];
    System.out.println(lcpString);
    for(int i=0;i<arr.length;i++){
      lcpString = LCP(arr[i], lcpString);
      System.out.println("Inside loop : " + lcpString);
      if(lcpString.length() == 0) return "";
    }
    return lcpString;
  }
  private String LCP(String s1, String s2){
      int i =0,j = 0;
      while(i < s1.length() && j < s2.length() && s1.charAt(i) == s2.charAt(j)){
        i++;
        j++;
      }
      return s2.substring(0, j);
  }
}
class Practice5{
  public static void main(String[] args){
    String[] arr =  {"dog","racecar","car"};
    // {"apple", "ape", "pril"};
    // {"geeksforgeeks", "geeks","geek","geezer"};
    Solution sol = new Solution();
    System.out.println(sol.getLCP(arr));
  }
}
