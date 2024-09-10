//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            long arr[] = new long[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().inversionCount(arr));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    static long inversionCount(long arr[]) {
        
        return mergeSortAndCount(arr, 0, arr.length - 1);
    }
    
    
    static long mergeSortAndCount(long[] arr, int left, int right) {
        long count = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;
            
            
            count += mergeSortAndCount(arr, left, mid);
            
        
            count += mergeSortAndCount(arr, mid + 1, right);
            
            
            count += mergeAndCount(arr, left, mid, right);
        }
        return count;
    }
    
    
    static long mergeAndCount(long[] arr, int left, int mid, int right) {
        
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        long[] leftArr = new long[n1];
        long[] rightArr = new long[n2];
        
        
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArr[i] = arr[mid + 1 + i];
        }
        
        
        int i = 0, j = 0, k = left;
        long count = 0;
    
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            
                count += (n1 - i); 
            }
        }
        
        
        while (i < n1) {
            arr[k++] = leftArr[i++];
        }
        
        
        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
        
        return count;
    }
}
