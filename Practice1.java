/**
Sachin likes sweets a lot. So, he goes to a market of sweets.
There is a row of sweet stalls. Every sweet stall has different sweets.
 To save some time, he decided to buy sweets from contiguous stalls.
 So, he can buy from as many stalls as he wants, but all of those stalls need to be contiguous.
 He also decided to buy only 1 kg of sweets from each of those stalls.
 Cost of 1 kg of sweets for each stall is given.
 There is a strange rule of billing in that market.
 And that rule is as follows- Total cost of all sweets bought is sum of the cost of all sweets multiplied
 by the cost of sweet he bought at the end.
  e.g. if he buys sweets having cost 2, 3, 4 in the same order than total cost of sweets will be 2*4+3*4+4*4=36.
  Now he wonders what will be the total cost of all possible ways of buying sweets.
  Can you help him. Because this number could be large, you should take modulo of the final result by 10^9+7.
*/
import java.util.Scanner;
public class Practice1{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int i = 0;i<n;i++){
      arr[i] = sc.nextInt();
    }
    int sum = 0;
    for(int i =1;i<=n;i++){
      for(int j=0;j<n;j++){
        sum = sum+arr[i]*arr[i];
      }
    }
  }
}
