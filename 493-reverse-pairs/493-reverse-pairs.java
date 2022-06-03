class Trie {
    int count[] = new int[2];
    Trie next[] = new Trie[2];
    int max=Integer.MIN_VALUE;
    int min = 2;
    public int insertp(int bits,int num) {
        int mask = 1 << bits;
        long num2 = (long)num << 1;
        Trie nextNode = this;
        Trie nextNode2 = this;
        int total = 0;
        boolean flag = true;
        if(num2 > this.max)
            flag = false;
        this.max = Math.max(this.max,num);
        for(int i = 0;i<bits+1;i++) {
            int digit = ((num & (mask>>i)) == 0)?0:1;
            if(flag) {
            int digit2 = ((num2 & (mask>>i)) == 0)?0:1;
            if(digit2 == 0) {
                total+=nextNode2.count[1];
            }
            nextNode2 = nextNode2.next[digit2];
            if(nextNode2 == null)
                flag = false;
            }
            if(nextNode.next[digit] == null)
                nextNode.next[digit] = new Trie();
            nextNode.count[digit]++;
           //System.out.println(num+" "+nextNode.count[digit]+" "+digit);
            nextNode = nextNode.next[digit];
        }
        //System.out.println("Done");
        return total;
    }
    public int insertneg(int bits,int num) {
        int mask = 1 << bits;
        long num2 = (long)(-num) << 1;
        Trie nextNode = this;
        Trie nextNode2 = this;
        int total = 0;
        boolean flag = true;
        if(-num2 > this.max || -num2 < min)
            flag = false;
        this.min = Math.min(this.min,num);
        this.max = Math.max(this.max,num);
        for(int i = 0;i<bits+1;i++) {
            int digit = ((-num & (mask>>i)) == 0)?0:1;
            if(flag) {
            int digit2 = ((num2 & (mask>>i)) == 0)?0:1;
            if(digit2 == 1){
                total+=nextNode2.count[0];
                System.out.println(total);
            }
            nextNode2 = nextNode2.next[digit2];
            if(nextNode2 == null)
                flag = false;
            }
            if(nextNode.next[digit] == null)
                nextNode.next[digit] = new Trie();
            nextNode.count[digit]++;
            //System.out.println(num+" "+nextNode.count[digit]+" "+digit);
            nextNode = nextNode.next[digit];
        }
        if(-num2 < min)
            return (this.count[0]+this.count[1]-1);
        return total;
    }
}
class Solution {
    public int reversePairs(int[] nums) {
        Trie pos = new Trie();
        Trie neg = new Trie();
        int total = 0;
        int max = 0;
        int min = 0;
        for(int i =0;i<nums.length;i++) {
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[i]);
        }
        int bitpos = (int)(Math.log(max)/Math.log(2));
        int bitneg = (int)(Math.log(-min)/Math.log(2));
        for(int i= 0;i<nums.length;i++){
            if(nums[i] >=0)
                total+=pos.insertp(bitpos,nums[i]);
            else
                total+=pos.count[0]+pos.count[1]+neg.insertneg(bitneg,nums[i]);
            
        }
        return total;
        
    }
}