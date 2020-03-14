import java.util.Stack;
class Solution{
  public String isBalanced(String str){
    if(str.length() == 0) return "balanced";
    if(str.length() == 1) return "unbalanced";
    Stack<Character> s = new Stack<>();
    for(int i =0;i<str.length();i++){
      char c = str.charAt(i);
      if(c == '{' || c == '[' || c == '(') s.push(c);
      else if(s.empty()) return "unbalanced";
      else if(c == ']'){
        if(s.peek() == '[') s.pop();
        else break;
      }
      else if(c == ')'){
        if(s.peek() == '(' ) s.pop();
        else break;
      }
      else if(c == '}' ){
        if(s.peek() == '{' ) s.pop();
        else break;
      }
    }
    if(s.empty()) return "balanced";
    else return "unbalanced";
  }
}
class Practice31{
  public static void main(String[] args) {
    String str = "{{}}";
    System.out.println(new Solution().isBalanced(str));;
  }
}
