package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description 用最少数量的箭引爆气球
 * 排序时注意边界条件，int的最大值和最小值
 * @Tag 重叠区间，排序，贪心
 * @Date 2021/7/2
 */

public class BurstBalloons_452 {
    public static void main(String[] argus) {

        int[][] points = {{-2147483646, -2147483645}, {2147483646, 2147483647}};
        System.out.println(findMinArrowShots(points));
    }

    public static int findMinArrowShots(int[][] points) {
        int arrowNum = 0;

        // 按XStart增序排序
        Arrays.sort(points, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] t1, int[] t2) {
                        if ((t1[0] < 0) && (t2[0] > 0)) {
                            return -1;
                        }
                        if ((t1[0] > 0) && (t2[0] < 0)) {
                            return 1;
                        } else {
                            return t1[0] - t2[0];
                        }
                    }
                }
        );

        int cur = 0;
        while (cur < points.length) {
            int minRight = points[cur][1];
            while ((cur < points.length) && (minRight >= points[cur][0])) {
                minRight = Math.min(minRight, points[cur][1]);
                cur++;
            }
            arrowNum++;
        }

        return arrowNum;
    }
}
