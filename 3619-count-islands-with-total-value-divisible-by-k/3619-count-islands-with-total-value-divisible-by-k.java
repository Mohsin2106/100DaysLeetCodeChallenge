
class Solution {
    int[][] grid;
    int m, n;

    public int countIslands(int[][] grid, int k) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (this.grid[i][j] != 0) {
                    if (countArea(i, j) % k == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    long countArea(int i, int j) {
        long sum = grid[i][j];
        grid[i][j] = 0;

        if (i > 0 && grid[i - 1][j] != 0)
            sum += countArea(i - 1, j);

        if (j > 0 && grid[i][j - 1] != 0)
            sum += countArea(i, j - 1);

        if (i < m - 1 && grid[i + 1][j] != 0)
            sum += countArea(i + 1, j);

        if (j < n - 1 && grid[i][j + 1] != 0)
            sum += countArea(i, j + 1);

        return sum;
    }
}
