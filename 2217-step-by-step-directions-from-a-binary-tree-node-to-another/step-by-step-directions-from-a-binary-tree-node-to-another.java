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

    private boolean find(TreeNode node,int val,StringBuilder str){
        if(node.val == val){
            return true;
        }
        if(node.left != null && find(node.left,val,str)){
            str.append("L");
        }
        else if(node.right != null && find(node.right,val,str)){
            str.append("R");
        }
        return str.length() > 0;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder start = new StringBuilder();
        StringBuilder dest = new StringBuilder();
        find(root,startValue,start);
        find(root,destValue,dest);
        System.out.println(start);
        System.out.println(dest);
        int i = 0;
        int max_i = Math.min(start.length(),dest.length());
        while(i < max_i && start.charAt(start.length() - i - 1) == dest.charAt(dest.length() - i - 1)){
            i++;
        }
        return "U".repeat(start.length() - i) + dest.reverse().toString().substring(i); 
    }
}