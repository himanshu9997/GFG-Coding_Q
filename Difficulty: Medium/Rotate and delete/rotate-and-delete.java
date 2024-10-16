//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends



class Solution {
    public static int rotateDelete(ArrayList<Integer> arr) {
        int sz = arr.size(); 
        int n = sz;
        
        
        for (int k = 1; k <= sz / 2; k++) {
 
            int lastElement = arr.get(n - 1);
            
            for (int i = n - 1; i > 0; i--) {
                arr.set(i, arr.get(i - 1));
            }
            arr.set(0, lastElement); 
            
           
            int deleteIndex = n - k;
            arr.remove(deleteIndex);
            n--; 
        }
        
        return arr.get(0);
    }
    
  
}



//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> arr = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                arr.add(Integer.parseInt(token));
            }

            Solution obj = new Solution();
            int res = obj.rotateDelete(arr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends