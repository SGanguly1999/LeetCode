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
    public int deepestLeavesSum(TreeNode root) {
      Queue<TreeNode> queue = new LinkedList<TreeNode>();
      TreeNode end = root;
      TreeNode end1 = null;
      int prev_sum = 0; 
      int sum = 0;
      queue.add(root); 
      while(!queue.isEmpty()) {
          TreeNode ele = queue.poll();
          sum+=ele.val;
          TreeNode left = ele.left;
          TreeNode right = ele.right;
          if(left != null) {
              queue.add(left);
              end1 = left;
          }
          if(right!=null) {
              queue.add(right);
              end1= right;
          }
          if(ele == end) {
              prev_sum = sum;
              sum = 0;
              end = end1;
          }
      }
        return prev_sum;
    }
}