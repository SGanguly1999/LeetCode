class Solution {
    long store[];
    public int uniquePaths(int m, int n) {
        int k = Math.max(n,m);
        double val =1;
        for(double i=k,c=1;i<=(m+n-2);i++,c++) {
            val=(val * i)/c;
            //val/=c;
        }
        return (int)val;
    }
    
}

   