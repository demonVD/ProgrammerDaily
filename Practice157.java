// anti diagonal
// https://www.interviewbit.com/problems/anti-diagonals/
import java.util.ArrayList;
class Solution{
  public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
    int length = A.size();
    ArrayList<ArrayList<Integer>> R = new ArrayList<>();
    boolean[][] visited = new boolean[length][length];
    init(visited, length);
    for(int i=0 ;i<length;i++){

      for(int j =0;j<length;j++){
        if(!visited[i][j]){
          ArrayList<Integer> B = new ArrayList<>();
            int x = i, y = j;
            while(x < length && y >= 0 && !visited[x][y]){
              // System.out.println("x : " + x  + " y : " + y);
              B.add(A.get(x).get(y));
              visited[x][y] = true;
              x += 1;
              y -= 1;
            }
            R.add(B);
        }
      }
    }
    return R;
  }
  private void init(boolean[][] visited, int length){
    for(int i=0;i<length;i++){
      for(int j =0;j<length;j++){
        visited[i][j] = false;
      }
    }
  }
  public void display(ArrayList<ArrayList<Integer>> A){
    for(ArrayList<Integer> B : A){
      for(int i : B){
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }
}

class Practice157{
  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> a0 = new ArrayList<>();
    a0.add(1); a0.add(2); a0.add(3);
    A.add(a0);
    ArrayList<Integer> a1 = new ArrayList<>();
    a1.add(4); a1.add(5); a1.add(6);
    A.add(a1);
    ArrayList<Integer> a2 = new ArrayList<>();
    a2.add(7); a2.add(8); a2.add(9);
    A.add(a2);
    Solution solution = new Solution();
    solution.display(solution.diagonal(A));
  }
}
