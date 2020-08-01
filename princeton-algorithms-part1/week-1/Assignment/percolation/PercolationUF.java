/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */


import edu.princeton.cs.algs4.StdRandom;

public class Percolation {
    private int numOpened = 0;
    private boolean[][] opened;
    private int[][][] group;

    private int N;
    private boolean percolate;

    private int[][] d = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        N = n;
        opened = new boolean[n][n];
        group = new int[n][n][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                group[i][j][0] = i;
                group[i][j][1] = j;
                opened[i][j] = false;
            }
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row > N || row < 1 || col > N || col < 1) {
            throw new IllegalArgumentException();
        }

        if (!isOpen(row, col)) {
            joinNeighbors(row, col);
            opened[row - 1][col - 1] = true;
            numOpened++;
        }

    }

    public int[] getGroup(int[] loc) {
        int i = loc[0];
        int j = loc[1];

        if (group[i][j][0] != i || group[i][j][1] != j) {
            group[i][j] = getGroup(group[i][j]);
        }

        return group[i][j];
    }

    public void joinEdge(int[] loc1, int[] loc2) {
        int[] group1, group2;

        group1 = getGroup(loc1);
        group2 = getGroup(loc2);

        // Always set the root to be the smaller value
        if (group1[0] <= group2[0]) {
            group[group2[0]][group2[1]] = group1;
            group[loc2[0]][loc2[1]] = group1;
        }
        else {
            group[group1[0]][group1[1]] = group2;
            group[loc1[0]][loc1[1]] = group2;
        }
    }

    public void joinNeighbors(int row, int col) {
        int[] cur = new int[] { row - 1, col - 1 };
        int newRow, newCol;

        for (int i = 0; i < 4; i++) {
            newRow = row + d[i][0];
            newCol = col + d[i][1];
            if (newRow > 0 && newRow <= N && newCol > 0 && newCol <= N) {
                if (isOpen(newRow, newCol)) {
                    joinEdge(cur, new int[] {
                            newRow - 1, newCol - 1
                    });
                }
            }
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row > N || row < 1 || col > N || col < 1) {
            throw new IllegalArgumentException();
        }
        return opened[row - 1][col - 1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row > N || row < 1 || col > N || col < 1) {
            throw new IllegalArgumentException();
        }
        return isOpen(row, col) && getGroup(new int[] { row - 1, col - 1 })[0] == 0;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return numOpened;
    }

    // does the system percolate?
    public boolean percolates() {
        if (!percolate) {
            for (int i = 1; i <= N; i++) {
                if (isFull(N, i)) {
                    percolate = true;
                    return percolate;
                }
            }
        }

        return percolate;
    }

    // test client (optional)
    public static void main(String[] args) {
        Percolation perc = new Percolation(5);
        // perc.open(5, 6);
        for (int i = 0; i < 10; i++) {
            System.out.println(StdRandom.uniform(5));
        }

    }
}
