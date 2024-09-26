//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class gfg {

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String st[] = read.readLine().trim().split("\\s+");
            int n = st.length;
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) arr[(int)i] = Integer.parseInt(st[(int)i]);

            System.out.println(new Solution().maxStep(arr));
        }
    }
}

// } Driver Code Ends



class Solution {
   
    public int maxStep(int arr[]) {
      
        int max_steps = 0;  
        int current_steps = 0;  

       
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
               
                current_steps++;
            } else {
                
                current_steps = 0;
            }

            max_steps = Math.max(max_steps, current_steps);
        }

       
        return max_steps;
    }
}
