package binarySearch;

/**
 * @Description: TODO
 * @Tag
 * @Date 2021/7/10
 */

public class MedianOfTwoSortedArrays_4 {
    public static void main(String[] argus) {
        int[] nums1 = {1,3};
        int m = 2;
        int[] nums2 = {2};
        int n = 1;

        merge(nums1, m, nums2, n);
        int len = nums1.length;
        if(len % 2 == 1) {
            System.out.println(nums1[len/2]);
        } else {
            int idx = len / 2;
            int res = (nums1[idx] + nums1[idx - 1])/2;
            System.out.println(res);
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(Math.floorMod(nums1.length, 2) == 0) {

        }

        return 1;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        }else if(n != 0) {
            if (nums1[m - 1] < nums2[0]) {
                for (int i = 0; i < n; i++) {
                    nums1[m + i] = nums2[i];
                }
            } else if (nums1[0] > nums2[n - 1]) {
                for(int i = m-1+n; i > n-1; i--) {
                    nums1[i] = nums1[i-n];
                }
                for (int i = 0; i < n; i++) {
                    nums1[i] = nums2[i];
                }
            } else {
                int p1 = m-1;
                int p2 = n-1;
                int cur = m + n -1;
                while(cur >= 0) {
                    if(p1 < 0) {
                        nums1[cur] = nums2[p2];
                        p2--;
                        cur--;
                        continue;
                    }
                    if(p2 < 0) {
                        nums1[cur] = nums1[p1];
                        p1--;
                        cur--;
                        continue;
                    }
                    if(p2 >= 0 && p1 >= 0) {
                        if (nums2[p2] >= nums1[p1]) {
                            nums1[cur] = nums2[p2];
                            p2--;
                        } else {
                            nums1[cur] = nums1[p1];
                            p1--;
                        }
                        cur--;
                    }
                }
            }

        }

    }
}
