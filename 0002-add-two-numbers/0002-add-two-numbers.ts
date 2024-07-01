/**
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */

function addTwoNumbers(l1: ListNode | null, l2: ListNode | null): ListNode | null {
    let dummyHead = new ListNode(0);
    let currentNode = dummyHead;
    let carry = 0;

    while (l1 || l2) {
        const val1 = l1 ? l1.val : 0;
        const val2 = l2 
        ? l2.val : 0;

        const sum = val1 + val2 + carry;
        carry = Math.floor(sum / 10);

        currentNode.next = new ListNode(sum % 10);
        currentNode = currentNode.next;

        if (l1) l1 = l1.next;
        if (l2) l2 = l2.next;
    }

    if (carry > 0) {
        currentNode.next = new ListNode(carry);
    }

    return dummyHead.next;
};