// Given a String of length S, reverse the whole string without reversing the individual words in it. Words are separated by dots.
class Solution{
  public String getReverse(String str){
    String[] list = str.split("\\.");
    // for(int i =0;i<list.length;i++)
    //   System.out.print(list[i] + " ");
    int i = 0;
    int j = list.length-1;
    while(i<j){
      String temp = list[i];
      list[i] = list[j];
      list[j] = temp;
      i++;
      j--;
    }
    // for(i =0;i<list.length;i++)
    //   System.out.print(list[i] + " ");
    StringBuilder s = new StringBuilder();
    for(i =0;i<list.length;i++){
      if(i!=list.length-1) s = s.append(list[i] + ".");
      else s = s.append(list[i]);
    }
    return s.toString();
  }
}
class Practice32{
  public static void main(String[] args) {
    String str = "mno.pqr";
    // "i.like.this.program.very.much";
    System.out.println(new Solution().getReverse(str));;
  }
}
