// codeForces
// https://codeforces.com/contest/1169/problem/A
import java.util.Scanner;
import java.lang.Math;
public class Solution{
  public static void main(String[] args) {
    // int[] arr = {1, 2, 3, 4, 5};
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int a = sc.nextInt();
    int x = sc.nextInt();
    int b = sc.nextInt();
    int y = sc.nextInt();

    boolean status = willCross(a, x, b, y);
    if(status) System.out.println("YES");
    else System.out.println("NO");
  }

  public boolean willCross(int a, int x, int b, int y){
    boolean status = false;
    if (y>x) {
      status = false;
    }
    else{
      if(Math.floor((a+b)/2.0) == (a+b)/2)
        status = true;
    }
    return status;
  }
}
public class Practice37{
  public static void main(String[] args) {
    // int[] arr = {1, 2, 3, 4, 5};
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int a = sc.nextInt();
    int x = sc.nextInt();
    int b = sc.nextInt();
    int y = sc.nextInt();

    boolean status = new Solution().willCross(a, x, b, y);
    if(status) System.out.println("YES");
    else System.out.println("NO");
  }
}
