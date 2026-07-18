/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode d= new ListNode(0);
        d.next=head;
        ListNode p=d;
        while(true){
            ListNode kth=p;
            for(int i =0;i<k && kth!=null;i++){
                kth=kth.next;
            }
            if(kth==null){
                break;
            }
            ListNode n=kth.next;
            ListNode prev=n;
            ListNode cur=p.next;
                        while (cur != n) {
                ListNode t = cur.next;
                cur.next = prev;
                prev = cur;
                cur = t;
            }

            ListNode s = p.next;
        
            p.next = kth;
            p=s;
        }
        return d.next;
    }
}