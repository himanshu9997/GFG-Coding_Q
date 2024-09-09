//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> a = new ArrayList<>();

            for (String s : inputArray) {
                a.add(Integer.parseInt(s));
            }

            Solution ob = new Solution();
            ob.sort012(a);

            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends




class Solution {
  
    public void sort012(ArrayList<Integer> arr) {
        int low = 0;  
        int mid = 0;   
        int high = arr.size() - 1; 
        
        while (mid <= high) {
            switch (arr.get(mid)) {
                case 0:
                    
                    swap(arr, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                
                    mid++;
                    break;
                case 2:
                   
                    swap(arr, mid, high);
                    high--;
                    break;
            }
        }
    }
    
    
    private void swap(ArrayList<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
    
   
}
