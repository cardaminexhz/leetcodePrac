package depthFirstSearch;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description todo
 * 给定一个字母矩阵，所有的字母都与上下左右四个方向上的字母相连。给定一个字符串，求
 * 字符串能不能在字母矩阵中寻找到。
 * @Tag
 * @Date 2021/7/30
 */

public class WordSearch_79 {
    public static void main(String[] argus) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCDE";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                Deque<Character> path = new ArrayDeque<>();
                if (dfs(board, i, j, path, word)) {
                    return true;
                }
            }
        }
        return true;
    }

    public static boolean dfs(char[][] board, int cur_x, int cur_y, Deque<Character> path, String word) {
        if(deque2String(path).equals(word)) {
            return true;
        }

        int[] i = {0, 0, -1, 1};
        int[] j = {-1, 1, 0, 0};
        int x;
        int y;
        for (int k = 0; k < 4; k++) {
            x = cur_x + i[k];
            y = cur_y + j[k];
            if(x >= 0 && y >= 0 && x <= board.length-1 && y <= board[0].length-1) {
                path.add(board[x][y]);
                dfs(board, x, y, path, word);
                path.removeLast();
            }
        }
        return false;
    }

    public static String deque2String(Deque<Character> path) {
        StringBuilder sb = new StringBuilder();
        for (Character c : path
             ) {
            sb.append(c);
        }
        return sb.toString();
    }
}
