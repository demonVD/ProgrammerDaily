// binary string divisible by 3 by using DFA(deterministic finite automata)
class Solution{
  public int isDivisibleByThree(String binary){
    int length = binary.length();
    char state = '0';
    // int i = 0;
    for(int i =0;i<length;i++){
      char currentChar = binary.charAt(i);
      switch(state)
      {
        case '0' :
          if(currentChar == '1'){
            state = '1';
          }
          // i++;
          break;

        case '1' :
          if(currentChar == '0'){
            state = '2';
          }
          else{
            state = '0';
          }
          // i++;
          break;

        case '2' :
          if(currentChar == '0'){
            state = '1';
          }
          // i++;
          break;

        default :
          break;
      }
    }
    if(state == '0') return 1;
    else return 0;
  }
}

class Practice15{
  public static void main(String[] args){
    String binary = "101";
    System.out.println(new Solution().isDivisibleByThree(binary));
  }
}
