package week9;

import edu.princeton.cs.algs4.In;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

public class ClosestNumbers {

    class Result {

        /*
         * Complete the 'closestNumbers' function below.
         *
         * The function is expected to return an INTEGER_ARRAY.
         * The function accepts INTEGER_ARRAY arr as parameter.
         */

        public static List<Integer> closestNumbers(List<Integer> arr) {
            Comparable[] a = new Comparable[arr.size()];

            for (int i = 0; i < arr.size(); i++) {
                a[i] = arr.get(i);
            }

            Mergesort.sort(a);

            List<Integer> result = new ArrayList<>();
            int distanceMin =  Integer.MAX_VALUE;
            for (int i = 0; i < a.length - 1; i++) {
                int x = (int) a[i + 1];
                int y = (int) a[i];
                if (x - y < distanceMin) distanceMin = x - y;
            }

            for (int i = 0; i < a.length - 1; i++) {
                int x = (int) a[i + 1];
                int y = (int) a[i];
                if (x - y == distanceMin) {
                    result.add(y);
                    result.add(x);
                }
            }

            return result;
        }

    }

    class Mergesort {
        private static void merge(Comparable [] a, Comparable []  aux, int lo, int mid, int hi) {
            for(int k = lo; k < hi; k++) {
                aux[k] = a[k];
            }
            int i = lo;
            int j = mid + 1;

            for(int k = lo; k <= hi; k++) {
                if (i > mid) a[k] = aux[j++];
                else if (j > hi) a[k] = aux[i++];
                else if (less(aux[i], aux[j])) a[k] = aux[i++];
                else a[k] = aux[j++];
            }
        }



        static boolean less(Comparable a, Comparable b) {
            if (a.compareTo(b) == -1) return true;
            return false;
        }

        private static void sort (Comparable [] a, Comparable [] aux, int lo, int hi) {
            if (hi <= lo) return;
            int mid = lo + (hi - lo) / 2;

            sort(a, aux, lo, mid);
            sort(a, aux, mid + 1, hi);
            merge(a, aux, lo, mid, hi);
        }

        public static void sort(Comparable [] a) {
            Comparable [] aux = new Comparable[a.length];
            sort(a, aux, 0, a.length - 1);
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

            List<Integer> result = Result.closestNumbers(arr);

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