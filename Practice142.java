// https://practice.geeksforgeeks.org/problems/final-destination/0
class Point{
  int x, y;
  Point(int x, int y){
    this.x = x;
    this.y = y;
  }
}
class Node{
  Point p;
  int dis;
  Node(Point p, int dis){
    this.p = p;
    this.dis = dis;
  }
}
class Solution{
  public int canReach(long endX, long endY, long steps)
  {
    long dis = Math.abs(endX) + Math.abs(endY);
    if(steps < dis) return 0;
    else{
      if((dis - steps)%2 == 0) return 1;
      else return 0;
    }
  }
}
class Practice142{
  public static void main(String[] args) {
    // int[][] mat = {{1, 1, 1},{1, 1, 1},{1, 1, 1}};
    Solution solution = new Solution();
    System.out.println(solution.canReach(10, 15, 25));
  }
}
