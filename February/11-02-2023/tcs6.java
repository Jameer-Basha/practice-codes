import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if(num%2!=0)
            System.out.println(num);
        else{
            num=num/2;
            int first =1;
            int second =1;
            int i=2;
            if(num<3)
                System.out.println(1);
            else{
                while(i<num){
                int temp = first;
                first =second;
                second= temp+second;
                i++;
            }    
            System.out.println(second);
            }
            
            
        }
    }
}
