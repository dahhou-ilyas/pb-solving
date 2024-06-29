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
    public int getDecimalValue(ListNode head) {
        int acc=0;
        int result=0;
        while (head!=null){
            result=acc*2+head.val;
            acc=result;
            head=head.next;
        }
        return result;
    }
}