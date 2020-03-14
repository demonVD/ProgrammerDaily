// Repeat and Missing Number Array
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class Solution{
  public ArrayList<Integer> repeatedNumber(final List<Integer> A){
    int length = A.size();
    int indexXOR = 0;
    int elementXOR = 0;
    for(int i = 0; i < length; i++){
      indexXOR ^= (i+1);
      elementXOR ^= A.get(i);
    }
    int indexElementXOR = indexXOR ^ elementXOR;
    // System.out.println(indexElementXOR);
    int rsb = indexElementXOR & (~indexElementXOR + 1); // RIGHTMOST SET BIT
    // System.out.println(rsb);
    int setrsb = 0;
    int unsetrsb = 0;
    for(int i = 0; i < length; i++){
        // System.out.print(" E : " + (A.get(i) & rsb) + " ");
      if((A.get(i) & rsb) == rsb){
        // System.out.println(" SET : " + A.get(i) + " ");
        setrsb ^= A.get(i);
      }
      else{
        // System.out.println(" UNSET : " + A.get(i) + " ");
        unsetrsb ^= A.get(i);
      }
      if(((i+1) & rsb) == rsb){
        // System.out.println(" SET Index : " + (i+1) + " ");
        setrsb ^= (i+1);
      }
      else{
        // System.out.println(" UNSET Index : " + (i+1) + " ");
        unsetrsb ^= (i+1);
      }
    }
    // System.out.println(setrsb + " " + unsetrsb);
    ArrayList<Integer> B = new ArrayList<Integer>();
    for(int i = 0; i < length; i++){
      if(A.get(i) == setrsb){
        B.add(setrsb);
        B.add(unsetrsb);
        break;
      }else if(A.get(i) == unsetrsb){
        B.add(unsetrsb);
        B.add(setrsb);
        break;
      }
    }
    return B;
  }
  public void display(ArrayList<Integer> A){
    for(int i = 0; i < A.size(); i++){
      System.out.print(A.get(i) + " ");
    }
  }
}
class Practice148{
  public static void main(String[] args) {
    Integer[] array = {3, 1, 2, 4, 3};
    final List<Integer> A = Arrays.asList(array);
    Solution solution = new Solution();
    solution.display(solution.repeatedNumber(A));
  }
}
