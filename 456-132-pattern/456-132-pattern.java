class Solution {
    public boolean find132pattern(int[] nums) {
        int stack[] = new int[200001];
        int pointer = -1;
        int min[] = new int[nums.length];
        min[0]=nums[0];
        for(int i = 1; i < nums.length; i++)
            min[i] = Math.min(min[i-1],nums[i]);
        for(int i = nums.length-1; i >= 0;i--) {
            while(pointer!=-1 && stack[pointer] <= min[i])
                pointer--;
            if(pointer!=-1 && stack[pointer] > min[i] && stack[pointer] < nums[i])
                return true;
            else
                stack[++pointer]=nums[i];
        }
        return false;
    }
    
}