package depthFirstSearch;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description
 * 递归方式：通过函数的调用来表示接下来遍历哪些土地，让下一层函数来访问
 * 栈方式：把接下来要遍历的土地放在栈里，在取出（弹栈）的时候访问，同时将四个方向的土地入栈；
 *        只要栈不为空，就说明还有土地要访问。
 * @Tag 深度优先搜索，栈
 * @Date 2021/7/26
 */

public class MaxAreaOfIsland_695_1 {
    public static void main(String[] argus) {
        int[][] grid = {{1,0,1,1,0,1,0,1}, {1,0,1,1,0,1,1,1}, {0,0,0,0,0,0,0,1}};
        System.out.println(maxAreaOfIsland(grid));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int[] x = {0, 0, -1, 1};
        int[] y = {-1, 1, 0, 0};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }

                int res = 0;
                Deque<Integer> stackX = new LinkedList<>();
                Deque<Integer> stackY = new LinkedList<>();
                stackX.add(i);
                stackY.add(j);

                while(!stackX.isEmpty()){
                    int cur_x = stackX.pop();
                    int cur_y = stackY.pop();

                    if(cur_x < 0 || cur_y < 0 || cur_x == grid.length || cur_y == grid[cur_x].length || grid[cur_x][cur_y] != 1) {
                        continue;
                    }

                    grid[cur_x][cur_y] = 0;
                    res++;
                    for (int k = 0; k < 4; k++) {
                        stackX.add(cur_x + x[k]);
                        stackY.add(cur_y + y[k]);
                    }
                }
                maxArea = Math.max(res, maxArea);
            }
        }
        return maxArea;
    }
}
