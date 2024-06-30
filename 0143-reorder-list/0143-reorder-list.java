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
    public void reorderList(ListNode head) {
        List<ListNode> arr=new ArrayList<>();

        ListNode pointer=head;
        while (pointer!=null){
            arr.add(pointer);
            pointer=pointer.next;
        }

        int right=arr.size()-1;
        int left=0;

        while (left<right){
            arr.get(left).next=arr.get(right);
            left=left+1;
            arr.get(right).next=arr.get(left);
            right=right-1;
        }
        arr.get(left).next = null;
    }
}