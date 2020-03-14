// pallindromic substring
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
class Solution{
  public void howManyPalindromes(String s, List<Integer> a, List<Integer> b) {
    int length = s.length();
    boolean[][] arr = new boolean[length][length];
    init(arr);
    for(int i = 0;i < length; i++){
      arr[i][i] = true;
    }
    for(int i = 0; i < length - 1; i++){
      int j = i + 1;
        if(s.charAt(i) == s.charAt(j)){
          arr[i][j] = true;
        }
        else{
          arr[i][j] = false;
        }
    }
    for(int i = 3; i <= length; i++){
      for(int j = 0; j < length - i + 1; j++){
        int ei = j + i - 1;
        if((s.charAt(j) == s.charAt(ei)) && (arr[j + 1][ei - 1])){
          arr[j][ei] = true;
        }
        else{
          arr[j][ei] = false;
        }
      }
    }
    List<Long> countList = new ArrayList<Long>();
    for(int i = 0; i < a.size(); i++){
      // for(int j = a.get(i); i < b.get(i); j++){
      //  for(int k = 0; k < length - j + 1; k++){
      //    int ei = k + j - 1;
      //    if()
      //  }
      long count = 0;
        for(int k = 0; k < length; k++){
          for(int z = 0; z < length; z++){
            int lengthSubString = z - k + 1;
            if(arr[k][z] && (lengthSubString >= a.get(i) && lengthSubString <= b.get(i))){
              count++;
            }
          }
        }
        countList.add(count);
      // }
    }
    display(countList);
    display(arr);
  }
  private void init(boolean[][] arr){
    for(int i=0;i<arr.length;i++){
      for(int j=0;j<arr[0].length;j++){
        arr[i][j] = false;
      }
    }
  }
  private void display(boolean[][] arr){
    // System.out.println(Arrays.toString(arr));
    for(int i=0;i<arr.length;i++){
      for(int j=0;j<arr[0].length;j++){
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }
  private void display(List<Long> arr){
    // System.out.println(Arrays.toString(arr));
    for(int i=0;i<arr.size();i++){
      System.out.print(arr.get(i) + " ");
    }
    System.out.println();
  }
}
class Practice168{
  public static void main(String[] args) {
    String s = "bxb";
    List<Integer> a = new ArrayList<>();
    List<Integer> b = new ArrayList<>();
    a.add(2); a.add(1);
    b.add(3); b.add(1);
    Solution solution = new Solution();
    solution.howManyPalindromes(s, a, b);
  }
}
