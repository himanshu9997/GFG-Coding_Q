//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.print2largest(arr);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int print2largest(int[] arr) {
        // Initialize variables to store the largest and second largest distinct elements
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        // First pass: find the largest element
        for (int num : arr) {
            if (num > largest) {
                largest = num;
            }
        }

        // Second pass: find the second largest distinct element
        for (int num : arr) {
            if (num > secondLargest && num < largest) {
                secondLargest = num;
            }
        }

        // If secondLargest hasn't changed, it means there is no second largest distinct element
        return (secondLargest == Integer.MIN_VALUE) ? -1 : secondLargest;
    }
}
