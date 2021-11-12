package week8;

import java.io.*;
import java.util.*;

public class JavaStringReverse {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String A = sc.next();

        int leng = A.length();


        for (int i = 0; i < leng / 2; i++) {
            if (A.charAt(i) != A.charAt(leng - 1 - i)) {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }
}
