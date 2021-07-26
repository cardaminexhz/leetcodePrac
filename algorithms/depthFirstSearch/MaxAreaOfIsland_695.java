package depthFirstSearch;

/**
 * @Description
 * 给定一个二维的 0-1 矩阵，其中 0 表示海洋，1 表示陆地。单独的或相邻的陆地可以形成岛屿，
 * 每个格子只与其上下左右四个格子相邻。求最大的岛屿面积。
 * tips 四个方向的遍历；递归函数中边界条件的确立
 * @Tag 深度优先搜索，递归
 * @Date 2021/7/24
 */

public class MaxAreaOfIsland_695 {
    public static void main(String[] argus) {
        int[][] grid = {{1,0,1,1,0,1,0,1}, {1,0,1,1,0,1,1,1}, {0,0,0,0,0,0,0,1}};
        System.out.println(maxAreaOfIsland(grid));
    }

    // 主函数：确定搜索的起始位置
    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int cur = dfs(grid, i, j);
                maxArea = Math.max(cur, maxArea);
            }
        }
        return maxArea;
    }

    // 副函数：进行搜索
    public static int dfs(int[][] grid, int cur_x, int cur_y) {
        if(cur_x < 0 || cur_y < 0 || cur_x == grid.length || cur_y == grid[cur_x].length || grid[cur_x][cur_y] != 1) {
            return 0;
        }

        int res = 1;
        grid[cur_x][cur_y] = 0;
        int[] x = {0, 0, -1, 1};
        int[] y = {-1, 1, 0, 0};
        for (int i = 0; i < 4; i++) {
            res += dfs(grid, cur_x+x[i], cur_y+y[i]);
        }
        return res;
    }
}
