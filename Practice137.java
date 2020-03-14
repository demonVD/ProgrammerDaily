// Maximum of all subarrays of size k
import java.util.LinkedList;
import java.util.Deque;
class Practice137{
  public static void main(String[] args) {
    int[] arr = {3, 2, 1, 1, 1, 4};
    // {1, 2, 3, 4, 4, 5, 2, 3, 6};
    int k = 3;
    new Solution().getMax(arr, k);
  }
}
class Solution{
  void getMax(int[] arr, int k)
  {
    Deque<Integer> deque = new LinkedList<Integer>();
    int i=0;
    for(;i<k;i++)
    {
      while( i<k && !deque.isEmpty() && arr[deque.peekLast()] < arr[i])
      {
        deque.removeLast();
      }
      deque.addLast(i);
    }
    for(;i<arr.length;i++)
    {
      System.out.print(arr[deque.peekFirst()]+" ");
      if(deque.peekFirst() < i-k+1)
      {
        deque.removeFirst();
      }
      while( i<arr.length && !deque.isEmpty() && arr[deque.peekLast()] < arr[i])
      {
        deque.removeLast();
      }
      deque.addLast(i);
    }
    System.out.print(arr[deque.peekFirst()]+" ");
  }
}
