// LeetCode P23 Merge k Sorted Lists
class ListNode{
  int data;
  ListNode next;
  ListNode(int data){
    this.data = data;
    this.next = null;
  }
}
class Solution{
  // public ListNode mergeKLists(ListNode[] lists) {
  //   // int start = 0;
  //   int last = lists.length - 1;
  //   ListNode l1 = new ListNode(0);
  //   l1.next = mergeKListsUtil(ListNode[] lists, last);
  //   return l1;
  // }

  public ListNode mergeKLists(ListNode[] lists){
    if(lists.length == 0) return null;
    int length = lists.length;
    while((length -1) != 0){
      // System.out.println(length);
      int start = 0;
      int last = length - 1;
      while(start < last){
        lists[start] = merge2Lists(lists[start], lists[last]);
        // lists[last] = null;
        start++;
        last--;
      }
      length = last+1;
    }
    return lists[0];
  }
  private ListNode merge2Lists(ListNode l1, ListNode l2) {
    // ListNode temp = null;
    ListNode temp = new ListNode(0);
    ListNode l3 = temp;
    while(l1 != null && l2 != null){
      if(l1.data <= l2.data) {
        temp.next = l1;
        l1 = l1.next;
      }
      else {
        temp.next = l2;
        l2 = l2.next;
      }
      temp = temp.next;
    }
    if(l1 != null) {
      temp.next = l1;
    }
    else{
      temp.next = l2;
    }
    // display(l3.next);
    // System.out.println();
    return l3.next;
  }
  public void display(ListNode node){
    while(node!=null){
      System.out.print(node.data + " ");
      node = node.next;
    }
  }
}
class Practice13{
  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(2);
    l1.next.next = new ListNode(4);
    ListNode l2 = new ListNode(-1);
    l2.next = new ListNode(4);
    l2.next.next = new ListNode(5);
    l2.next.next.next = new ListNode(5);
    ListNode l3 = new ListNode(1);
    l3.next = new ListNode(4);
    l3.next.next = new ListNode(6);
    // ListNode l4 = new ListNode(4);
    // l4.next = new ListNode(5);
    // l4.next.next = new ListNode(6);
    Solution solution = new Solution();
    solution.display(solution.mergeKLists(new ListNode[]{l1, l2, l3}));
    // [[],[-1,5],[1,4,6],[4,5,6]]
    // [[1, 2, 4], [-1, 4, 5, 5], [1, 4, 6]]
  }
}
