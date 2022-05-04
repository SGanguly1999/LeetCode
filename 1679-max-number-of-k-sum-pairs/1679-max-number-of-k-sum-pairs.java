class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0;i<nums.length;i++) {
            if(!map.containsKey(nums[i]))
                map.put(nums[i],1);
            else
                map.put(nums[i],map.get(nums[i])+1);
        }
        int op = 0;
        for(int i = 0;i<nums.length;i++) {
            if(map.get(nums[i]) > 0)
               map.put(nums[i],map.get(nums[i])-1);
            else
                continue;
            int num2 = k - nums[i];
            if(map.containsKey(num2) && map.get(num2)>0) {
                //System.out.println(nums[i]+" "+num2);
                op++;
                map.put(num2,map.get(num2)-1);
            }
        }
        return op;
    }
}