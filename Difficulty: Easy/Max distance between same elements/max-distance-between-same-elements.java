//{ Driver Code Starts
import java.util.*;
import java.util.Scanner;


// } Driver Code Ends





class Solution {
    public int maxDistance(int[] arr) {
        // Create a HashMap to store the first occurrence of each element
        HashMap<Integer, Integer> firstOccurrence = new HashMap<>();
        int maxDist = 0;  // Variable to keep track of the maximum distance

        // Loop through the array
        for (int i = 0; i < arr.length; i++) {
            // Check if the element is already in the map
            if (!firstOccurrence.containsKey(arr[i])) {
                // If not, store its first occurrence (index)
                firstOccurrence.put(arr[i], i);
            } else {
                
                int distance = i - firstOccurrence.get(arr[i]);
                
                maxDist = Math.max(maxDist, distance);
            }
        }

        return maxDist;  
    }

   
}




//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String input = sc.nextLine();
            String[] parts = input.split(" ");
            int[] arr = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                arr[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maxDistance(arr));
        }
        sc.close();
    }
}
// } Driver Code Ends