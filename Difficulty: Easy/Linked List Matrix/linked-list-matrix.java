//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node right, down;

    Node(int data) {
        this.data = data;
        right = null;
        down = null;
    }
}

public class Linked_list_2D_Matrix {

    // Non-static display method
    void display(Node head) {
        Node Dp = head;
        while (Dp != null) {
            Node Rp = Dp;
            while (Rp != null) {
                System.out.print(Rp.data + " ");
                if (Rp.right != null)
                    System.out.print(Rp.right.data + " ");
                else
                    System.out.print("null ");
                if (Rp.down != null)
                    System.out.print(Rp.down.data + " ");
                else
                    System.out.print("null ");
                Rp = Rp.right;
            }
            Dp = Dp.down;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Linked_list_2D_Matrix ll2d =
            new Linked_list_2D_Matrix(); // Create an instance of the class

        try {
            int t = Integer.parseInt(scanner.nextLine().trim());

            while (t-- > 0) {
                // Read and process the first line of input
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    continue; // Skip empty lines
                }

                String[] elements = line.split("\\s+");
                int n = elements.length;

                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = Integer.parseInt(elements[i]);
                }

                int[][] mat = new int[n][n];
                mat[0] = arr;

                // Read the remaining rows of the matrix
                for (int i = 1; i < n; i++) {
                    line = scanner.nextLine().trim();
                    elements = line.split("\\s+");
                    for (int j = 0; j < n; j++) {
                        mat[i][j] = Integer.parseInt(elements[j]);
                    }
                }

                Solution obj = new Solution();
                Node head = obj.construct(mat);
                ll2d.display(head); // Call non-static method using instance
                System.out.println();
            }
        } catch (NumberFormatException e) {
            System.err.println(
                "Error reading input. Please ensure the input is in the correct format.");
        } finally {
            scanner.close();
        }
    }
}

// } Driver Code Ends


class Solution {
    static Node construct(int arr[][]) {
        int n = arr.length;    // Number of rows (and columns as it is an n*n matrix)
        
        if (n == 0) return null;  // Handle edge case of an empty matrix

        Node[][] nodes = new Node[n][n];  // 2D array to store the Node references

        // Step 1: Create a node for each element in the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nodes[i][j] = new Node(arr[i][j]);
            }
        }

        // Step 2: Link the nodes together using right and down pointers
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j < n - 1) nodes[i][j].right = nodes[i][j + 1];  // Link to the right node
                if (i < n - 1) nodes[i][j].down = nodes[i + 1][j];   // Link to the down node
            }
        }

        // Step 3: Return the top-left node as the head of the 2D linked list
        return nodes[0][0];
    }
}
