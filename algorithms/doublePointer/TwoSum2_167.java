package doublePointer;

/**
 * @Description
 * 在一个增序的整数数组里找到两个数，使它们的和为给定值。已知有且只有一对解。
 * @Tag 双指针
 * @Date 2021/7/6
 */

public class TwoSum2_167 {
    public static void main(String[] argus) {
        int[] numbers = {-1,0};
        int target = -1;
        int[] res = twoSum(numbers, target);
        for (int elem:res
             ) {
            System.out.println(elem);
        }
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int pre = 1;
        int cur = 0;
        while(cur < numbers.length) {
            while (pre < numbers.length) {
                if ((numbers[cur] + numbers[pre]) == target) {
                    res[0] = cur + 1;
                    res[1] = pre + 1;
                    return res;
                } else if ((numbers[cur] + numbers[pre]) < target) {
                    pre++;
                } else {
                    break;
                }
            }
            cur++;
            pre = cur + 1;
        }

        return res;
    }
}
