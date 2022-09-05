/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        Node currentNode = root;
        if(root == null) {
            return list;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        Node endOfLevel = root;
        Node item = null;
        ArrayList<Integer> newlist = new ArrayList<Integer>();
        while(!queue.isEmpty()) {
            currentNode = queue.poll();
            newlist.add(currentNode.val);
            for(Node item1:currentNode.children) {
                item = item1;
                queue.add(item);
            }
            if(currentNode == endOfLevel) {
                list.add(newlist);
                newlist = new ArrayList<Integer>();
                endOfLevel = item;
            }
            
        }
        return list;
    }
}