package week7;

import java.util.Scanner;

public class QuicksortInPlace {
    static int partition(int[] arr, int hi, int lo) {
        int pivot = arr[hi];
        int i = lo;
        for (int j = lo; j < hi; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, hi, i);
        return i;
    }

    static void sort(int[] arr, int hi, int lo) {
        if (lo >= hi)
            return;
        int j = partition(arr, hi, lo);
        show(arr);

        sort(arr, j - 1, lo);

        sort(arr, hi, j + 1);

    }

    static void swap(int[] arr, int a, int b) {
        int swap = arr[a];
        arr[a] = arr[b];
        arr[b] = swap;
    }

    static void show(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        sort(arr, arr.length - 1, 0);

    }
}