package depthFirstSearch;

import java.util.List;

/**
 * @Description TODO
 * @Tag
 * @Date 2021/7/26
 */

public class PacificAtlanticWaterFlow_417 {
    public static void main(String[] argus) {
        int[][] heights = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        pacificAtlantic(heights);
//        System.out.println(pacificAtlantic(heights));
    }

    public static void pacificAtlantic(int[][] heights) {
        int[][] pacific = new int[heights.length][heights.length];
        int[][] atlantic = new int[heights.length][heights.length];

        int i1 = 0;
        for (int j1 = 0; j1 < heights.length; j1++) {
            pacific[i1][j1] = 1;
        }
        int j2 = 0;
        for (int i2 = 0; i2 < heights.length; i2++) {
            pacific[i2][j2] = 1;
        }

        for (int j1 = 0; j1 < heights.length; j1++) {
            dfsPacific(heights, i1, j1, pacific);
        }

        for (int i2 = 0; i2 < heights.length; i2++) {
            dfsPacific(heights, i2, j2, pacific);
        }
        int i3= 0;

    }

    public static void dfsPacific(int[][] h, int x, int y, int[][] pacific) {
        if (x == h.length-1 || y == h.length-1) {
            return;
        }
        if (h[x][y] <= h[x][y + 1]) {
            pacific[x][y] = 1;
            dfsPacific(h, x, y + 1, pacific);
        }
        if (h[x][y] <= h[x + 1][y]) {
            pacific[x][y] = 1;
            dfsPacific(h, x + 1, y, pacific);
        }
    }

    public static void dfsAtlantic(int[][] heights, int cur_x, int cur_y, int[][] atlantic) {

    }

}
