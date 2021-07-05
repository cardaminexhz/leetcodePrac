package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Description:
 * 把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 * @Tag 预处理（首次出现位置，最后一次出现位置等），排序，贪心，重叠区间
 * @Date 2021/7/3
 */

public class PartitionLabels_763 {
    public static void main(String[] argus) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> labels = partitionLabels(s);
        System.out.println(labels.toString());
    }

    public static List<Integer> partitionLabels(String s) {
        List<Integer> labels = new ArrayList<>();
        String[] az = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        int[][] staticsOri = new int[26][2];

        //预处理 字母-firstIdx-lastIdx
        int j = 0;
        for (int i = 0; i < az.length; i++) {
            if(s.contains(az[i])) {
                staticsOri[j][0] = s.indexOf(az[i]);
                staticsOri[j][1] = s.lastIndexOf(az[i]);
                j++;
            }
        }
        int[][] statics = new int[j][2];
        for (int i = 0; i < statics.length; i++) {
            statics[i][0] = staticsOri[i][0];
            statics[i][1] = staticsOri[i][1];
        }

        //排序 按firstIdx增序
        Arrays.sort(statics, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[0] - t2[0];
            }
        });

        int cur = 0;
        int labelSum = 0;
        while(cur < statics.length) {
            int maxRight = statics[cur][1];
            while((cur < statics.length) && (statics[cur][0] <= maxRight)) {
                maxRight = Math.max(statics[cur][1], maxRight);
                cur++;
            }
            int dual = (labels.size() == 0) ? (maxRight+1): (maxRight - labelSum + 1);
            labels.add(dual);
            labelSum += dual;
        }

        return labels;
    }
}
