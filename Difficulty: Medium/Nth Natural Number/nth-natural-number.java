//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        int t = ob.nextInt();
        while (t-- > 0) {
            long n = ob.nextLong();
            Solution ab = new Solution();
            long k = ab.findNth(n);
            System.out.println(k);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    long findNth(long n) {
        long result = 0;
        long placeValue = 1;

        // Convert the number from base-10 to base-9
        while (n > 0) {
            result += (n % 9) * placeValue;  // Extract the current base-9 digit
            n /= 9;                          // Move to the next digit in base-9
            placeValue *= 10;                 // Shift the place value in base-10
        }

        return result;
    }
}
