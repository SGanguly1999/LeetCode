class Solution {
    public int firstMissingPositive(int[] nums) {
        int i;
        for( i  = 0; i < nums.length; i++) {
            if(nums[i] <= 0)
                nums[i] = (nums.length+1);
        }
        for(i = 0;i< nums.length;i++) {
            int val = Math.abs(nums[i]);
            if(val-1 < nums.length && nums[val-1] > 0)
                nums[val-1]*=-1;
        }
        for(i = 0; i < nums.length;i++) {
            if(nums[i] > 0)
                return i+1;
        }
        return nums.length + 1;
}
}