//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            String S = br.readLine();
            Solution ob = new Solution();
            String ans = ob.rremove(S).trim();
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String rremove(String s) {
        // code here
        StringBuilder result = new StringBuilder();
        
        
        if(s == null || s.length() <= 1) {
            return s;
        }
        
        
        int n = s.length();
        boolean dupString = false;
        
        for(int i = 0;i < n;i++) {
            if(i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                dupString = true;
                
                while(i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                    i++;
                }
            }else{
                result.append(s.charAt(i));
            }
        }
        
        if(dupString) {
            return rremove(result.toString());
        }
        return result.toString();
    }
}