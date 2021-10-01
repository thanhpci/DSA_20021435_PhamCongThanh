package week2;

import edu.princeton.cs.algs4.*;

public class UFClient2 {


    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new UF(N);
        int count_couple = 0;
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            count_couple++;
            if (!uf.connected(p, q)) {
                uf.union(p, q);
            }

            if (conectedAll(uf, N)) {
                System.out.println(count_couple);
                return;
            }
        }
        System.out.println("FAIDED");
    }

    public static boolean conectedAll(UF uf, int N) {
        for (int i = 1; i < N; i++) {
            if (!uf.connected(0, i)) return false;
        }
        return true;
    }
}
