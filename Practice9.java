// LeetCode P20 Valid Parenthese
import java.util.Stack;
class Solution{
  public  boolean isValid(String s){
    Stack<Character> stack = new Stack<>();
    for(int i=0;i<s.length();i++){
      if( s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[' ) stack.push(s.charAt(i));
      else if( stack.empty() ) return false;
      else if( s.charAt(i) == ')' ){
          char topChar = stack.pop();
          if(topChar == '[' || topChar == '{') return false;
      }
      else if(s.charAt(i) == '}'){
          char topChar = stack.pop();
          if(topChar == '(' || topChar == '[') return false;
      }
      else if(s.charAt(i) == ']'){
          char topChar = stack.pop();
          if(topChar == '(' || topChar == '{') return false;
      }
    }
    return stack.empty();
  }
}
class Practice9{
  public static void main(String[] args){
    String s = "[[]]";
    System.out.println(new Solution().isValid(s));
  }
}
