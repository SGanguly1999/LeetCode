class Solution {
    public int singleNonDuplicate(int[] nums) {
        return binarySearch(nums,0,nums.length-1);
    }
    public int binarySearch(int nums[],int a,int b){
        int mid = (a + b)/2;
        //System.out.println(mid +" "+a+" "+b);
        if(mid+1<=b && nums[mid+1] == nums[mid]) {
            if((mid-a)%2 != 0)
                return binarySearch(nums,a,mid-1);
            else
                 return binarySearch(nums,mid+2,b);
        }
        else if(mid-1>=a && nums[mid-1] == nums[mid]) {
            if((mid-1-a)%2 != 0)
                return binarySearch(nums,a,mid-2);
            else
                 return binarySearch(nums,mid+1,b);
        }
        else 
            return nums[mid];
        
    }
}