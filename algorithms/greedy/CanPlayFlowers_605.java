package greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description-
 * 采取什么样的贪心策略，可以种植最多的花朵呢？
 * @Date 2021/6/29
 */

public class CanPlayFlowers_605 {
    public static void main(String[] argus) {
        int[] flowerbed = {};
        int n = 1;
        System.out.println(canPlaceFlowers(flowerbed, n));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        List<Integer> idxs = new ArrayList<>();
        boolean ifALLZero = true;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                idxs.add(i);
                ifALLZero = false;
            }
        }

        int sum = 0;
        if(ifALLZero) {
            sum = (flowerbed.length+1) / 2;
        } else {
            if (idxs.get(0) >= 2) {
                sum += 1;
                idxs.add(0, 0);
            }
            if (idxs.get(idxs.size() - 1) <= flowerbed.length - 1 - 2) {
                sum += 1;
                idxs.add(flowerbed.length - 1);
            }
            for (int i = 1; i < idxs.size(); i++) {
                int interval = idxs.get(i) - idxs.get(i - 1) - 1;
                if (interval >= 3) {
                    sum += (interval - 1) / 2;
                }
            }
        }

        return (sum >= n);
    }
}
