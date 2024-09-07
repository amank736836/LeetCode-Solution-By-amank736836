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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;
        
        // Check if the current root matches the list, or check left/right subtrees
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    // Helper method to check if a path starting at the current tree node matches the linked list
    private boolean dfs(ListNode head, TreeNode node) {
        // If we've reached the end of the linked list, return true
        if (head == null) return true;
        // If the tree node is null or the values don't match, return false
        if (node == null || head.val != node.val) return false;
        
        // Check the next node in the list with the left and right children of the current tree node
        return dfs(head.next, node.left) || dfs(head.next, node.right);
    }
}