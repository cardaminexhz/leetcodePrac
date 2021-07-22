package sort;

import java.util.Arrays;

/**
 * @Description
 * 对三个重复且打乱的值进行排序
 * 遍历一遍统计频率，重写数组。需要两次遍历
 * @Tag
 * @Date 2021/7/22
 */

public class SortColors_75 {
    public static void main(String[] argus) {
        int[] nums = {0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int[] cnt = new int[3];
        for (int elem : nums
             ) {
            switch (elem) {
                case 0:
                    cnt[0]++;
                    break;
                case 1:
                    cnt[1]++;
                    break;
                case 2:
                    cnt[2]++;
                    break;
            }
        }

        int i;
        for (i = 0 ; i < cnt[0]; i++) {
            nums[i] = 0;
        }
        int j;
        for (j = i; j < cnt[0] + cnt[1]; j++) {
            nums[j] = 1;
        }
        int k;
        for (k = j; k < nums.length; k++) {
            nums[k] = 2;
        }

    }
}
