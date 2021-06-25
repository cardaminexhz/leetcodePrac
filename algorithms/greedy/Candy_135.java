package greedy;

import java.sql.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description 135 Candy
 * 一群孩子站成一排，每一个孩子有自己的评分。现在需要给这些孩子发糖果，规则是如果一
 * 个孩子的评分比自己身旁的一个孩子要高，那么这个孩子就必须得到比身旁孩子更多的糖果；所
 * 有孩子至少要有一个糖果。求解最少需要多少个糖果。
 * @Date 2021/6/25
 */

public class Candy_135 {
    public static int candySum = 0;
    public static int candy[] = null;
    public static int ratBak[] = null;
    public static int ratingSort[][] = null;

    public static void main(String[] argus) {
        int[] ratings = {1,2,2};
        System.out.println(candy(ratings));

    }

    public static int candy(int[] ratings) {
        ratBak = ratings;
        candy = new int[ratBak.length];
        ratingSort = new int[ratings.length][2];
        int candySum = 0;
        //将ratings初始化到二维数组，存idx和val;按val升序排序
        for (int i = 0; i < ratings.length; i++) {
            ratingSort[i][0] = i;
            ratingSort[i][1] = ratings[i];
        }

        //二维数组按第二列val排序
        Arrays.sort(ratingSort, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[1] - t2[1];
            }
        });

        //递归确定candy[]
        for (int[] elem : ratingSort
        ) {
            assignCandy(elem[0]);
        }

        for (int i : candy
             ) {
            candySum += i;
        }
        return candySum;
    }

    public static void assignCandy(int cur) {
        if (candy[cur] != 0) {
            return;
        }

        int minIdx, maxIdx, minRate, maxRate;

        if(cur == 0) {

        } else if(cur == ratBak.length - 1) {

        } else {
            if(ratBak[cur-1] < ratBak[cur+1]) {
                minIdx = cur - 1;
                maxIdx = cur + 1;
                minRate = ratBak[cur - 1];
                maxRate = ratBak[cur + 1];
            } else if(ratBak[cur-1] > ratBak[cur+1]) {
                minIdx = cur + 1;
                maxIdx = cur - 1;
                minRate = ratBak[cur + 1];
                maxRate = ratBak[cur - 1];
            } else {

            }
        }

//        int preRating = (cur == 0) ? 0 : ratBak[cur - 1];
//        int nextRating = (cur == ratBak.length - 1) ? 0 : ratBak[cur + 1];
//        int minRating = Math.min(preRating, nextRating);
//        int maxRating = Math.max(preRating, nextRating);
//
//        int preCandy = (cur == 0) ? 0 : candy[cur - 1];
//        int nextCandy =  (cur == ratBak.length - 1) ? 0 : candy[cur + 1];
//        int minCandy = Math.min(preCandy, nextCandy);
//        int maxCandy = Math.max(preCandy, nextCandy);

        if (ratBak[cur] < minRate) {
            //比两边都小
            candy[cur] = 1;
            if(cur > 0) {
                assignCandy(cur - 1);
            }
            if(cur < ratBak.length ) {
                assignCandy(cur + 1);
            }
        } else if (ratBak[cur] > maxRate) {
            //比两边都大
            candy[cur] = candy[maxIdx] + 1;
        } else if (ratBak[cur] > minRate && ratBak[cur] <= maxRate) {
            //比一边大，或者与大的一边相同
            candy[cur] = candy[minIdx] + 1;
        } else if (ratBak[cur] == minRate) {
            //与两边一样大，或者与小的一边相同
            //评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果
            //即与两边一样评分的，可以比两侧都少，可为最少
            candy[cur] = 1;
        }

    }

}
