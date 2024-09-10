//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String A[] = in.readLine().trim().split(" ");
            int N = Integer.parseInt(A[0]);
            A = in.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.isCircle(A));
        }
    }
}
// } Driver Code Ends




class Solution {
    public int isCircle(String arr[]) {
        if (arr == null || arr.length == 0) return 0;

        // Step 1: Build the graph and calculate in-degrees and out-degrees
        Map<Character, Integer> inDegree = new HashMap<>();
        Map<Character, Integer> outDegree = new HashMap<>();
        Map<Character, Set<Character>> adjList = new HashMap<>();
        Set<Character> nodes = new HashSet<>();

        for (String s : arr) {
            char start = s.charAt(0);
            char end = s.charAt(s.length() - 1);

            // Update out-degree for the start character and in-degree for the end character
            outDegree.put(start, outDegree.getOrDefault(start, 0) + 1);
            inDegree.put(end, inDegree.getOrDefault(end, 0) + 1);

            // Build adjacency list
            adjList.computeIfAbsent(start, k -> new HashSet<>()).add(end);
            nodes.add(start);
            nodes.add(end);
        }

        // Step 2: Check if in-degrees match out-degrees for all characters
        for (char node : nodes) {
            if (!inDegree.getOrDefault(node, 0).equals(outDegree.getOrDefault(node, 0))) {
                return 0;
            }
        }

        // Step 3: Check for strong connectivity
        // Perform a DFS from any node with non-zero degree
        char startNode = nodes.iterator().next();
        if (!isConnected(startNode, adjList, nodes)) {
            return 0;
        }

        // Reverse the graph
        Map<Character, Set<Character>> reverseAdjList = new HashMap<>();
        for (char node : nodes) {
            reverseAdjList.put(node, new HashSet<>());
        }
        for (Map.Entry<Character, Set<Character>> entry : adjList.entrySet()) {
            char u = entry.getKey();
            for (char v : entry.getValue()) {
                reverseAdjList.get(v).add(u);
            }
        }

        // Check connectivity in the reversed graph
        if (!isConnected(startNode, reverseAdjList, nodes)) {
            return 0;
        }

        return 1;
    }

    private boolean isConnected(char startNode, Map<Character, Set<Character>> adjList, Set<Character> nodes) {
        Set<Character> visited = new HashSet<>();
        Deque<Character> stack = new ArrayDeque<>();
        stack.push(startNode);

        while (!stack.isEmpty()) {
            char node = stack.pop();
            if (visited.contains(node)) continue;
            visited.add(node);
            for (char neighbor : adjList.getOrDefault(node, Collections.emptySet())) {
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                }
            }
        }

        return visited.equals(nodes);
    }
}
