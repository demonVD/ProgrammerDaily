// LeetCode P21 Merge Two Sorted Lists
class ListNode{
  int data;
  ListNode next;
  ListNode(int data){
    this.data = data;
    this.next = null;
  }
}
class Solution{
  public void display(ListNode head){
    while(head!=null){
      System.out.print(head.data+" ");
      head = head.next;
    }
  }
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
    return l3.next;
  }
}
class Practice12{
  public static void main(String[] args) {
    // ListNode l1 = new ListNode(1);
    // l1.next = new ListNode(2);
    // l1.next.next = new ListNode(4);
    ListNode l1 = null;
    // ListNode l2 = new ListNode(1);
    // l2.next = new ListNode(3);
    // l2.next.next = new ListNode(4);
    // l2.next.next.next = new ListNode(5);
    ListNode l2 = null;
    Solution solution = new Solution();
    solution.display(solution.mergeTwoLists(l1, l2));
  }
}
