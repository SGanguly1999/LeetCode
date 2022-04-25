class Trie {
    static Trie root;
    Trie arr[] = new Trie[2];
    boolean isEnd = false;
    public Trie() {
    }
    public int insert(int num,int bits,int max) {
        int length = bits;
        int  no = 1 << bits;
        Trie currentNode = this;
        Trie searchMaxSum = this;
        int max_sum = 0;
        int ind = 0;
        for(int i=0;i<bits+1;i++) {
            int val = num & (no >> i);
            if(val>0)
                ind = 1;
            else
                ind = 0;
            if(currentNode.arr[ind] == null) {
                currentNode.arr[ind] = new Trie();
            }
            currentNode = currentNode.arr[ind];
            if(searchMaxSum.arr[1 - ind] !=null) {
                max_sum^=no>>i;
                searchMaxSum = searchMaxSum.arr[1-ind];
            }
            else
                searchMaxSum = searchMaxSum.arr[ind];
            
        }
        currentNode.isEnd = true;
        if(max < max_sum)
            return max_sum;
        return max;
    }
}
class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie root = new Trie();
        int max = 0;
        for(int i=0;i<nums.length;i++){
         if(nums[i] > max)
             max = nums[i];
        }
        int no_bits = (int)(Math.log(max)/Math.log(2));
        max = 1<<no_bits;
        int max_sum = 0;
        for(int i=0;i<nums.length;i++) {
            max_sum = root.insert(nums[i],no_bits,max_sum);
        }
        System.out.println(max_sum);
        return max_sum;
        }
    }