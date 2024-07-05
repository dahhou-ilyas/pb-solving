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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] result=new int[2];
        ListNode curr=head;
        List<Integer> criticalIndex=new ArrayList<>();
        List<ListNode> nodes=new ArrayList<>();
        while(curr!=null){
            nodes.add(curr);
            curr=curr.next;
        }
        for (int i=1;i<nodes.size()-1;i++){
            if((nodes.get(i).val<nodes.get(i-1).val && nodes.get(i).val<nodes.get(i+1).val) || (nodes.get(i).val>nodes.get(i-1).val && nodes.get(i).val>nodes.get(i+1).val)){
                criticalIndex.add(i);
                if (criticalIndex.size()==2){
                    result[0]=Math.abs(criticalIndex.get(0)-criticalIndex.get(1));
                }
            }
        }
        if (criticalIndex.size()<2){
            return new int[]{-1,-1};
        }
        if (criticalIndex.size()==2){
            result[1]=result[0];
            return result;
        }
        
        return getMaxMinDifference(criticalIndex);
    }

    public static int[] getMaxMinDifference(List<Integer> nums) {
        if (nums.size() < 2) {
            throw new IllegalArgumentException("La liste doit contenir au moins deux éléments");
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> uniqueNums = new HashSet<>();

        for (int num : nums) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
            uniqueNums.add(num);
        }

        if (uniqueNums.size() == 1) {
            return new int[]{0, 0}; // Tous les éléments sont identiques
        }

        int minDiff = Integer.MAX_VALUE;
        int previous = Integer.MAX_VALUE;

        for (int num : uniqueNums) {
            if (previous != Integer.MAX_VALUE) {
                int diff = Math.abs(num - previous);
                if (diff < minDiff) {
                    minDiff = diff;
                }
            }
            previous = num;
        }

        return new int[]{minDiff,max - min };
    }
}