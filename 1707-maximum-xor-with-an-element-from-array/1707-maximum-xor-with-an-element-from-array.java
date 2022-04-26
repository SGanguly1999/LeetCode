class Trie {
    Trie arr[] = new Trie[2];
    boolean flag = false;
    int min1 = Integer.MAX_VALUE;
    int min0 = Integer.MAX_VALUE;
    public void insert(int num,int bits) {
        int mask = 1 << bits;
        Trie root = this;
        Trie currentNode = root;
        int ind = 0;
        for(int i = 0; i < bits + 1; i++){
            int val = num & (mask >> i);
            if(val > 0) {
                ind = 1;
                currentNode.min1 = Math.min(num,currentNode.min1);
            }
            else {
                ind = 0;
                currentNode.min0 = Math.min(num,currentNode.min0);
            }
            if(currentNode.arr[ind] == null)
                currentNode.arr[ind] = new Trie();
            currentNode = currentNode.arr[ind];
        }
        currentNode.flag = true;
    }
    public int findMaxXor(int num,int bits, int limit) {
        Trie root = this;
        Trie currentNode = root;
        int mask = 1 << bits;
        int max_sum = num & ~((mask << 1)-1);
        int ind = 0;
        int numo = 0;
        int chosen = 0;
        boolean flag = false;
        for(int i = 0; i < bits + 1; i++){
            int val = num & (mask >> i);
            if(val > 0)
                ind = 1;
            else
                ind = 0;
            if(currentNode.arr[1-ind] != null && ind == 1 && currentNode.min0 <= limit) {
                max_sum ^= mask >> i;
                currentNode = currentNode.arr[1 - ind];
                chosen = 0;
            }
            else if(currentNode.arr[1] != null && ind == 0 && currentNode.min1 <= limit){  
                max_sum ^= mask >> i;
                currentNode = currentNode.arr[1 - ind];
                numo|=mask >> i;
                chosen = 1;
            }
            else if(currentNode.arr[ind] != null && ind == 0 && currentNode.min0 <=limit) {
                 currentNode = currentNode.arr[ind];
                chosen = 0;
            }
            else if(currentNode.arr[ind] != null && ind == 1 && currentNode.min1 <= limit) {
                 currentNode = currentNode.arr[ind];
                 numo|=mask >> i;
                chosen = 1;
            }
           else {
               return -1;
           }
        }
        return max_sum;
    }
}
class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Trie root = new Trie();
        int result[] = new int[queries.length];
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(max < nums[i])
                max = nums[i];
        }
        int bits = (int)(Math.log(max)/Math.log(2));
        for(int i = 0; i< nums.length;i++){
            root.insert(nums[i],bits);
        }
        for(int i = 0; i < queries.length; i++){
            int x = queries[i][0];
            int limit = queries[i][1];
            result[i] = root.findMaxXor(x,bits,limit);
        }
        return result;
    }
}