//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Long> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Long.parseLong(token));
            }

            long[] arr = new long[array.size()];
            int idx = 0;
            for (long i : array) arr[idx++] = i;

            Solution obj = new Solution();

            // calling maxSubarraySum() function
            System.out.println(obj.equilibriumPoint(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public static int equilibriumPoint(long arr[]) {
        long totalSum = 0;
        long leftSum = 0;
        
       
        for (long num : arr) {
            totalSum += num;
        }
        
        
        for (int i = 0; i < arr.length; i++) {
           
            long rightSum = totalSum - leftSum - arr[i];
            
        
            if (leftSum == rightSum) {
                
                return i + 1;
            }
            
            leftSum += arr[i];
        }
        
      
        return -1;
    }
}
