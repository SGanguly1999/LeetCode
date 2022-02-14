class Solution {
    public boolean isMatch(String s,String p) {
        s = " " + s;
        p = " " + p;
        int s_l = s.length();
        int p_l = p.length();
        boolean mat[][] = new boolean[p_l][s_l];
        for (int i = 0; i < p_l; i++) {
            char c = p.charAt(i);
            for (int j = 0; j < s_l; j++) {
                char d = s.charAt(j);
                if (i == 0 && j == 0)
                    mat[0][0] = true;
                else {
                    if ((c == '.' && j != 0 && mat[i - 1][j - 1] == true))
                        mat[i][j] = true;
                    else if (c == d && j != 0 && mat[i - 1][j - 1] == true)
                        mat[i][j] = true;
                  else if ((c == '*' && j == 0 && mat[i - 2][0] == true) || (c == '*' && j != 0 && (mat[i][j-1] == true || mat[i - 1][j - 1] == true || mat[i - 2][j - 1] == true) && (d == p.charAt(i - 1) || p.charAt(i - 1) == '.')) || (c=='*' && j!=0 && mat[i-2][j] == true)) {
                        mat[i][j] = true;
                    }
                }
            }
        }
            return mat[p_l-1][s_l-1];  
    }
}