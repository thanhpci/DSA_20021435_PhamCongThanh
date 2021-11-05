package week8;

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

public class JesseAndCookies {
    class Result {

        /*
         * Complete the 'cookies' function below.
         *
         * Thne function is expected to return an INTEGER.
         * The fuction accepts following parameters:
         *  1. INTEGER k
         *  2. INTEGER_ARRAY A
         */

        public static int cookies(int k, List<Integer> A) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(A);

            int count = 0;
            while(pq.size() > 1 && pq.peek() < k) {
                int m1 = pq.poll();
                int m2 = pq.poll();
                int sweet = m1 + 2 * m2;
                pq.add(sweet);
                count++;
            }

            if (pq.peek() < k) return -1;
            else return count;

        }

    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int n = Integer.parseInt(firstMultipleInput[0]);

            int k = Integer.parseInt(firstMultipleInput[1]);

            List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            int result = Result.cookies(k, A);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        }
    }

}
