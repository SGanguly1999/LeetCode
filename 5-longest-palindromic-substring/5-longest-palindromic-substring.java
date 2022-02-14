class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String out = "";
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i > -1; i--){
            for (int j = i; j < n; j++){
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i + 1 > out.length()){
                    out = s.substring(i, j + 1);
                }
            }
        }
        return out;
    }
}