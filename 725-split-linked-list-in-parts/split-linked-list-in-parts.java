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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];

        ListNode current = head;
        int count = 0;
        while(current != null){
            count++;
            current = current.next;
        }

        int equal = count / k;
        int extra = count % k;

        current = head;
        ListNode prev = current;

        for(int i=0;i<k;i++){
            int size = equal;
            if(extra > 0){
                extra--;
                size++;
            }

            ListNode newHead = current;
            int j=0;
            while(j < size){
                prev = current;
                current = current.next;
                j++;
            }

            if(prev != null){
                prev.next = null;
            }
            
            ans[i] = newHead;
        }

        return ans;
    }
}