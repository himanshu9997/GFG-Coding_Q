//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            
            int arr[] = new int[n];
            int dep[] = new int[n];
            
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                dep[i] = Integer.parseInt(str[i]);
                
            System.out.println(new Solution().findPlatform(arr, dep, n));
        }
    }
    
    
}



// } Driver Code Ends


//User function Template for Java



class Solution
{
    
    static int findPlatform(int arr[], int dep[], int n)
    {

        Arrays.sort(arr);
        Arrays.sort(dep);
        

        int platforms_needed = 0;
        int max_platforms = 0;
        int i = 0, j = 0;
        
        
        while (i < n && j < n) {
           
            if (arr[i] <= dep[j]) {
                platforms_needed++;
                i++;
               
                max_platforms = Math.max(max_platforms, platforms_needed);
            }
          
            else {
                platforms_needed--;
                j++;
            }
        }
        
        
        return max_platforms;
    }
}

