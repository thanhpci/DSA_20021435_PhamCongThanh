package week6;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class InsertionSortPart2 {
    class Result {

        /*
         * Complete the 'insertionSort2' function below.
         *
         * The function accepts following parameters:
         *  1. INTEGER n
         *  2. INTEGER_ARRAY arr
         */

        public static void insertionSort2(int n, List<Integer> arr) {
            for (int i = 1; i < n; i++) {
                for (int j = i ; j > 0; j--) {
                    if (arr.get(j) < arr.get(j - 1)) {
                        int tmp = arr.get(j);
                        arr.set(j, arr.get(j - 1));
                        arr.set(j - 1, tmp);
                    } else break;

                }

                for (int num : arr) {
                    System.out.print(num + " ");
                }
                System.out.print("\n");
            }
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

            Result.insertionSort2(n, arr);

            bufferedReader.close();
        }
    }

}
