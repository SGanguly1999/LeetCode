class Solution {
    public String getSmallestString(int n, int k) {
        char[] list = new char[n];
        int j;
        int mul = 26 * n;
        for(int i = 0; i<n;i++) {
            mul = mul - 26;
            j = k - mul;
            if(j<=0)
                j = 1;
            k = k -j;
            list[i]=(char)('a'-1+j);
        }
        
    return String.valueOf(list);
    }
}