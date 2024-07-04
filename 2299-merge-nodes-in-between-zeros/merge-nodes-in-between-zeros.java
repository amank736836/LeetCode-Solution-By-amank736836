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
    public ListNode mergeNodes(ListNode head) {
        ListNode temp = new ListNode();
        ListNode cur = temp;
        head = head.next;
        int sum = 0;
        while(head!=null){
            if(head.val == 0){
                cur.next = head;
                head.val = sum;
                cur = cur.next;
                sum = 0;
            }else{
                sum += head.val;
            }
            head = head.next;
        }
        return temp.next;
    }
}