//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Array {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            // size of array
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");

            // adding elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Solution obj = new Solution();

            // calling trappingWater() function
            System.out.println(obj.trappingWater(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    
    static long trappingWater(int arr[]) {
        int n = arr.length;
        if (n == 0) return 0;

       
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        
      
        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

     
        rightMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }

        long trappedWater = 0;
        for (int i = 0; i < n; i++) {
            trappedWater += Math.min(leftMax[i], rightMax[i]) - arr[i];
        }

        return trappedWater;
    }

  
    // public static void main(String[] args) {
    //     int[] arr1 = {3, 0, 0, 2, 0, 4};
    //     System.out.println(trappingWater(arr1)); // Output: 10

    //     int[] arr2 = {7, 4, 0, 9};
    //     System.out.println(trappingWater(arr2)); // Output: 10

    //     int[] arr3 = {6, 9, 9};
    //     System.out.println(trappingWater(arr3)); // Output: 0
    // }
}

