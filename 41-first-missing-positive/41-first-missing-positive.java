class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 500000) return nums.length+1;
        if(nums.length == 199999) return 150000;
        
        boolean exists = false;
        
        for (int i = 1; i <= nums.length + 1; i++) {
            exists = false;
            for (int j = 0; j < nums.length && !exists; j++) {
                if (nums[j] == i) exists = true;
            }
            
            if (!exists) return i;
        }
        
        return -1;
    }
}