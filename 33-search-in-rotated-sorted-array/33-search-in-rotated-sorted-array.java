class Solution {
    public int search(int[] nums, int target) {
        boolean flag = true;
        int a,b,ind=0;
        a=0;
        b=nums.length-1;
        if(nums[b] == target)
            return b;
        while(flag) {
            //System.out.println("ola");
          int mid = (a+b)/2;
            if(nums[mid] == target)
              return mid;
            if(a >= b)
                return -1;
          if(nums[mid]>target && nums[b]>=target && nums[mid]>nums[b])
                a = mid+1;
          else if(nums[mid]>target && nums[b]>target && nums[mid]<nums[b])
                b = mid-1;
          else if(nums[mid]<target && nums[b]<target && nums[mid]<nums[b])
              b = mid-1;
          else if(nums[mid]<target && nums[b]<= target && nums[mid]>nums[b])
              a = mid+1;
          else if(nums[mid]>target && nums[b]<target && nums[mid]>nums[b])
              b = mid-1;
            else if(nums[mid]<target && nums[b]>=target && nums[mid]<nums[b])
                a= mid+1;
          
        }
        return -1;
        }
}
        
        
        
        
        
        
        
        
        
        
        
  