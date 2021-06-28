package greedy;

/**
 * @Description
 * 两次遍历，从左到右，从右到左，
 * 每次遍历中，只考虑更新相邻一侧的大小关系
 * @Date 2021/6/28
 */

public class Candy_135_1 {
    public static void main(String[] argus) {
        int[] ratings = {0,1,2,5,3,2,7};
        System.out.println(candy(ratings));

    }

    public static int candy(int[] ratings) {
        if (ratings.length == 0 || ratings.length == 1) {
            return 1;
        }
        int[] candies = new int[ratings.length];
        for (int i = 0; i < candies.length; i++) {
            candies[i] = 1;
        }
        int candySum = 0;

        for (int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            }
        }
        for (int i = ratings.length-1; i >= 1; i--) {
            if((ratings[i-1] > ratings[i]) && (candies[i-1] <= candies[i])) {
                candies[i-1] = candies[i] + 1;
            }
        }

        for (int elem : candies
             ) {
            candySum += elem;
        }
        return candySum;
    }
}
