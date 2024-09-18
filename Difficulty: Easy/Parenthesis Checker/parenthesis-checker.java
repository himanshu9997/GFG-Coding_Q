//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}
// } Driver Code Ends


class Solution
{

    static boolean ispar(String x)
    {

        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < x.length(); i++) {
            char ch = x.charAt(i);
            
        
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
    
            else if (ch == ')' || ch == '}' || ch == ']') {
                
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), ch)) {
                    return false;
                }
            }
        }
        
        
        return stack.isEmpty();
    }
     private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }

}

