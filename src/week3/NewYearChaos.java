package week3;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class NewYearChaos {
    class Result {

        /*
         * Complete the 'minimumBribes' function below.
         *
         * The function accepts INTEGER_ARRAY q as parameter.
         */

        public static void minimumBribes(List<Integer> q) {
            int n = q.size();
            int bribes = 0;
            for (int i = n - 2; i >= 0  ; i--) {
                int count = 0;
                for (int j = i + 1; j < n; j++) {
                    if (q.get(i) > q.get(j)) count++;
                    if (count > 2) {
                        System.out.println("Too chaotic");
                        return;
                    }
                }

                bribes += count;
            }

            System.out.println(bribes);
        }

    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int t = Integer.parseInt(bufferedReader.readLine().trim());

            for (int tItr = 0; tItr < t; tItr++) {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                String[] qTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                List<Integer> q = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    int qItem = Integer.parseInt(qTemp[i]);
                    q.add(qItem);
                }

                Result.minimumBribes(q);
            }

            bufferedReader.close();
        }
    }
}
