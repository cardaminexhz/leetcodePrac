package depthFirstSearch;

/**
 * @Description
 * 给定一个字母矩阵，所有的字母都与上下左右四个方向上的字母相连。给定一个字符串，求
 * 字符串能不能在字母矩阵中寻找到。
 * @Tag 深度优先搜索，回溯
 * @Date 2021/8/2
 */

public class WordSearch_79 {
    public static void main(String[] argus) {
//        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        char[][] board = {{'A','B'},{'C','D'}}; //word:ABCD, res:false, 注意按单词顺序遍历字母
        String word = "ABCD";
        System.out.println(exist(board, word));
    }

    // 主函数，遍历board的所有元素，先找到和word首字母相同的元素，进入递归流程
    public static boolean exist(char[][] board, String word) {
        char firstChar = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(firstChar != board[i][j]) {
                    continue;
                }
                boolean[][] visited = new boolean[board.length][board[0].length];
                if (dfs(board, i, j, 1, word, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    //递归函数
    public static boolean dfs(char[][] board, int cur_x, int cur_y, int pos, String word, boolean[][] visited) {
        if(pos == word.length()) {
            return true;
        }

        //当前节点状态
        visited[cur_x][cur_y] = true;

        //向四个方向遍历，在不越界且未访问过的前提下，看哪个方向能匹配word的下一个字母
        int[] i = {0, 0, -1, 1};
        int[] j = {-1, 1, 0, 0};
        int x;
        int y;
        for (int k = 0; k < 4; k++) {
            x = cur_x + i[k];
            y = cur_y + j[k];
            if(x >= 0 && y >= 0 && x <= board.length-1 && y <= board[0].length-1
                    && !visited[x][y] && word.charAt(pos) == board[x][y]) {
                if(dfs(board, x, y, pos+1, word, visited)) {
                    return true;
                }
                //回改当前节点状态
                visited[x][y] = false;
            }
        }
        return false;
    }
}
