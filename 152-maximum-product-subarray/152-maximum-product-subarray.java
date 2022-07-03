class Solution {
    public int maxProduct(int[] nums) {
       int a[] = new int[nums.length];
       int min[] = new int[nums.length];
        a[0]=nums[0];
        int max = a[0];
        min[0]=nums[0];
       // System.out.println(a[0]+" "+min[0]);
        for(int i = 1; i < nums.length; i++) {
           if(a[i-1]*nums[i] >= a[i-1] && a[i-1]*nums[i]>nums[i] && a[i-1]!=0)
               a[i] = a[i-1] * nums[i];
            else
                a[i]=nums[i];
           if(min[i-1] * nums[i] > a[i])
               a[i] = min[i-1] * nums[i];
            if(min[i-1] == 0) {
                if(nums[i]<0)
                    min[i] = nums[i];
                else
                    min[i]=0;
            }
        else if(min[i-1] * nums[i] <= min[i-1] )
               min[i] = min[i-1] * nums[i];
            else
               min[i] = nums[i];
            if(a[i-1] * nums[i] < min[i])
                min[i] = a[i-1] * nums[i];
            
            max = Math.max(max,a[i]);
           // System.out.println(a[i]+" "+min[i]);
        }
        return max;
    }
}