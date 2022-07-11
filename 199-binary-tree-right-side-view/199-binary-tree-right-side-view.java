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
    public List<Integer> rightSideView(TreeNode root) {
        int no_ele_level = 1;
        int no_ele_nextl = 0;
        boolean flag = true;
       Queue<TreeNode> queue = new LinkedList<TreeNode>();
       List<Integer> list = new LinkedList<Integer>();
       if(root == null)
           return list;
       queue.add(root);
       while(!queue.isEmpty()) {
           TreeNode currentNode = queue.poll();
           no_ele_level--;
           if(flag) {
                flag = false;
            list.add(currentNode.val);
           }
           if(currentNode.right != null) {
               queue.add(currentNode.right);
               no_ele_nextl++;
           }
           if(currentNode.left != null) {
               queue.add(currentNode.left);
               no_ele_nextl++;
           }
           if(no_ele_level == 0){
               flag = true;
               no_ele_level = no_ele_nextl;
               no_ele_nextl = 0;
           }
       }
        return list;
    }
}