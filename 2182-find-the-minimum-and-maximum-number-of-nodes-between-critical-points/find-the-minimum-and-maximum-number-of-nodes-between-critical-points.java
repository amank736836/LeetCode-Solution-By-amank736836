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
        int[] ans = {-1,-1};
        ListNode pre = head;
        ListNode cur = head.next;
        int prePosition = -1;
        int curPosition = -1;
        int firstPosition = -1;
        int position = 0;
        while(cur.next != null){
            if((cur.val < pre.val && cur.val < cur.next.val) || (cur.val > pre.val && cur.val > cur.next.val)){
                prePosition = curPosition;
                curPosition = position;
                if(firstPosition == -1){
                    firstPosition = position;
                }
                if(prePosition != -1){
                    if(ans[0] == -1){
                        ans[0] = curPosition - prePosition;
                    }else{
                        ans[0] = Math.min(ans[0], curPosition - prePosition);
                    }
                    ans[1] = position - firstPosition;
                }
            }
            position++;
            pre = cur;
            cur = cur.next;
        }
        return ans;
    }
}