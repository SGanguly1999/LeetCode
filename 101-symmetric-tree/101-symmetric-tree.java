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
    boolean res = true;
    public boolean isSymmetric(TreeNode root) {
        isSymmetric(root.left,root.right);
        return res;
    }
    public void isSymmetric(TreeNode root1 , TreeNode root2) {
        if(!res)
            return;
        boolean flag = check(root1,root2);
        if(flag){
            if(root1 != null) {
            isSymmetric(root1.right,root2.left);
            isSymmetric(root1.left,root2.right);
            }
        }
        else
          res = false;
    }
    public boolean check(TreeNode node1,TreeNode node2) {
        if(node1 == null && node2 == null)
            return true;
        if((node1 != null && node2 == null ) || (node1 == null && node2 != null))
            return false;
        if(node1.val != node2.val)
            return false;
        return true;
    }
}