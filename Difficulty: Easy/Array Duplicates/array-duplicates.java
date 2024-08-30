//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[] arr = IntArray.input(br, n);

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.duplicates(arr);

            IntArray.print(res);
        }
    }
}

// } Driver Code Ends




class Solution {
    public static ArrayList<Integer> duplicates(int[] arr) {
        int n = arr.length;
        int[] frequency = new int[n];
        ArrayList<Integer> duplicates = new ArrayList<>();

        // Count the frequency of each element
        for (int i = 0; i < n; i++) {
            frequency[arr[i]]++;
        }

        // Identify elements occurring more than once
        for (int i = 0; i < n; i++) {
            if (frequency[i] > 1) {
                duplicates.add(i);
            }
        }

        // If no duplicates found, return list containing -1
        if (duplicates.isEmpty()) {
            duplicates.add(-1);
        } else {
            // Ensure the list is in ascending order
            Collections.sort(duplicates);
        }

        return duplicates;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the size of the array
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        // Input the elements of the array
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Find duplicates
        ArrayList<Integer> result = duplicates(arr);

        // Output the result
        System.out.println("Output: " + result);

        scanner.close();
    }
}
