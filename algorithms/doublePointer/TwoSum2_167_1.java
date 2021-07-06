package doublePointer;

/**
 * @Description
 * 在一个增序的整数数组里找到两个数，使它们的和为给定值。已知有且只有一对解。
 * 对于排好序且有解的数组，双指针一定能遍历到最优解。
 * @Tag 双数组，相向运动
 * @Date 2021/7/6
 */

public class TwoSum2_167_1 {
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
        int left = 0;
        int right = numbers.length - 1;
        int sum = 0;

        while(left < right) {
            sum = numbers[left] + numbers[right];
            if(sum == target) {
                break;
            } else if(sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{left+1, right+1};
    }
}
