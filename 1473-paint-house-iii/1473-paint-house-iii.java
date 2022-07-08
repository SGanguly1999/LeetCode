class Solution {
    Integer[][][] dp;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        dp = new Integer[m][n+1][target+1];
        
        // start from first house
        // let prev house (before first) color is 0(not already painted)
        // initially no neighbours
        int ans = solve(0,0,0,houses,cost,m,n,target);
        return (ans==Integer.MAX_VALUE/2)?-1:ans;
    }
    
    /*
        i       : index to traverse houses
        CI      : for color of previous house
        NB      : number of neighbours
    */
    private int solve(int i, int CI, int NB, int[] houses, int[][] cost, int m, int n, int target)
    {
        /* If # of neighbours exceeds the target, then return MAX */
        if(NB>target)
            return Integer.MAX_VALUE/2;
        
        /* If reached to last house then,
                    - if neighbours reached target then return 0
                    - else return MAX as neighbour are not exactly equal to target
         */
        if(i==m)
            return (NB==target) ? 0 : Integer.MAX_VALUE/2;
        
        if(dp[i][CI][NB]!=null) return dp[i][CI][NB];
        
        int ans = Integer.MAX_VALUE/2;
        
        // If the house is not painted
        if(houses[i]==0){
            
            /* then check for the min cost required from all the available cost values
                i+1 : to move next house
                j+1 : to check for next cost 
                if CI==j+1 -> if the house is neighbour then NB else NB+1
            */
            for(int j=0; j<n; j++){
                ans = Math.min(ans, cost[i][j]+solve(i+1, j+1, (CI==j+1)?NB:NB+1, houses,cost,m,n,target));}
        }
        
        // If the house is already painted then simply move to next house
        else{
            ans = Math.min(ans,solve(i+1,houses[i], (houses[i]==CI)?NB:NB+1, houses, cost, m, n, target));
        } 

        return dp[i][CI][NB] = ans;
        
    }
}