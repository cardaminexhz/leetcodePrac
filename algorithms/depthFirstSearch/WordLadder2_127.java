package depthFirstSearch;

import java.util.Arrays;
import java.util.List;

/**
 * @Description TODO
 * @Tag
 * @Date 2021/8/4
 */

public class WordLadder2_127 {
    public static void main(String[] argus) {
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        String beginWord = "hot";
        String endWord = "cog";

        System.out.println(ladderLength(beginWord, endWord, wordList));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //判断beginword endword是否都在wordlist中

        return 0;
    }
}
