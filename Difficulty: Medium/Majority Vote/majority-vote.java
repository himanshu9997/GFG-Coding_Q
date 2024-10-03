//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            List<Integer> nums = new ArrayList<>();
            for (String part : parts) {
                nums.add(Integer.parseInt(part));
            }
            Solution ob = new Solution();
            List<Integer> ans = ob.findMajority(nums);
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {

    public List<Integer> findMajority(List<Integer> nums) {
        int n = nums.size();
        
    
        int candidate1 = -1, candidate2 = -1;
        int count1 = 0, count2 = 0;
        
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        
       
        count1 = 0;
        count2 = 0;
        
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }
        
       
        List<Integer> result = new ArrayList<>();
        
        if (count1 > n / 3) result.add(candidate1);
        if (count2 > n / 3) result.add(candidate2);
        
    
        if (result.isEmpty()) {
            result.add(-1);
        } else {
            Collections.sort(result); 
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Test case 1
        List<Integer> nums1 = Arrays.asList(2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6);
        System.out.println(sol.findMajority(nums1));  // Output: [5, 6]
        
        // Test case 2
        List<Integer> nums2 = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(sol.findMajority(nums2));  // Output: [-1]
    }
}

