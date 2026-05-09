import java.util.*;

class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {

            List<Integer> list = new ArrayList<>();

            int top = layer;
            int left = layer;
            int bottom = m - layer - 1;
            int right = n - layer - 1;

            for (int j = left; j <= right; j++) {
                list.add(grid[top][j]);
            }

            for (int i = top + 1; i < bottom; i++) {
                list.add(grid[i][right]);
            }

            for (int j = right; j >= left; j--) {
                list.add(grid[bottom][j]);
            }

            for (int i = bottom - 1; i > top; i--) {
                list.add(grid[i][left]);
            }

            int len = list.size();
            int rotate = k % len;

            List<Integer> rotated = new ArrayList<>();

            for (int i = 0; i < len; i++) {
                rotated.add(list.get((i + rotate) % len));
            }

            int idx = 0;

            for (int j = left; j <= right; j++) {
                grid[top][j] = rotated.get(idx++);
            }

            for (int i = top + 1; i < bottom; i++) {
                grid[i][right] = rotated.get(idx++);
            }

            for (int j = right; j >= left; j--) {
                grid[bottom][j] = rotated.get(idx++);
            }

            for (int i = bottom - 1; i > top; i--) {
                grid[i][left] = rotated.get(idx++);
            }
        }

        return grid;
    }
}