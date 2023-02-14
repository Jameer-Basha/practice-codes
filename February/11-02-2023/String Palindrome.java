import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s=s.toLowerCase();
        int n = s.length();
        for(int i=0;i<n/2;i++){
            if(s.charAt(i)!= s.charAt(n-i-1)){
                System.out.println("Not Palindrome");
            return;
            }
                
        }
        System.out.println("Palindrome");
    }
}
