package tests;

 //Definition for singly-linked list.
 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }

class Solution6 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null){
            return null;
        }
        ListNode slow = null;
        ListNode fast =head;
        for(int i=1;i<m;++i){//find first node and node begin head node
            slow = fast;
            fast = fast.next;
        }
        ListNode fore =fast;
        ListNode p1 = fast.next;//fore end at n
        int reveredNum = 0;//reveredNum<n-m
        while(reveredNum<n-m){
            ListNode temp = p1.next;
            p1.next = fore;
            fore = p1;
            p1 = temp;
            ++reveredNum;
        }
        if(slow==null){
            fast.next = p1;
            return fore;
        }
        slow.next = fore;
        fast.next = p1;
        return head;
    }
}
public class Leet92 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        for (int i=2;i<=10;++i){
            ListNode temp = new ListNode(i);
            p.next = temp;
            p = p.next;
        }
        Solution6 s = new Solution6();
        ListNode x1= s.reverseBetween(head,1,4);

        while(x1!=null){
            System.out.println(x1.val);
            x1 = x1.next;
        }
    }


}
