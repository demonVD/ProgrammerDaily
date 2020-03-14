// https://practice.geeksforgeeks.org/problems/shortest-source-to-destination-path/0/
import java.util.Queue;
import java.util.LinkedList;
class Point{
  int x, y;
  Point(int x, int y){
    this.x = x;
    this.y = y;
  }
}
class Node{
  Point point;
  int dis;
  Node(Point p, int dis){
    this.point = point;
    this.dis = dis;
  }
}
class Solution{
  private void init(boolean[][] visited, int[][] mat){
    for(int i=0;i<visited.length;i++){
      for(int j=0;j<visited[0].length;j++){
        visited[i][j] = false;
        if(mat[i][j] == 0) visited[i][j] = true;
      }
    }
  }
  public int minSteps(int[][] mat, Point dest){
    int row = mat.length;
    int col = mat[0].length;
    Queue<Node> queue = new LinkedList<>();
    boolean[][] visited = new boolean[row][col];
    init(visited, mat);
    Point source = new Point(0,0);
    queue.add(new Node(source, 0));
    while(!queue.isEmpty()){
      System.out.println(queue.size());
      Node front = queue.poll();
      System.out.println("HAHA");
      // System.out.println(front);
      // System.out.println(front.point.x);
      // System.out.println(front.point.y);
      visited[front.point.x][front.point.y] = true;
      System.out.println("HAHA");
      if(front.point.x == dest.x && front.point.y == dest.y) return front.dis;
      if(front.point.y+1 < col && !visited[front.point.x][front.point.y+1]){
        queue.add(new Node(new Point(front.point.x, front.point.y+1), front.dis + 1));
      }
      if(front.point.x+1 < row && !visited[front.point.x+1][front.point.y]){
        queue.add(new Node(new Point(front.point.x+1, front.point.y), front.dis + 1));
      }
      if(front.point.y-1 > 0 && !visited[front.point.x][front.point.y-1]){
        queue.add(new Node(new Point(front.point.x, front.point.y-1), front.dis + 1));
      }
      if(front.point.x-1 > 0 && !visited[front.point.x-1][front.point.y]){
        queue.add(new Node(new Point(front.point.x-1, front.point.y), front.dis + 1));
      }
    }
    return -1;
  }
}
class Practice143{
  public static void main(String[] args) {
    int[][] mat = {{1, 0, 1},{1, 1, 1},{0, 1, 1}};
    Point dest = new Point(2, 2);
    Solution solution = new Solution();
    System.out.println(solution.minSteps(mat, dest));
  }
}
