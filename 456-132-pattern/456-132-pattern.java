class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        int min[] = new int[nums.length];
        min[0]=nums[0];
        for(int i = 1; i < nums.length; i++)
            min[i] = Math.min(min[i-1],nums[i]);
        for(int i = nums.length-1; i >= 0;i--) {
            while(!stack.isEmpty() && stack.peek() <= min[i])
                stack.pop();
            if(!stack.isEmpty() && stack.peek() > min[i] && stack.peek() < nums[i])
                return true;
            else
                stack.push(nums[i]);
        }
        return false;
    }
    
}