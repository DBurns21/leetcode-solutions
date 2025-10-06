class Solution {
    int[][] directions = {{0,-1}, {0, 1}, {-1, 0}, {1, 0}};

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int ans = Integer.MAX_VALUE;
        int low = 0;
        int high = n * n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            boolean[][] visited = new boolean[n][n];
            if (grid[0][0] <= mid && dfs(0, 0, mid, grid, visited)) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean dfs(int x, int y, int t, int[][] grid, boolean[][] visited) {
        int n = grid.length;
        visited[x][y] = true;

        if (x == n - 1 && y == n - 1) {
            return true;
        }

        for (int[] d : directions) {
            int nextX = x + d[0];
            int nextY = y + d[1];
            if (nextX >= 0 && nextX < n && nextY >=0 && nextY < n && !visited[nextX][nextY] && grid[nextX][nextY] <= t) {
                if (dfs(nextX, nextY, t, grid, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}