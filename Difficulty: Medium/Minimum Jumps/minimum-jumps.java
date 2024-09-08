//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            System.out.println(new Solution().minJumps(arr));
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static int minJumps(int[] arr) {
        int n = arr.length;

        // If the array has only one element, no jumps are needed.
        if (n <= 1) {
            return 0;
        }

     
        if (arr[0] == 0) {
            return -1;
        }

       
        int maxReach = arr[0];

        
        int steps = arr[0];

       
        int jumps = 1;

       
        for (int i = 1; i < n; i++) {
            
            if (i == n - 1) {
                return jumps;
            }

            // Update maxReach
            maxReach = Math.max(maxReach, i + arr[i]);

            // We use a step to get to the current index.
            steps--;

            // If no further steps remain
            if (steps == 0) {
                // We must have used a jump
                jumps++;

               
               
                if (i >= maxReach) {
                    return -1;
                }

               
                steps = maxReach - i;
            }
        }

        return -1;
    }

    // public static void main(String[] args) {
    //     int[] arr1 = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
    //     System.out.println(minJumps(arr1)); // Output: 3

    //     int[] arr2 = {1, 4, 3, 2, 6, 7};
    //     System.out.println(minJumps(arr2)); // Output: 2

    //     int[] arr3 = {0, 10, 20};
    //     System.out.println(minJumps(arr3)); // Output: -1
    // }
}
