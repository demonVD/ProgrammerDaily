// no of set bits
class Solution{
  public int hammingDigit(int n){
    int count = 0;
     System.out.println(Integer.toBinaryString(n));
     String s = Integer.toBinaryString(n);
    // while(n > 0){
    //   if((n & 1) == 1){
    //     count++;
    //   }
    //   n = n >>> 1;
    // }
    for(int i=0;i<s.length();i++){
      if(s.charAt(i) == '1'){
        count++;
      }
    }
    return count;
  }
}
class Practice169{
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.hammingDigit(-3));
    // System.out.println(solution.hammingDigit(3));
  }
}
