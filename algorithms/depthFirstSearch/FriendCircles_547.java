package depthFirstSearch;

/**
 * @Description 给定一个二维的 0-1 矩阵，如果第 (i, j) 位置是 1，则表示第 i 个人和第 j 个人是朋友。已知
 * 朋友关系是可以传递的，即如果 a 是 b 的朋友，b 是 c 的朋友，那么 a 和 c 也是朋友，换言之这
 * 三个人处于同一个朋友圈之内。求一共有多少个朋友圈。同695
 * @Tag 深度优先搜索
 * @Date 2021/7/26
 */

public class FriendCircles_547 {
    public static void main(String[] argus) {
        int[][] grid = {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
        System.out.println(findCircleNum(grid));
    }

    public static int findCircleNum(int[][] grid) {
        int circleNum = 0;
        boolean[] visited = new boolean[grid.length];
        for (int i = 0; i < grid.length; i++) {
            if(!visited[i]) {
                dfs(grid, i, visited);
                ++circleNum;
            }
        }
        return circleNum;
    }

    public static void dfs(int[][] grid, int cur_x, boolean[] visited) {
        for (int j = 0; j < grid.length; j++) {
            if(grid[cur_x][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(grid, j, visited);
            }
        }
    }
}
