package depthFirstSearch;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description
 * 给定一个二维 0-1 矩阵，其中 1 表示陆地，0 表示海洋，每个位置与上下左右相连。
 * 已知矩阵中有且只有两个岛屿，求最少要填海造陆多少个位置才可以将两个岛屿相连。
 * 灵魂发问：
 * 1.grid里的两个岛屿都是由1组成，那么向周围搜索的时候，遇到1，怎么知道是本岛屿的还是另一个岛屿的。
 * 2.bridge何时+1，即如何记录层次
 * 3.注意，首次加入队列的，并不只有第一个岛屿的一个元素，而要把第一个岛屿的所有元素都加入队列
 * @Tag 广度优先搜索，深度优先搜索
 * @Date 2021/8/2
 */

public class ShortestBridge_934 {
    public static void main(String[] argus) {
        int[][] grid = {{0,1,0,0,0},{0,1,0,1,1},{0,0,0,0,1},{0,0,0,0,0},{0,0,0,0,0}};

        System.out.println(shortestBridge(grid));
    }

    public static int shortestBridge(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] != 1) {
                    continue;
                }
                Deque<Integer> dequeX = new ArrayDeque<>();
                Deque<Integer> dequeY = new ArrayDeque<>();
                //深度优先遍历：1.找到1个岛屿，将其元素变成2，以便和另一个岛屿区分; 2.将这个岛屿的所有元素加入队列
                dfs(grid, i, j, dequeX, dequeY);
                //广度优先遍历，进入正题
                int bridge = bfs(grid, dequeX, dequeY);
                return bridge;
            }
        }
        return 0;
    }

    public static int bfs(int[][] grid, Deque<Integer> dequeX, Deque<Integer> dequeY) {
        int level = 0;
        int[] i = {0, 0, -1, 1};
        int[] j = {-1, 1, 0, 0};

        while(!dequeX.isEmpty()) {
            ++level;
            int pointsNum = dequeX.size();
            while(pointsNum > 0) {
                int x = dequeX.pop();
                int y = dequeY.pop();
                --pointsNum;

                for (int k = 0; k < 4; k++) {
                    int r = x + i[k];
                    int c = y + j[k];
                    if (r < 0 || c < 0 || r == grid.length || c == grid[0].length) {
                        continue;
                    }
                    if (grid[r][c] == 1) {
                        return level-1;
                    }
                    if (grid[r][c] == 0) {
                        dequeX.add(r);
                        dequeY.add(c);
                        grid[r][c] = 2;
                    }
                }
            }
        }
        return level;
    }

    public static void dfs(int[][] grid, int x, int y, Deque<Integer> dequeX, Deque<Integer> dequeY) {
        if(x < 0 || y < 0 || x == grid.length || y ==grid[0].length || grid[x][y] != 1 ) {
            return;
        }

        grid[x][y] = 2;
        dequeX.add(x);
        dequeY.add(y);
        int[] i = {0, 0, -1, 1};
        int[] j = {-1, 1, 0, 0};
        for (int k = 0; k < 4; k++) {
            dfs(grid,x+i[k], y+j[k], dequeX, dequeY);
        }
    }

}
