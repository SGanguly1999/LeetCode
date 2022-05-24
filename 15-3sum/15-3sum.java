class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        HashSet<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-2;i++){
            int s = i+1;
            int e = nums.length-1;
            
            while(s < e){
                int sum = nums[i] + nums[s] + nums[e];
                if(sum == 0){
                    set.add(List.of(nums[i], nums[s], nums[e]));
                }
                if(sum > 0) e--;
                else s++;
            }
            
        }
        return new ArrayList<>(set);
    }    
}