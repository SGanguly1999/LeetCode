// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            int k = Integer.parseInt(stt.nextToken());
            int a[] = new int[(int)(n)];
            int b[] = new int[(int)(m)];


            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(inputLine1[i]);
            }


            Solution obj = new Solution();
            System.out.println(obj.kthElement( a, b, n, m, k));

        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        boolean flag = true;
        int a,b;
        a = 0;
        b = arr1.length - 1;
        while(flag) {
            if(a >= b)
                flag = false;
            int mid1 = (a + b)/2;
            int mid2 = k - mid1 - 2;
            int min1 = getVal(arr1,mid1);
            int min2 = getVal(arr2,mid2);
            int max1 = getVal(arr1,mid1+1);
            int max2 = getVal(arr2,mid2+1);
            if(min1 <= max2 && min2 <= max1)
                return Math.max(min1,min2);
            else if(min1 <= max2 && min2 > max1)
                a = mid1 + 1;
            else if(min1 > max2 && min2 <= max1)
                b = mid1 - 1;
            else if(min1 > max2 && min2 > max1)
                return -1; // Either of the arrays not sorted
        }
        return -1;
    }
    public int getVal(int arr[],int ind) {
        int len = arr.length;
        if(ind < 0)
            return Integer.MIN_VALUE;
        else if(ind >= len)
            return Integer.MAX_VALUE;
        else
            return arr[ind];
    }

}