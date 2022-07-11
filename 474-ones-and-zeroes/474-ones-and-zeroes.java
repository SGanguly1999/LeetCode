class Solution {
    static int max[][][];
    static int arr[][];
    public int findMaxForm(String[] strs, int m, int n) {
        arr = new int[strs.length][2];
        for(int i = 0; i < strs.length; i++ ) {
            for(int j = 0; j < strs[i].length();j++){
                char c = strs[i].charAt(j);
                if( c == '0')
                    arr[i][0]++;
                if(c == '1')
                    arr[i][1]++;
            }
        }
        max = new int[m+1][n+1][strs.length];
        return solution(0,m,n);
    }
    public int solution(int start,int m, int n) {
        if((start > arr.length -1) || ( m < 1 && n < 1) || (m < 0 || n < 0))
            return 0;
        if(max[m][n][start] > 0)
            return max[m][n][start]-1;
        int includ = -1;
        int includ_not = -1;
        int ones = arr[start][1];
        int zeros = arr[start][0];
        if((m-zeros>=0 && n - ones >=0) && (ones <= n && zeros <=m))
         includ = solution(start+1,m-zeros,n-ones);
        includ_not = solution(start+1,m,n);
        //System.out.println(start+" "+m+" "+n);
        //System.out.println(includ+" "+includ_not);
        max[m][n][start] = Math.max(1+includ,includ_not)+1;
        return (max[m][n][start]-1);
    }
}