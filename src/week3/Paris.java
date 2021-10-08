package week3;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Paris {

    /*
     * Complete the 'pairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY arr
     */

    public static int pairs(int k, List<Integer> arr) {
        int count = 0;
        int n = arr.size();
        Collections.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int distance = arr.get(j) - arr.get(i);
                if (distance == k) {
                    count++;
                    break;
                }
                if (distance > k) {
                    break;
                }
            }
        }
        return count;
    }

}

