//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
/*
Structure of node class is:
class Node {
    char data;
    Node next;

    public Node(char data){
        this.data = data;
        next = null;
    }
}
*/


class Solution {
    
    
    public boolean isValid(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public Node arrangeCV(Node head) {
        // write code here and return the head of changed linked list
        if(head == null) {
        return null;
        }
        
        Node vowalDummy = new Node('#');
        Node consonDummy = new Node('#');
        
        
        Node vowalTail = vowalDummy;
        Node consonTail = consonDummy;
        
        Node current = head;
        
        while(current != null) {
            if(isValid(current.data)) {
                vowalTail.next = current;
                vowalTail = vowalTail.next;
            } else {
                consonTail.next = current;
                consonTail = consonTail.next;
            }
            current = current.next;
        }
        vowalTail.next = consonDummy.next;
        consonTail.next = null;
        return vowalDummy.next;
    }
}

//{ Driver Code Starts.

class Node {
    char data;
    Node next;

    public Node(char data) {
        this.data = data;
        next = null;
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().split(" ");
            int n = str.length;
            Node head = null, tail = null;

            char head_c = str[0].charAt(0);
            head = new Node(head_c);
            tail = head;

            for (int i = 1; i < n; i++) {
                tail.next = new Node(str[i].charAt(0));
                tail = tail.next;
            }

            Solution obj = new Solution();
            // show(head);
            show(obj.arrangeCV(head));
        }
    }

    public static void po(Object o) { System.out.println(o); }

    public static void show(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}

// } Driver Code Ends