class Solution {
    public int singleNumber(int[] nums) {
        int ele=0;
        for(int i:nums) {
            ele^=i;
        }
        return ele;
    }
}