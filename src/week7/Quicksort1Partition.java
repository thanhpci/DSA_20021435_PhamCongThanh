package week7;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class Quicksort1Partition {
    class Result {

        /*
         * Complete the 'quickSort' function below.
         *
         * The function is expected to return an INTEGER_ARRAY.
         * The function accepts INTEGER_ARRAY arr as parameter.
         */

        public static List<Integer> quickSort(List<Integer> arr) {
            int lo = 0;
            int hi = arr.size() - 1;

            int i = 0;
            int j = hi + 1;

            while (true) {
                while (arr.get(++i) < arr.get(lo)) {
                    if (i == hi) break;
                }

                while (arr.get(lo) < arr.get(--j)) {
                    if (j == lo) break;
                }

                if (i >= j) break;

                int tmp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, tmp);
            }

            int tmp = arr.get(lo);
            arr.set(lo, arr.get(j));
            arr.set(j, tmp);

            List<Integer> result = arr;

            return result;

        }

    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            List<Integer> result = Result.quickSort(arr);

            bufferedWriter.write(
                    result.stream()
                            .map(Object::toString)
                            .collect(joining(" "))
                            + "\n"
            );

            bufferedReader.close();
            bufferedWriter.close();
        }
    }

}
