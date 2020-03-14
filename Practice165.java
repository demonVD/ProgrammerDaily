// Given a list of non negative integers, arrange them such that they form the largest number.
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
// class Solution{
//   public String getLargestNumber(final List<Integer> A){
//     Integer[] B = A.toArray(Integer.class);
//     getLargestNumberHelper(A, 0, A.size()-1);
//     StringBuilder str = new StringBuilder();
//     for(int i : B){
//       str.append(i + "");
//     }
//     return str.toString();
//   }
//   private void getLargestNumberHelper(Integer[] A, int low, int high){
//     if(low < high){
//       int mid = low + (high - low)/2;
//       getLargestNumberHelper(A, low, mid);
//       getLargestNumberHelper(A, mid + 1, high);
//       sort(A, low, mid, high);
//     }
//   }
//   private void sort(Integer[] A, int low, int mid, int high){
//     int i = low, j = mid + 1, k = low;
//     int l1 = mid - low + 1;
//     int l2 = high - (mid + 1) + 1;
//     int[] arr1 = new int[l1];
//     int[] arr2 = new int[l2];
//     int[] arr3 = new int[l1 + l2];
//     for(int i = low; i < l1; i++){
//       arr1[i] = A[i];
//     }
//     for(int i = mid + 1; i < l2; i++){
//       arr2[i] = A[i];
//     }
//     while(i < l1 && j < l2){
//       // String s1 = A.get(i) + "" + A.get(j);
//       // String s2 = A.get(j) + "" + A.get(i);
//       String s1 = A[i] + "" + A[j];
//       String s2 = A[j] + "" + A[i];
//       int n1 = Integer.parseInt(s1);
//       int n2 = Integer.parseInt(s2);
//       if(n1 > n2){
//         i++;
//       }
//       else{
//         // swap(A, k, j);
//
//       }
//       k++;
//     }
//     /*while(i <= mid){
//       k++;
//     }
//     while(j <= high){
//       k++;
//     }*/
//   }
//   private void swap(final List<Integer> A, int k, int j){
//     int temp = A.get(k);
//     A.set(k, A.get(j));
//     A.set(j, temp);
//   }
// }
class Solution2{
  public String getLargestNumber(final List<Integer> A){
    Integer[] arr = new Integer[A.size()];
    arr = A.toArray(arr);
    Arrays.sort(arr, (Integer x, Integer y) -> {
      String s1 = x + "" + y;
      String s2 = y + "" + x;
      Integer n1 = Integer.parseInt(s1);
      Integer n2 = Integer.parseInt(s2);
      if(n1 > n2){
        return -1;
      }
      if(n1 < n2){
        return 1;
      }
      return 0;
    });
    StringBuilder str = new StringBuilder();
    for(int i : arr){
      str.append(i + "");
    }
    return str.toString();
  }
}
class Practice165{
  public static void main(String[] args){
    final List<Integer> A = new ArrayList<Integer>();
    // A.add(98);A.add(9);A.add(9);A.add(31);A.add(4);
    A.add(3);A.add(30);A.add(34);A.add(5);A.add(9);
    Solution2 solution = new Solution2();
    System.out.println(solution.getLargestNumber(A));;
  }
}
