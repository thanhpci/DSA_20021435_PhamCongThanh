package week2;

import edu.princeton.cs.algs4.*;

public class TwoSum {
    public static void main(String[] args) {
//        int N = StdIn.readInt();
//        int [] a = new int[N];
//        for (int i = 0; i < N; i++) {
//            a[i] = StdIn.readInt();
//        }
        In in = new In("D:\\Coursera\\algs4-data\\4Kints.txt"); // tạo luồng đọc từ file
        int[] a = in.readAllInts();  // đọc toàn bộ file vào mảng a
        // xử lý dữ liệu trong mảng a
        StdArrayIO.print(a); // in mảng ra màn hình

        twoSum(a);
    }
    public static void twoSum(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i ++) {
            for (int j = i + 1; j < N; j++) {
                if (a[i] + a[j] == 0) System.out.println("(" + a[i] + ", " + a[j] + ")");
            }
        }
    }
}


