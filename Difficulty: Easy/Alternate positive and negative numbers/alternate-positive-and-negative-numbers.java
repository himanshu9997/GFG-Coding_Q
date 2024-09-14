//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();

            for (String s : inputArray) {
                arr.add(Integer.parseInt(s));
            }

            new Solution().rearrange(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java





class Solution {
    void rearrange(ArrayList<Integer> arr) {
        ArrayList<Integer> positiveList = new ArrayList<>();
        ArrayList<Integer> negativeList = new ArrayList<>();
        
        for (int num : arr) {
            if (num >= 0) {
                positiveList.add(num);
            } else {
                negativeList.add(num);
            }
        }
        
       
        arr.clear();
        
        int posIndex = 0, negIndex = 0;
        boolean turnPositive = true; 
        
      
        while (posIndex < positiveList.size() && negIndex < negativeList.size()) {
            if (turnPositive) {
                arr.add(positiveList.get(posIndex++));
            } else {
                arr.add(negativeList.get(negIndex++));
            }
            turnPositive = !turnPositive; 
        }
        
        
        while (posIndex < positiveList.size()) {
            arr.add(positiveList.get(posIndex++));
        }
        
      
        while (negIndex < negativeList.size()) {
            arr.add(negativeList.get(negIndex++));
        }
    }
}
