package week11;

import edu.princeton.cs.algs4.In;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MisingNumbers {


    class Result {

        /*
         * Complete the 'missingNumbers' function below.
         *
         * The function is expected to return an INTEGER_ARRAY.
         * The function accepts following parameters:
         *  1. INTEGER_ARRAY arr
         *  2. INTEGER_ARRAY brr
         */

        //way1
        public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
            Hashtable<Integer, Integer> hashtable = new Hashtable<>();

            for (int k : brr) {
                int frequency = hashtable.getOrDefault(k, 0);
                frequency++;
                hashtable.put(k, frequency);
            }

            for (int k : arr) {
                int frequency = hashtable.get(k);
                frequency--;
                if(frequency > 0) hashtable.put(k, frequency);
                if (frequency == 0) hashtable.remove(k);
            }

            List<Integer> result = new ArrayList<>();

            for (Map.Entry<Integer, Integer> e : hashtable.entrySet()) {
                result.add(e.getKey());
            }
            Collections.sort(result);
            return result;
        }


        //way2
        public static List<Integer> missingNumbers2(List<Integer> arr, List<Integer> brr) {
            Collections.sort(arr);
            Collections.sort(brr);

            for (int i = 0; i < arr.size(); i++) {
                for (int j = 0; j < brr.size(); j++) {
                    int x = arr.get(i);
                    int y = brr.get(j);

                    if (x == y) {
                        brr.remove(j);
                        break;
                    }
                }
            }

            return brr;
        }

        //way3
        public static List<Integer> missingNumbers3(List<Integer> arr, List<Integer> brr) {
            int[] frequency1 = new int[100000];
            int[] frequency2 = new int[100000];

            for (int i : arr) frequency1[i]++;
            for (int i : brr) frequency2[i]++;

            List<Integer> result = new ArrayList<>();
            for (int i = 0; i <= 100000; i++) {
                if (frequency1[i] != frequency2[i]) result.add(i);
            }
            return result;
        }


    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrTemp[i]);
                arr.add(arrItem);
            }

            int m = Integer.parseInt(bufferedReader.readLine().trim());

            String[] brrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> brr = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                int brrItem = Integer.parseInt(brrTemp[i]);
                brr.add(brrItem);
            }

            List<Integer> result = Result.missingNumbers(arr, brr);

            for (int i = 0; i < result.size(); i++) {
                bufferedWriter.write(String.valueOf(result.get(i)));

                if (i != result.size() - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        }
    }
}
