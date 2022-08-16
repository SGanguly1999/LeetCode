class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int len = satisfaction.length;
        int result=0;
        for(int i = len; i >0;i--) {
            int r = 0;
            int k =i;
            for(int j = satisfaction.length-1; j >=len-i;j--)
                    r+=satisfaction[j]*k--; 
            result = Math.max(result,r);
            
        }
        return result;
}
}