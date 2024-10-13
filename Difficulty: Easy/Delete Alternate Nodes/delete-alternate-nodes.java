//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}


// } Driver Code Ends
/*
class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    public void deleteAlt(Node head) {
        if (head == null) return; // If the list is empty, do nothing

        Node current = head; // Start with the head node
        Node prev = null; // Previous node

        int count = 1; // To track the position of the nodes (1-based index)

        while (current != null) {
            // If the current node is in an even position
            if (count % 2 == 0) {
                // Delete current node by updating the previous node's next pointer
                if (prev != null) {
                    prev.next = current.next; // Bypass the current node
                }
            } else {
                // Move prev to current only if current is not deleted
                prev = current;
            }

            // Move to the next node
            current = current.next;
            count++; // Increment count
        }
    }
}

// Class to represent the singly linked list
class SinglyLinkedList {
    Node head;

    // Function to add a new node at the end of the list
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Function to print the linked list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

//{ Driver Code Starts.

public class GFG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = sc.nextLine();
            Scanner ss = new Scanner(input);
            while (ss.hasNextInt()) {
                arr.add(ss.nextInt());
            }
            Node head = new Node(arr.get(0));
            Node tail = head;
            for (int i = 1; i < arr.size(); i++) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }
            Solution ob = new Solution();
            ob.deleteAlt(head);
            printList(head);
        }
    }
}

// } Driver Code Ends