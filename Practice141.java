// Shortest path in a Binary Maze
import java.util.Queue;
import java.util.LinkedList;

class Point{
  int x;
  int y;
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
  private void init(boolean[][] visited){
    for(int i=0;i<visited.length;i++){
      for(int j=0;j<visited[0].length;j++){
        visited[i][j] = false;
      }
    }
  }
  public int getMinDis(int[][] mat, Point source, Point dest)
  {
    int row = mat.length;
    int col = mat[0].length;
    Queue<Node> queue = new LinkedList<>();
    boolean[][] visited = new boolean[row][col];
    init(visited);
    queue.add(new Node(source, 0));
    while(!queue.isEmpty()){
      Node front = queue.poll();
      // System.out.println(front.p.x +" " + front.p.y);
      visited[front.p.x][front.p.y] = true;
      if(front.p.x == dest.x && front.p.y == dest.y) return front.dis;
      if(front.p.x-1 > 0 && front.p.y-1 > 0 && !visited[front.p.x-1][front.p.y-1]){
        queue.add(new Node(new Point(front.p.x-1, front.p.y-1), front.dis+1));
      }
      if(front.p.x-1 > 0 && front.p.y > 0 && !visited[front.p.x-1][front.p.y]){
        queue.add(new Node(new Point(front.p.x-1, front.p.y), front.dis+1));
      }
      if(front.p.x-1 > 0 && front.p.y+1 < col && !visited[front.p.x-1][front.p.y+1]){
        queue.add(new Node(new Point(front.p.x-1, front.p.y+1), front.dis+1));
      }
      if(front.p.x > 0 && front.p.y-1 > 0 && !visited[front.p.x][front.p.y-1]){
        queue.add(new Node(new Point(front.p.x, front.p.y-1), front.dis+1));
      }
      if(front.p.x > 0 && front.p.y+1 < col && !visited[front.p.x][front.p.y+1]){
        queue.add(new Node(new Point(front.p.x, front.p.y+1), front.dis+1));
      }
      if(front.p.x+1 < row && front.p.y-1 > 0 && !visited[front.p.x][front.p.y-1]){
        queue.add(new Node(new Point(front.p.x+1, front.p.y-1), front.dis+1));
      }
      if(front.p.x+1 < row && front.p.y > 0 && !visited[front.p.x+1][front.p.y]){
        queue.add(new Node(new Point(front.p.x+1, front.p.y), front.dis+1));
      }
      if(front.p.x+1 < row && front.p.y+1 < col && !visited[front.p.x+1][front.p.y+1]){
        queue.add(new Node(new Point(front.p.x+1, front.p.y+1), front.dis+1));
      }
    }
    return -1;
  }
}
class Practice141{
  public static void main(String[] args) {
    int[][] mat = {{1, 1, 1},{1, 1, 1},{1, 1, 1}};
    // {{1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                  // {1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                  // {1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                  // {0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                  // {1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                  // {1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                  // {1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                  // {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                  // {1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};
    Point source = new Point(0,0);
    Point dest = new Point(1, 1);
    Solution solution = new Solution();
    System.out.println(solution.getMinDis(mat, source, dest));
  }
}
