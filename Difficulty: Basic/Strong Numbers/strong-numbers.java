//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.isStrong(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int isStrong(int N) {
        // code here
        int orignal = N;
        int sumFact = 0;
        
        while(N > 0) {
            int digit = N % 10;
            sumFact += isStrongNumbers(digit);
            N /= 10;
        }
        
        if(sumFact == orignal) {
            return 1;
        }else {
            return 0;
        }
    }
    
    static int isStrongNumbers(int nums) {
        
        int fact = 1;
        for(int i = 1;i <= nums;i++) {
            fact *= i;
        }
        return fact;
    }
}