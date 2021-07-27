package depthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * 给定一个二维的非负整数矩阵，每个位置的值表示海拔高度。假设左边和上边是太平洋，右
 * 边和下边是大西洋，求从哪些位置向下流水，可以流到太平洋和大西洋。水只能从海拔高的位置
 * 流到海拔低或相同的位置。
 * tips 四条边的遍历
 * @Tag 深度优先搜索
 * @Date 2021/7/26
 */

public class PacificAtlanticWaterFlow_417 {
    public static void main(String[] argus) {
//        int[][] heights = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        int[][] heights = {{1,1},{1,1},{1,1}};
        System.out.println(pacificAtlantic(heights));
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i <= m-1; i++) {
            dfs(heights, i, 0, pacific);
            dfs(heights, i, n-1, atlantic);
        }

        for (int i = 0; i <= n-1 ; i++) {
            dfs(heights, 0, i, pacific);
            dfs(heights, m-1, i, atlantic);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(new Integer[]{i, j}));
                }
            }
        }
        return res;

    }

    public static int[] xx = {0,0,-1,1};
    public static int[] yy = {-1,1,0,0};

    public static void dfs(int[][] h, int cur_x, int cur_y, boolean[][] canReach) {
        if (canReach[cur_x][cur_y]) {
            return;
        }

        canReach[cur_x][cur_y] = true;
        for (int i = 0; i < 4; i++) {
            int x = cur_x + xx[i];
            int y = cur_y + yy[i];
            if (x >= 0 && y >= 0 && x <= h.length - 1 && y <= h[0].length - 1
                    && h[cur_x][cur_y] <= h[x][y]) {
                dfs(h, x, y, canReach);
            }
        }
    }

}
