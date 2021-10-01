package week3;

import edu.princeton.cs.algs4.*;

public class binarySearch {
    public static int binarySearch(int[] a, int number) {
        int lo = 0;
        int hi = a.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (number < a[mid]) hi = mid - 1;
            else if (number > a[mid]) lo = mid + 1;
            else return mid;
        }

        return -1;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        int numberKey = StdIn.readInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdIn.readInt();
        }


        System.out.println(binarySearch(a, numberKey));
    }

}
