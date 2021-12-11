package week13;

public class PrimMSTSpecialSubtree {
    class Cost implements Comparable<Cost> {
        public int r, v;

        public Cost(int cost, int vertex) {
            r = cost;
            v = vertex;
        }

        @Override
        public int compareTo(Cost c) {
            if (r < c.r) return -1;
            if (r > c.r) return 1;
            if (v < c.v) return -1;
            if (v > c.v) return 1;
            return 0;
        }

    }

}
