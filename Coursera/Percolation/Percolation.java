import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final int maxSites;
    private final int gridSize;
    private final WeightedQuickUnionUF openSites;
    private final WeightedQuickUnionUF fullSites;
    private boolean[] openedSites;
    private int openSitesCount;

    public Percolation(int gridSize) {
        this.gridSize = gridSize;
        this.maxSites = this.gridSize * this.gridSize + 2;
        this.openSites = new WeightedQuickUnionUF(this.maxSites);
        this.fullSites = new WeightedQuickUnionUF(this.maxSites - 1);
        this.openedSites = new boolean[this.maxSites];
        this.openSitesCount = 0;

        setSiteOpen(0);
        setSiteOpen(this.maxSites - 1);
    }

    public void open(int row, int col) {

        int currentIndex = indexFrom2D(row, col);

        if (!getSiteOpen(currentIndex)) {
            setSiteOpen(currentIndex);
            this.openSitesCount++;

            int leftIndex = leftSiteIndex(row, col);
            int aboveIndex = aboveSiteIndex(row, col);
            int rightIndex = rightSiteIndex(row, col);
            int belowIndex = belowSiteIndex(row, col);

            if (leftIndex != -1 && getSiteOpen(leftIndex)) {
                this.openSites.union(currentIndex, leftIndex);
                this.fullSites.union(currentIndex, leftIndex);
            }

            if (aboveIndex != -1 && getSiteOpen(aboveIndex)) {
                this.openSites.union(currentIndex, aboveIndex);
                this.fullSites.union(currentIndex, aboveIndex);
            } else if (aboveIndex == -1) {
                this.openSites.union(currentIndex, 0);
                this.fullSites.union(currentIndex, 0);
            }

            if (rightIndex != -1 && getSiteOpen(rightIndex)) {
                this.openSites.union(currentIndex, rightIndex);
                this.fullSites.union(currentIndex, rightIndex);
            }

            if (belowIndex != -1 && getSiteOpen(belowIndex)) {
                this.openSites.union(currentIndex, belowIndex);
                this.fullSites.union(currentIndex, belowIndex);
            } else if (belowIndex == -1) {
                this.openSites.union(currentIndex, this.maxSites - 1);
            }
        }
    }

    public boolean isOpen(int row, int col) {

        int currentIndex = indexFrom2D(row, col);

        return getSiteOpen(currentIndex);
    }

    public boolean isFull(int row, int col) {
        int currentIndex = indexFrom2D(row, col);

        return this.fullSites.connected(0, currentIndex);
    }

    public int numberOfOpenSites() {
        return this.openSitesCount;
    }


    public boolean percolates() {
        return this.openSites.connected(0, this.maxSites - 1);
    }


    private int indexFrom2D(int row, int col) {
        return this.gridSize * (row - 1) + col;
    }

    private int leftSiteIndex(int row, int col) {
        return col > 1 ? indexFrom2D(row, col - 1) : -1;
    }

    private int aboveSiteIndex(int row, int col) {
        return row > 1 ? indexFrom2D(row - 1, col) : -1;
    }

    private int rightSiteIndex(int row, int col) {
        return col < this.gridSize ? indexFrom2D(row, col + 1) : -1;
    }


    private int belowSiteIndex(int row, int col) {
        return row < this.gridSize ? indexFrom2D(row + 1, col) : -1;
    }

    private boolean getSiteOpen(int i) {
        return this.openedSites[i];
    }

    private void setSiteOpen(int i) {
        this.openedSites[i] = true;
    }

}
