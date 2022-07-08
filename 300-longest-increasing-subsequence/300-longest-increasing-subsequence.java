class Solution {
    public int lengthOfLIS(int[] nums) {
        int arr[] = new int[nums.length];
        arr[0]=1;
        int max = 0;
        int res = 1;
        for(int i = 1;i < nums.length;i++) {
            max = 0;
            for(int j = i-1;j>=0;j--){
                if(nums[j] < nums[i]) 
                    max = Math.max(arr[j],max);
                if(max > i) {
                    arr[i]=max+1;
                    break;
                }
            }
            if(arr[i] == 0)
                arr[i]=max+1;
            res = Math.max(arr[i],res);
        }
       /* for(int i = 0;i<nums.length;i++)
            System.out.print(arr[i]+" ");*/
        return res;
    }
}