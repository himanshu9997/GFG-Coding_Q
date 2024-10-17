//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Main {
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

            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }

            Solution ob = new Solution();
            Node[] result = ob.alternatingSplitList(head);
            printList(result[0]);
            printList(result[1]);
        }

        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    
    Node[] alternatingSplitList(Node head) {
        if (head == null) {
            return new Node[]{null, null};
        }

        Node headA = null, headB = null; 
        Node tailA = null, tailB = null; 
        Node current = head;
        boolean flag = true; 

        while (current != null) {
            if (flag) {
                
                if (headA == null) {
                    headA = current; 
                    tailA = headA;
                } else {
                    tailA.next = current; 
                    tailA = tailA.next;
                }
            } else {
            
                if (headB == null) {
                    headB = current; 
                    tailB = headB;
                } else {
                    tailB.next = current; 
                    tailB = tailB.next;
                }
            }

    
            current = current.next;
            flag = !flag;
        }

        if (tailA != null) {
            tailA.next = null;
        }
        if (tailB != null) {
            tailB.next = null;
        }

      
        return new Node[]{headA, headB};
    }
    
    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print("->");
            }
            temp = temp.next;
        }
        System.out.println();
    }

}



