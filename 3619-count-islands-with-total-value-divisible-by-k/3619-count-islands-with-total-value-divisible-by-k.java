class Solution {
    public int countIslands(int[][] grid, int k) {
        int rows = grid.length;
        int columns = grid[0].length;
        int count = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }

                long sum = 0;
                Stack<int[]> stack = new Stack<>();
                stack.push(new int[]{i, j});

                sum += grid[i][j];
                grid[i][j] = 0;

                while (!stack.isEmpty()) {
                    int[] cell = stack.pop();

                    for (int d = 0; d < 4; d++) {
                        int nr = cell[0] + dr[d];
                        int nc = cell[1] + dc[d];

                        if (nr < 0 || nr >= rows ||
                            nc < 0 || nc >= columns ||
                            grid[nr][nc] == 0) {
                            continue;
                        }

                        sum += grid[nr][nc];
                        grid[nr][nc] = 0;
                        stack.push(new int[]{nr, nc});
                    }
                }

                if (sum % k == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
