class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int maxscore=0;
        int sum1[] = new int[k];
        int sum2[] = new int[k];
        int l=0;
        int r=cardPoints.length-1;
        sum1[0] = cardPoints[l++];
        sum2[0] = cardPoints[r--];
        for(int i = 1;i<k;i++) {
           sum1[i]=sum1[i-1]+cardPoints[l++];
           sum2[i]=sum2[i-1]+cardPoints[r--];
           // System.out.println(sum1[i]+" "+sum2[i]);
        }
        if(cardPoints.length == k)
            return sum1[k-1];
        for(int i=0;i<=k;i++){
            if(i==0)
             maxscore=Math.max(maxscore,sum2[k-1]);
            else if(i == k)
             maxscore = Math.max(maxscore,sum1[k-1]);
            else {
                maxscore = Math.max(maxscore,sum1[i-1]+sum2[k-i-1]);
                
            }
        }
        return maxscore;
    }
}