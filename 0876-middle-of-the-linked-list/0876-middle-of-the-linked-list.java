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
    public ListNode middleNode(ListNode head) {
        ListNode node=head;

        int count =0;
        while (node!=null){
            count=count+1;
            node=node.next;
        }
        int i=0;
        if(count%2!=0){
            count=(count/2);
            while (head!=null){
                if(i==count){
                    break;
                }
                head=head.next;
                i++;
            }
        }else {
            count=(count/2);
            while (head!=null){
                if(i==count){
                    break;
                }
                head=head.next;
                i++;
            }
        }
        return head; 
        
    }
}