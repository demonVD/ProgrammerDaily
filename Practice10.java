// techgig Cadbury Problem
import java.lang.Math;
class Solution{
  public int noOfStudents(int m, int n, int o, int p){
    int students = 0;
    if(m == 0 || n == 0 || o == 0 || p == 0) return students;
    // int count = 0;
    for(int i=m;i<=n;i++){
      for(int j=o;j<=p;j++){
        int l = Math.max(i, j);
        int b = Math.min(i, j);
        if(l == b) students++;
        else{
          int area = l*b;
          while(area!=0){
            int length = Math.max(l, b);
            int breadth = Math.min(l, b);
            // System.out.println("l : " + l + "b : " + b);
            area = area - (breadth*breadth);
            students++;
            b = length - breadth;
            l = breadth;
          }
        }
      }
    }
    return students;
  }
}
class Practice10{
  public static void main(String[] args){
    int m = 5, n = 5, o = 1, p = 1;
    System.out.println(new Solution().noOfStudents(m, n, o, p));
  }
}
