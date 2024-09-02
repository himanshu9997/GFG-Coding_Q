//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            System.out.println(sln.missingNumber(n, arr));
        }
    }
}
// } Driver Code Ends


class Solution {

    int missingNumber(int n, int arr[]) {

       
        int totalSum = n * (n + 1) / 2;
        

        int arraySum = 0;
        for (int i = 0; i < arr.length; i++) {
            arraySum += arr[i];
        }
        
        return totalSum - arraySum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n1 = 5;
        int[] arr1 = {1, 2, 3, 5};
        System.out.println("Missing number: " + solution.missingNumber(n1, arr1)); // Output: 4

        int n2 = 2;
        int[] arr2 = {1};
        System.out.println("Missing number: " + solution.missingNumber(n2, arr2)); // Output: 2
    }
}

