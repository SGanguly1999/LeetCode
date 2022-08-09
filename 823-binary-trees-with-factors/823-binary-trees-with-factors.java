class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        Arrays.sort(arr);
        for(int i = 0; i < arr.length;i++)
            map.put(arr[i],i);
        long ar[] = new long[arr.length];
        ar[0] = 1;
        long mod =1000000007;
        for(int i = 1; i < arr.length;i++) {
            ar[i]=1;
            for(int j = 0; j < i; j++) {
                if(arr[i]%arr[j] == 0 && map.containsKey(arr[i]/arr[j])) {
                    int m = map.get(arr[i]/arr[j]);
                    ar[i] = (ar[i]+(ar[j]*ar[m])%mod)%mod;
                }
            }
        }
        long res = 0;
        for(int i=0;i<arr.length;i++)
            res = (res+ar[i])%mod;
        return (int)res;
    }
}