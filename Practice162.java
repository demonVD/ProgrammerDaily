// Permutaions of a string
import java.util.HashSet;
class Solution{
  public void permutations(String str){
    HashSet<String> arr = new HashSet<>();
    permutationsHelper(str, 0, str.length() - 1, arr);
    display(arr);
  }
  private void display(HashSet<String> str){
    for(String s : str){
      System.out.print(s + " ");
    }
    System.out.println();
  }
  private void permutationsHelper(String str, int start, int end, HashSet<String> arr){
    for(int i = start; i <= end; i++){
      if(start >= end){
        // System.out.print(str + " ");
        if(!arr.contains(str)){
          arr.add(new String(str));
        }
      }else{
        str = swap(str, start, i);
        permutationsHelper(str, start + 1, end, arr);
        str = swap(str, start, i);
      }
    }
  }
  public String swap(String a, int i, int j)
  {
    char temp;
    char[] charArray = a.toCharArray();
    temp = charArray[i] ;
    charArray[i] = charArray[j];
    charArray[j] = temp;
    return String.valueOf(charArray);
  }
}
class Practice162{
  public static void main(String[] args){
    String str = "aaa";
    Solution solution = new Solution();
    solution.permutations(str);
  }
}
