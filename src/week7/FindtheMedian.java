package week7;

import java.util.Scanner;

public class FindtheMedian {
    static int getMedian(int[] arr, int lo, int hi, int k ) {
        if (lo == hi) return arr[hi];
        int mid = partition(arr, lo, hi);
        if (mid == k) return arr[mid];
        if (mid > k) {
            return getMedian(arr, lo, mid - 1, k);
        }
        if (mid < k) {
            return getMedian(arr, mid + 1, hi, k);
        }
        return -1;
    }

    static int partition(int[] arr, int lo, int hi) {
        if (lo == hi) return hi;
        int i = lo;
        int pivot = arr[hi];
        for (int j = lo; j < hi; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, hi, i);
        return i;
    }

    static void swap(int[] arr, int i, int j) {
        int swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(getMedian(arr, 0, arr.length - 1, N / 2));
    }
}
