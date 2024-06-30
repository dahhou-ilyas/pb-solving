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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count=0;
        ListNode pointer=head;
        while (pointer != null){
            count++;
            pointer=pointer.next;
        }
        int position=count-n;
        ListNode pointer3=null;
        ListNode pointer4=null;
        int i=0;
        ListNode pointer2 =head;
        while (pointer2 != null){
            if(position-1 == i){
                pointer3=pointer2;
            }
            if (position+1==i){
                pointer4=pointer2;
            }
            i++;
            pointer2=pointer2.next;
        }
        if(pointer3==null){
            return head.next;
        }

        pointer3.next=pointer4;
        return head;
    }
}