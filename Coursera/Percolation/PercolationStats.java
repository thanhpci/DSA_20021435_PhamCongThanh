import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {


    private static final double CONFIDENCE_95 = 1.96;
    private final double[] fractionOfOpenSites;
    private final double m;
    private final double s;


    public PercolationStats(int n, int trials) {
        this.fractionOfOpenSites = new double[trials];

        for (int t = 0; t < trials; t++) {
            Percolation p = new Percolation(n);

            while (!p.percolates()) {
                int row = StdRandom.uniform(n) + 1;
                int col = StdRandom.uniform(n) + 1;
                p.open(row, col);
            }

            this.fractionOfOpenSites[t] = p.numberOfOpenSites() / Math.pow(n, 2);
        }

        this.m = StdStats.mean(this.fractionOfOpenSites);
        this.s = StdStats.stddev(this.fractionOfOpenSites);
    }


    public double mean() {
        return this.m;
    }


    public double stddev() {
        return this.s;
    }


    public double confidenceLo() {
        return this.m - CONFIDENCE_95 * this.s / Math.sqrt(this.fractionOfOpenSites.length);
    }


    public double confidenceHi() {
        return this.m + CONFIDENCE_95 * this.s / Math.sqrt(this.fractionOfOpenSites.length);
    }


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);

        PercolationStats ps = new PercolationStats(n, t);
        System.out.println("mean                    = " + ps.mean());
        System.out.println("stddev                  = " + ps.stddev());
        System.out.println("95% confidence interval = [" + ps.confidenceLo() + ", " + ps.confidenceHi() + "]");
    }

}
