class Solution {
    List<List<String>> res;
    int arr[];
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<List<String>>();
        arr = new int[n];
        permutation(n);
        return res;
    }
    public void permutation(int n) {
        //System.out.println(n);
        if(n == 0)
            res.add(genString(arr));
       loop1: for(int i = 1;i<=arr.length;i++){
            //System.out.println(n+" "+i);
            for(int j=arr.length-1;j >n-1;j--) {
                if(i == arr[j] || Math.abs(arr[j] - i)==j-n+1) {
                     //System.out.println(i+" "+n+" "+j+" "+" "+arr[j]+" "+Math.abs(arr[j] - i));
                    continue loop1;
                }
            }
           arr[n-1]=i;
           permutation(n-1);
        }
    }
    public List<String> genString(int arr[]) {
        List<String> list = new ArrayList<String>();
        for(int i=0;i<arr.length;i++){
            String m ="";
            for(int j=0;j<arr.length;j++)
                if(j+1 == arr[i])
                    m+="Q";
                else
                    m+=".";
            list.add(m);
        }
       return list; 
    }
}