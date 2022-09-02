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
    public List<Double> averageOfLevels(TreeNode root) {
        TreeNode currentNode = root;
        TreeNode end = root;
        TreeNode lastadded = null;
        int c = 0;
        boolean flag = true;
        List<Double> list = new ArrayList<Double>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(end);
        list.add(end.val*1.0);
        double sum = 0;
        while(!queue.isEmpty()) {
            currentNode = queue.poll();
            if(currentNode.left != null) {
                lastadded = currentNode.left;
                sum+=lastadded.val;
                queue.add(lastadded);
                c++;
            }
            if(currentNode.right != null) {
                lastadded = currentNode.right;
                sum+=lastadded.val;
                queue.add(lastadded);
                c++;
            }
            if(currentNode == end && c!=0) {
                list.add(sum*1.0/c);
                c = 0;
                sum = 0;
                end = lastadded;
            }
        }
        return list;
    }
}