package week3;

import edu.princeton.cs.algs4.StdIn;

public class SherlockAndArray {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdIn.readInt();
        }
        System.out.println(Sherlock(a, n));
    }

    public static String Sherlock(int arr[], int n) {
        for (int i = 0; i < n ; i++) {
            int sumLeft = 0;
            int sumRight = 0;

            for (int j = i + 1; j < n; j++) {
                sumRight += arr[j];
            }
            for (int j = 0; j < n; j++) {
                sumLeft += arr[j];
            }
            if (sumLeft == sumRight) return "YES";
        }
        return "NO";
    }
}

