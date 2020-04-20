// Power of three
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
class Solution{
	public boolean isPowerOfThree(int n){
		System.out.println(Math.log(n)/Math.log(3));
		BigDecimal d = new BigDecimal(Math.log(n)/Math.log(3));
		System.out.println(d);
		if(d.equals(new Integer(d.intValueExact()))){
			return true;
		}
		return false;
	}
}
class Practice191{
	public static void main(String[] args) throws IOException{
		// BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// int a = Integer.parseInt(reader.readLine());
		Solution solution  = new Solution();
		System.out.println(solution.isPowerOfThree(243));
	}
}



import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {


    /*
     * Complete the function below.
     */
    static String findQualifiedNumbers(int[] numberArray) {
                // .matches("^[123]{3}$");
                List<Integer> list = new ArrayList<>();
                for(int i =0;i<numberArray.length;i++){
                    // System.out.println(Integer.toString(numberArray[i]).matches("^[123]{3}$"));
                    int number = numberArray[i];
                    int count = 0;
                    while(number > 0){
                        int digit = number%10;
                        System.out.println("DIGIT : " + digit);
                        if(digit == 1 || digit == 2 || digit == 3){
                            count++;
                        }
                        number = number/10;
                    }
                    System.out.println("Count :: " + count);
                    if(count == 3){
                        list.add(numberArray[i]);
                    }
                }
                Collections.sort(list);
                while(){
                    
                }
                return "";
    }

    public static void main(String[] args) throws IOException {