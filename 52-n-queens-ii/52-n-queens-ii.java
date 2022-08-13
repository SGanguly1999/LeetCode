class Solution {
    int arr[];
    int count=0;
    public int totalNQueens(int n) {
        arr = new int[n];
        permutation(n);
        return count;
    }
    public void permutation(int n) {
        //System.out.println(n);
        if(n == 0)
           count++;
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
}