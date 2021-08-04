package depthFirstSearch;

/**
 * @Description
 * 被围绕的区域，给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * 任何边界上的 'O' 都不会被填充为 'X'。
 * 参考934，1.区分边界上的 'O' 与里面的 'O'
 * 2.找到与边界上的 'O' 相连的里面的 'O'
 * @Tag 深度优先搜索
 * @Date 2021/8/4
 */

public class SurroundedRegions_130 {
    public static void main(String[] argus) {
//        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
//        char[][] board = {{'O','O','O'},{'O','O','O'},{'O','O','O'}};
        char[][] board = {{'X','O','X','X'},{'O','X','O','X'},{'X','O','X','O'},{'O','X','O','X'},{'X','O','X','O'},{'O','X','O','X'}};
        solve(board);
        System.out.println(1);
    }

    public static void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        //把四条边上的O标记为1
        for (int i = 0; i <= m-1; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if(board[i][n-1] == 'O') {
                dfs(board, i, n-1);
            }
        }
        for (int j = 0; j <= n-1; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[m-1][j] == 'O'){
                dfs(board, m-1, j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if(board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public static void dfs(char[][] board, int cur_x, int cur_y) {
        board[cur_x][cur_y] = '1';

        int[] x = {0, 0, -1, 1};
        int[] y = {-1, 1, 0, 0};
        for (int k = 0; k < 4; k++) {
            int r = cur_x + x[k];
            int c = cur_y + y[k];
            if(r < 0 || c < 0 || r > board.length-1 || c > board[0].length-1 || board[r][c] == '1') {
                continue;
            }
            if(board[r][c] == 'O') {
                dfs(board, r, c);
            }
        }
    }
}
