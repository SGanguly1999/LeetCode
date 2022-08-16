class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int len = satisfaction.length;
        int result=0;
        int sum = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            if (sum + satisfaction[i] < 0) break;
            
            sum += satisfaction[i];
            result += sum;
        }
        return result;
}
}