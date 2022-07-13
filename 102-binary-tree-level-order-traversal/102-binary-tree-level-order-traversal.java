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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int nodes_cu_level = 1;
        int nodes_nxt_level = 0;
        boolean flag = true;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<Integer>();
        if(root == null)
            return result;
        while(!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            list.add(currentNode.val);
            nodes_cu_level--;
            if(nodes_cu_level == 0)
                flag = true;
            if(currentNode.left != null) {
                queue.add(currentNode.left);
                nodes_nxt_level++;
            }
            if(currentNode.right != null) {
                queue.add(currentNode.right);
                nodes_nxt_level++;
            }
            if(flag) {
                nodes_cu_level = nodes_nxt_level;
                nodes_nxt_level = 0;
                result.add(list);
                list = new ArrayList<Integer>();
                flag = false;
            }
            
        }
        return result;
    }
}