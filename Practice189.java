// Rotate a LinkedList
class Solution{
	public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
		ListNode temp = head;
        int length = findLength(temp);
        k = k % length;
        if(k == 0) return head;
        k--;
        // System.out.println(length);
        // System.out.println(k);
        int count = 0;
        ListNode kPtr = null;
        while(temp.next != null){
        	if(count == k){
        		kPtr = head;
        	}else{
                if(kPtr != null) kPtr = kPtr.next; 
            }
            // prev = temp;
        	temp = temp.next;
        	count++;
        }
        temp.next = head;
        head = kPtr.next;
        kPtr.next = null;
        return head;
    }
    private int findLength(ListNode head){
    	ListNode temp = head;
    	int count = 0;
    	while(temp != null){
    		count++;
    		temp = temp.next;
    	}
    	return count;
    }
    public void display(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
class Practice189{
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
  //       head.next.next.next = new ListNode(4);
  //       head.next.next.next.next = new ListNode(5);
		Solution solution = new Solution();
		solution.display(solution.rotateRight(head, 4));
	}
}
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}