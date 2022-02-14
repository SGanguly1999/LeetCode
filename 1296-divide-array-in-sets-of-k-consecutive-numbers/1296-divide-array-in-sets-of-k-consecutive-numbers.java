class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer,Integer> count = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int c = count.getOrDefault(nums[i],0)+1;
            count.put(nums[i],c);
        }
       
        Arrays.sort(nums);
        for(Integer i:nums){
            if(count.get(i)==0) continue;
            for(int j=i;j<i+k;j++){
                if(count.getOrDefault(j,0)<=0){
                    return false;
                }
                count.put(j,count.get(j)-1);
            }
        }
        return true;
    }
}