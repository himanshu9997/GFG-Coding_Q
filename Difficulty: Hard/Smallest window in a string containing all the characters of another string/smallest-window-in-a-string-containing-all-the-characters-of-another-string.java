//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends




class Solution
{
    // Function to find the smallest window in the string s consisting
    // of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        if (s.length() < p.length()) {
            return "-1"; // Not possible if s is shorter than p
        }
        
        // Frequency map for characters in p
        HashMap<Character, Integer> pCount = new HashMap<>();
        for (char c : p.toCharArray()) {
            pCount.put(c, pCount.getOrDefault(c, 0) + 1);
        }
        
        int required = pCount.size(); // Number of unique characters in p
        int formed = 0; // To track how many unique characters in p are present in the current window
        HashMap<Character, Integer> windowCount = new HashMap<>();
        
        int left = 0, right = 0; // Sliding window pointers
        int minLength = Integer.MAX_VALUE; // To track the minimum length
        int minLeft = 0; // Starting index of the minimum window
        
        while (right < s.length()) {
            char c = s.charAt(right);
            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);
            
            // Check if this character contributes to a valid window
            if (pCount.containsKey(c) && windowCount.get(c).intValue() == pCount.get(c).intValue()) {
                formed++;
            }
            
            // Contract the window till it ceases to be valid
            while (formed == required) {
                // Update the minimum length and starting index
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minLeft = left;
                }
                
                // Try to remove the leftmost character
                char leftChar = s.charAt(left);
                windowCount.put(leftChar, windowCount.get(leftChar) - 1);
                if (pCount.containsKey(leftChar) && windowCount.get(leftChar).intValue() < pCount.get(leftChar).intValue()) {
                    formed--;
                }
                left++;
            }
            right++;
        }
        
        return minLength == Integer.MAX_VALUE ? "-1" : s.substring(minLeft, minLeft + minLength);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(smallestWindow("timetopractice", "toc")); // Output: "toprac"
        System.out.println(smallestWindow("zoomlazapzo", "oza")); // Output: "apzo"
        System.out.println(smallestWindow("a", "aa")); // Output: "-1"
        System.out.println(smallestWindow("thisisaverylargeteststring", "tst")); // Output: "tst"
    }
}
