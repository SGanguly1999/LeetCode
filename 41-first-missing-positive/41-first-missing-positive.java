class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0;i<nums.length;i++) {
            if(nums[i]>nums.length || nums[i] <= 0)
                continue;
            int index = i;
            int num = nums[index];
            while(num != index+1) {
               int new_ind = num - 1;
                int store = nums[new_ind];
                nums[new_ind] = num;
                num = store;
                index = new_ind;
                if(num > nums.length || num <= 0)
                    break;
            }
        }
        for(int i = 0; i < nums.length;i++) {
            if(nums[i] != i+1)
                return i+1;
        }
        return nums.length+1;
        
}
}