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
    List<TreeNode> roots;
    ArrayList<TreeNode> memo_table[][];
    public List<TreeNode> generateTrees(int n) {
        memo_table = new ArrayList[n+1][n+1];
        generateRootList(n); 
        return memo_table[n][1];
    }
    public void generateRootList(int n) {
        ArrayList<TreeNode> left,right;
        for(int i = 1; i<=n;i++) { // generating the limit 
            for(int j = 1; j<=n-i+1;j++) { // generating the start point
                memo_table[i][j] = new ArrayList<TreeNode>();
                for(int k = j;k<=j+i-1;k++) { // selecting the root in the range
                    left=right=null;
                    if(j != k)
                     left = memo_table[k-j][j];
                    if(k+1 <= j+i-1)
                      right = memo_table[j+i-1-k][k+1];
                    System.out.println(i+" "+j+" "+k+" "+left+" "+right);
                    if( left != null && right!=null) {
                    for(TreeNode node:left) {
                        for(TreeNode node2:right) {
                           TreeNode root = new  TreeNode(k,node,node2);
                            memo_table[i][j].add(root);
                            }
                    }
                    }
                    else if(right!=null) {
                     insertElement(right,memo_table[i][j],k,0);
                    }
                    else if(left != null) {
                        insertElement(left,memo_table[i][j],k,1);
                    }
                    else {               
                        memo_table[i][j].add(new TreeNode(k));
                    }
                }
            }
        }
    }
    public void insertElement(ArrayList<TreeNode> list,ArrayList<TreeNode> list1,int k,int j) {
        TreeNode root;
        int len = list.size();
          for(int i=0;i<len;i++){
              TreeNode node = list.get(i);
                           if(j==0)
                              root = new  TreeNode(k,null,node);
                            else
                              root = new TreeNode(k,node,null);
                            list1.add(root);
                    }
    }
}