// Maximum Power HackerEarth Challenge
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.io.*;
class Solution{
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        while(testCase-- > 0){
            int q = Integer.parseInt(br.readLine());
            int size = 0;
            Query[] queries = new Query[q];
            for(int i=0;i<q;i++){
                queries[i] = new Query();
                String[] str = br.readLine().trim().split(" ");
                queries[i].parameter = str[0];
                if(queries[i].parameter.equalsIgnoreCase("A")) size++;
                queries[i].number = Integer.parseInt(str[1]);
            }
            // ArrayList<Integer> arr = new ArrayList<>();
            int[] arr = new int[size];
            int current =0;
            for(int i=0;i<q;i++){
                if(queries[i].parameter.equalsIgnoreCase("A")){
                    // arr.add(queries[i].number);
                    arr[current++] = queries[i].number;
                }
                
                else if(queries[i].parameter.equalsIgnoreCase("I")){
                    incrementAllElements(arr, queries[i].number);
                }
                else if(queries[i].parameter.equalsIgnoreCase("D")){
                    decrementAllElements(arr, queries[i].number);
                }
                else if(queries[i].parameter.equalsIgnoreCase("P")){
                    // Arrays.sort(arr);
                    // Collections.sort()
                    printPower(arr, queries[i].number);
                }
            }
            // for(int i=0;i<size;i++) System.out.print(arr[i]);
            int startIndex = (size/2) -1;
            for(int i=startIndex; i >= 0;i--){
                heapify(arr, size, i);
            }
            // Arrays.sort(arr);
            // for(int i=0;i<size;i++) System.out.print(arr[i]);
            /*for(int i=0;i<q;i++){
                if(queries[i].parameter.equalsIgnoreCase("P")){
                    printPower(arr, queries[i].number);
                }
            }*/
        }
    }
    public static void incrementAllElements(int[] arr, int number){
        for(int i=0;i<arr.length;i++){
            // arr.set(i, arr.get(i) + number);
            arr[i] += number;
        }
    }
    public static void decrementAllElements(int[] arr, int number){
        for(int i=0;i<arr.length;i++){
            // arr.set(i, arr.get(i) - number);
            arr[i] -= number;
        }
    }
    public static void printPower(int[] arr, int number){
        if(number > arr.length){
            System.out.println("-1");
        }else{
            // Collections.sort(arr);
            // System.out.println(arr[number-1]);
            System.out.println(arr[arr.length - number]);
        }
    }
    public static void heapify(int[] arr, int size, int i){
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;
        if( l < size && arr[l] > arr[largest] ) largest = l;
        if( r < size && arr[r] > arr[largest] ) largest = r;
        if(largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, size, largest);
        }
    }  
    public static int delete(int[] arr, int size){
        int lastElement = arr[size-1];
        arr[0] = lastElement;
        n = n-1;
        heapify(arr, size, i);
    }
}
class Query{
    String parameter;
    int number;
}
}
class Practice102{
	public static void main(String[] args) {
		
	}
}
