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
    int count = 0;
    boolean flag = false;
    public int countNodes(TreeNode root) {
        int level = -1;
        int level1 = -1;
        TreeNode current = root;
        TreeNode current1 = root;
        if(root == null)
            return 0;
        while(current!=null) {
            current = current.left;
            if(current1 != null) {
                level1++;
                current1 = current1.right;
            }  
            level++;
        }
        
        int value = (1 << (level+1)) - 1;
        if(level1 != level)
        missingNodes(root,level,-1);
        return value - count;
        
    }
    public void missingNodes(TreeNode root,int level,int cu_level) {
        if(flag)
            return;
        cu_level++;
        if(level-1 == cu_level) {
            count++;
            System.out.println(count+" "+root.val+" "+level);
        if(root.right!=null) {
            count = 2 * (count-1);
            flag = true;
        }
        else if(root.left!=null) {
            count = 2 * count - 1;
            flag = true;
        }
        }
        if(!flag && root.right!=null)
         missingNodes(root.right,level,cu_level);
        if(!flag && root.left!=null)
         missingNodes(root.left,level,cu_level);
    }
}