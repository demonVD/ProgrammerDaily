//https://practice.geeksforgeeks.org/problems/does-robot-moves-circular/0
class Solution{
  public boolean isCircular(char[] moves){
    // 0 up
    // 1 right
    // 2 down
    // 3 left
    int direction = 0;
    int x = 0, y = 0;
    for(int i=0;i<moves.length;i++){
      if(moves[i] == 'L'){
        direction = (4 + direction - 1)%4;
        // if(direction == 0) direction = 3;
        // else if(direction == 1) direction = 0;
        // else if(direction == 2) direction = 1;
        // else direction = 2;
      }
      else if(moves[i] == 'R'){
        direction = (direction + 1)%4;
        // if(direction == 0) direction = 1;
        // else if(direction == 1) direction = 2;
        // else if(direction == 2) direction = 3;
        // else direction = 0;
      }
      else{
        if(direction == 0){
          y++;
        }
        else if(direction == 1){
          x++;
        }
        else if(direction == 2){
          y--;
        }
        else{
          x--;
        }
      }
    }
    return (x == 0 && y == 0);
  }
}
class Practice176{
  public static void main(String[] args) {
    String s = "GLLG";
    char[] moves = s.toCharArray();
    // {'G','L','G','L','G','L','G'};
    // {'L','G','R','G','R','G','G'};
    Solution solution = new Solution();
    System.out.println(solution.isCircular(moves));
  }
}
