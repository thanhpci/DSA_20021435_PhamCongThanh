package week3;

import java.util.*;

class ClosestNumbers {

    /*
     * Complete the 'closestNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> closestNumbers(List<Integer> arr) {
        int n = arr.size();
        Collections.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            if (arr.get(i + 1) - arr.get(i) < min) {
                min = arr.get(i + 1) - arr.get(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            if (arr.get(i + 1) - arr.get(i) == min) {
                result.add(arr.get(i));
                result.add(arr.get(i+1));
            }
        }
        return result;
    }

}
