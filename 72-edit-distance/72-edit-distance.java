/**

# Operation 1: Insert a character

# Operation 2: Delete a character

# Operation 3: Replace a character


We will use dynamic programing approach

For storing the previous result we will use a 2 dimensional matrix...The minimum operation to convert from a particular index of word1 to end to word2 starting from a partuicular index of word2 to end is stored in corresponding cell

For example: horse
             ros
store[0][0] stores the minimum operation to convert starting from 0th index of word1 to  word starting from 0 th index of word2.            

*/

class Solution {
    int store[][];
    public int minDistance(String word1, String word2) {
     store = new int[word1.length()][word2.length()];
     return minDistance(word1,word2,0,0);
    }
    public int minDistance(String word1, String word2,int i,int j) {
        if(i >= word1.length())
            return word2.length() - j;
        if(j >= word2.length())
            return word1.length() - i;
        if(store[i][j]!=0)
            return store[i][j];
        char c1 = word1.charAt(i);
        char c2 = word2.charAt(j);
        int op1,op2,op3;
        if(c1 == c2)
            return minDistance(word1,word2,i+1,j+1);
         op1 = minDistance(word1,word2,i,j+1);
         op2 = minDistance(word1,word2,i+1,j);
         op3 = minDistance(word1,word2,i+1,j+1);
        store[i][j] = Math.min(Math.min(op1,op2),op3)+1;
        return store[i][j];
    }
}