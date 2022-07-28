/**


#  




*/

class Solution {
    int store[][];
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        char arr[] = floor.toCharArray();
        store = new int[numCarpets+1][arr.length];
        return minimumWhiteTiles(arr,numCarpets,carpetLen,0);
    }
    public int minimumWhiteTiles(char arr[],int numCarpets,int carpetLen,int index) {
        if(index >=arr.length)
            return 0;
        char c = arr[index];
        int op1,op2;
        op1 = op2 = Integer.MAX_VALUE;
        if(store[numCarpets][index]!=0)
            return store[numCarpets][index]-1;
        if(c == '1') {
            if(numCarpets!=0)
            op1 = minimumWhiteTiles(arr,numCarpets - 1,carpetLen,index+carpetLen);
            op2 = minimumWhiteTiles(arr,numCarpets,carpetLen,index+1)+1;
            store[numCarpets][index] = Math.min(op1,op2)+1;
    }
        else
            store[numCarpets][index] =  minimumWhiteTiles(arr,numCarpets,carpetLen,index+1)+1;
        return store[numCarpets][index]-1;
}
}