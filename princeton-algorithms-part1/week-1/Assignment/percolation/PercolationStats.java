/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double[] frac;
    private int T;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }

        T = trials;
        frac = new double[T];

        for (int i = 0; i < trials; i++) {
            frac[i] = PercolationTest(n);
        }

        // System.out.println(Arrays.toString(frac));

    }

    private double PercolationTest(int n) {
        Percolation perc = new Percolation(n);
        int gridNum = n * n;
        int opened = 0;
        boolean percolate = false;
        int row, col;
        while (opened < gridNum && !percolate) {
            row = StdRandom.uniform(1, n + 1);
            col = StdRandom.uniform(1, n + 1);
            perc.open(row, col);
            opened = perc.numberOfOpenSites();
            percolate = perc.percolates();
        }

        return opened / (double) gridNum;
    }

    // // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(frac);
    }

    // // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(frac);
    }

    // // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - 1.96 / Math.sqrt(T);
    }

    // // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + 1.96 / Math.sqrt(T);
    }

    // test client (see below)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        PercolationStats stat = new PercolationStats(n, trials);
        System.out.println("mean                    = " + stat.mean());
        System.out.println("stddev                  = " + stat.stddev());
        System.out.println(
                "95% confidence interval = [" + stat.confidenceLo() + ", " + stat.confidenceHi()
                        + "]");

    }

}
