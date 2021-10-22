package week6;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class InsertionSortPart1 {
    class Result {

        /*
         * Complete the 'insertionSort1' function below.
         *
         * The function accepts following parameters:
         *  1. INTEGER n
         *  2. INTEGER_ARRAY arr
         */

        public static void insertionSort1(int n, List<Integer> arr) {
            int value = arr.get(n - 1);

            for (int i = n - 2; i >= 0; i--) {
                if (arr.get(i) <= value) {
                    arr.set(i + 1, value);
                    break;
                } else {
                    arr.set(i + 1, arr.get(i));
                }

                for (int number : arr) {
                    System.out.print(number + " ");
                }
                System.out.print("\n");

            }

            if (arr.get(0) > value) arr.set(0, value);

            for (int number : arr) {
                System.out.print(number + " ");
            }
            System.out.print("\n");


        }

    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrTemp[i]);
                arr.add(arrItem);
            }

            Result.insertionSort1(n, arr);

            bufferedReader.close();
        }
    }

}
